/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import ClasesUtilidad.Historial;
import Entidades.Cliente;
import Entidades.Cuenta;
import enumeradores.AccionCatalogoEnum;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import persistencia.CuentasDAO;
import persistencia.HistorialDAO;
import persistencia.IClientesDAO;
import persistencia.ICuentasDAO;
import persistencia.IHistorialDAO;
import persistencia.IRetiroSinCuentaDAO;
import persistencia.RetiroSinCuentaDAO;

/**
 *
 * @author diego
 */
public class frmMenu extends javax.swing.JFrame {
     private IClientesDAO clienteDAO; 
     private ICuentasDAO cuentasDAO;    
     private IHistorialDAO HistorialDAO ;
     private AccionCatalogoEnum accion;
     private Cliente clienteInicio;
     FondoPanel fondo = new FondoPanel();
    /**
     * Creates new form NewJFrame
     */
    public frmMenu(ICuentasDAO cuentasDAO,IClientesDAO clienteDAO,Cliente cliente) {
        this.cuentasDAO=cuentasDAO;
        this.clienteDAO = clienteDAO;
        this.clienteInicio= cliente;
        this.setContentPane(fondo);
        initComponents();
        lblAviso.setVisible(false);
        HistorialDAO= new HistorialDAO();
        lblCliente.setText(cliente.getNombres()+" "+cliente.getApellidoPaterno()+" "+cliente.getApellidoMaterno());
        llenarComboBoxCuentas();
    }
    
    public void llenarComboBoxCuentas(){
        comboBoxCuentas.removeAllItems();
        List<Cuenta> combo = cuentasDAO.buscarPorIdClienteActivas(clienteInicio.getIdCliente());    
        if (combo==null) {
            lblAviso.setVisible(true);
            BtnRetirarSinCuenta.setEnabled(false);
            btnCancelarCuenta.setEnabled(false);
            btnTransferencia.setEnabled(false);
            btnHistorial.setEnabled(false);
            btnHistorialSinCuenta.setEnabled(false);
            btnHistorialTrans.setEnabled(false);
        }else{
            lblAviso.setVisible(false);
            BtnRetirarSinCuenta.setEnabled(true);
            btnCancelarCuenta.setEnabled(true);
            btnTransferencia.setEnabled(true);
            btnHistorial.setEnabled(true);
            btnHistorialSinCuenta.setEnabled(true);
            btnHistorialTrans.setEnabled(true);
            
            Iterator i = combo.iterator();
            while(i.hasNext()){
            Cuenta cuenta = (Cuenta) i.next();
            
            this.comboBoxCuentas.addItem(cuenta);
        }
            modeloHistorialTodo(Integer.parseInt(cuentaCombo().getNumeroCuenta()));
        }
        crearFont();
    }
    public void crearFont(){
        //Colocar Colores A Label
        lblDinero.setForeground(Color.black);
        lblCliente.setForeground(Color.black);
        lblTitulo.setForeground(Color.black);
        lblNombrePar.setForeground(Color.black);
        lblSaldo.setForeground(Color.black);
        btnActualizarDatos.setForeground(Color.black);
        btnTransferencia.setForeground(Color.black);
        btnCrearCuenta.setForeground(Color.black);
        BtnRetirarSinCuenta.setForeground(Color.black);
        btnCancelarCuenta.setForeground(Color.black);
    }
    public void modeloHistorialRetiro(int NumeroCuenta){
        DefaultTableModel defa = new DefaultTableModel();
        tblHistorial.setModel(defa);
        defa.addColumn("FOLIO");
        defa.addColumn("CANTIDAD");
        defa.addColumn("FECHA REALIZADO");
        defa.addColumn("FECHA COBRADO");
        defa.addColumn("ESTADO");
        if (HistorialDAO.HistorialRetiroSinCuenta(NumeroCuenta)==null) {
            
        }else{
            Object[] datos = new Object[defa.getColumnCount()];
            for (Historial historial:HistorialDAO.HistorialRetiroSinCuenta(NumeroCuenta)) {
               datos[0]=historial.getFolio();
               datos[1]=historial.getCantidad();
               datos[2]=historial.getFechaHora();
               datos[3]=historial.getFechaHoraRetirado();
               datos[4]=historial.getEstado();
               defa.addRow(datos);
        }
        }
    }
    public void modeloHistorialTransaccion(int NumeroCuenta){
        DefaultTableModel defa = new DefaultTableModel();
        tblHistorial.setModel(defa);
        defa.addColumn("NUMERO CUENTA ENVIO");
        defa.addColumn("CANTIDAD");
        defa.addColumn("FECHA REALIZADO");
        if (HistorialDAO.HistorialTransacciones(NumeroCuenta)==null) {
            
        }else{
            Object[] datos = new Object[defa.getColumnCount()];
            for (Historial historial:HistorialDAO.HistorialTransacciones(NumeroCuenta)) {
               datos[0]=historial.getNumeroCuentaEnvio();
               datos[1]=historial.getCantidad();
               datos[2]=historial.getFechaHora();
               defa.addRow(datos);
        }
        }
    }
    public void modeloHistorialTodo(int NumeroCuenta){
        DefaultTableModel defa = new DefaultTableModel();
        tblHistorial.setModel(defa);
        defa.addColumn("CANTIDAD");
        defa.addColumn("FECHA REALIZADO");
        defa.addColumn("TIPO");
        if (HistorialDAO.HistorialRetiroSinCuenta(NumeroCuenta)==null) {
            
        }else{
            Object[] datos = new Object[defa.getColumnCount()];
            for (Historial historial:HistorialDAO.HistorialRetiroSinCuenta(NumeroCuenta)) {
               datos[0]=historial.getCantidad();
               datos[1]=historial.getFechaHora();
               datos[2]="Retiro Sin Cuenta";
               defa.addRow(datos);
            }      
        }
        if (HistorialDAO.HistorialTransacciones(NumeroCuenta)==null) {
            
        }else{
            Object[] datos = new Object[defa.getColumnCount()];
            for (Historial historial:HistorialDAO.HistorialTransacciones(NumeroCuenta)) {
               datos[0]=historial.getCantidad();
               datos[1]=historial.getFechaHora();
               datos[2]="Transaccion";
               defa.addRow(datos);
             }     
        }
    }
    public Cuenta cuentaCombo(){
        Cuenta cuentaSeleccionada = (Cuenta) comboBoxCuentas.getSelectedItem();
        if(cuentaSeleccionada==null){
            return null;
        }
        return cuentaSeleccionada;
    }
    
