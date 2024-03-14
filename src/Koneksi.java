
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Koneksi {
    private String url = "jdbc:mysql://localhost/kasir_anita4";
    private String Username = "root";
    private String Password = "";
    private Connection con;

 public void connect (){
     try {
         con = DriverManager.getConnection(url, Username,Password);
         System.out.println("Koneksi Database Berhasil");
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Koneksi Database Gagal");
     }  
}
 public Connection getCon(){
     return con;
 }


}
