import java.sql.Connection;
import java.sql.DriverManager;

public class DbaseConnection {
    public static void main(String[] args) {
        String host ="jdbc:mysql://localhost:3306/bus";
        String uName="root";
        String pass="Ejgaming1234";        
        Connection conn = null;
       try
       {
           conn = DriverManager.getConnection(host,uName,pass);
           if(conn !=null)
           { 
               System.out.print("koneksi berhasil");
           }          
       }
       catch(Exception e)
       {
        System.out.print("Koneksi gagal");
       }
      }
    }
    