/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Entidades.Cliente;
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
import persistencia.IClientesDAO;

/**
 *
 * @author diego
 */
public class frmCliente extends javax.swing.JFrame {
    FondoPanel fondo = new FondoPanel();
    private Cliente reinicio;
    private final Cliente cliente;
    private final IClientesDAO iClienteDAO;
    private Font font = null;
    private AccionCatalogoEnum accion;
    /**
     * Creates new form frmCliente
     */
    public frmCliente(Cliente cliente,AccionCatalogoEnum accion,IClientesDAO iClienteDAO) {
        this.iClienteDAO = iClienteDAO;
        this.cliente = cliente;
        this.accion= accion;
        this.setContentPane(fondo);
        initComponents();
        
        if (accion==accion.EDITAR) {
            lblTitulo.setText("Editar Empleado");
            btnAccion.setText("Actualizar");
            txtNombre.setText(cliente.getNombres());
            txtApellidoP.setText(cliente.getApellidoPaterno());
            txtApellidoM.setText(cliente.getApellidoMaterno());     
            txtContraseña.setText(cliente.getContra());
            txtCiudad.setText(cliente.getCiudad());  
            txtColonia.setText(cliente.getColinia());  
            txtCalle.setText(cliente.getCalleNumero());      
            
        }
        if (accion==accion.ELIMINAR) {
            lblTitulo.setText("Eliminar Empleado");
            btnAccion.setText("Eliminar");
            txtNombre.setText(cliente.getNombres());
            txtApellidoP.setText(cliente.getApellidoPaterno());
            txtApellidoM.setText(cliente.getApellidoMaterno());     
            txtContraseña.setText(cliente.getContra());
            txtCiudad.setText(cliente.getCiudad());  
            txtColonia.setText(cliente.getColinia());  
            txtCalle.setText(cliente.getCalleNumero());           
            txtNombre.setEditable(false);
            txtApellidoP.setEditable(false);
            txtApellidoM.setEditable(false);
            txtContraseña.setEditable(false);
            txtCiudad.setEditable(false);
            txtColonia.setEditable(false);
            txtCalle.setEditable(false);
            dcFechaNac.setEnabled(false);
        }
        if (accion==accion.NUEVO) {
            lblTitulo.setText("Registrar Empleado");
                    
        }
        try {
            crearFont();
        } catch (FontFormatException ex) {
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearFont() throws FontFormatException, IOException{
        //Creacion de Fuentes
        String fuente="/contb.ttf";
        InputStream is= getClass().getResourceAsStream(fuente);
        font = Font.createFont(Font.TRUETYPE_FONT, is);
        
        //Fuente de diferentes Tamaños
        font = font.deriveFont(0, 35);
        Font font1 = font.deriveFont(0, 20);
        
        //Colocar Fuentes
        lblTitulo.setFont(font);
        lblNombre.setFont(font1);
        lblApellidoP.setFont(font1);
        lblApellidoM.setFont(font1);
        lblContra.setFont(font1);
        lblCalle.setFont(font1);
        lblColonia.setFont(font1);
        lblCiudad.setFont(font1);
        lblFecha.setFont(font1);
        txtNombre.setFont(font1);
        txtApellidoP.setFont(font1);
        txtApellidoM.setFont(font1);
        txtContraseña.setFont(font1);
        txtCiudad.setFont(font1);
        txtColonia.setFont(font1);
        txtCalle.setFont(font1);
        
        //Colocar Colores A Label
        lblTitulo.setForeground(Color.black);
        lblNombre.setForeground(Color.black);
        lblApellidoP.setForeground(Color.black);
        lblApellidoM.setForeground(Color.black);
        lblContra.setForeground(Color.black);
        lblCalle.setForeground(Color.black);
        lblColonia.setForeground(Color.black);
        lblCiudad.setForeground(Color.black);
        lblFecha.setForeground(Color.black);
        
    }
    public Cliente getClienteControles(){
        Cliente cliente = new Cliente();
        cliente.setNombres(txtNombre.getText());
        cliente.setApellidoMaterno(txtApellidoM.getText());
        cliente.setApellidoPaterno(txtApellidoP.getText());
        long dateLong = this.dcFechaNac.getDate().getTime();
        java.sql.Date date = new java.sql.Date(dateLong);       
        cliente.setFechaNacimiento(date.toString());
        cliente.setCiudad(txtCiudad.getText());
        cliente.setColinia(txtColonia.getText());
        cliente.setCalleNumero(txtCalle.getText());
        cliente.setContra(txtContraseña.getText());       
        return cliente;
    }
    private void guardar() {

        Cliente clienteGuardar = this.iClienteDAO.guardar(getClienteControles());      
        if (clienteGuardar != null) {
            JOptionPane.showMessageDialog(this, "Se ha Registrado Correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible Registrarse",
                    "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
  private void eliminar() {

        Cliente clienteEliminar = this.iClienteDAO.eliminar(getClienteControles());
        if (clienteEliminar != null) {
            JOptionPane.showMessageDialog(this, "Cliente Eliminado Correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible Eliminar el Cliente",
                    "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
   private void editar() {

           Cliente clienteE = getClienteControles();
           Cliente clienteEditar = this.iClienteDAO.editar(clienteE);
        if (clienteEditar != null) {
            JOptionPane.showMessageDialog(this, "Se Actualizo Su Perfil",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No fue posible Actualizar al empleado",
                                                "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblContra = new javax.swing.JLabel();
        lblCalle = new javax.swing.JLabel();
        lblColonia = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        lblApellidoM = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        lblCiudad = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAccion = new javax.swing.JButton();
        dcFechaNac = new com.toedter.calendar.JDateChooser();
        btnReiniciar = new javax.swing.JButton();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellidoP = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Titulo");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblFecha.setText("Fecha De Nacimiento ");

        lblContra.setText("Contraseña:");

        lblCalle.setText("Calle:");

        lblColonia.setText("Colonia:");

        lblApellidoM.setText("Apellido Materno:");

        lblCiudad.setText("Ciudad:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAccion.setText("Aceptar");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        btnReiniciar.setText("reinicio");

        lblNombre.setText("Nombre:");

        lblApellidoP.setText("Apellido Paterno:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidoP, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellidoP)
                                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(lblCalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblColonia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnReiniciar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btnCancelar)
                .addGap(227, 227, 227)
                .addComponent(btnAccion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lblApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnReiniciar)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAccion))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
    if (txtNombre.getText().equals("")||
            txtApellidoM.getText().equals("")||    
            txtApellidoP.getText().equals("")||
            txtCiudad.getText().equals("")||
            txtCalle.getText().equals("")||
            txtColonia.getText().equals("")||
            txtContraseña.getText().equals("")||
            dcFechaNac.getDate()==null
                ) {
            JOptionPane.showMessageDialog(this, "Hay Espacios en Blanco!!!!!","Informacion",JOptionPane.ERROR_MESSAGE);
        }else{
        if (accion==accion.EDITAR) {
            editar();
        }
        if (accion==accion.ELIMINAR) { 
           eliminar();
        }
        if (accion==accion.NUEVO) {
            guardar();
     
        }
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btnAccionActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new frmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReiniciar;
    private com.toedter.calendar.JDateChooser dcFechaNac;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNombre;
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
