CREATE DATABASE bdbanco;
USE bdbanco;
CREATE TABLE Cliente (
  idCliente int NOT NULL AUTO_INCREMENT,
  nombres varchar(60) NOT NULL,
   contrasena varchar(40) NOT NULL,
  apellidoPaterno varchar(30) NOT NULL,
  apellidoMaterno varchar(30) NOT NULL,
  edad int,
  fechaNacimiento date not null,
  ciudad varchar(30) NOT NULL,
  colinia varchar(30) NOT NULL,
  calleNumero varchar(30) NOT NULL,
  PRIMARY KEY (idCliente)
);
CREATE TABLE Cuenta (
  numeroCuenta int NOT NULL AUTO_INCREMENT,
  fechaApertura date NOT NULL,
  estado varchar(30) NOT NULL,
  saldo int NOT NULL,
  idCliente int not null,
  PRIMARY KEY (numeroCuenta),
  KEY idCliente_idx (idCliente),
  CONSTRAINT idCliente FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
);
CREATE TABLE Retiro (
  idRetiro int NOT NULL AUTO_INCREMENT,
  fechaHora datetime,
  cantidad int NOT NULL,
  numeroCuenta int NOT NULL,
  PRIMARY KEY (idRetiro),
  KEY numeroCuenta(numeroCuenta),
  CONSTRAINT numeroCuenta_Retiro FOREIGN KEY (numeroCuenta) REFERENCES Cuenta (numeroCuenta)
);
CREATE TABLE RetiroSinCuenta (
  folio int NOT NULL AUTO_INCREMENT,
  numeroCuenta int NOT NULL,
  cantidad varchar(30) NOT NULL,
  estado varchar(30) NOT NULL,
  contraseña int NOT NULL,
  fechaHora datetime NOT NULL,
  fechaHoraLimite datetime NOT NULL,
  PRIMARY KEY (folio),
  KEY numeroCuenta (numeroCuenta),
  CONSTRAINT numeroCuenta_RetiroSinCuenta FOREIGN KEY (numeroCuenta) REFERENCES Cuenta (numeroCuenta)
);
CREATE TABLE Transacciones (
  idTransacciones int NOT NULL AUTO_INCREMENT,
  numeroCuenta int NOT NULL,
  numeroCuentaEnvio varchar(30) NOT NULL,
  cantidad varchar(30) NOT NULL,
  fechaHora datetime NOT NULL,
  PRIMARY KEY (idTransacciones),
  KEY numeroCuenta (numeroCuenta),
  CONSTRAINT numeroCuenta_Transacciones FOREIGN KEY (numeroCuenta) REFERENCES Cuenta (numeroCuenta)
);
delimiter //
create trigger calcularEdad BEFORE insert on cliente
for each row 
begin
  SET NEW.edad = TIMESTAMPDIFF(YEAR, new.fechaNacimiento, CURDATE());
end//
delimiter ;

delimiter //
create procedure SaldoCuenta(in numeroCuenta int)
begin
select saldo
from cuenta
where numeroCuenta=numeroCuenta;
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
insert into cliente(nombres,apellidoPaterno,apellidoMaterno,fechaNacimiento,
				    ciudad,colinia,calleNumero)
                    values('nombre','robles','Rojas','2003-07-03','C.dObregon','SanAnselmo','Josefat #1744');
insert into cuenta(numeroCuenta,fechaApertura,estado,saldo,idCliente)   
					values('1',current_date(),'Activo',1000,1);
select * from cliente;
select * from cuenta;
call SaldoCuenta(1);
insert into retiro(fechaHora,cantidad,numeroCuenta)
				  values(current_timestamp(),888,1);
                  
START TRANSACTION;
insert into retiro(fechaHora,cantidad,numeroCuenta)
				  values(current_timestamp(),888,1);				
rollback;
