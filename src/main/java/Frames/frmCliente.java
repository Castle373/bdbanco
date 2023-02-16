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
import java.sql.Connection;
import java.sql.Statement;
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
       
            crearFont();
        
    }
    public void crearFont(){

        
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
            String id = this.iClienteDAO.buscarid(txtNombre.getText(),txtApellidoP.getText(),txtColonia.getText());  
            JOptionPane.showMessageDialog(this, "Se ha Registrado Correctamente, tu id es: "+id,
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

           Cliente clienteE =getClienteControles();
           clienteE.setIdCliente(cliente.getIdCliente());
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

        lblTitulo.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        lblTitulo.setText("Titulo");

        txtNombre.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblFecha.setText("Fecha De Nacimiento ");

        lblContra.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblContra.setText("Contraseña:");

        lblCalle.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblCalle.setText("Calle:");

        lblColonia.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblColonia.setText("Colonia:");

        txtCalle.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N

        txtColonia.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N

        lblApellidoM.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblApellidoM.setText("Apellido Materno:");

        txtCiudad.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N

        lblCiudad.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
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

        txtApellidoP.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N

        txtApellidoM.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellidoP.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblApellidoP.setText("Apellido Paterno:");

        txtContraseña.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnAccion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblColonia, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(183, 183, 183)))
                                .addComponent(btnReiniciar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnReiniciar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnAccion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 51, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(75, 75, 75))))
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
