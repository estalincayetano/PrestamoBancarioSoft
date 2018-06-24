package bancosoft.capa1_presentacion;

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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JCheckBoxMenuItem();
        Salir = new javax.swing.JCheckBoxMenuItem();
        menuCliente = new javax.swing.JMenu();
        GestionarCliente = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        GestionarPrestamos = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Exit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/archive.png"))); // NOI18N
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuAyuda.setSelected(true);
        menuAyuda.setText("Ayuda");
        menuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAyuda);

        Salir.setSelected(true);
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu1.add(Salir);

        jMenuBar1.add(jMenu1);

        menuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/client (2).png"))); // NOI18N
        menuCliente.setText("Clientes");
        menuCliente.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        GestionarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GestionarCliente.setSelected(true);
        GestionarCliente.setText("Gestionar Cliente");
        GestionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarClienteActionPerformed(evt);
            }
        });
        menuCliente.add(GestionarCliente);

        jMenuBar1.add(menuCliente);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/prestamo.png"))); // NOI18N
        jMenu3.setText("Prestamos");
        jMenu3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        GestionarPrestamos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GestionarPrestamos.setSelected(true);
        GestionarPrestamos.setText("Realizar Prestamo");
        GestionarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarPrestamosActionPerformed(evt);
            }
        });
        jMenu3.add(GestionarPrestamos);

        jCheckBoxMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Prestamos Realizados");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/records.png"))); // NOI18N
        jMenu5.setText("Ingresos");
        jMenu5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jCheckBoxMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Pagar Prestamo");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu5);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/analitica (1).png"))); // NOI18N
        jMenu2.setText("Reportes ");
        jMenu2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu2);

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancosoft/capa1_presentacion/imagenes/salir.png"))); // NOI18N
        Exit.setText("Salir");
        Exit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenuBar1.add(Exit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
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

    private void menuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAyudaActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        FormPrestamosRealizados prestamosRealizados = new FormPrestamosRealizados(this, true);
        prestamosRealizados.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        formRegistrarPagos registrarPagos = new formRegistrarPagos(this, true);
        registrarPagos.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Exit;
    private javax.swing.JCheckBoxMenuItem GestionarCliente;
    private javax.swing.JCheckBoxMenuItem GestionarPrestamos;
    private javax.swing.JCheckBoxMenuItem Salir;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JCheckBoxMenuItem menuAyuda;
    private javax.swing.JMenu menuCliente;
    // End of variables declaration//GEN-END:variables
}
