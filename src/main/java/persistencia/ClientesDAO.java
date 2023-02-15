/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

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
                 Cliente nuevoCliente = new Cliente(idCliente,nombres,apellidoPaterno,apellidoMaterno,
                                                 fechaNacimiento,ciudad,colinia,calleNumero,edad,contra); 
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
                 clienteEncontrado = new Cliente(idCliente,nombres,apellidoPaterno,apellidoMaterno,
                                                 fechaNacimiento,ciudad,colinia,calleNumero,edad,contra);        

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
        try {
            Connection conex = this.conexion.crearConexion();
            Statement comando = conex.createStatement();
            String codigo= String.format("INSERT INTO Cliente (nombres,apellidoPaterno,apellidoMaterno,fechaNacimiento,ciudad,colinia,calleNumero,contrasena)"
                    + "VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')",
                    cliente.getNombres(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento(),
                    cliente.getCiudad(),
                    cliente.getColinia(),
                    cliente.getCalleNumero(),
                    cliente.getContra()
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
    public Cliente editar(Cliente cliente) {
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
                    cliente.getContra(),
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
            String querySql= "Select * From Cliente WHERE idCliente ='"+cliente.getIdCliente()+"' and contrasena='"+cliente.getContra()+"'";
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
                 clienteEncontrado = new Cliente(idCliente,nombres,apellidoPaterno,apellidoMaterno,
                                                 fechaNacimiento,ciudad,colinia,calleNumero,edad,contra);        

         }
        conex.close();
        return clienteEncontrado;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return clienteEncontrado;
    }
    
}
