
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Produk extends javax.swing.JFrame {

    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    Koneksi k = new Koneksi();
    
    public Produk() {
        initComponents();
        k.connect();
          refreshTable();
    }
    
    class FProduk  {
        int ProdukId,Harga,Stok;
        String NamaProduk;
        
        public FProduk (){
            this.ProdukId = 0;
            this.NamaProduk = jTextField2.getText();
            this.Harga = Integer.parseInt(jTextField3.getText());
             this.Stok = Integer.parseInt(jTextField4.getText());
            
        }
    }
    
      public void refreshTable(){
         model = new DefaultTableModel();
             model.addColumn("ProdukId");
             model.addColumn("NamaProduk");    
             model.addColumn("Harga");   
             model.addColumn("Stok");  
             table_produk.setModel(model);
            try {
               this.stat = k.getCon().prepareStatement("select * from produk");
             this.rs = this.stat.executeQuery();
             while (rs.next()) {
                 Object[] data = {
                     rs.getString("ProdukId"),
                      rs.getString("NamaProduk"),
                       rs.getString("Harga"),
                        rs.getString("Stok")
     
                 };
                 model.addRow(data);
             }
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e.getMessage());
          }
           jTextField1.setText("");
           jTextField2.setText("");
           jTextField3.setText("");
          
          }
          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        text_produkid = new javax.swing.JLabel();
        text_nama_produk = new javax.swing.JLabel();
        text_harga = new javax.swing.JLabel();
        text_stok = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_produk = new javax.swing.JTable();
        btn_logout = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_registrasi = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("PRODUK");

        text_produkid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_produkid.setText("Produk Id");

        text_nama_produk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_nama_produk.setText("Nama Produk");

        text_harga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_harga.setText("Harga");

        text_stok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_stok.setText("Stok");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        table_produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_produkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_produk);

        btn_logout.setText("LOG OUT");
        btn_logout.setEnabled(false);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        btn_transaksi.setText("TRANSAKSI");
        btn_transaksi.setEnabled(false);
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_input.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_registrasi.setText("REGISTRASI");
        btn_registrasi.setEnabled(false);
        btn_registrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_input)
                .addGap(66, 66, 66)
                .addComponent(btn_update)
                .addGap(58, 58, 58)
                .addComponent(btn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btn_registrasi)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_registrasi))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_transaksi)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)
                        .addGap(181, 181, 181)
                        .addComponent(btn_logout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_harga)
                            .addComponent(text_nama_produk)
                            .addComponent(text_produkid)
                            .addComponent(text_stok))
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_logout)
                    .addComponent(btn_transaksi))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_produkid)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_nama_produk)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_harga)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_stok)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
       Login I = new Login();
       I.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            FProduk b = new FProduk();
            this.stat = k.getCon().prepareStatement("insert into produk values(?,?,?,?)");
           stat.setInt(1, b.ProdukId);
           stat.setString(2, b.NamaProduk);
           stat.setInt(3, b.Harga);
           stat.setInt(4, b.Stok);
           stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            FProduk b = new FProduk();
            this.stat = k.getCon().prepareStatement ("update buah set nama_buah=?,"
                    + "Harga=?,Stok=? where Id_Buah=?");
           stat.setInt(1,  b.ProdukId);
           stat.setString(2, b.NamaProduk);
           stat.setInt(3, b.Harga);
           stat.setInt(4, b.Stok);
           stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
                    this.stat =k.getCon().prepareStatement("delete from produk where produk_id=?");
                    this.stat.setInt(1, Integer.parseInt(text_nama_produk.getText()));
                    this.stat.executeUpdate();
                    refreshTable();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void table_produkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_produkMouseClicked
        // TODO add your handling code here:
         text_produkid.setText(model.getValueAt(table_produk.getSelectedRow(), 0) . toString());
     text_nama_produk.setText(model.getValueAt(table_produk.getSelectedRow(), 1) . toString());
      text_harga.setText(model.getValueAt(table_produk.getSelectedRow(), 2) . toString());
       text_stok.setText(model.getValueAt(table_produk.getSelectedRow(), 0) . toString());
    }//GEN-LAST:event_table_produkMouseClicked

    private void btn_registrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrasiActionPerformed
        // TODO add your handling code here:
        Registrasi reg = new Registrasi();
        reg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_registrasiActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        // TODO add your handling code here:
        Transaksi t = new Transaksi();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

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
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_input;
    public javax.swing.JButton btn_logout;
    public javax.swing.JButton btn_registrasi;
    public javax.swing.JButton btn_transaksi;
    public javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable table_produk;
    private javax.swing.JLabel text_harga;
    private javax.swing.JLabel text_nama_produk;
    private javax.swing.JLabel text_produkid;
    private javax.swing.JLabel text_stok;
    // End of variables declaration//GEN-END:variables
}
