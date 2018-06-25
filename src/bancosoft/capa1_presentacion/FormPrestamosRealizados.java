/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa1_presentacion;

import bancosoft.capa1_presentacion.util.ConfiguradorDeTabla;
import bancosoft.capa1_presentacion.util.Mensaje;
import bancosoft.capa2_aplicacion.RegistrarPrestamoServicio;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Prestamo;
import bancosoft.capa3_dominio.entidades.Usuario;
import java.util.List;
import javax.swing.JTable;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author estal
 */
public class FormPrestamosRealizados extends javax.swing.JDialog {
    
    Usuario user = FormInciarSeccion.usuario;
    public int idanalista = user.getUsuarioid();
    private int pendientes_id;
    private int pagados_id;
    private int selecciona_cuotaid;

    /**
     * Creates new form FormPrestamosRealizados
     */
    public FormPrestamosRealizados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarPagadosTabla();
        mostrarPendientesTabla();
        mostrarCuotasTabla();
    }
    
    public void limpiarTextos() {
        txtDNI.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
    }
    
    public void limpiarTodo() {
        limpiarTablaCuotas();
        limpiarTablaPagados();
        limpiarTablaPendientes();
        limpiarTextos();
    }
    
    public void limpiarTablaPagados() {
        ModeloTabla modeloTabla = (ModeloTabla) tablaPagados.getModel();
        modeloTabla.eliminarTotalFilas();
    }
    
    public void limpiarTablaPendientes() {
        ModeloTabla modeloTabla = (ModeloTabla) tablaPendientes.getModel();
        modeloTabla.eliminarTotalFilas();
    }
    
    public void limpiarTablaCuotas() {
        ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
        modeloTabla.eliminarTotalFilas();
    }
    
    public void mostrarPagadosTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna(null, null));
        tabla.agregarColumna(new Columna("MONTO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("INTERES " + "%", "java.lang.Double"));
        tabla.agregarColumna(new Columna("CUOTAS", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("FECHA", "java.lang.String"));
        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaPagados.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPagados, 0, 30, 30, 30);
        ConfiguradorDeTabla.ocultarColumna(tablaPagados, 0);
        
    }
    
    public void mostrarPendientesTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna(null, null));
        tabla.agregarColumna(new Columna("MONTO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("INTERES " + "%", "java.lang.Double"));
        tabla.agregarColumna(new Columna("CUOTAS", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("FECHA", "java.lang.String"));
        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaPendientes.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPendientes, 0, 30, 30, 30);
        ConfiguradorDeTabla.ocultarColumna(tablaPendientes, 0);
    }
    
    public void mostrarCuotasTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("ID", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("MONTO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("FECHA DE PAGO", "java.lang.String"));
        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaCuotas.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 0, 40, 50, 50);
        
    }
    
    public void refrescarDatosTabla(JTable tabla) {
        ModeloTabla modeloTabla = (ModeloTabla) tabla.getModel();
        modeloTabla.refrescarDatos();
    }
    
    public void buscarPagados() {
        Fila fila;
        String estado = "CANCELADO";
        try {
            RegistrarPrestamoServicio registrarPrestamoServicio = new RegistrarPrestamoServicio();
            List<Prestamo> prestamos = registrarPrestamoServicio.buscarPrestamos(estado, idanalista);
            ModeloTabla modeloTabla = (ModeloTabla) tablaPagados.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Prestamo prestamo : prestamos) {
                fila = new Fila();
                fila.agregarValorCelda(prestamo.getPrestamoid());
                fila.agregarValorCelda(prestamo.getMonto());
                fila.agregarValorCelda(prestamo.getInteres());
                fila.agregarValorCelda(prestamo.getNumeroCuotas());
                fila.agregarValorCelda(prestamo.getFechaInicio());
                fila.agregarValorCelda(prestamo.getEstado());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarError(this, e.getMessage());
        }
    }
    
    public void buscarCliente(int idprestamo) {
        try {
            RegistrarPrestamoServicio registrarPrestamoServicio = new RegistrarPrestamoServicio();
            Cliente cliente = registrarPrestamoServicio.buscarCliente(idprestamo);
            if (cliente != null) {
                txtDNI.setText(cliente.getDni());
                txtNombre.setText(cliente.getNombre());
                txtApellidos.setText(cliente.getApellido());
            } else {
                Mensaje.mostrarError(this, "No se a encontrado un cliente");
                
            }
        } catch (Exception e) {
            Mensaje.mostrarError(this, e.getMessage());
        }
    }
    
    public void buscarCuotas(int idprestamo) {
        Fila fila;
        try {
            RegistrarPrestamoServicio registrarPrestamoServicio = new RegistrarPrestamoServicio();
            List<Cuota> cuotas = registrarPrestamoServicio.buscarCuotas(idprestamo);
            ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Cuota cuota : cuotas) {
                fila = new Fila();
                fila.agregarValorCelda(cuota.getCuotaid());
                fila.agregarValorCelda(cuota.getMontoCuota());
                fila.agregarValorCelda(cuota.getFechaPago());
                fila.agregarValorCelda(cuota.getEstado());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarError(this, e.getMessage());
        }
    }
    
    public void seleccionaPendientes() {
        int numeroFila = tablaPendientes.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaPendientes.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        pendientes_id = (Integer) fila.obtenerCelda(0).getValor();
    }
    
    public void seleccionaPagados() {
        int numeroFila = tablaPagados.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaPagados.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        pagados_id = (Integer) fila.obtenerCelda(0).getValor();
    }
    
    public void buscarPendientes() {
        Fila fila;
        String estado = "VIGENTE";
        
        try {
            RegistrarPrestamoServicio registrarPrestamoServicio = new RegistrarPrestamoServicio();
            List<Prestamo> prestamos = registrarPrestamoServicio.buscarPrestamos(estado, idanalista);
            ModeloTabla modeloTabla = (ModeloTabla) tablaPendientes.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Prestamo prestamo : prestamos) {
                fila = new Fila();
                fila.agregarValorCelda(prestamo.getPrestamoid());
                fila.agregarValorCelda(prestamo.getMonto());
                fila.agregarValorCelda(prestamo.getInteres());
                fila.agregarValorCelda(prestamo.getNumeroCuotas());
                fila.agregarValorCelda(prestamo.getFechaInicio());
                fila.agregarValorCelda(prestamo.getEstado());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarError(this, e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPagados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPendientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCuotas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 166, 184));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HISTORIAL DE PRESTAMOS BANCARIOS");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRESTAMOS PAGADOS");

        tablaPagados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tablaPagados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPagados.setSelectionBackground(new java.awt.Color(0, 0, 255));
        tablaPagados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPagadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPagados);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRESTAMOS PENDIENTES DE PAGO");

        tablaPendientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tablaPendientes.setForeground(new java.awt.Color(255, 0, 0));
        tablaPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPendientes.setSelectionBackground(new java.awt.Color(0, 51, 204));
        tablaPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPendientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPendientes);

        jButton1.setBackground(new java.awt.Color(51, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/new.png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 166, 184));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("DNI:");

        txtDNI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtDNI.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDNI.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApellidos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtApellidos.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tablaCuotas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablaCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCuotas.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tablaCuotas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tablaCuotas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarTodo();
        buscarPagados();
        buscarPendientes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        buscarPagados();
        buscarPendientes();
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPendientesMouseClicked
        limpiarTextos();
        limpiarTablaCuotas();
        seleccionaPendientes();
        buscarCliente(pendientes_id);
        buscarCuotas(pendientes_id);
        refrescarDatosTabla(tablaPagados);
    }//GEN-LAST:event_tablaPendientesMouseClicked

    private void tablaPagadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPagadosMouseClicked
        limpiarTextos();
        limpiarTablaCuotas();
        seleccionaPagados();
        buscarCliente(pagados_id);
        buscarCuotas(pagados_id);
        refrescarDatosTabla(tablaPendientes);
    }//GEN-LAST:event_tablaPagadosMouseClicked

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
            java.util.logging.Logger.getLogger(FormPrestamosRealizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrestamosRealizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrestamosRealizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrestamosRealizados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPrestamosRealizados dialog = new FormPrestamosRealizados(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaCuotas;
    private javax.swing.JTable tablaPagados;
    private javax.swing.JTable tablaPendientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
