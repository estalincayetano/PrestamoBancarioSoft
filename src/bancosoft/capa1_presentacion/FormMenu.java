package bancosoft.capa1_presentacion;

import bancosoft.capa3_dominio.entidades.Usuario;

/**
 *
 * @author estal
 */
public class FormMenu extends javax.swing.JFrame {

    public FormMenu() {
        asignarLookandfeel();
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        setLocationRelativeTo(this);
    }

    private void asignarLookandfeel() {
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
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuBancoSoft = new javax.swing.JMenu();
        elementoAyuda = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        elementoSalir = new javax.swing.JCheckBoxMenuItem();
        menuCliente = new javax.swing.JMenu();
        GestionarCliente = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        menuPrestamos = new javax.swing.JMenu();
        GestionarPrestamos = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        menuIngresos = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem8 = new javax.swing.JCheckBoxMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuSeguridad = new javax.swing.JMenu();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem7 = new javax.swing.JCheckBoxMenuItem();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/fondo.jpg"))); // NOI18N

        jMenuBar1.setToolTipText("");
        jMenuBar1.setAutoscrolls(true);

        menuBancoSoft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/bank.png"))); // NOI18N
        menuBancoSoft.setText("BancoSoft");
        menuBancoSoft.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        menuBancoSoft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBancoSoftActionPerformed(evt);
            }
        });

        elementoAyuda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        elementoAyuda.setSelected(true);
        elementoAyuda.setText("Perfil");
        elementoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/profile.png"))); // NOI18N
        elementoAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementoAyudaActionPerformed(evt);
            }
        });
        menuBancoSoft.add(elementoAyuda);

        jCheckBoxMenuItem6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem6.setSelected(true);
        jCheckBoxMenuItem6.setText("Configuración");
        jCheckBoxMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/config.png"))); // NOI18N
        menuBancoSoft.add(jCheckBoxMenuItem6);

        elementoSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        elementoSalir.setSelected(true);
        elementoSalir.setText("Salir");
        elementoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/salir.png"))); // NOI18N
        elementoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementoSalirActionPerformed(evt);
            }
        });
        menuBancoSoft.add(elementoSalir);

        jMenuBar1.add(menuBancoSoft);

        menuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/client.png"))); // NOI18N
        menuCliente.setText("Clientes");
        menuCliente.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        GestionarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GestionarCliente.setSelected(true);
        GestionarCliente.setText("Gestionar Cliente");
        GestionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/client.png"))); // NOI18N
        GestionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarClienteActionPerformed(evt);
            }
        });
        menuCliente.add(GestionarCliente);

        jCheckBoxMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem5.setSelected(true);
        jCheckBoxMenuItem5.setText("Listar Clientes");
        jCheckBoxMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/list.png"))); // NOI18N
        menuCliente.add(jCheckBoxMenuItem5);

        jMenuBar1.add(menuCliente);

        menuPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/recordmanagement.png"))); // NOI18N
        menuPrestamos.setText("Prestamos");
        menuPrestamos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        GestionarPrestamos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GestionarPrestamos.setSelected(true);
        GestionarPrestamos.setText("Registrar Prestamo");
        GestionarPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/lendmoney.png"))); // NOI18N
        GestionarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarPrestamosActionPerformed(evt);
            }
        });
        menuPrestamos.add(GestionarPrestamos);

        jCheckBoxMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Prestamos Realizados");
        jCheckBoxMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/list.png"))); // NOI18N
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        menuPrestamos.add(jCheckBoxMenuItem2);

        jMenuBar1.add(menuPrestamos);

        menuIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/search.png"))); // NOI18N
        menuIngresos.setText("Ingresos");
        menuIngresos.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jCheckBoxMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Registrar Pago");
        jCheckBoxMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/card.png"))); // NOI18N
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        menuIngresos.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem8.setSelected(true);
        jCheckBoxMenuItem8.setText("Listar Pagos");
        jCheckBoxMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/list.png"))); // NOI18N
        menuIngresos.add(jCheckBoxMenuItem8);

        jMenuBar1.add(menuIngresos);

        menuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/edit.png"))); // NOI18N
        menuReportes.setText("Reportes ");
        menuReportes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jMenuBar1.add(menuReportes);

        menuSeguridad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/userupdate.png"))); // NOI18N
        menuSeguridad.setText("Seguridad");
        menuSeguridad.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jCheckBoxMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("Gestionar Usuarios");
        jCheckBoxMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/users.png"))); // NOI18N
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        menuSeguridad.add(jCheckBoxMenuItem3);

        jCheckBoxMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("Gestionar Permisos");
        jCheckBoxMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/userupdate.png"))); // NOI18N
        jCheckBoxMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem4ActionPerformed(evt);
            }
        });
        menuSeguridad.add(jCheckBoxMenuItem4);

        jCheckBoxMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem7.setSelected(true);
        jCheckBoxMenuItem7.setText("Listar Usuarios");
        jCheckBoxMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/list.png"))); // NOI18N
        menuSeguridad.add(jCheckBoxMenuItem7);

        jMenuBar1.add(menuSeguridad);

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        menuSalir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalirMouseClicked(evt);
            }
        });
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GestionarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarPrestamosActionPerformed
        FormRegistrarPrestamo gestionarPrestamo = new FormRegistrarPrestamo(this, true);
        gestionarPrestamo.setVisible(true);
    }//GEN-LAST:event_GestionarPrestamosActionPerformed

    private void GestionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarClienteActionPerformed
        FormDatosCliente formDatosCliente = new FormDatosCliente(this, true);
        formDatosCliente.setVisible(true);
    }//GEN-LAST:event_GestionarClienteActionPerformed

    private void elementoAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementoAyudaActionPerformed
        FormPerfilUsuario formPerfilUsuario= new FormPerfilUsuario(this, true);
        formPerfilUsuario.setVisible(true);
    }//GEN-LAST:event_elementoAyudaActionPerformed

    private void elementoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementoSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_elementoSalirActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuBancoSoftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBancoSoftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuBancoSoftActionPerformed

    private void menuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_menuSalirMouseClicked

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        FormPrestamosRealizados prestamosRealizados = new FormPrestamosRealizados(this, true);
        prestamosRealizados.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
       FormGestionarPagos registrarPagos = new FormGestionarPagos(this, true);
        registrarPagos.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem4ActionPerformed
        FormGestionarPermisos formGestionarPermisos = new FormGestionarPermisos(this, true);
        formGestionarPermisos.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem4ActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        FormGestionarUsuarios formGestionarUsuario = new FormGestionarUsuarios(this, true);
        formGestionarUsuario.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Usuario user = FormInciarSeccion.usuario;
        if (user.getTipo().equals("Analista")) {
            menuIngresos.setEnabled(false);
            menuSeguridad.setEnabled(false);
            menuReportes.setEnabled(false);
        } else if (user.getTipo().equals("Cajero(a)")) {
            menuCliente.setEnabled(false);
            menuPrestamos.setEnabled(false);
            menuSeguridad.setEnabled(false);
            menuReportes.setEnabled(false);
        }

    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem GestionarCliente;
    private javax.swing.JCheckBoxMenuItem GestionarPrestamos;
    private javax.swing.JCheckBoxMenuItem elementoAyuda;
    private javax.swing.JCheckBoxMenuItem elementoSalir;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuBancoSoft;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuIngresos;
    private javax.swing.JMenu menuPrestamos;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenu menuSeguridad;
    // End of variables declaration//GEN-END:variables
}
