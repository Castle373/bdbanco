/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.bdbanco;

import Frames.frmInicio;
import Frames.frmMenu;
import persistencia.ClientesDAO;
import persistencia.ConexionBD;
import persistencia.IClientesDAO;
import persistencia.IConexionBD;

/**
 *
 * @author diego
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       IConexionBD cone = new ConexionBD();
       IClientesDAO emple = new ClientesDAO();
       frmInicio frame = new frmInicio(emple);
       frame.setVisible(true);
    }
    
}
