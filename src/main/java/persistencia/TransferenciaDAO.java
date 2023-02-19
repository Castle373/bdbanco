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
            String codigo= String.format("INSERT INTO Transacciones  (numeroCuenta, numeroCuentaEnvio, cantidad)"
                    + "VALUES ('%s','%s','%d')",
                    Transferencia.getNumeroCuenta(),
                    Transferencia.getNumeroCuentaEnvio(),
                    Transferencia.getCantidad()
                    );
            
            System.out.println(codigo);
            
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      return Transferencia;
    }    
 @Override
 public Transferencia Operacion(float a, float b,Transferencia Transferencia,String Cuentaenviar){
      try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("UPDATE Transacciones SET Sueldo="+a+" Where="+Transferencia.getNumeroCuenta());
             String codigo2= String.format("UPDATE Transacciones SET Sueldo="+b+" Where="+Cuentaenviar);
            System.out.println(codigo);
            
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
