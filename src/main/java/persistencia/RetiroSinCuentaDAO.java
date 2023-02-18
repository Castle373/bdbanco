/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.RetiroSinCuenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO{

    private ConexionBD conexion;
    public RetiroSinCuentaDAO() {
        this.conexion = new ConexionBD();
    }
    @Override
    public RetiroSinCuenta guardar(RetiroSinCuenta retiroSinCuenta) {     
     try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("INSERT INTO RetiroSinCuenta (numeroCuenta,cantidad,contraseña)"
                    + "VALUES ('%s','%s','%d')",
                    retiroSinCuenta.getNumeroCuenta(),
                    retiroSinCuenta.getCantidad(),
                    retiroSinCuenta.getContraseña()
                    );
            
            System.out.println(codigo);
            
            comando.executeUpdate(codigo);
            retiroSinCuenta.setFolio(buscarid(conex));        
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      return retiroSinCuenta;
    }
    public String buscarid(Connection conexi) {
        String id = null;
        try {
            Connection conex = conexi;
            Statement comandoSQL = conex.createStatement();
            String querySql= "select LAST_INSERT_ID()";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
             
             if(resultado.next()){
                 String folio = resultado.getString("LAST_INSERT_ID()");
                 id=folio;
         }
        return id;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return id;
    }
    @Override
    public RetiroSinCuenta PorFolioContra(RetiroSinCuenta retiroSinCuenta) {
        
        RetiroSinCuenta cuentaEncontrado = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From RetiroSinCuenta WHERE folio ='"+retiroSinCuenta.getFolio()+"' and contraseña='"+retiroSinCuenta.getContraseña()+"'";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
             
             if(resultado.next()){
                 String folio = resultado.getString("folio");
                 String numeroCuenta = resultado.getString("numeroCuenta");
                 String cantidad = resultado.getString("cantidad");
                 int contraseña = resultado.getInt("contraseña");  
                 String estado = resultado.getString("estado");  
                 String fechaHora = resultado.getString("fechaHora");  
                 String fechaHoraRetirado = resultado.getString("fechaHoraRetirado");  
             String fechaHoraLimite = resultado.getString("fechaHoraLimite");  
                 cuentaEncontrado = new RetiroSinCuenta(folio,numeroCuenta,cantidad,estado,contraseña
                                                        ,fechaHora,fechaHoraRetirado,fechaHoraLimite);       

         }
        conex.close();
        return cuentaEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return cuentaEncontrado;
    }

    @Override
    public void ProcedimientoRetirar(RetiroSinCuenta retiroSinCuenta) {
    try {
        Connection conex = this.conexion.crearConexion();
        CallableStatement cs = conex.prepareCall("{call realizarRetiroSinCuenta(?,?)}");
        cs.setInt(1, Integer.parseInt(retiroSinCuenta.getFolio()));
        cs.setInt(2, retiroSinCuenta.getContraseña());
        cs.execute();
        conex.close();
    } catch (SQLException ex) {
        Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
}
