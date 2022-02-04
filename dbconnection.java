import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class dbconnection{
    public static void main(String[] args) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/busaccount", "root", "Nml_19092002");
            if(conn !=null){
                System.out.print("successfull connect");
            }
        }catch(Exception e){
            System.out.print("not connected");
        }
    }

    public static Statement getInstance() {
        return null;
    }

    public static Connection getConnection() {
        return null;
    }
}