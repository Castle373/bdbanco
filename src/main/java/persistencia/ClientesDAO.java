/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import Entidades.Cliente;
import com.mycompany.bdbanco.Encripta;
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
public class ClientesDAO implements IClientesDAO{
    private ConexionBD conexion;
    public ClientesDAO() {
        this.conexion = new ConexionBD();
    }
    @Override
    public List<Cliente> ListaCliente() {
      List<Cliente> listCliente = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cliente";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
         
             while(resultado.next()){
              if(listCliente==null){
                  listCliente = new ArrayList<>();
              }   
                 
             String idCliente = resultado.getString("idCliente");
                 String nombres = resultado.getString("nombres");
                 String apellidoPaterno = resultado.getString("apellidoPaterno");
                 String apellidoMaterno = resultado.getString("apellidoMaterno");
                 String edad = resultado.getString("edad");
                 String fechaNacimiento = resultado.getString("fechaNacimiento");
                 String ciudad = resultado.getString("ciudad");
                 String colinia = resultado.getString("colinia");
                 String calleNumero = resultado.getString("calleNumero");   
                 String contra = resultado.getString("contrasena");
                 String usuario = resultado.getString("usuario");
                 Cliente nuevoCliente = new Cliente(idCliente,nombres,apellidoPaterno,apellidoMaterno,
                                                 fechaNacimiento,ciudad,colinia,calleNumero,edad,contra,usuario); 
             listCliente.add(nuevoCliente);

         }
        conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return listCliente;
    }

    @Override
    public List<Cliente> ListaClienteNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscarPorIdCliente(String Cliente) {
        Cliente clienteEncontrado = new Cliente();
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cliente WHERE idCliente ="+Cliente;
             ResultSet resultado = comandoSQL.executeQuery(querySql);
             
             if(resultado.next()){
                 String idCliente = resultado.getString("idCliente");
                 String nombres = resultado.getString("nombres");
                 String apellidoPaterno = resultado.getString("apellidoPaterno");
                 String apellidoMaterno = resultado.getString("apellidoMaterno");
                 String edad = resultado.getString("edad");
                 String fechaNacimiento = resultado.getString("fechaNacimiento");
                 String ciudad = resultado.getString("ciudad");
                 String colinia = resultado.getString("colinia");
                 String calleNumero = resultado.getString("calleNumero");       
                 String contra = resultado.getString("contrasena");   
                 String usuario = resultado.getString("usuario");
                 clienteEncontrado = new Cliente(idCliente,nombres,apellidoPaterno,apellidoMaterno,
                                                 fechaNacimiento,ciudad,colinia,calleNumero,edad,contra,usuario);        

         }
        conex.close();
        return clienteEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return clienteEncontrado;
    }
    @Override
    public Cliente guardar(Cliente cliente) { 
    String contra;
    contra=cliente.getContra();
        Encripta encripta=new Encripta();
        
     
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("INSERT INTO Cliente (usuario,nombres,apellidoPaterno,apellidoMaterno,fechaNacimiento,ciudad,colinia,calleNumero,contrasena)"
                    + "VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                    cliente.getUsuario(),
                    cliente.getNombres(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento(),
                    cliente.getCiudad(),
                    cliente.getColinia(),
                    cliente.getCalleNumero(),
                    encripta.encriptar(contra)
                    );
            
            comando.executeUpdate(codigo);
            cliente.setIdCliente(buscarid(conex));
            
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return cliente;
    }
    @Override
    public String buscarid(Connection conexi) {
        String id = null;
        try {
            Connection conex = conexi;
            Statement comandoSQL = conex.createStatement();
            String querySql= "select LAST_INSERT_ID()";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
             
             if(resultado.next()){
                 String idCliente = resultado.getString("LAST_INSERT_ID()");
                 id=idCliente;
         }
        return id;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return id;
    }
    @Override
    public Cliente editar(Cliente cliente) {
        String contra;
         contra=cliente.getContra();
        Encripta encripta=new Encripta();
         try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("UPDATE Cliente "
                    + "SET nombres='%s',apellidoPaterno='%s',apellidoMaterno='%s',"
                    + "fechaNacimiento='%s',ciudad='%s',colinia='%s',calleNumero='%s',contrasena='%s'"
                    + " WHERE idCliente =%s",
                    cliente.getNombres(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento(),
                    cliente.getCiudad(),
                    cliente.getColinia(),
                    cliente.getCalleNumero(),
                    encripta.encriptar(contra),
                    cliente.getIdCliente()
                    );
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         return cliente;
    }

    @Override
    public Cliente eliminar(Cliente cliente) {
      try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("DELETE FROM Cliente WHERE idCliente=%s",cliente.getIdCliente());
            comando.executeUpdate(codigo);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         return cliente;
    }

    @Override
    public Cliente InicioSesionCliente(Cliente cliente) {         
        Cliente clienteEncontrado=null;
        
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cliente WHERE usuario ='"+cliente.getUsuario()+"' and contrasena='"+cliente.getContra()+"'";
    
             ResultSet resultado = comandoSQL.executeQuery(querySql);
             
             if(resultado.next()){
                 String idCliente = resultado.getString("idCliente");
                 String nombres = resultado.getString("nombres");
                 String apellidoPaterno = resultado.getString("apellidoPaterno");
                 String apellidoMaterno = resultado.getString("apellidoMaterno");
                 String edad = resultado.getString("edad");
                 String fechaNacimiento = resultado.getString("fechaNacimiento");
                 String ciudad = resultado.getString("ciudad");
                 String colinia = resultado.getString("colinia");
                 String calleNumero = resultado.getString("calleNumero");       
                 String contra = resultado.getString("contrasena"); 
                 String usuario = resultado.getString("usuario");
                 clienteEncontrado = new Cliente(idCliente,nombres,apellidoPaterno,apellidoMaterno,
                                                 fechaNacimiento,ciudad,colinia,calleNumero,edad,contra,usuario);        

         }
        conex.close();
        return clienteEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return clienteEncontrado;
    }
    
        /*
    @Override
    public String buscarid(String usuario,String apellido,String colonia) {
        String id = null;
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comandoSQL = conex.createStatement();
            String querySql= "Select * From Cliente WHERE nombres ='"+usuario+"' and "+"colinia= '"+colonia+"' and "+"apellidoPaterno= '"+apellido+"'";
             ResultSet resultado = comandoSQL.executeQuery(querySql);
             
             if(resultado.next()){
                 String idCliente = resultado.getString("idCliente");
                 id=idCliente;
         }
            
        conex.close();
        return id;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return id;
    }
*/
}
