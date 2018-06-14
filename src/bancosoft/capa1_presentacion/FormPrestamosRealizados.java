/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa1_presentacion;

import bancosoft.capa1_presentacion.util.ConfiguradorDeTabla;
import bancosoft.capa1_presentacion.util.Mensaje;
import bancosoft.capa2_aplicacion.RegistrarPrestamoServicio;
import bancosoft.capa3_dominio.entidades.Prestamo;
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

    /**
     * Creates new form FormPrestamosRealizados
     */
    public FormPrestamosRealizados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarPagadosTabla();
        mostrarPendientesTabla();
    }

    public void mostrarPagadosTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna(null, null));
        tabla.agregarColumna(new Columna("MONTO", "java.lang.Double"));
        tabla.agregarColumna(new Columna("INTERES ANUAL", "java.lang.Double"));
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
        tabla.agregarColumna(new Columna("INTERES ANUAL"+"%", "java.lang.Double"));
        tabla.agregarColumna(new Columna("CUOTAS", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("FECHA", "java.lang.String"));
        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaPendientes.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPendientes, 0, 30, 30, 30);
        ConfiguradorDeTabla.ocultarColumna(tablaPendientes, 0);
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
            List<Prestamo> prestamos = registrarPrestamoServicio.buscarProductos(estado);
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

    public void buscarPendientes() {
        Fila fila;
        String estado = "VIGENTE";
        try {
            RegistrarPrestamoServicio registrarPrestamoServicio = new RegistrarPrestamoServicio();
            List<Prestamo> prestamos = registrarPrestamoServicio.buscarProductos(estado);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPendientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPagados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRESTAMOS PAGADOS");

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
        jScrollPane1.setViewportView(tablaPendientes);

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
        jScrollPane2.setViewportView(tablaPagados);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PRESTAMOS PENDIENTES DE PAGO");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/new.png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        refrescarDatosTabla(tablaPagados);
        refrescarDatosTabla(tablaPendientes);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        buscarPagados();
        buscarPendientes();
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPagados;
    private javax.swing.JTable tablaPendientes;
    // End of variables declaration//GEN-END:variables
}
