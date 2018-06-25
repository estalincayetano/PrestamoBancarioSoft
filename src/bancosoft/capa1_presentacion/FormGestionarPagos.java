package bancosoft.capa1_presentacion;

import bancosoft.capa1_presentacion.util.ConfiguradorDeTabla;
import bancosoft.capa1_presentacion.util.Mensaje;
import bancosoft.capa2_aplicacion.GestionarClienteServicio;
import bancosoft.capa2_aplicacion.RegistrarPagoServicio;
import bancosoft.capa2_aplicacion.RegistrarPrestamoServicio;
import bancosoft.capa3_dominio.entidades.Cajero;
import bancosoft.capa3_dominio.entidades.Cliente;
import bancosoft.capa3_dominio.entidades.Cuota;
import bancosoft.capa3_dominio.entidades.Pago;
import bancosoft.capa3_dominio.entidades.Prestamo;
import bancosoft.capa3_dominio.entidades.Usuario;
import java.text.DecimalFormat;
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
public class FormGestionarPagos extends javax.swing.JDialog {

    Cliente cliente;
    Cuota cuota;
    Pago pago;
    private int selecciona_prestamoid;
    private int selecciona_cuotaid;
    private java.sql.Date fecha_pago;
    private double monto_cuota;
    private int numFila;
    private int numPrestamos;
    Usuario user = FormInciarSeccion.usuario;

    public FormGestionarPagos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrarPrestamosCliente();
        mostrarTablaCuotas();
        this.desabilitar();
        txtCajero.setText(user.getNombre().toUpperCase());
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

    public void habilitar() {
        btnBuscar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnPagar.setEnabled(true);
        btnSalir.setEnabled(false);
        txtDNI.setEnabled(true);
    }

    public void desabilitar() {
        btnBuscar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnSalir.setEnabled(true);
        btnPagar.setEnabled(false);
        txtDNI.setEnabled(false);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCajero = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCuotas = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
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
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro De Pagos");

        jPanel1.setBackground(new java.awt.Color(0, 166, 184));

        jPanel2.setBackground(new java.awt.Color(0, 166, 184));
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

        jLabel1.setBackground(new java.awt.Color(204, 255, 153));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR PAGOS DE CUOTAS DE PRESTAMOS");

        jPanel3.setBackground(new java.awt.Color(0, 166, 184));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

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

        btnBuscar.setBackground(new java.awt.Color(0, 204, 204));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("CAJERO:");

        txtCajero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCajero.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCajero.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtApellidos))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNombres))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(45, 45, 45)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCajero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 166, 184));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuotas Pendientes de Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 166, 184));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btnPagar.setBackground(new java.awt.Color(255, 255, 255));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/card.png"))); // NOI18N
        btnPagar.setText("Pagar Cuota");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/new.png"))); // NOI18N
        btnNuevo.setText("Nuevo Pago");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 204, 255));
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

        btnSalir.setBackground(new java.awt.Color(204, 255, 255));
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
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPrestamosMouseClicked
        String estado = "PENDIENTE";
        seleccionaPrestamo();
        buscarCuotas(selecciona_prestamoid, estado);
    }//GEN-LAST:event_tablaPrestamosMouseClicked

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        String patron_de_entrada = "0123456789";
        if (txtDNI.getText().length() == Cliente.LONGITUD_DNI
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

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
                        RegistrarPrestamoServicio registrarPrestamoServicio = new RegistrarPrestamoServicio();
                        numPrestamos = registrarPrestamoServicio.numeroDePrestamos(dni);
                        if (numPrestamos != 0) {
                            txtNombres.setText(cliente.getNombre());
                            txtApellidos.setText(cliente.getApellido());
                            buscarPrestamos(cliente.getDni());
                        } else {
                            Mensaje.mostrarAdvertencia(this, "El cliente no tiene prestamos pendientes de pago");
                            limpiarTodo();
                            this.desabilitar();
                        }

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

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (txtMonto.getText().equals("") || txtMora.getText().equals("") || txtTotal.getText().equals("")) {
            Mensaje.mostrarErrorDeCreacion(this);
        } else {
            try {
                Cajero cajero= new Cajero();
                cajero.setIdcajero(user.getUsuarioid());
                pago.setCajero(cajero);
                RegistrarPagoServicio registrarPagoServicio = new RegistrarPagoServicio();
                if (Mensaje.mostrarPreguntaDeConfirmacion(this)) {
                    int registros_afectados = registrarPagoServicio.registrarPago(pago);
                    int cuotaMax = registrarPagoServicio.cuotaMax(selecciona_prestamoid);
                    if (registros_afectados == 1) {
                        Mensaje.mostrarAfirmacionDeCreacion(this);
                        if (cuotaMax == selecciona_cuotaid) {
                            int update = registrarPagoServicio.updatePrestamo(selecciona_prestamoid);
                            if (update != 1) {
                                Mensaje.mostrarError(this, "No se que pasa por ahora");
                            } else {
                                Mensaje.mostrarAfirmacionDeActualizacion(this);
                                limpiarTodo();
                                ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
                                modeloTabla.eliminarTotalFilas();
                                this.desabilitar();
                            }
                        } else if (Mensaje.mostrarPreguntaDePermanencia(this)) {
                            txtMonto.setText("");
                            txtMora.setText("");
                            txtTotal.setText("");
                            ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
                            modeloTabla.eliminarTotalFilas();
                            String estado = "PENDIENTE";
                            buscarCuotas(selecciona_prestamoid, estado);
                            modeloTabla.refrescarDatos();
                        } else {
                            this.desabilitar();
                            limpiarTodo();
                            ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
                            modeloTabla.eliminarTotalFilas();
                        }
                    }
                } else {
                    txtMonto.setText("");
                    txtMora.setText("");
                    txtTotal.setText("");
                    ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
                    modeloTabla.eliminarTotalFilas();
                    String estado = "PENDIENTE";
                    buscarCuotas(selecciona_prestamoid, estado);
                    modeloTabla.refrescarDatos();
                }

            } catch (Exception e) {
                Mensaje.mostrarError(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.habilitar();
        limpiarTodo();
        ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
        modeloTabla.eliminarTotalFilas();
        txtDNI.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTodo();
        ModeloTabla modeloTabla = (ModeloTabla) tablaCuotas.getModel();
        modeloTabla.eliminarTotalFilas();
        this.desabilitar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCuotas;
    private javax.swing.JTable tablaPrestamos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCajero;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
