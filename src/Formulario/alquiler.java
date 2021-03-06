package Formulario;

import ClaseConectar.Conectar;
import Clases.fecha;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class alquiler extends javax.swing.JInternalFrame {

    public static seleccion_habitacion seleccion_ha;
    DefaultTableModel modelo;
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
    Integer seleccionado;
    fecha fecha=new fecha();
    //String rtta;//r
    Integer cantidadpersonas;
    public static String bandera_alquiler;//guardar el usuario que inicio sesion
    public String usuario_alquiler;
    ///////////////
    public alquiler() {
        super();
        initComponents();
        this.setLocation(15, 10);
        setResizable(false);
        this.setTitle("Alquiler");
        usuario_alquiler=MenuPrincipal.usuario_actual; 
        bandera_alquiler="bandera";
        ////Tabla
        modelo= new DefaultTableModel();        
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("DNI");
        this.tb_det.setModel(modelo);
        ///
        limpiar();  
        btnnuevo();  
    }
    void bloqueorestantes(){
        btnbuscar_h.setEnabled(false);
        btnhuesped.setEnabled(false);  
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
    }    
    void btnnuevo(){
        btnbuscar_h.setEnabled(true);
        btnhuesped.setEnabled(true);  
        btnbuscar_th.setEnabled(false);
        btnagregar.setEnabled(false);
        btneditar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        btneliminart.setEnabled(false);
        btnguardar.setEnabled(false);
        //
        txtdni.setEnabled(true);
        txtdni.setEditable(true);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtcant.setEnabled(false);
        txtcant.setEditable(true);
        txtnumeroha.setEnabled(false);
        txttipoha.setEnabled(false);
        txtnumeroca.setEnabled(false);
        
        txtnombre_mi.setEnabled(false);
        txtapellido_mi.setEnabled(false);
        txtdni_mi.setEnabled(false);
        
        txtidalquiler.setEnabled(false);
        txtllegada.setEnabled(false);
        txtsalida.setEnabled(false);
        txtusuario.setEnabled(false);
        txtmontototal.setEnabled(false);
        txtobservacion.setEnabled(false);          
    }    
    void limpiar(){
        txtdni.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtcant.setText("1");
        txtnumeroha.setText("");
        txttipoha.setText("");
        txtnumeroca.setText("");
        obt_id(); 
        txtllegada.setText(fecha_actual());
        txtusuario.setText(usuario_alquiler);
        txtmontototal.setText("");
        txtobservacion.setText("");
        txtdni_mi.setText("");
        txtnombre_mi.setText("");
        txtapellido_mi.setText("");
        eliminarelementos();       
    }    
    void eliminarelementos(){
        int cantfil=tb_det.getRowCount();
        for(int i=cantfil-1;i>=0;i--){
            modelo.removeRow(i);
            cantidadpersonas=cantidadpersonas+1;
        }
    }
    /////////////////       
    public void obt_id(){
        try{
            //obteniendo id de alquila.. id maximo            
            ResultSet rsa;
            Statement sent = cn.createStatement();
            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_alquila AS UNSIGNED)), 0) codigoExterno FROM hotel_version7.alquila");
            int cont;
            while(rsa.next()){
                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                this.txtidalquiler.setText(String.valueOf(cont));
            }            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }      
    }    
    public static String fecha_actual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha= new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_dt_huesp = new javax.swing.JPanel();
        lb_dni_alq = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        lb_nom_alq = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        lb_ape_alq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        btnbuscar_h = new javax.swing.JButton();
        btnhuesped = new javax.swing.JButton();
        panel_dt_hab = new javax.swing.JPanel();
        lb_num_hab_alq = new javax.swing.JLabel();
        lb_tip_hab_alq = new javax.swing.JLabel();
        txttipoha = new javax.swing.JTextField();
        txtnumeroha = new javax.swing.JTextField();
        btnbuscar_th = new javax.swing.JButton();
        txtnumeroca = new javax.swing.JTextField();
        lb_num_camas_hab_alq1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        panel_dt_alq = new javax.swing.JPanel();
        lb_id_alq = new javax.swing.JLabel();
        lb_fech_lleg = new javax.swing.JLabel();
        lb_fech_sal = new javax.swing.JLabel();
        lb_num_camas_hab_alq = new javax.swing.JLabel();
        lb_obs_alq = new javax.swing.JLabel();
        lb_id_recep = new javax.swing.JLabel();
        txtidalquiler = new javax.swing.JTextField();
        txtllegada = new javax.swing.JTextField();
        txtmontototal = new javax.swing.JTextField();
        txtobservacion = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtsalida = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtdni_mi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtapellido_mi = new javax.swing.JTextField();
        txtnombre_mi = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_det = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btneliminart = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panel_dt_huesp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Huésped", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N
        panel_dt_huesp.setToolTipText("");

        lb_dni_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_dni_alq.setText("DNI:");

        txtdni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        txtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdniKeyTyped(evt);
            }
        });

        lb_nom_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_nom_alq.setText("Nombres:");

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtapellido.setEditable(false);
        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_ape_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_ape_alq.setText("Apellidos:");

        jLabel2.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad de personas:");

        txtcant.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtcant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantKeyTyped(evt);
            }
        });

        btnbuscar_h.setText("Buscar");
        btnbuscar_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_hActionPerformed(evt);
            }
        });

        btnhuesped.setText("Nuevo Huesped");
        btnhuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuespedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_dt_huespLayout = new javax.swing.GroupLayout(panel_dt_huesp);
        panel_dt_huesp.setLayout(panel_dt_huespLayout);
        panel_dt_huespLayout.setHorizontalGroup(
            panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addComponent(lb_dni_alq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar_h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnhuesped))
                    .addGroup(panel_dt_huespLayout.createSequentialGroup()
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_nom_alq)
                            .addComponent(lb_ape_alq))
                        .addGap(33, 33, 33)
                        .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtapellido))))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        panel_dt_huespLayout.setVerticalGroup(
            panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_huespLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dni_alq)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar_h)
                    .addComponent(btnhuesped))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nom_alq)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_ape_alq)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel_dt_huespLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panel_dt_hab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Habitación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("URW Gothic L", 1, 12))); // NOI18N

        lb_num_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_num_hab_alq.setText("N° Habitación:");

        lb_tip_hab_alq.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        lb_tip_hab_alq.setText("Tipo:");

        txttipoha.setEditable(false);
        txttipoha.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N

        txtnumeroha.setEditable(false);
        txtnumeroha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtnumeroha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumerohaActionPerformed(evt);
            }
        });

        btnbuscar_th.setText("Buscar");
        btnbuscar_th.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_thActionPerformed(evt);
            }
        });

        txtnumeroca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnumeroca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumerocaKeyTyped(evt);
            }
        });

        lb_num_camas_hab_alq1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq1.setText("N° Camas: ");

        javax.swing.GroupLayout panel_dt_habLayout = new javax.swing.GroupLayout(panel_dt_hab);
        panel_dt_hab.setLayout(panel_dt_habLayout);
        panel_dt_habLayout.setHorizontalGroup(
            panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_habLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_habLayout.createSequentialGroup()
                        .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_num_hab_alq)
                            .addComponent(lb_tip_hab_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_dt_habLayout.createSequentialGroup()
                        .addComponent(lb_num_camas_hab_alq1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_habLayout.createSequentialGroup()
                        .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttipoha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumeroha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btnbuscar_th))
                    .addComponent(txtnumeroca, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panel_dt_habLayout.setVerticalGroup(
            panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_habLayout.createSequentialGroup()
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_habLayout.createSequentialGroup()
                        .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_num_hab_alq)
                            .addComponent(txtnumeroha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_tip_hab_alq)
                            .addComponent(txttipoha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_dt_habLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnbuscar_th)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_dt_habLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_num_camas_hab_alq1)
                    .addComponent(txtnumeroca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_dt_alq.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panel_dt_alq.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lb_id_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_alq.setText("ID alquiler:");

        lb_fech_lleg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_lleg.setText("Fecha Llegada:");

        lb_fech_sal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_fech_sal.setText("Fecha Salida:");

        lb_num_camas_hab_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_num_camas_hab_alq.setText("Monto Total:");

        lb_obs_alq.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_alq.setText("Observación: ");

        lb_id_recep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id_recep.setText("ID recepcionista:");

        txtidalquiler.setEditable(false);
        txtidalquiler.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtidalquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidalquilerActionPerformed(evt);
            }
        });

        txtllegada.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtllegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtllegadaActionPerformed(evt);
            }
        });
        txtllegada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtllegadaKeyTyped(evt);
            }
        });

        txtmontototal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtmontototal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontototalKeyTyped(evt);
            }
        });

        txtobservacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtobservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtobservacionKeyTyped(evt);
            }
        });

        txtusuario.setEditable(false);
        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        javax.swing.GroupLayout panel_dt_alqLayout = new javax.swing.GroupLayout(panel_dt_alq);
        panel_dt_alq.setLayout(panel_dt_alqLayout);
        panel_dt_alqLayout.setHorizontalGroup(
            panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_alqLayout.createSequentialGroup()
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panel_dt_alqLayout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtidalquiler, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_dt_alqLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_obs_alq)
                                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_dt_alqLayout.createSequentialGroup()
                                        .addComponent(lb_id_recep)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_dt_alqLayout.createSequentialGroup()
                                        .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_id_alq)
                                            .addComponent(lb_fech_lleg)
                                            .addComponent(lb_fech_sal))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panel_dt_alqLayout.createSequentialGroup()
                                        .addComponent(lb_num_camas_hab_alq, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtmontototal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panel_dt_alqLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panel_dt_alqLayout.setVerticalGroup(
            panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dt_alqLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_id_alq)
                    .addComponent(txtidalquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_fech_lleg)
                    .addComponent(txtllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_fech_sal)
                    .addComponent(txtsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_id_recep)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_dt_alqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_num_camas_hab_alq)
                    .addComponent(txtmontototal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lb_obs_alq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Miembros en la habitación"));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtdni_mi.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtdni_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdni_miKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("DNI:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nombres:");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Apellidos:");

        txtapellido_mi.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtapellido_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellido_miKeyTyped(evt);
            }
        });

        txtnombre_mi.setFont(new java.awt.Font("URW Gothic L", 0, 14)); // NOI18N
        txtnombre_mi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre_miKeyTyped(evt);
            }
        });

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtapellido_mi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtnombre_mi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdni_mi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdni_mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnagregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre_mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtapellido_mi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(9, 9, 9))))
        );

        tb_det.setFont(new java.awt.Font("URW Gothic L", 0, 18)); // NOI18N
        tb_det.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_det);

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btneliminart.setText("Eliminar Todo");
        btneliminart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminartActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btneditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminart, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnactualizar)
                            .addComponent(btneliminar)
                            .addComponent(btneliminart)
                            .addComponent(btneditar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_dt_huesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_dt_hab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_dt_alq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_dt_huesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_dt_hab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_dt_alq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed

    private void txtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdniKeyTyped
        // TODO add your handling code here:
        int numerocaracteres=8;
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtdni.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_txtdniKeyTyped

    private void txtcantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantKeyTyped
        // cantidad de huespedes
        char c = evt.getKeyChar();
        int numerocaracteres=1;
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        } else 
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtcant.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Exceso de dígitos","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_txtcantKeyTyped

    private void btnbuscar_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_hActionPerformed
        // TODO add your handling code here:
        if (txtdni.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese Documento de Identidad");
        }
        else
        {
            txtnombre.setText("");
            txtapellido.setText("");
            String dni= (txtdni.getText());
            try{
                ResultSet rs1;
                PreparedStatement pst=cn.prepareStatement("SELECT nombre_h,apellidos_h FROM hotel_version7.huesped where dni_huesped='"+dni+"'");
                rs1 = pst.executeQuery();//buscando datos y guardando en interfaz
                while(rs1.next()){
                    txtnombre.setText(rs1.getString("nombre_h"));
                    txtapellido.setText(rs1.getString("apellidos_h"));
                }
                if (txtnombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"DNI no encontrado, por favor registre al cliente","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    txtdni.setText("");
                }else{
                    //desbloqueo
                    btnhuesped.setEnabled(false);                    
                    txtcant.setEnabled(true);
                    btnbuscar_th.setEnabled(true);
                    btnguardar.setEnabled(true);
                    txtnumeroha.setEnabled(true);
                    txttipoha.setEnabled(true);
                }
            }catch(HeadlessException | SQLException e){
                System.err.println("No se pudo buscar");
            }
        }

    }//GEN-LAST:event_btnbuscar_hActionPerformed

    private void txtnumerohaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumerohaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumerohaActionPerformed

    private void btnbuscar_thActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_thActionPerformed
        //boton buscar
        // mostrar_seleccion_habitacion();
        //if(Integer.parseInt(txtcant.getText())>0||txtcant.getText().isEmpty()==false){
        btnbuscar_h.setEnabled(false);
        txtdni.setEditable(false);
        //        
        if(txtcant.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingresa Cantidad de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(Integer.parseInt(txtcant.getText())>0){    
            cantidadpersonas=Integer.parseInt(txtcant.getText());
            seleccion_ha=new seleccion_habitacion(this,true);
            seleccion_ha.setVisible(true);
            //
            
            txtcant.setEditable(false);
            txtnumeroca.setEnabled(true);
            txtidalquiler.setEnabled(true);
            txtllegada.setEnabled(true);
            txtsalida.setEnabled(true);
            txtusuario.setEnabled(true);
            txtmontototal.setEnabled(true);
            btnguardar.setEnabled(true);
            txtobservacion.setEnabled(true);
            ////
            if(cantidadpersonas>=2){
                //configurar
                btnagregar.setEnabled(true);                
                txtnombre_mi.setEnabled(true);
                txtapellido_mi.setEnabled(true);
                txtdni_mi.setEnabled(true);
                
            } 
        }else{
            JOptionPane.showMessageDialog(null,"Ingresa número válido de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnbuscar_thActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // boton nuevo
        limpiar(); 
        btnnuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // boton salir
        cc.desconectar();
        bandera_alquiler=null;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // boton guardar
        if(txtdni.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Elija Huésped","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtcant.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingresa Cantidas de Personas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtnumeroca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa Cantidad de camas","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txtidalquiler.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"No existe ID_Alquiler","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtllegada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Ingresa Fecha de llegada","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if (txtsalida.getDate()==null) {
            JOptionPane.showMessageDialog(null,"Ingresa Fecha Salida","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if(txttipoha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Elije habitacion","ERROR",JOptionPane.ERROR_MESSAGE);
        }else if((Integer.parseInt(txtcant.getText())>1) && ((tb_det.getRowCount()+1)!=Integer.parseInt(txtcant.getText()))){
            JOptionPane.showMessageDialog(null,"Completa la Tabla de Huespedes en esta habitación","ERROR",JOptionPane.ERROR_MESSAGE);
        }else
        {
            try
            {
                PreparedStatement pst=cn.prepareStatement("INSERT INTO hotel_version7.alquila (habitacion_nro_hab,"
                        + "huesped_dni_huesped,id_alquila,fecha_llegada,fecha_salida,num_dias,num_camas,observacion,"
                    + "usuario_id_usuario,monto_total) VALUES (?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1,txtnumeroha.getText());
                pst.setString(2,txtdni.getText());
                pst.setString(3,txtidalquiler.getText());//id alquiler
                pst.setString(4,txtllegada.getText());
                pst.setString(5,fecha.getFecha(txtsalida));//fecha salida
                pst.setString(6,"1");//num dias
                pst.setString(7,txtnumeroca.getText());//num camas
                pst.setString(8,txtobservacion.getText());
                pst.setString(9,txtusuario.getText());
                pst.setString(10,txtmontototal.getText());
                int a=pst.executeUpdate();
                if(a>0){
                    System.out.println("Registro exitoso en Alquila");
                }
                else{
                    JOptionPane.showMessageDialog(null,"error al agregar ","Error",1);
                }              
                //
                String habb=txtnumeroha.getText();
                PreparedStatement pst1=cn.prepareStatement("UPDATE hotel_version7.habitacion SET estado='Ocupado' WHERE nro_hab='"+habb+"'");
                int b=pst1.executeUpdate();                
                if(b>0){
                    System.out.println("Actualizacion exitosa en Habitacion");                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al actualizar ","Error",1);
                } 
                int c=1;
                ////  actualizar tabla detalle              
                if(Integer.parseInt(txtcant.getText())>1)
                {
                    c=0;
                    try 
                    {                                                
                        for(int i=0;i<tb_det.getRowCount();i++)
                        {
                            String id="";
                            ResultSet rsa;
                            int cont;
                            Statement sent = cn.createStatement();   
                            rsa = sent.executeQuery("SELECT IFNULL(MAX(CAST(id_detalle AS UNSIGNED)), 0) codigoExterno FROM hotel_version7.detalle_alquila");                                
                            while(rsa.next()){
                                cont =Integer.parseInt(rsa.getString("codigoExterno"))+1;
                                id=(String.valueOf(cont));                                    
                            }
                            PreparedStatement pst2=cn.prepareStatement("INSERT INTO hotel_version7.detalle_alquila"
                                    + " (id_detalle,Nombres,Apellidos,dni_detalle,alquila_id_alquila)"
                                    + " VALUES (?,?,?,?,?)");                               
                            pst2.setString(1,id);//                                
                            pst2.setString(2,tb_det.getValueAt(i,0).toString());//nombre
                            pst2.setString(3,tb_det.getValueAt(i,1).toString());//apellido
                            pst2.setString(4,tb_det.getValueAt(i,2).toString());//dni
                            pst2.setString(5,txtidalquiler.getText());//id alquiler                           
                            c=pst2.executeUpdate();
                            if(c>0){
                                System.out.println("Registro exitoso en detalle_alquiler");
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Error al agregar ","Error",1);
                            }                                
                        }//fin for                            
                    } catch (Exception e) {
                       System.out.println("no se pudo actualizar detalle alquiler: "+e.getMessage());
                    }//fin trycatch
                }// fin if para detalle alquiler                
                if((a>0)&&(b>0)&&(c>0)){
                    JOptionPane.showMessageDialog(null,"Registro Exitoso","FELICITACIONES",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Error al agregar ");
                }
                btnnuevo();
                eliminarelementos(); 
                bloqueorestantes();///fin de todos los insert
               
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(null, "error al agegar datos en alquila y detalle " +e);
            }//fin trycatch
        }//fn else 
        ///
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtllegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtllegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtllegadaActionPerformed

    private void txtmontototalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontototalKeyTyped
        // TODO add your handling code here:       
        int numerocaracteres=7;        
        if(txtmontototal.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtmontototalKeyTyped

    private void txtobservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtobservacionKeyTyped
        // observacion        
        int numerocaracteres=35;        
        if(txtobservacion.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtobservacionKeyTyped

    private void txtnumerocaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumerocaKeyTyped
        // camas
        char c = evt.getKeyChar();
        int numerocaracteres=1;
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo numeros");
        }else if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtnumeroca.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtnumerocaKeyTyped

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // boton agregar
        String []Dato=new String [5];
        //Dato[0]=txtidalquiler.getText();
        //Dato[1]=txtnumeroha.getText();
        Dato[0]=txtnombre_mi.getText();
        Dato[1]=txtapellido_mi.getText();
        Dato[2]=txtdni_mi.getText();
        txtnombre_mi.setText(null);
        txtapellido_mi.setText(null);
        txtdni_mi.setText(null);
        modelo.addRow(Dato);
        //
        btneditar.setEnabled(true);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(true);
        btneliminart.setEnabled(true);
        //
        cantidadpersonas=cantidadpersonas-1;
        if(cantidadpersonas<=1){
            ///
            btnagregar.setEnabled(false);
            txtnombre_mi.setEnabled(false);
            txtapellido_mi.setEnabled(false);
            txtdni_mi.setEnabled(false);
            
            btnactualizar.setEnabled(false);
            
        }

    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // btn eliminar
        int filasel=tb_det.getSelectedRow();
        if(filasel>=0){
            modelo.removeRow(filasel);
            cantidadpersonas=cantidadpersonas+1;
            
            txtnombre_mi.setEnabled(true);
            txtapellido_mi.setEnabled(true);
            txtdni_mi.setEnabled(true);            
            btnagregar.setEnabled(true);
            //btneditar.setEnabled(false);
            //btnactualizar.setEnabled(true);
            //btneliminar.setEnabled(false);
            //btneliminart.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(null,"Elije registro para eliminar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btneliminartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminartActionPerformed
        // boton eliminar todos elementos
        eliminarelementos(); 
        btnagregar.setEnabled(true);
        btneditar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        btneliminart.setEnabled(false);
        
        txtnombre_mi.setEnabled(true);
        txtapellido_mi.setEnabled(true);
        txtdni_mi.setEnabled(true);            
        
    }//GEN-LAST:event_btneliminartActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // Actualizar
        modelo.setValueAt(txtnombre_mi.getText(), seleccionado, 0);
        modelo.setValueAt(txtapellido_mi.getText(), seleccionado, 1);
        modelo.setValueAt(txtdni_mi.getText(), seleccionado, 2);
        txtnombre_mi.setText(null);
        txtapellido_mi.setText(null);
        txtdni_mi.setText(null);
        
        
        btneditar.setEnabled(true);
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(true);
        btneliminart.setEnabled(true);
        
        btnagregar.setEnabled(true); 
        
        if(cantidadpersonas<=1){
            ///
            txtnombre_mi.setEnabled(false);
            txtapellido_mi.setEnabled(false);
            txtdni_mi.setEnabled(false); 
            btnagregar.setEnabled(false);  
            
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtidalquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidalquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidalquilerActionPerformed

    private void btnhuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuespedActionPerformed
        // boton nuevo huesped
       
        String bandera=huesped.bandera_huesped;
        try{            
            if(bandera==null){            
                huesped a= new huesped();
                this.getDesktopPane().add(a);
                a.setVisible(true);            
            }else{
                JOptionPane.showMessageDialog(rootPane,"La ventana ya esta abierta!");
            }    
        }catch(Exception e){
            e.printStackTrace();    
        }
        
    }//GEN-LAST:event_btnhuespedActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // cerrando ventana
        bandera_alquiler=null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        seleccionado=tb_det.getSelectedRow();
        if(seleccionado>-1){
            txtnombre_mi.setText(tb_det.getValueAt(seleccionado,0).toString());
            txtapellido_mi.setText(tb_det.getValueAt(seleccionado,1).toString());
            txtdni_mi.setText(tb_det.getValueAt(seleccionado,2).toString()); 
            txtnombre_mi.setEnabled(true);
            txtapellido_mi.setEnabled(true);
            txtdni_mi.setEnabled(true);
            
            btnagregar.setEnabled(false); 
            
            btneditar.setEnabled(false);
            btnactualizar.setEnabled(true);
            btneliminar.setEnabled(false);
            btneliminart.setEnabled(false);           
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void txtllegadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtllegadaKeyTyped
        // fecha llegada        
        int numerocaracteres=11;        
        if(txtllegada.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtllegadaKeyTyped

    private void txtdni_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdni_miKeyTyped
        // dni de miembro habitacion
        int numerocaracteres=8;
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtdni_mi.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtdni_miKeyTyped

    private void txtnombre_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre_miKeyTyped
        // nombre miembro habitacion
        int numerocaracteres=20;
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtnombre_mi.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtnombre_miKeyTyped

    private void txtapellido_miKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellido_miKeyTyped
        // apellido de miembro habitacion
        int numerocaracteres=20;
        if ((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>123 && (int)evt.getKeyChar()<=255)
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No usar caracteres","!Advertencia!",JOptionPane.WARNING_MESSAGE);
        }else if(txtapellido_mi.getText().length()>=numerocaracteres){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtapellido_miKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar_h;
    private javax.swing.JButton btnbuscar_th;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btneliminart;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnhuesped;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ape_alq;
    private javax.swing.JLabel lb_dni_alq;
    private javax.swing.JLabel lb_fech_lleg;
    private javax.swing.JLabel lb_fech_sal;
    private javax.swing.JLabel lb_id_alq;
    private javax.swing.JLabel lb_id_recep;
    private javax.swing.JLabel lb_nom_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq;
    private javax.swing.JLabel lb_num_camas_hab_alq1;
    private javax.swing.JLabel lb_num_hab_alq;
    private javax.swing.JLabel lb_obs_alq;
    private javax.swing.JLabel lb_tip_hab_alq;
    private javax.swing.JPanel panel_dt_alq;
    private javax.swing.JPanel panel_dt_hab;
    private javax.swing.JPanel panel_dt_huesp;
    private javax.swing.JTable tb_det;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtapellido_mi;
    private javax.swing.JTextField txtcant;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtdni_mi;
    private javax.swing.JTextField txtidalquiler;
    private javax.swing.JTextField txtllegada;
    public static javax.swing.JTextField txtmontototal;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombre_mi;
    public static javax.swing.JTextField txtnumeroca;
    public static javax.swing.JTextField txtnumeroha;
    private javax.swing.JTextField txtobservacion;
    private com.toedter.calendar.JDateChooser txtsalida;
    public static javax.swing.JTextField txttipoha;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
