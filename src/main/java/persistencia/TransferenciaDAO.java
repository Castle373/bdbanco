/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.Transferencia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class TransferenciaDAO implements ITransferenciaDAO{
    
    private ConexionBD conexion;
    public TransferenciaDAO() {
        this.conexion = new ConexionBD();
    }
   
 @Override
    public Transferencia guardar(Transferencia Transferencia) {     
     try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("INSERT INTO Transacciones  (numeroCuenta,numeroCuentaEnvio,cantidad)"
                    + "VALUES ('%s','%s','%s')",
                    Transferencia.getNumeroCuenta(),
                    Transferencia.getNumeroCuentaEnvio(),
                    Transferencia.getCantidad()
                    );
            
            
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      return Transferencia;
    }    
 @Override
 public Transferencia Operacion(float a, float b,Transferencia Transferencia,String Cuentaenviar,String cuenta){
      try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("UPDATE Cuenta SET saldo="+a+" Where numeroCuenta="+cuenta);
             String codigo2= String.format("UPDATE Cuenta SET saldo="+b+" Where numeroCuenta="+Cuentaenviar);
            
            comando.executeUpdate(codigo);
             comando.executeUpdate(codigo2);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
     return Transferencia;
 }
    
}
