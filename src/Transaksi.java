
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Transaksi extends javax.swing.JFrame {
 private DefaultTableModel model = null;
 private PreparedStatement stat;
 private ResultSet rs;
 Koneksi k = new Koneksi();
 
    
    public Transaksi() {
        initComponents();
        k.connect();
        RefreshTable();
        refreshcombo();
       
    }

    class transaksi extends Transaksi  {
        int Id_Transaksi, Id_Buah, Harga,Jumlah_Beli,Total_Bayar;
        String Nama_Pelanggan, Tanggal, Nama_Buah;
    
        public transaksi() {
            this.Nama_Pelanggan = text_nama_pelanggan.getText();
            String combo = combo_id_buah.getSelectedItem().toString();
            String[] arr = combo.split(":");
             this.Id_Buah = Integer.parseInt(arr[0]);
             try {
                Date date = text_Tanggal.getDate();
                DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");
                this.Tanggal = dateformat.format(date);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            this.Nama_Pelanggan = arr[1];
            this.Jumlah_Beli = Integer.parseInt(arr[2]);
            this.Total_Bayar = this.Harga * this.Jumlah_Beli;
                    
        }
} 
    
    public void RefreshTable(){
        model = new DefaultTableModel();
        model.addColumn("Id_Transkasi");
        model.addColumn("Nama_Pelanggan");
        model.addColumn("Id_Buah");
        model.addColumn("Tanggal");
        model.addColumn("Nama_Buah");
        model.addColumn("Harga");
        model.addColumn("Jumlah_Beli");
        model.addColumn("Total_Bayar");
        table_transaksi.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("select * from Transaksi");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {
                Object [] date={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                } ;
                model.addRow(date);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        text_id_transaksi.setText("");
        text_nama_pelanggan.setText("");
        text_jml_beli.setText("");
        text_total_bayar.setText("");
    }
     
    public void refreshcombo (){
        try {
            this.stat = k.getCon().prepareStatement("select * from Produk" + "where Stok='Tersedia'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {
                combo_id_buah.addItem(rs.getString("Id_Buah")+":"+
                        rs.getString("Nama_Buah")+":"+ rs.getString("Harga"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        text_id_transaksi = new javax.swing.JLabel();
        text_nama_pelanggan = new javax.swing.JLabel();
        text_id_buah = new javax.swing.JLabel();
        text_tanggal = new javax.swing.JLabel();
        text_jml_beli = new javax.swing.JLabel();
        text_total_bayar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        combo_id_buah = new javax.swing.JComboBox();
        menu_Buah = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cetak_laporan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new javax.swing.JTable();
        text_Tanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI");

        text_id_transaksi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_id_transaksi.setText("ID Transaksi");

        text_nama_pelanggan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_nama_pelanggan.setText("Nama Pelanggan");

        text_id_buah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_id_buah.setText("ID Buah");

        text_tanggal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_tanggal.setText("Tanggal ");

        text_jml_beli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_jml_beli.setText("Jumlah Beli");

        text_total_bayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_total_bayar.setText("Total Bayar");

        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        combo_id_buah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_id_buahActionPerformed(evt);
            }
        });

        menu_Buah.setText("LIHAT MENU");
        menu_Buah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_BuahMouseClicked(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_cetak_laporan.setText("CETAK LAPORAN");
        btn_cetak_laporan.setEnabled(false);

        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        table_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_transaksi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_input)
                        .addGap(59, 59, 59)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_delete)
                        .addGap(28, 28, 28)
                        .addComponent(btn_cetak_laporan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_id_transaksi)
                            .addComponent(text_nama_pelanggan)
                            .addComponent(text_id_buah)
                            .addComponent(text_tanggal)
                            .addComponent(text_jml_beli)
                            .addComponent(text_total_bayar))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                .addComponent(jTextField2)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(combo_id_buah, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(menu_Buah))
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton1)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_id_transaksi)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nama_pelanggan)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(text_id_buah))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_id_buah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menu_Buah))))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_tanggal)
                    .addComponent(text_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_jml_beli)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_total_bayar)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_cetak_laporan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void combo_id_buahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_id_buahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_id_buahActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            transaksi t = new transaksi ();
            text_total_bayar.setText(""+t.Total_Bayar);
            this.stat = k.getCon().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?,?");
            this.stat.setInt(1, 0);
            this.stat.setString(2, t.Nama_Pelanggan);
            this.stat.setInt(3, t.Id_Buah);
            this.stat.setString(4, t.Tanggal);
            this.stat.setString(5, t.Nama_Buah);
            this.stat.setInt(6, t.Harga);
            this.stat.setInt(7, t.Jumlah_Beli);
            this.stat.setInt(8, t.Total_Bayar);
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "tanggal: "+t.Tanggal+
                            "\nNama_Pelanggan : "+t.Nama_Pelanggan+
                            "\nPembelian : "+t.Jumlah_Beli+" "+t.Id_Buah+
                            "\nTotal_Bayar : "+t.Total_Bayar+"\n",
                            "Tambah Transaksi?",
                            JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                this.stat.executeUpdate();
                RefreshTable ();
            } else if (pilihan == JOptionPane.NO_OPTION) {
                 RefreshTable () ;
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Login I = new Login();
        I.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            transaksi t = new transaksi
          t.id_transaksi = Integer.parseInt(text_id_transaksi.getText());        
          this.stat = k.getCon().prepareStatement("Update transaksi nama_planggan=?," + "Id_Buah=?, tanggal=?,nama_Buah=? ,harga=? ,Total_Bayar=?  where Id_transaksi=?");
         this.stat.setString(1, t.Nama_Pelanggan);
         this.stat.setInt(2, t.Id_Buah);
         this.stat.setString(3, t.Tanggal);
         this.stat.setString(4, t.Nama_Buah);
         this.stat.setInt(5, t.Harga);
         this.stat.setInt(6, t.Jumlah_Beli);
          this.stat.setInt(7, t.Total_Bayar);
          this.stat.setInt(8, t.Id_Transaksi);
          this.stat.executeUpdate();
          RefreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void table_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transaksiMouseClicked
        // TODO add your handling code here:
        text_id_transaksi.setText(model.getValueAt(table_transaksi.getSelectedRow(), 0) . toString());
     text_nama_pelanggan.setText(model.getValueAt(table_transaksi.getSelectedRow(), 1) . toString());
      text_jml_beli.setText(model.getValueAt(table_transaksi.getSelectedRow(), 2) . toString());
       text_total_bayar.setText(model.getValueAt(table_transaksi.getSelectedRow(), 0) . toString());
    }//GEN-LAST:event_table_transaksiMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            transaksi t = new transaksi
                    t.id_transaksi = Integer.parseInt(text_id_transaksi);
                    this.stat =k.getCon().prepareStatement("delete from transaksi"
                    + "where id_transaksi=?");
                    this.stat.setInt(1, t.Id_Transaksi);
                    this.stat.executeUpdate();
                    RefreshTable();
                    
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void menu_BuahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_BuahMouseClicked
        // TODO add your handling code here:
        menu_Buah buah = new menu_buah();
        buah.setVisible(true);
        this.setVisible(false);
        buah.btn_delete.setEnabled(true);
        buah.btn_input.setVisibled(true);
        buah.btn_transaksi.setVisible(true);
                
    }//GEN-LAST:event_menu_BuahMouseClicked

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetak_laporan;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_input;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox combo_id_buah;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton menu_Buah;
    private javax.swing.JTable table_transaksi;
    private com.toedter.calendar.JDateChooser text_Tanggal;
    private javax.swing.JLabel text_id_buah;
    private javax.swing.JLabel text_id_transaksi;
    private javax.swing.JLabel text_jml_beli;
    private javax.swing.JLabel text_nama_pelanggan;
    private javax.swing.JLabel text_tanggal;
    private javax.swing.JLabel text_total_bayar;
    // End of variables declaration//GEN-END:variables
}
