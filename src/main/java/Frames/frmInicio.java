/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Entidades.Cliente;
import com.mycompany.bdbanco.Encriptacion;
import enumeradores.AccionCatalogoEnum;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import persistencia.ClientesDAO;
import persistencia.ConexionBD;
import persistencia.CuentasDAO;
import persistencia.IClientesDAO;
import persistencia.IConexionBD;
import persistencia.ICuentasDAO;
import persistencia.IRetiroSinCuentaDAO;
import persistencia.RetiroSinCuentaDAO;

/**
 *
 * @author diego
 */
public class frmInicio extends javax.swing.JFrame {
      IClientesDAO clienteDAO;     
      private AccionCatalogoEnum accion;
      Cliente clienteInicio,cliente2;
      FondoPanel fondo = new FondoPanel();
      private Font font = null;
    /**
     * Creates new form frmInicio
     */
    public frmInicio(IClientesDAO clienteDAO) {
        
        this.clienteDAO = clienteDAO;
        this.setContentPane(fondo);
        initComponents();
        
        try {
            crearFont();
        } catch (Exception ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
      
    }
    public boolean ValidarCuenta(){
        String id = txtId.getText();
        Encriptacion a=new Encriptacion();
        String contra = txtContraseña.getText();
        
        clienteInicio = new Cliente(id);
        clienteInicio.setContra(contra);
        
        clienteInicio.setIdCliente(id);
        Cliente cli = clienteDAO.InicioSesionCliente(clienteInicio);
        if (cli!=null) {
            return true; 
            
        }
        
            JOptionPane.showMessageDialog(this, "El id o la Contraseña son incorrectas",
                    "Información", JOptionPane.INFORMATION_MESSAGE);          
            return false;  
        
    }
    public void crearFont() throws FontFormatException, IOException{
        //Creacion de Fuentes
        String fuente="/contb.ttf";
        InputStream is= getClass().getResourceAsStream(fuente);
        font = Font.createFont(Font.TRUETYPE_FONT, is);
        
        //Fuente de diferentes Tamaños
        font = font.deriveFont(0, 30);
        Font font1 = font.deriveFont(0, 20);
        
        //Colocar Fuentes
        lblNombre.setFont(font);
        lblId.setFont(font1);
        lblContraseña.setFont(font1);
        txtId.setFont(font);
        txtContraseña.setFont(font);
        
        //Colocar Colores A Label
        lblNombre.setForeground(Color.black);
        lblId.setForeground(Color.black);
        lblContraseña.setForeground(Color.black);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnRegistro = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        btnRetirarSinCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));

        lblNombre.setText("INICIO DE SESION");

        lblId.setText("ID:");

        lblContraseña.setText("Contraseña:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        btnRegistro.setText("Registrar");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnIniciarSesion.setText("Iniciar");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnRetirarSinCuenta.setText("Retirar Sin Cuenta");
        btnRetirarSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarSinCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnRetirarSinCuenta)
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(txtContraseña)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblNombre)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(lblNombre)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion)
                    .addComponent(btnRegistro)
                    .addComponent(btnRetirarSinCuenta))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros)
        {
            evt.consume();

        }


    }//GEN-LAST:event_txtIdKeyTyped

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        Cliente cli = new Cliente();
        frmCliente registro = new frmCliente(cli,accion.NUEVO,this.clienteDAO);
        registro.setVisible(true);
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
<<<<<<< HEAD
        if (ValidarCuenta()) { 
            
            Cliente cli = this.clienteDAO.buscarPorIdCliente(txtId.getText());
            ICuentasDAO CuentasDAO = new CuentasDAO();
            frmMenu registro = new frmMenu(CuentasDAO,this.clienteDAO,cli);
            registro.setVisible(true);
            this.dispose();
        }
=======
          Encriptacion a=new Encriptacion();
        cliente2=clienteDAO.buscarPorIdCliente(txtId.getText());
        
        byte[] hola = cliente2.getContra().getBytes();
          try {
              if(a.descifra(hola)==txtContraseña.getText()) {
                  
                  if (ValidarCuenta()) {
                      Cliente cli = this.clienteDAO.buscarPorIdCliente(txtId.getText());
                      ICuentasDAO CuentasDAO = new CuentasDAO();
                      frmMenu registro = new frmMenu(CuentasDAO,this.clienteDAO,cli);
                      registro.setVisible(true);
                      this.dispose();
                  }
              }      } catch (Exception ex) {
              Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
          }
          
>>>>>>> a3bc7c1f5314d950810c2ebafebc141538e3fac5

    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRetirarSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarSinCuentaActionPerformed
   
        IRetiroSinCuentaDAO retiroSinCuentaDAO= new RetiroSinCuentaDAO();
        frmRetiroSinCuenta retriroSinCuenta = new frmRetiroSinCuenta(clienteDAO,retiroSinCuentaDAO);
        retriroSinCuenta.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnRetirarSinCuentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
    //            new frmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRetirarSinCuenta;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/xp.jpg"));
            imagen = imageIcon.getImage();
            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
            try{
                super.paint(g); 
            }catch(Exception e){
                
            }
           
        }
    }
}
