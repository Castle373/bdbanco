/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.Cuenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class CuentasDAO implements ICuentasDAO{
    private ConexionBD conexion;
    public CuentasDAO() {
        this.conexion = new ConexionBD();
    }
    @Override
    public List<Cuenta> ListaCuenta() {
      List<Cuenta> listCuenta = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cuenta";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
         
             while(resultado.next()){
              if(listCuenta==null){
                  listCuenta = new ArrayList<>();
              }   
                 
                 String numeroCuenta = resultado.getString("numeroCuenta");
                 String fechaApertura = resultado.getString("fechaApertura");
                 String estado = resultado.getString("estado");
                 float saldo = resultado.getFloat("saldo");
                 String idCliente = resultado.getString("idCliente");  
                 Cuenta nuevoCuenta = new Cuenta(numeroCuenta,fechaApertura,estado,saldo,idCliente); 
             listCuenta.add(nuevoCuenta);

         }
        conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listCuenta;
    }

    @Override
    public Cuenta buscarPorNumeroCuenta(String Cuenta) {
        Cuenta cuentaEncontrado = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cuenta WHERE numeroCuenta ="+Cuenta;
             ResultSet resultado = comandoSQL.executeQuery(querySql);
             
             if(resultado.next()){
                 String numeroCuenta = resultado.getString("numeroCuenta");
                 String fechaApertura = resultado.getString("fechaApertura");
                 String estado = resultado.getString("estado");
                 float saldo = resultado.getFloat("saldo");
                 String idCliente = resultado.getString("idCliente");  
                 cuentaEncontrado = new Cuenta(numeroCuenta,fechaApertura,estado,saldo,idCliente);       

         }
        conex.close();
        return cuentaEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return cuentaEncontrado;
    }

    @Override
    public Cuenta guardar(Cuenta Cuenta) {
     try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("INSERT INTO Cuenta (saldo,idCliente)"
                    + "VALUES ('%s','%s')",
                    Cuenta.getSaldo(),
                    Cuenta.getIdCliente()
                    );
            
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      return Cuenta;
    }

    @Override
    public Cuenta editarSaldo(Cuenta Cuenta) {
        
         try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("UPDATE Cuenta "
                    + "SET saldo='%s'"
                    + " WHERE idCliente =%s",
                    Cuenta.getSaldo(),
                    Cuenta.getIdCliente()
                    );
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         return Cuenta;
    }

    @Override
    public List<Cuenta> buscarPorIdCliente(String IdCliente) {     
      List<Cuenta> listCuenta = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cuenta WHERE idClient='"+IdCliente+"'";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
         
             while(resultado.next()){
              if(listCuenta==null){
                  listCuenta = new ArrayList<>();
              }    
                 String numeroCuenta = resultado.getString("numeroCuenta");
                 String fechaApertura = resultado.getString("fechaApertura");
                 String estado = resultado.getString("estado");
                 float saldo = resultado.getFloat("saldo");
                 String idCliente = resultado.getString("idCliente");  
                 Cuenta nuevoCuenta = new Cuenta(numeroCuenta,fechaApertura,estado,saldo,idCliente); 
             listCuenta.add(nuevoCuenta);

         }
        conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listCuenta;
    }

    @Override
    public List<Cuenta> buscarPorIdClienteActivas(String IdCliente) {
            
      List<Cuenta> listCuenta = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cuenta WHERE idCliente='"+IdCliente+"' and estado='ACTIVO'";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
         
             while(resultado.next()){
              if(listCuenta==null){
                  listCuenta = new ArrayList<>();
              }    
                 String numeroCuenta = resultado.getString("numeroCuenta");
                 String fechaApertura = resultado.getString("fechaApertura");
                 String estado = resultado.getString("estado");
                 float saldo = resultado.getFloat("saldo");
                 String idCliente = resultado.getString("idCliente");  
                 Cuenta nuevoCuenta = new Cuenta(numeroCuenta,fechaApertura,estado,saldo,idCliente); 
             listCuenta.add(nuevoCuenta);

         }
        conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listCuenta;
    }

    @Override
    public Cuenta editarEstado(Cuenta Cuenta) {
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("UPDATE Cliente "
                    + "SET estado='CANCELADO'"
                    + " WHERE idCliente =%s",
                    Cuenta.getIdCliente()
                    );
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         return Cuenta;
    }

    
}
