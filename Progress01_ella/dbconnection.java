import java.sql.Connection;
import java.sql.DriverManager;


public class dbconnection{
    public static Connection busConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/busApplication", "root", "Nml_19092002");
            if(conn !=null){
                System.out.println("successfull connect");
            }
        }catch(Exception e){
            System.out.println("not connected");
        }
        return conn;
    }
}