    public boolean cancelarCuenta(){
        if (cuentaCombo()==null) {
            return false; 
        }
        if (cuentasDAO.editarEstado(cuentaCombo())==null) {
            JOptionPane.showMessageDialog(this, "No Se Pudo Eliminar La Cuenta",
                    "Información", JOptionPane.INFORMATION_MESSAGE);  
        }else{
            JOptionPane.showMessageDialog(this, "Cuenta "+cuentaCombo().getNumeroCuenta()+" Cancelada",
                    "Información", JOptionPane.INFORMATION_MESSAGE);  
        }
        llenarComboBoxCuentas();
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblDinero = new javax.swing.JLabel();
        btnTransferencia = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        btnCrearCuenta = new javax.swing.JButton();
        BtnRetirarSinCuenta = new javax.swing.JButton();
        lblNombrePar = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        comboBoxCuentas = new javax.swing.JComboBox<>();
        btnActualizarDatos = new javax.swing.JButton();
        btnCancelarCuenta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnHistorialSinCuenta = new javax.swing.JButton();
        btnHistorialTrans = new javax.swing.JButton();

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

        lblDinero.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lblDinero.setText(":");

        btnTransferencia.setBackground(new java.awt.Color(149, 175, 255));
        btnTransferencia.setText("Transferir");
        btnTransferencia.setFocusPainted(false);
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Century Schoolbook", 1, 48)); // NOI18N
        lblTitulo.setText("Cuentas");

        lblSaldo.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblSaldo.setText("Saldo");

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblHistorial.setRequestFocusEnabled(false);
        tblHistorial.setRowSelectionAllowed(false);
        tblHistorial.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblHistorial);

