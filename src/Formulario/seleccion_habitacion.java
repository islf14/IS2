package Formulario;

import ClaseConectar.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class seleccion_habitacion extends javax.swing.JDialog {

    public static alquiler alquile;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    ResultSet datos;
    DefaultTableModel model;
    String nrohab,nom_tipo,estado,costo,camas;
    /////////////
    public seleccion_habitacion(alquiler parent, boolean modal) {
        //super(parent, modal);
        this.alquile= parent;
        this.setModal(modal);
        this.setTitle("Seleccion de Habitación");
        initComponents();
        cargar("");
        this.setLocationRelativeTo(this);        
    }
    ///7///
    //public void enviodato(){
    //    alquile.poner();
    // }
    //////////////////
    void cargar(String valor)
    {
        String [] titulos = {"Nro de Habitacion", "Tipo", "Estado","Costo","Nro Camas"};
        model =new DefaultTableModel(null,titulos);
        try{            
            PreparedStatement pst=cn.prepareStatement("SELECT  nro_hab,nombre_tipo,estado,costo,nro_camas "
                    + "FROM tip_habitacion inner join  habitacion on habitacion.tip_habitacion_id_tipo=tip_habitacion.id_tipo where nombre_tipo LIKE '%"+valor+"%' order by nro_hab");
            datos = pst.executeQuery();//buscando datos y guardando en datos           
            String [] fila = new String[5];
            while(datos.next()){
                fila[0]=datos.getString("nro_hab");
                fila[1]=datos.getString("nombre_tipo");
                fila[2]=datos.getString("estado");
                fila[3]=datos.getString("costo");
                fila[4]=datos.getString("nro_camas");
                model.addRow(fila); 
            } 
            jTable1.setModel(model);
        }catch(HeadlessException | SQLException e){
            System.err.println("No dispone de ese tipo");
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        tipo_ha_alq = new javax.swing.JTextField();
        btnseleccionar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_tip_hab_alq.setFont(new java.awt.Font("URW Gothic L", 1, 14)); // NOI18N
        lb_tip_hab_alq.setText("Tipo:");

        tipo_ha_alq.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tipo_ha_alq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tipo_ha_alqKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipo_ha_alqKeyTyped(evt);
            }
        });

        btnseleccionar.setText("Seleccionar");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(lb_tip_hab_alq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipo_ha_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_tip_hab_alq)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tipo_ha_alq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnseleccionar)
                        .addComponent(btnsalir)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("URW Gothic L", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipo_ha_alqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_ha_alqKeyReleased
        // TODO add your handling code here:
        cargar(tipo_ha_alq.getText());
    }//GEN-LAST:event_tipo_ha_alqKeyReleased

    private void tipo_ha_alqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_ha_alqKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo letras","Advertencia.!!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tipo_ha_alqKeyTyped

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        //boton seleccionar
        int fsel= jTable1.getSelectedRow();
        try {            
            int canti=0;
            if (fsel==-1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una habitacion");
            }else{
                //System.out.println("habitacion seleccionada");
                //"Nro de Habitacion", "Tipo", "Estado","Costo","Nro Camas"
                model= (DefaultTableModel) jTable1.getModel();
                nrohab= jTable1.getValueAt(fsel, 0).toString();
                nom_tipo= jTable1.getValueAt (fsel,1).toString();
                costo= jTable1.getValueAt (fsel,3).toString();
                camas=jTable1.getValueAt (fsel,4).toString();
                estado= jTable1.getValueAt (fsel,2).toString().toUpperCase();                
                if (estado.equals("DISPONIBLE")) {
                    //System.out.println("numero habitacion: "+nrohab);
                    alquiler.txtnumeroha.setText(nrohab);
                    alquiler.txttipoha.setText(nom_tipo);
                    alquiler.txtmontototal.setText(costo);
                    alquiler.txtnumeroca.setText(camas);                    
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccionar habitacion disponible");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seleccion_habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                seleccion_habitacion dialog = new seleccion_habitacion(alquile, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnseleccionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_tip_hab_alq;
    private javax.swing.JTextField tipo_ha_alq;
    // End of variables declaration//GEN-END:variables
}
