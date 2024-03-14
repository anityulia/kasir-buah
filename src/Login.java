
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    private PreparedStatement stat;
    private ResultSet rs;
    Koneksi k = new Koneksi ();
    
    public Login() {
        initComponents();
        k.connect();
        
    }

  class KLogin {
      int Id, id_level;
      String Username,Password, nama_user;      
      
      public KLogin(){
          this.Id = 0;
          this.Username = txtusername.getText ();
          this.Password = txtpsw.getText ();
          this.nama_user ="";
          this.id_level =0;
          
      }
              
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtpsw = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("USERNAME");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PASSWORD");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtusername, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton1))
                    .addComponent(txtpsw))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jButton1)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        KLogin f = new KLogin();
        try {
            this.stat=k.getCon().prepareStatement("select*from tbl_Login where Username ='"+f.Username+"' and Password ='"+f.Password+"'");
            this.rs = this.stat.executeQuery();
            while (rs.next ()) {
                f.id_level = rs.getInt("id_level");
            }   
            if( f.id_level ==0){
                 JOptionPane.showMessageDialog(null,"Akun Tidak DiTemukan");
            }else{
                switch(f.id_level){
                    case 1:
                        MenuUtama m  = new MenuUtama();
                        m.setVisible(true);
                        this.setVisible(false);
                        break;
                    case 2:
                        Transaksi tran = new Transaksi();
                        tran.setVisible(true);
                        this.setVisible(false);
                        tran.btn_cetak_laporan.setEnabled(true);
                        break;
                    case 3:
                        Detail_Penjualan dp = new Detail_Penjualan();
                        dp.setVisible(true);
                        this.setVisible(false);
                        break;
                    case 4:
                        Produk p = new Produk ();
                        p.setVisible(true);
                        this.setVisible(false);
                        p.btn_logout.setEnabled(true);
                        
                        
              
            }
              }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
       // JOptionPane.showMessageDialog(null,"Gagal");
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            } 
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtpsw;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
