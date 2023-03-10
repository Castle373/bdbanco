/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Entidades.RetiroSinCuenta;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import persistencia.IClientesDAO;
import persistencia.IRetiroSinCuentaDAO;

/**
 *
 * @author diego
 */
public class frmRetiroSinCuenta extends javax.swing.JFrame {
    IClientesDAO clienteDAO;
    IRetiroSinCuentaDAO retiroSinCuentaDAO;
    FondoPanel fondo = new FondoPanel();
    /**
     * Creates new form frmRetiroSinCuenta
     */
    public frmRetiroSinCuenta(IClientesDAO clienteDAO,IRetiroSinCuentaDAO retiroSinCuentaDAO) {
        this.clienteDAO=clienteDAO;
        this.retiroSinCuentaDAO=retiroSinCuentaDAO;
        this.setContentPane(fondo);
        initComponents();
        crearFont();
    }
    public void crearFont(){
        //Colocar Colores A Label
        lblTitulo.setForeground(Color.black);
        lblFolio.setForeground(Color.black);
        lblContraseña.setForeground(Color.black);
        
    }
    public boolean retirar(){
        
        String folio = txtFolio.getText();
        int contraseña = Integer.parseInt(txtContraseña.getText());
        RetiroSinCuenta retiro = new RetiroSinCuenta(folio,contraseña);
        if (retiroSinCuentaDAO.PorFolioContra(retiro)==null) {
             JOptionPane.showMessageDialog(this, "Retiro Invalido",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
             return false;
        }else{
            if (retiroSinCuentaDAO.PorFolioContra(retiro).getEstado().equalsIgnoreCase("COBRADO")) {
                JOptionPane.showMessageDialog(this, "Este Retiro Ya fue Cobrado",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }else{
                retiroSinCuentaDAO.ProcedimientoRetirar(retiro);             
                if (retiroSinCuentaDAO.PorFolioContra(retiro).getEstado().equalsIgnoreCase("CADUCADO")) {
                JOptionPane.showMessageDialog(this, "Este Retiro esta Caducado",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
                return false;
                }
                
                if (retiroSinCuentaDAO.PorFolioContra(retiro).getEstado().equalsIgnoreCase("INSUFICIENTE")) {
                JOptionPane.showMessageDialog(this, "La Cuenta No Tiene Suficiente Dinero",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
                return false;
                }
                if (retiroSinCuentaDAO.PorFolioContra(retiro).getEstado().equalsIgnoreCase("COBRADO")) {
                JOptionPane.showMessageDialog(this, "Retiro Exitoso",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
                return true;
                }
            }
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFolio = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        lblFolio = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFolioActionPerformed(evt);
            }
        });
        txtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFolioKeyTyped(evt);
            }
        });

        lblContraseña.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblContraseña.setText("Contraseña:");

        lblFolio.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblFolio.setText("FOLIO:");

        lblTitulo.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        lblTitulo.setText("Retiro Sin Cuenta");

        btnCancelar.setBackground(new java.awt.Color(149, 175, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(149, 175, 255));
        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCancelar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAceptar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres Volver Al Menu?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        if (opcion!=0) {
            
        }else{
            frmInicio inicio = new frmInicio(clienteDAO);
            inicio.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (retirar()) {
            frmInicio inicio = new frmInicio(clienteDAO);
            inicio.setVisible(true);
           this.dispose();
        }
        
        
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFolioActionPerformed

    private void txtFolioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyTyped
    int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros)
        {
            evt.consume();

        } 
    }//GEN-LAST:event_txtFolioKeyTyped

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
            java.util.logging.Logger.getLogger(frmRetiroSinCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRetiroSinCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRetiroSinCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRetiroSinCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
  //               new frmRetiroSinCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtFolio;
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
