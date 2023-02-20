/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import ClasesUtilidad.Historial;
import Entidades.Cliente;
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
public class HistorialDAO implements IHistorialDAO{
    private ConexionBD conexion;
    public HistorialDAO() {
        this.conexion = new ConexionBD();
    }
    @Override
    public List<Historial> HistorialRetiroSinCuenta(int NumeroCuenta) {
       
      List<Historial> ListHistorial = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "SELECT folio, cantidad, fechaHora, \n" +
"    CASE \n" +
"        WHEN fechaHoraRetirado IS NULL AND CURRENT_TIMESTAMP NOT BETWEEN fechaHora AND fechaHoraLimite \n" +
"            THEN 'CADUCADO' \n" +
"        ELSE COALESCE(fechaHoraRetirado, '') \n" +
"    END AS fechaHoraRetirado,\n" +
"    fechaHoraLimite, \n" +
"    CASE \n" +
"        WHEN fechaHoraRetirado IS NULL AND CURRENT_TIMESTAMP NOT BETWEEN fechaHora AND fechaHoraLimite \n" +
"            THEN 'CADUCADO' \n" +
"        ELSE estado \n" +
"    END AS estado\n" +
"FROM retiroSinCuenta Where numeroCuenta="+NumeroCuenta;
             ResultSet resultado = comandoSQL.executeQuery(querySql);
         
             while(resultado.next()){
              if(ListHistorial==null){
                  ListHistorial = new ArrayList<>();
              }   
                 Historial histo = new Historial();
                 String folio = resultado.getString("folio");
                 String cantidad = resultado.getString("cantidad");
                 String fechaHora = resultado.getString("fechaHora");
                 String fechaHoraRetirado = resultado.getString("fechaHoraRetirado");
                 String estado = resultado.getString("estado");  
                 histo.setFolio(folio);
                 histo.setCantidad(cantidad);
                 histo.setFechaHora(fechaHora);
                 histo.setFechaHoraRetirado(fechaHoraRetirado);
                 histo.setEstado(estado);
             ListHistorial.add(histo);

         }
        conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ListHistorial;
    }
    @Override
    public List<Historial> HistorialTransacciones(int NumeroCuenta) {
       
      List<Historial> ListHistorial = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "select numeroCuenta,numeroCuentaEnvio,cantidad,fechaHora from transacciones where numeroCuenta="+NumeroCuenta;
             ResultSet resultado = comandoSQL.executeQuery(querySql);
         
             while(resultado.next()){
              if(ListHistorial==null){
                  ListHistorial = new ArrayList<>();
              }   
                 Historial histo = new Historial();
                 String numeroCuentaOrigen = resultado.getString("numeroCuenta");
                 String numeroCuentaEnvio = resultado.getString("numeroCuentaEnvio");
                 String cantidad = resultado.getString("cantidad");
                 String fechaHora = resultado.getString("fechaHora");
                 histo.setNumeroCuentaOrigen(numeroCuentaOrigen);
                 histo.setNumeroCuentaEnvio(numeroCuentaEnvio);
                 histo.setCantidad(cantidad);
                 histo.setFechaHora(fechaHora);
                 ListHistorial.add(histo);

         }
        conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ListHistorial;
    }
    
    @Override
    public List<Historial> HistorialTransaccionesRecibido(int NumeroCuenta) {
       
      List<Historial> ListHistorial = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "select numeroCuenta,numeroCuentaEnvio,cantidad,fechaHora from transacciones where numeroCuentaEnvio="+NumeroCuenta;
             ResultSet resultado = comandoSQL.executeQuery(querySql);
         
             while(resultado.next()){
              if(ListHistorial==null){
                  ListHistorial = new ArrayList<>();
              }   
                 Historial histo = new Historial();
                 String numeroCuentaOrigen = resultado.getString("numeroCuenta");
                 String numeroCuentaEnvio = resultado.getString("numeroCuentaEnvio");
                 String cantidad = resultado.getString("cantidad");
                 String fechaHora = resultado.getString("fechaHora");
                 histo.setNumeroCuentaOrigen(numeroCuentaOrigen);
                 histo.setNumeroCuentaEnvio(numeroCuentaEnvio);
                 histo.setCantidad(cantidad);
                 histo.setFechaHora(fechaHora);
                 ListHistorial.add(histo);

         }
        conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ListHistorial;
    }
}