        btnCrearCuenta.setBackground(new java.awt.Color(149, 175, 255));
        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.setFocusPainted(false);
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        BtnRetirarSinCuenta.setBackground(new java.awt.Color(149, 175, 255));
        BtnRetirarSinCuenta.setText("Crear Retiro Sin cuenta");
        BtnRetirarSinCuenta.setFocusPainted(false);
        BtnRetirarSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetirarSinCuentaActionPerformed(evt);
            }
        });

        lblNombrePar.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblNombrePar.setText("Nombre:");

        lblCliente.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblCliente.setText("N");

        lblAviso.setText("No se Encontro Ninguna Cuenta");

        comboBoxCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCuentasActionPerformed(evt);
            }
        });

        btnActualizarDatos.setBackground(new java.awt.Color(149, 175, 255));
        btnActualizarDatos.setText("Actualiza Datos");
        btnActualizarDatos.setFocusPainted(false);
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });

        btnCancelarCuenta.setBackground(new java.awt.Color(153, 0, 0));
        btnCancelarCuenta.setText("Cancelar Cuenta");
        btnCancelarCuenta.setFocusPainted(false);
        btnCancelarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCuentaActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 153, 51));
        btnSalir.setText("Salir");
        btnSalir.setFocusPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnHistorial.setText("Historial General");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnHistorialSinCuenta.setText("Historial Retiros Sin Cuenta");
        btnHistorialSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialSinCuentaActionPerformed(evt);
            }
        });

        btnHistorialTrans.setText("Historial Transacciones");
        btnHistorialTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialTransActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCrearCuenta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnActualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombrePar)
                            .addComponent(btnHistorial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHistorialSinCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHistorialTrans)))
                        .addGap(0, 159, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnRetirarSinCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTransferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombrePar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearCuenta)
                    .addComponent(btnActualizarDatos))
                .addGap(15, 15, 15)
                .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistorialSinCuenta)
                    .addComponent(btnHistorial)
                    .addComponent(btnHistorialTrans))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(btnTransferencia)
                                .addGap(18, 18, 18)
                                .addComponent(BtnRetirarSinCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarCuenta)
                                .addGap(42, 42, 42))))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed

            
            frmCuenta cuentaNueva = new frmCuenta(cuentasDAO,accion.NUEVO,clienteInicio);
            cuentaNueva.setVisible(true);
            this.dispose();
        
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void comboBoxCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCuentasActionPerformed

        if (cuentaCombo()==null) {
            
        }else{
            lblDinero.setText(String.valueOf(cuentaCombo().getSaldo()));
             modeloHistorialTodo(Integer.parseInt(cuentaCombo().getNumeroCuenta()));
        }
    }//GEN-LAST:event_comboBoxCuentasActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed

            frmCliente clienteDatosNuevos = new frmCliente(clienteInicio,accion.EDITAR,this.clienteDAO);
            clienteDatosNuevos.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void btnCancelarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCuentaActionPerformed
       int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres Eliminar La Cuenta "+cuentaCombo().getNumeroCuenta(), "Confirmacion", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        if (opcion!=0) {
            
        }else{
                this.cancelarCuenta();
        }
        
        
    }//GEN-LAST:event_btnCancelarCuentaActionPerformed

    private void BtnRetirarSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetirarSinCuentaActionPerformed
        IRetiroSinCuentaDAO RetiroSinCuentaDAO = new RetiroSinCuentaDAO();
        Cuenta cuentaSeleccionada = (Cuenta) comboBoxCuentas.getSelectedItem();
        frmRetiro creaRetiro = new frmRetiro(RetiroSinCuentaDAO,cuentaSeleccionada,clienteInicio);
        creaRetiro.setVisible(true);
        this.dispose();
    
    }//GEN-LAST:event_BtnRetirarSinCuentaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
   
    int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres Volver Al Menu?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        if (opcion!=0) {
            
        }else{
            frmInicio inicio = new frmInicio(clienteDAO);
            inicio.setVisible(true);
            this.dispose();
        }
        
        
        
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (cuentaCombo()!=null) {
            this.modeloHistorialTodo(Integer.parseInt(cuentaCombo().getNumeroCuenta()));
        }
        
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnHistorialSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialSinCuentaActionPerformed
    if (cuentaCombo()!=null) {
            this.modeloHistorialRetiro(Integer.parseInt(cuentaCombo().getNumeroCuenta()));
        }
    }//GEN-LAST:event_btnHistorialSinCuentaActionPerformed

    private void btnHistorialTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialTransActionPerformed
    if (cuentaCombo()!=null) {
            this.modeloHistorialTransaccion(Integer.parseInt(cuentaCombo().getNumeroCuenta()));
        }
    }//GEN-LAST:event_btnHistorialTransActionPerformed

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
            //    new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRetirarSinCuenta;
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnCancelarCuenta;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnHistorialSinCuenta;
    private javax.swing.JButton btnHistorialTrans;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JComboBox<Cuenta> comboBoxCuentas;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblNombrePar;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblHistorial;
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
