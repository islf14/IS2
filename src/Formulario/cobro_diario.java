package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class cobro_diario extends javax.swing.JInternalFrame {

    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    public static String bandera_cobro;
    public String usuario_cobro;
    public cobro_diario() {        
        initComponents();        
        usuario_cobro=MenuPrincipal.usuario_actual;  
        this.setTitle("Cobro Diario de determinado Alquiler");
        txtrecepcionista.setText(usuario_cobro);        
        bandera_cobro="bc";
        txtfechaactual.setText(fecha_actual());
    }
    
    
    public static String fecha_actual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_id_alq_cb_diario = new javax.swing.JLabel();
        txtalquiler = new javax.swing.JTextField();
        lb_vuelt_cb_diario3 = new javax.swing.JLabel();
        lb_id_recep_cb_diario = new javax.swing.JLabel();
        txtfechaactual = new javax.swing.JTextField();
        txtrecepcionista = new javax.swing.JTextField();
        lb_mont_c_cb_diario = new javax.swing.JLabel();
        lb_mont_xc_cb_diario2 = new javax.swing.JLabel();
        lb_vuelt_cb_diario4 = new javax.swing.JLabel();
        txtmontocobrado = new javax.swing.JTextField();
        txtmontoporcobrar = new javax.swing.JTextField();
        txtvuelto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setTitle("COBRO DIARIO");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setForeground(java.awt.Color.lightGray);

        lb_id_alq_cb_diario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_alq_cb_diario.setText("Alquiler:");

        lb_vuelt_cb_diario3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_vuelt_cb_diario3.setText("Fecha Actual: ");

        lb_id_recep_cb_diario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_recep_cb_diario.setText("Recepcionista:");

        txtfechaactual.setEditable(false);

        lb_mont_c_cb_diario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_mont_c_cb_diario.setText("Monto Cobrado:");

        lb_mont_xc_cb_diario2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_mont_xc_cb_diario2.setText("Monto por Cobrar:");

        lb_vuelt_cb_diario4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_vuelt_cb_diario4.setText("Vuelto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id_alq_cb_diario)
                    .addComponent(lb_vuelt_cb_diario3)
                    .addComponent(lb_id_recep_cb_diario))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtalquiler)
                    .addComponent(txtfechaactual)
                    .addComponent(txtrecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_mont_c_cb_diario)
                    .addComponent(lb_vuelt_cb_diario4)
                    .addComponent(lb_mont_xc_cb_diario2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmontoporcobrar)
                            .addComponent(txtvuelto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtmontocobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmontocobrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_mont_c_cb_diario))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_mont_xc_cb_diario2)
                            .addComponent(txtmontoporcobrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_vuelt_cb_diario4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_id_alq_cb_diario)
                            .addComponent(txtalquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_vuelt_cb_diario3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfechaactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_id_recep_cb_diario)
                            .addComponent(txtrecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnguardar)
                .addGap(33, 33, 33)
                .addComponent(btneditar)
                .addGap(28, 28, 28)
                .addComponent(btnsalir)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneditar)
                    .addComponent(btnguardar)
                    .addComponent(btnsalir))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if(txtalquiler.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingresa código de Alquiler ","ERROR",JOptionPane.ERROR_MESSAGE);
        }else   if (txtfechaactual.getText().isEmpty()) {            
            JOptionPane.showMessageDialog(null,"Ingrese Fecha Actual","ERROR",JOptionPane.ERROR_MESSAGE); 
        }else if(txtrecepcionista.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Ingrese su codigo de usuario","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtmontocobrado.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Ingrese Monto Cobrado ","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtmontoporcobrar.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Ingrese el Monto por Cobrar ","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtvuelto.getText().isEmpty()){
             JOptionPane.showMessageDialog(null,"Ingrese el Vuelto Correpondiente","ERROR",JOptionPane.ERROR_MESSAGE);
        }else
        {
            try
            {            
                PreparedStatement pst=cn.prepareStatement("INSERT INTO hotel_version7.detalle_diario_dinero"
                    + " (fecha_actual_dinero,alquila_id_alquila,id_usuario_dinero,mon_cobra_det_diario,mon_xcobra_det_diario,vuelto_det_diario)"
                     + " VALUES (?,?,?,?,?,?);");
                pst.setString(1,txtfechaactual.getText());          
                pst.setString(2,txtalquiler.getText());
                pst.setString(3,txtrecepcionista.getText());
                pst.setString(4,txtmontocobrado.getText());             
                pst.setString(5,txtmontoporcobrar.getText());
                pst.setString(6,txtvuelto.getText());                        
                int a=pst.executeUpdate();
                //
               /*
                String habb=nro_habitacion_a.getText();
                PreparedStatement pst1=cn.prepareStatement("UPDATE hotel_version7.habitacion SET estado='Ocupado' WHERE nro_hab='"+habb+"'");                
                int b=pst1.executeUpdate();
                */
                if((a>0)){                    
                    JOptionPane.showMessageDialog(null,"Registro exitoso ");                                       
                }
                else{
                    JOptionPane.showMessageDialog(null,"error al agregar ");
                }  
                
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "error al agegar datos en alquila y detalle " +e);
            }
            //tty
        }
    }//GEN-LAST:event_btnguardarActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        // cerrando ventana
        bandera_cobro=null;
    }
    
    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        
        bandera_cobro=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_id_alq_cb_diario;
    private javax.swing.JLabel lb_id_recep_cb_diario;
    private javax.swing.JLabel lb_mont_c_cb_diario;
    private javax.swing.JLabel lb_mont_xc_cb_diario2;
    private javax.swing.JLabel lb_vuelt_cb_diario3;
    private javax.swing.JLabel lb_vuelt_cb_diario4;
    private javax.swing.JTextField txtalquiler;
    private javax.swing.JTextField txtfechaactual;
    private javax.swing.JTextField txtmontocobrado;
    private javax.swing.JTextField txtmontoporcobrar;
    private javax.swing.JTextField txtrecepcionista;
    private javax.swing.JTextField txtvuelto;
    // End of variables declaration//GEN-END:variables
}
