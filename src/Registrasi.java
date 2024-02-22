import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


 
public class Registrasi extends javax.swing.JFrame {
     private DefaultTableModel model = null;
     private PreparedStatement stat;
     private ResultSet rs;
     Koneksi k = new Koneksi();
    /**
     
     */
    public Registrasi() {
        initComponents();
    }
 
    class user extends Registrasi {
        int id_user,id_level;
        String Username, Password, nama_user;
        
        public user(){
            Username = text_username.getText();
            Password = text_password.getText();
            nama_user= text_nama_user.getText();
            id_level =  Integer.parseInt(combo_id_level.getSelectedItem().toString());
        }
    }
     public void refreshTable(){
         model = new DefaultTableModel();
             model.addColumn("Id_User");
             model.addColumn("Username");    
             model.addColumn("Password");   
             model.addColumn("Nama User");  
             model.addColumn("Id Level");   
             table_Registrasi.setModel(model);
             try {
             this.stat = k.getCon().prepareStatement("select * from user");
             this.rs = this.stat.executeQuery();
             while (rs.next()) {
                 Object[] data = {
                     rs.getString("Id_User"),
                      rs.getString("Username"),
                       rs.getString("Password"),
                        rs.getString("Nama User"),
                          rs.getString("Id Level"),
                 };
                 model.addRow(data);
                 }
         } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
         }
             text_id_user.setText("");
             text_username.setText("");
             text_password.setText("");
             text_nama_user.setText("");
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_id_user = new javax.swing.JTextField();
        text_username = new javax.swing.JTextField();
        text_password = new javax.swing.JTextField();
        text_nama_user = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combo_id_level = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Registrasi = new javax.swing.JTable();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_menu_buah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRASI");

        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID User");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nama User");

        text_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_passwordActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Id Level");

        combo_id_level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));

        table_Registrasi.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Registrasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_RegistrasiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Registrasi);

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

        btn_menu_buah.setText("MENU BUAH");
        btn_menu_buah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menu_buahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(text_id_user)
                                    .addComponent(text_username)
                                    .addComponent(text_password)
                                    .addComponent(text_nama_user, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6)
                                .addGap(38, 38, 38)
                                .addComponent(combo_id_level, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(175, 175, 175)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_input)
                                .addGap(84, 84, 84)
                                .addComponent(btn_update)
                                .addGap(70, 70, 70)
                                .addComponent(btn_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(btn_menu_buah)
                                .addGap(27, 27, 27))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(text_id_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(text_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(text_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(text_nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_id_level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_menu_buah))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_passwordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login I = new Login();
        I.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            user u = new user();
            this.stat = k.getCon().prepareStatement("insert into user values(?,?,?,?,?)");
            stat.setInt(1,0);
            stat.setString(2,u.Username);
            stat.setString(3,u.Password);
            stat.setString(4,u.nama_user);
            stat.setInt(5,u.id_level);
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            user u = new user();
            this.stat = k.getCon().prepareStatement("Update user set Username=?," + "Password=?, Nama_User=?,Id_Level=? where Id_User=?");
            stat.setInt(1, 0);
            stat.setString(2,u.Username);
            stat.setString(3,u.Password);
            stat.setString(4,u.nama_user);
            stat.setInt(5,u.id_level);
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
             user u = new user();
               this.stat = k.getCon().prepareStatement("Delete from user whele id_user=?");
               stat.setInt(1, u.id_user); 
               stat.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void table_RegistrasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_RegistrasiMouseClicked
        // TODO add your handling code here:
         text_id_user.setText(model.getValueAt(table_Registrasi.getSelectedRow(), 0) . toString());
     text_username.setText(model.getValueAt(table_Registrasi.getSelectedRow(), 1) . toString());
      text_password.setText(model.getValueAt(table_Registrasi.getSelectedRow(), 2) . toString());
       text_nama_user.setText(model.getValueAt(table_Registrasi.getSelectedRow(), 0) . toString());
    }//GEN-LAST:event_table_RegistrasiMouseClicked

    private void btn_menu_buahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menu_buahActionPerformed
        // TODO add your handling code here:
        Produk p = new Produk
        p.setVisible(true);
        this.setVisible(false);
         p .btn_input.setEnabled(true);   
         p.btn_update.setEnabled(true); 
         p.btn_delete.setEnabled(true);
         p.btn_transaksi.setEnabled(true);   
         p.btn_registrasi.setEnabled(true);   
    }//GEN-LAST:event_btn_menu_buahActionPerformed

    
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
            java.util.logging.Logger.getLogger(Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_input;
    private javax.swing.JButton btn_menu_buah;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox combo_id_level;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Registrasi;
    private javax.swing.JTextField text_id_user;
    private javax.swing.JTextField text_nama_user;
    private javax.swing.JTextField text_password;
    private javax.swing.JTextField text_username;
    // End of variables declaration//GEN-END:variables
}
