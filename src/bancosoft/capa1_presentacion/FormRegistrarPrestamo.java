/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosoft.capa1_presentacion;

import bancosoft.capa1_presentacion.util.ConfiguradorDeTabla;
import bancosoft.capa1_presentacion.util.HelpersFecha;
import bancosoft.capa1_presentacion.util.Mensaje;
import bancosoft.capa2_aplicacion.GestionarClienteServicio;
import bancosoft.capa2_aplicacion.RegistrarPrestamoServicio;
import bancosoft.capa3_dominio.entidades.Analista;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Prestamo;
import bancosoft.capa3_dominio.entidades.Usuario;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author estal
 */
public class FormRegistrarPrestamo extends javax.swing.JDialog {

    Usuario user = FormInciarSeccion.usuario;
    Date fecha;
    Cliente cliente;
    Prestamo prestamo;
    int numero_prestamos;

    public FormRegistrarPrestamo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        MostrarCuotasTabla();
        this.desabilitar();
        fecha = java.sql.Date.valueOf(String.format("%1$tY-%1$tm-%1$te", new java.util.Date()));;
        txtFecha.setText("" + fecha);
        txtAnalista.setText(user.getNombre().toUpperCase());
    }

    public void habilitar() {
        btnGuardar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnCronograma.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnSalir.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnImprimir.setEnabled(true);
        txtDNI.setEnabled(true);
        txtMonto.setEnabled(true);
        txtCuotas.setEnabled(true);
        txtInteres.setEnabled(true);
        txtNota.setEnabled(true);
    }

    public void desabilitar() {
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnCronograma.setEnabled(false);
        btnImprimir.setEnabled(false);
        txtDNI.setEnabled(false);
        txtMonto.setEnabled(false);
        txtCuotas.setEnabled(false);
        txtInteres.setEnabled(false);
        txtNota.setEnabled(false);
    }

    public void MostrarCuotasTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("N°", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Fecha Pago", "java.lang.String"));
        tabla.agregarColumna(new Columna("capital", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Interés", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Cuota", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Seguro", "java.lang.Double"));
        tabla.agregarColumna(new Columna("Total", "java.lang.Double"));
        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tablaCuotas.setModel(modeloTabla);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 0, 40, 50, 40);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 1, 140, 150, 140);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 2, 120, 130, 120);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 3, 110, 120, 110);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 4, 125, 130, 125);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 5, 110, 120, 110);
        ConfiguradorDeTabla.configurarAnchoColumna(tablaCuotas, 6, 130, 140, 130);
        txtDNI.requestFocus();
    }

    public void limpiarTextos() {
        txtDNI.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtMonto.setText("");
        txtInteres.setText("");

    }

    public void limpiarTodo() {
        limpiarTextos();
        txtCuotas.setText("");
        txtValorCuota.setText("");
        txtCapital.setText("");
        txtInteresTotal.setText("");
        txtTotalCredito.setText("");
        txtTotalPrestamo.setText("");
        txtNota.setText("");
        txtCuotaImporte.setText("");
        txtSeguro.setText("");
        ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
        modeloTabla.eliminarTotalFilas();
    }

    public void refrescarDatosTabla(JTable tabla) {
        ModeloTabla modeloTabla = (ModeloTabla) tabla.getModel();
        modeloTabla.refrescarDatos();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNPrestamos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAnalista = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCuotas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtValorCuota = new javax.swing.JTextField();
        btnCronograma = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuotas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtCapital = new javax.swing.JTextField();
        txtCuotaImporte = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTotalPrestamo = new javax.swing.JTextField();
        txtInteresTotal = new javax.swing.JTextField();
        txtSeguro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTotalCredito = new javax.swing.JTextField();
        txtNota = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro De Prestamos");
        setIconImage(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 166, 184));
        jPanel1.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(0, 166, 184));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("DNI:");

        txtDNI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 204, 204));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Nombres");

        txtNombre.setBackground(java.awt.SystemColor.control);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 0, 0));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setText("Apellidos");

        txtApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtApellido.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("Fecha:");

        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtFecha.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("N° De Prestamos:");

        txtNPrestamos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNPrestamos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNPrestamos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNPrestamos.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel12.setText("Analista:");

        txtAnalista.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAnalista.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAnalista.setEnabled(false);

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(txtAnalista))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel3))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtAnalista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 11, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 166, 184));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Prestamo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setText("Taza de Interés");

        txtInteres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtInteres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInteresKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setText("%");

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText("Monto S/.");

        txtMonto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setText("N° de Cuotas");

        txtCuotas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCuotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuotasKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setText("Valor cuota");

        txtValorCuota.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtValorCuota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValorCuota.setDisabledTextColor(new java.awt.Color(0, 0, 255));
        txtValorCuota.setEnabled(false);

        btnCronograma.setBackground(new java.awt.Color(0, 204, 204));
        btnCronograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/calendar.png"))); // NOI18N
        btnCronograma.setText("Generar Cronograma");
        btnCronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCronogramaActionPerformed(evt);
            }
        });

        tablaCuotas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tablaCuotas.setForeground(new java.awt.Color(0, 0, 204));
        tablaCuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCuotas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaCuotas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaCuotas.setName(""); // NOI18N
        tablaCuotas.setSelectionBackground(new java.awt.Color(204, 255, 51));
        tablaCuotas.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tablaCuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCuotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCuotas);
        tablaCuotas.getAccessibleContext().setAccessibleParent(this);

        jPanel4.setBackground(new java.awt.Color(0, 166, 184));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtCapital.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCapital.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCapital.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCapital.setEnabled(false);

        txtCuotaImporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtCuotaImporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCuotaImporte.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCuotaImporte.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("=");

        txtTotalPrestamo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTotalPrestamo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalPrestamo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalPrestamo.setEnabled(false);
        txtTotalPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPrestamoActionPerformed(evt);
            }
        });

        txtInteresTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtInteresTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtInteresTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtInteresTotal.setEnabled(false);
        txtInteresTotal.setSelectionColor(new java.awt.Color(255, 0, 51));

        txtSeguro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtSeguro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSeguro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSeguro.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(txtCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtInteresTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtCuotaImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(txtTotalPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapital)
                    .addComponent(txtCuotaImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtInteresTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("TOTALES");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Total Credito");

        txtTotalCredito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalCredito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCredito.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalCredito.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Nota");

        btnImprimir.setBackground(new java.awt.Color(102, 102, 255));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/print.png"))); // NOI18N
        btnImprimir.setText("Imprimir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel8)
                        .addGap(16, 16, 16)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCronograma))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(667, 667, 667)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 74, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addGap(16, 16, 16)
                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCronograma)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtNota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtInteres.getAccessibleContext().setAccessibleParent(this);
        txtMonto.getAccessibleContext().setAccessibleParent(this);
        txtCuotas.getAccessibleContext().setAccessibleParent(this);
        jPanel4.getAccessibleContext().setAccessibleParent(this);

        jPanel5.setBackground(new java.awt.Color(0, 166, 184));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnGuardar.setBackground(new java.awt.Color(51, 204, 0));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 153, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/new.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 204, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("REGISTRO DE PRESTAMOS BANCARIOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleParent(this);
        jPanel3.getAccessibleContext().setAccessibleParent(this);
        jPanel5.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarTodo();
        this.habilitar();
        txtDNI.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTodo();
        this.desabilitar();// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (cliente != null && prestamo != null) {
            prestamo.setCliente(cliente);
            Analista analista = new Analista();
            analista.setIdanalista(user.getUsuarioid());
            prestamo.setAnalista(analista);
            prestamo.setNota(txtNota.getText());
            try {
                RegistrarPrestamoServicio gestionarPrestamoServicio = new RegistrarPrestamoServicio();
                int registros_afectados = gestionarPrestamoServicio.crearPrestamo(prestamo);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeCreacion(this);
                    limpiarTodo();
                    this.desabilitar();
                } else {
                    Mensaje.mostrarErrorDeCreacion(this);
                }
            } catch (Exception e) {
                Mensaje.mostrarError(this, e.getMessage());
            }
        } else {
            Mensaje.mostrarErrorDeCreacion(this);
            txtDNI.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTotalPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPrestamoActionPerformed

    private void tablaCuotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCuotasMouseClicked

    }//GEN-LAST:event_tablaCuotasMouseClicked

    private void btnCronogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCronogramaActionPerformed

        Date fecha_next;
        double total_capital = 0, total_interes = 0, total_cuota = 0, total = 0, total_seguro = 0;
        if (txtMonto.getText().equals("") && txtInteres.getText().equals("") && txtCuotas.getText().equals("")) {
            Mensaje.mostrarError(this, "Faltan Datos. No se puede Generar el Cronograma");
            txtMonto.requestFocusInWindow();
        } else {
            prestamo = new Prestamo();
            prestamo.setMonto(Double.parseDouble(txtMonto.getText()));
            prestamo.setInteres(Double.parseDouble(txtInteres.getText()));
            prestamo.setNumeroCuotas(Integer.parseInt(txtCuotas.getText()));
            if (prestamo.validarMonto()==true && prestamo.validarInteres()==true && prestamo.validarCuotas()==true) {
                ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
                modeloTabla.eliminarTotalFilas();
                for (int i = 1; i <= prestamo.getNumeroCuotas(); i++) {
                    Cuota cuota = new Cuota();
                    cuota.setCapital_cuota(prestamo.calcularCapital());
                    cuota.setInteres_cuota(prestamo.calcularInteresMensual());
                    cuota.setSeguro(prestamo.calcularDesgraven());
                    fecha_next = HelpersFecha.addDay(fecha, i * 31);
                    cuota.setFechaPago(fecha_next);
                    cuota.setMontoCuota(prestamo.calcularImporteDeCuota());
                    prestamo.agregarCuota(cuota);
                    Fila fila = new Fila();
                    fila.agregarValorCelda(i);
                    fila.agregarValorCelda(String.format("%1$tY-%1$tm-%1$te", cuota.getFechaPago()));
                    fila.agregarValorCelda(cuota.getCapital_cuota());
                    fila.agregarValorCelda(cuota.getInteres_cuota());
                    fila.agregarValorCelda(prestamo.calcularImporteCuotaReferencial());
                    fila.agregarValorCelda(cuota.getSeguro());
                    fila.agregarValorCelda(cuota.getMontoCuota());
                    total_capital = total_capital + prestamo.calcularCapital();
                    total_interes = total_interes + prestamo.calcularInteresMensual();
                    total_cuota = total_cuota + prestamo.calcularImporteCuotaReferencial();
                    total_seguro = total_seguro + prestamo.calcularDesgraven();
                    total = total + prestamo.calcularImporteDeCuota();
                    modeloTabla.agregarFila(fila);
                }
                modeloTabla.refrescarDatos();
                DecimalFormat formateador = new DecimalFormat("#0.00");
                txtValorCuota.setText("S/. " + String.valueOf(formateador.format(prestamo.calcularImporteDeCuota())));
                txtCapital.setText("S/. " + String.valueOf(formateador.format(total_capital)));
                txtInteresTotal.setText("S/. " + String.valueOf(formateador.format(total_interes)));
                txtSeguro.setText("S/. " + String.valueOf(formateador.format(total_seguro)));
                txtCuotaImporte.setText("S/. " + String.valueOf(formateador.format(total_cuota)));
                txtTotalPrestamo.setText("S/. " + String.valueOf(formateador.format(total)));
                txtTotalCredito.setText("S/. " + String.valueOf(formateador.format(total)));

            } else {
                Mensaje.mostrarAdvertencia(this, "No se puede generar el cronograma: \n  " + "El monto (" + prestamo.getMonto() + ") deber ser como minimo 1000 \n"
                        + "El Interes (" + prestamo.getInteres() + ") debe ser como minimo 10% \n"
                        + "N° de Cuotas (" + prestamo.getNumeroCuotas() + ") deben como minimo 6");
                txtMonto.requestFocusInWindow();
            }

        }
    }//GEN-LAST:event_btnCronogramaActionPerformed

    private void txtCuotasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuotasKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtCuotas.getText().length() == Prestamo.LONGITUD_CUOTA || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCuotasKeyTyped

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtMonto.getText().length() == Prestamo.LONGITUD_MONTO
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void txtInteresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInteresKeyTyped
        String patron_de_entrada = "0123456789.";
        if (txtInteres.getText().length() == Prestamo.LONGITUD_INTERES || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtInteresKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String dni = txtDNI.getText();
        if (txtDNI.getText().equals("")) {
            Mensaje.mostrarAdvertencia(this, "Ingrese DNI del cliente");
            txtDNI.requestFocusInWindow();
        } else {
            if (txtDNI.getText().length() != 8) {
                Mensaje.mostrarError(this, "El N° " + dni + "\n  No es un N° de DNI valido");
                limpiarTextos();
                txtDNI.requestFocusInWindow();
            } else {
                try {
                    GestionarClienteServicio gestionarClienteServicio = new GestionarClienteServicio();
                    cliente = gestionarClienteServicio.buscarDNI(dni);
                    if (cliente != null) {
                        if (cliente.getAnalista().getIdanalista() != user.getUsuarioid()) {
                            Mensaje.mostrarInformacion(this, "El cliente " + cliente.getNombre() + " no esta asignado a su cartera");
                            limpiarTodo();
                            this.desabilitar();
                        } else {

                            RegistrarPrestamoServicio registrarPrestamoServicio = new RegistrarPrestamoServicio();
                            numero_prestamos = registrarPrestamoServicio.numeroDePrestamos(dni);
                            if (numero_prestamos == 3) {
                                Mensaje.mostrarAlertaExceso(this);
                                limpiarTodo();
                                txtDNI.requestFocusInWindow();
                            } else {
                                txtNombre.setText(cliente.getNombre());
                                txtApellido.setText(cliente.getApellido());
                                txtMonto.requestFocusInWindow();
                                txtNPrestamos.setText(String.valueOf(numero_prestamos));
                            }
                        }
                    } else {
                        Mensaje.mostrarInformacion(this, "El cliente no se encuentra Registrado en el sistema");
                        limpiarTextos();
                        txtDNI.requestFocusInWindow();
                    }

                } catch (Exception e) {
                    Mensaje.mostrarError(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtDNI.getText().length() == Cliente.LONGITUD_DNI
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyReleased

    }//GEN-LAST:event_txtDNIKeyReleased

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
            java.util.logging.Logger.getLogger(FormRegistrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegistrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormRegistrarPrestamo dialog = new FormRegistrarPrestamo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCronograma;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaCuotas;
    private javax.swing.JTextField txtAnalista;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCapital;
    private javax.swing.JTextField txtCuotaImporte;
    private javax.swing.JTextField txtCuotas;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtInteres;
    private javax.swing.JTextField txtInteresTotal;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNPrestamos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtSeguro;
    private javax.swing.JTextField txtTotalCredito;
    private javax.swing.JTextField txtTotalPrestamo;
    private javax.swing.JTextField txtValorCuota;
    // End of variables declaration//GEN-END:variables
}
