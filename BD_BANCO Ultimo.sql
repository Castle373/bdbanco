CREATE DATABASE bdbanco;
USE bdbanco;
CREATE TABLE Cliente (
  idCliente int NOT NULL AUTO_INCREMENT,
  nombres varchar(60) NOT NULL,
  apellidoPaterno varchar(30) NOT NULL,
  apellidoMaterno varchar(30) NOT NULL,
  edad int,
  fechaNacimiento date not null,
  ciudad varchar(30) NOT NULL,
  colinia varchar(30) NOT NULL,
  calleNumero varchar(30) NOT NULL,
  contrasena varchar(30) NOT NULL,
  PRIMARY KEY (idCliente)
);
CREATE TABLE Cuenta (
  numeroCuenta int NOT NULL,
  fechaApertura date NOT NULL,
  estado varchar(30) NOT NULL,
  saldo float NOT NULL,
  idCliente int not null,
  PRIMARY KEY (numeroCuenta),
  KEY idCliente_idx (idCliente),
  CONSTRAINT idCliente FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
);
CREATE TABLE Retiro (
  idRetiro int NOT NULL AUTO_INCREMENT,
  fechaHora datetime,
  cantidad float NOT NULL,
  numeroCuenta int NOT NULL,
  PRIMARY KEY (idRetiro),
  KEY numeroCuenta(numeroCuenta),
  CONSTRAINT numeroCuenta_Retiro FOREIGN KEY (numeroCuenta) REFERENCES Cuenta (numeroCuenta)
);
CREATE TABLE RetiroSinCuenta (
  folio int NOT NULL AUTO_INCREMENT,
  numeroCuenta int NOT NULL,
  cantidad float NOT NULL,
  estado varchar(30) NOT NULL,
  contraseña int NOT NULL,
  fechaHora datetime NOT NULL,
  fechaHoraRetirado datetime,
  fechaHoraLimite datetime NOT NULL,
  PRIMARY KEY (folio),
  KEY numeroCuenta (numeroCuenta),
  CONSTRAINT numeroCuenta_RetiroSinCuenta FOREIGN KEY (numeroCuenta) REFERENCES Cuenta (numeroCuenta)
);
CREATE TABLE Transacciones (
  idTransacciones int NOT NULL AUTO_INCREMENT,
  numeroCuenta int NOT NULL,
  numeroCuentaEnvio varchar(30) NOT NULL,
  cantidad float NOT NULL,
  fechaHora datetime NOT NULL,
  PRIMARY KEY (idTransacciones),
  KEY numeroCuenta (numeroCuenta),
  CONSTRAINT numeroCuenta_Transacciones FOREIGN KEY (numeroCuenta) REFERENCES Cuenta (numeroCuenta)
);

delimiter //
create trigger  CuentaDatos BEFORE insert on Cuenta
for each row 
begin
  SET NEW.numeroCuenta = FLOOR(RAND() * (99999999 - 10000000 + 1)) + 10000000;
  SET NEW.fechaApertura = CURDATE();
  SET NEW.estado = 'ACTIVO';
end//
delimiter ;
delimiter //
create trigger insertRetiroSinCuenta BEFORE insert on RetiroSinCuenta
for each row 
begin
  SET NEW.estado = 'ACTIVO';
  SET NEW.fechaHora = CURRENT_TIMESTAMP();
  SET NEW.fechaHoraLimite = date_add(CURRENT_TIMESTAMP(),interval 10 minute);
end//
delimiter ;

delimiter //
create trigger calcularEdad BEFORE insert on cliente
for each row 
begin
  SET NEW.edad = TIMESTAMPDIFF(YEAR, new.fechaNacimiento, CURDATE());
end//
delimiter ;


delimiter //
create procedure SaldoCuenta(in numeroCuentaB int,out saldoDinero float)
begin
select saldo into saldoDinero
from cuenta
where numeroCuenta=numeroCuentaB;
end//
delimiter ;
delimiter //
create trigger ProcesoRetiro after insert on retiro
for each row 
begin 
update cuenta set saldo=saldo-new.cantidad
where new.numeroCuenta=numeroCuenta;
end//
delimiter ;
delimiter $$
CREATE PROCEDURE realizarRetiroSinCuenta (
  IN folioB INT,
  IN contraseñaB INT
)
BEGIN
  DECLARE cantidadDinero FLOAT;
  DECLARE fechaInicio DATETIME;
  DECLARE fechaFin DATETIME;
  DECLARE NumeroCuentaB int;
  DECLARE estadoB varchar(40);
  
  SELECT numeroCuenta INTO NumeroCuentaB FROM RetiroSinCuenta WHERE folio = folioB AND contraseña = contraseñaB;
  
  CALL SaldoCuenta(NumeroCuentaB, @saldoCuenta); -- use the declared @saldoCuenta variable here
  
  SELECT fechaHora, fechaHoraLimite, cantidad, numeroCuenta, estado INTO fechaInicio, fechaFin, cantidadDinero, NumeroCuentaB, estadoB
  FROM RetiroSinCuenta WHERE folio = folioB AND contraseña = contraseñaB FOR UPDATE;
  
  IF estadoB = 'COBRADO' THEN
    UPDATE RetiroSinCuenta SET estado = 'COBRADO' WHERE folio = folioB AND contraseña = contraseñaB;
    
  ELSEIF fechaInicio <= CURRENT_TIMESTAMP() AND fechaFin >= CURRENT_TIMESTAMP() THEN
    IF @saldoCuenta < cantidadDinero THEN -- use the @saldoCuenta variable here
      UPDATE RetiroSinCuenta SET estado = 'INSUFICIENTE' WHERE folio = folioB AND contraseña = contraseñaB;
    ELSE
      UPDATE RetiroSinCuenta SET estado = 'COBRADO' WHERE folio = folioB AND contraseña = contraseñaB;
      UPDATE RetiroSinCuenta set fechaHoraRetirado = CURRENT_TIMESTAMP() WHERE folio = folioB AND contraseña = contraseñaB;
      UPDATE Cuenta SET saldo = @saldoCuenta - cantidadDinero WHERE numeroCuenta = NumeroCuentaB; -- use the @saldoCuenta variable here
    END IF;
  ELSE
    UPDATE RetiroSinCuenta SET estado = 'CADUCADO' WHERE folio = folioB AND contraseña = contraseñaB;
  END IF;
  
END$$
delimiter ; 
                   