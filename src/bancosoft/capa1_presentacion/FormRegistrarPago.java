/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa1_presentacion;

import bancosoft.capa1_presentacion.util.ConfiguradorDeTabla;
import bancosoft.capa1_presentacion.util.Mensaje;
import bancosoft.capa2_aplicacion.GestionarClienteServicio;
import bancosoft.capa2_aplicacion.RegistrarPagoServicio;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Pago;
import bancosoft.capa3_dominio.entidades.Prestamo;
import java.text.DecimalFormat;
import java.util.EventObject;
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
public class FormRegistrarPago extends javax.swing.JDialog {

    Cliente cliente;
    Cuota cuota;
    Pago pago;
    private int selecciona_prestamoid;
    private int selecciona_cuotaid;
    private java.sql.Date fecha_pago;
    private double monto_cuota;
    private int numFila;

    /**
     * Creates new form FormRegistrarPago
     */
    public FormRegistrarPago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarPrestamosCliente();
        mostrarTablaCuotas();
    }

    public void mostrarPrestamosCliente() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("ID", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Cuotas", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Interes", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Fecha", "java.lang.String"));
        tabla.agregarColumna(new Columna("Monto", "java.lang.Double"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaPrestamos.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaPrestamos, 0, 30, 30, 30);
        ConfiguradorDeTabla.ocultarColumna(tablaPrestamos, 0);
    }

    public void mostrarTablaCuotas() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("ID", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Capital", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Interes", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Seguro", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Monto", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Fecha", "java.lang.String"));
        tabla.agregarColumna(new Columna("Estado", "java.lang.String"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaCuotas.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 0, 30, 30, 30);
        ConfiguradorDeTabla.ocultarColumna(tablaCuotas, 0);
    }

    public void refrescarDatosTabla(JTable tabla) {
        ModeloTabla modeloTabla = (ModeloTabla) tabla.getModel();
        modeloTabla.refrescarDatos();
    }

    public void limpiarTodo() {
        txtDNI.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtMonto.setText("");
        txtMora.setText("");
        txtTotal.setText("");
        ModeloTabla modeloTabla = (ModeloTabla) tablaPrestamos.getModel();
        modeloTabla.eliminarTotalFilas();
    }

    public void buscarPrestamos(String dni) {
        Fila fila;
        try {
            RegistrarPagoServicio registrarPagoServicio = new RegistrarPagoServicio();
            List<Prestamo> prestamos = registrarPagoServicio.buscarPrestamos(dni);
            ModeloTabla modeloTabla = (ModeloTabla) tablaPrestamos.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Prestamo prestamo : prestamos) {
                fila = new Fila();
                fila.agregarValorCelda(prestamo.getPrestamoid());
                fila.agregarValorCelda(prestamo.getNumeroCuotas());
                fila.agregarValorCelda(prestamo.getInteres());
                fila.agregarValorCelda(prestamo.getFechaInicio());
                fila.agregarValorCelda(prestamo.getMonto());
                modeloTabla.agregarFila(fila);
            }
            modeloTabla.refrescarDatos();
        } catch (Exception e) {
            Mensaje.mostrarError(this, e.getMessage());
        }
    }

    public void buscarCuotas(int idcuota, String estado) {
        Fila fila;
        try {
            RegistrarPagoServicio registrarPagoServicio = new RegistrarPagoServicio();
            List<Cuota> cuotas = registrarPagoServicio.buscarCuotas(idcuota, estado);
            ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
            modeloTabla.eliminarTotalFilas();
            for (Cuota cuota : cuotas) {
                fila = new Fila();
                fila.agregarValorCelda(cuota.getCuotaid());
                fila.agregarValorCelda(cuota.getCapital_cuota());
                fila.agregarValorCelda(cuota.getInteres_cuota());
                fila.agregarValorCelda(cuota.getSeguro());
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

    public void seleccionaPrestamo() {
        int numeroFila = tablaPrestamos.getSelectedRow();
        if (numeroFila == -1) {
            Mensaje.mostrarFilaNoSeleccionada(this);
            return;
        }
        ModeloTabla modeloTabla = (ModeloTabla) tablaPrestamos.getModel();
        Fila fila = modeloTabla.obtenerFila(numeroFila);
        selecciona_prestamoid = (Integer) fila.obtenerCelda(0).getValor();
    }

    public void seleccionaCuota() {
        int numeroFila = tablaCuotas.getSelectedRow();
        numFila = numeroFila;
        if (numeroFila != 0) {
            return;
        } else {
            ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
            Fila fila = modeloTabla.obtenerFila(numeroFila);
            selecciona_cuotaid = (Integer) fila.obtenerCelda(0).getValor();
            monto_cuota = (Double) fila.obtenerCelda(4).getValor();
            fecha_pago = (java.sql.Date) fila.obtenerCelda(5).getValor();

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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCuotas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro De Pagos");
        setBackground(new java.awt.Color(255, 204, 102));

        jLabel1.setBackground(new java.awt.Color(255, 204, 102));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR PAGOS DE CUOTAS DE PRESTAMOS");

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("NOMBRES:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("APELLIDOS:");

        txtDNI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombres.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombres.setEnabled(false);

        txtApellidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtApellidos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtApellidos.setEnabled(false);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombres))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prestamos Pendientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        tablaPrestamos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablaPrestamos.setForeground(new java.awt.Color(102, 0, 0));
        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPrestamos.setSelectionBackground(new java.awt.Color(204, 255, 0));
        tablaPrestamos.setSelectionForeground(new java.awt.Color(255, 0, 0));
        tablaPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPrestamosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPrestamos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuotas Pendientes de Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        tablaCuotas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablaCuotas.setForeground(new java.awt.Color(0, 0, 204));
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
        tablaCuotas.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tablaCuotas.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tablaCuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCuotasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCuotas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pago"));

        btnPagar.setText("Pagar Cuota");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/new.png"))); // NOI18N
        btnNuevo.setText("Nuevo Pago");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Monto de Cuota");

        txtMonto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtMonto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMonto.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Soles");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Mora");

        txtMora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtMora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMora.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Soles");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Total a Pagar:");

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotal.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Soles");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar)
                    .addComponent(btnNuevo)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dni = txtDNI.getText();
        if (txtDNI.getText().equals("")) {
            Mensaje.mostrarError(this, "Ingrese DNI del cliente");
            txtDNI.requestFocusInWindow();
        } else {
            if (txtDNI.getText().length() != 8) {
                Mensaje.mostrarError(this, "El N° de DNI: " + dni + "\n  No es Correcto");
                txtDNI.setText("");
                txtDNI.requestFocusInWindow();
            } else {
                try {
                    GestionarClienteServicio gestionarClienteServicio = new GestionarClienteServicio();
                    cliente = gestionarClienteServicio.buscarDNI(dni);
                    if (cliente != null) {
                        txtNombres.setText(cliente.getNombre());
                        txtApellidos.setText(cliente.getApellido());
                        buscarPrestamos(cliente.getDni());
                    } else {
                        Mensaje.mostrarError(this, " El cliente no se encuentra registrado en el sistema.");
                        txtDNI.setText("");
                        txtDNI.requestFocusInWindow();
                    }

                } catch (Exception e) {
                    Mensaje.mostrarError(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPrestamosMouseClicked
        String estado = "PENDIENTE";
        seleccionaPrestamo();
        buscarCuotas(selecciona_prestamoid, estado);
    }//GEN-LAST:event_tablaPrestamosMouseClicked

    private void tablaCuotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCuotasMouseClicked
        cuota = new Cuota();
        seleccionaCuota();
        if (numFila == 0) {
            cuota.setCuotaid(selecciona_cuotaid);
            cuota.setMontoCuota(monto_cuota);
            cuota.setFechaPago(fecha_pago);
            pago = new Pago();
            pago.setCuota(cuota);
            DecimalFormat formateador = new DecimalFormat("#0.0");
            txtMonto.setText(String.valueOf(formateador.format(cuota.getMontoCuota())));
            txtMora.setText(String.valueOf(formateador.format(pago.calcularMora())));
            txtTotal.setText(String.valueOf(formateador.format(pago.pagoTotal())));
        } else {
            Mensaje.mostrarError(this, "La cuota Seleccionada no puede ser Pagada \n Tiene cuotas Anteriores Pendientes");
            txtMonto.setText("");
            txtMora.setText("");
            txtTotal.setText("");
        }

    }//GEN-LAST:event_tablaCuotasMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarTodo();
        ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
        modeloTabla.eliminarTotalFilas();
        txtDNI.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (txtMonto.getText().equals("") || txtMora.getText().equals("") || txtTotal.getText().equals("")) {
            Mensaje.mostrarErrorDeCreacion(this);
        } else {
            try {
                RegistrarPagoServicio registrarPagoServicio = new RegistrarPagoServicio();
                int registros_afectados = registrarPagoServicio.registrarPago(pago);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                    if (Mensaje.mostrarPreguntaDePermanencia(this)) {
                        ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
                        modeloTabla.refrescarDatos();
                        txtMonto.setText("");
                        txtMora.setText("");
                        txtTotal.setText("");

                    } else {
                        limpiarTodo();
                        ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
                        modeloTabla.eliminarTotalFilas();
                        txtDNI.requestFocusInWindow();
                    }

                }
            } catch (Exception e) {
                Mensaje.mostrarError(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtDNI.getText().length() == Cliente.LONGITUD_DNI
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

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
            java.util.logging.Logger.getLogger(FormRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormRegistrarPago dialog = new FormRegistrarPago(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCuotas;
    private javax.swing.JTable tablaPrestamos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
