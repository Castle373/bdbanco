/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class frmMenu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public frmMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        txtp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblDinero = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnActualizarDatos = new javax.swing.JButton();
        comboBoxCuentas = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtp1 = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        btnCrearRetiro = new javax.swing.JButton();
        btnCrearCuenta = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        BtnRetirarSinCuenta = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpActionPerformed(evt);
            }
        });
        txtp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpKeyTyped(evt);
            }
        });
        getContentPane().add(txtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 160, -1));

        jLabel1.setText("Contraseña");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 70, 20));

        lblDinero.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        lblDinero.setText(":");
        getContentPane().add(lblDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 60, 40));

        btnIniciarSesion.setText("Iniciar");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 90, -1));

        btnTransferencia.setText("Transferir");
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 160, -1));

        btnActualizarDatos.setText("Actualiza Datos");
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 140, -1));

        comboBoxCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCuentasActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 350, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 20, 140));

        txtp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtp1ActionPerformed(evt);
            }
        });
        txtp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtp1KeyTyped(evt);
            }
        });
        getContentPane().add(txtp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 160, -1));

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel4.setText("ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 40, -1));

        jLabel5.setText("Cliente:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Vani", 1, 48)); // NOI18N
        jLabel6.setText("Cuentas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 80));

        jLabel7.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        jLabel7.setText("Saldo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 60, 40));

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHistorial);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 370, 190));

        btnCrearRetiro.setText(" Retiro Sin Cuenta");
        btnCrearRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRetiroActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 160, -1));

        btnCrearCuenta.setText("Crear Cuenta");
        getContentPane().add(btnCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        btnRegistro.setText("Registrar");
        getContentPane().add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 90, -1));

        jButton8.setText("Registrar");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 90, -1));

        btnRetiro.setText("Retirar Saldo");
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, -1));

        BtnRetirarSinCuenta.setText("Retirar Sin cuenta");
        getContentPane().add(BtnRetirarSinCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpActionPerformed

    private void txtpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpKeyTyped
    int key = evt.getKeyChar();

    boolean numeros = key >= 48 && key <= 57;
        
    if (!numeros)
    {
        evt.consume();
        
    }

    if (txtp.getText().trim().length() == 10) {
        evt.consume();
        JOptionPane.showMessageDialog(this, "", "", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_txtpKeyTyped

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void txtp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtp1ActionPerformed

    private void txtp1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtp1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtp1KeyTyped

    private void comboBoxCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCuentasActionPerformed

    private void btnCrearRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRetiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearRetiroActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRetirarSinCuenta;
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnCrearRetiro;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JComboBox<String> comboBoxCuentas;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextField txtp;
    private javax.swing.JTextField txtp1;
    // End of variables declaration//GEN-END:variables
}
