/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Robles Rojas
 */
public class ConexionBD implements IConexionBD{
private final String Server ="localhost:3306";
private final String BASE_DATOS ="bdbanco";
private final String CONEXION= "jdbc:mysql://"+Server+"/"+BASE_DATOS;
private final String USUARIO = "root";
private final String CONTRASEÑA ="12345";      
    @Override
    
    public Connection crearConexion() throws SQLException {
        Connection conexion;
        conexion = DriverManager.getConnection(CONEXION,USUARIO,CONTRASEÑA);
        return conexion;  
    }

}
