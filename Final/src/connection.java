import java.sql.Connection;
import java.sql.DriverManager;


public class connection{
    public static Connection BusConnecition(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BusApplication", "root", "Nml_19092002");
            if(conn !=null){
                System.out.println("successfull connect");
            }
        }catch(Exception e){
            System.out.println("not connected");
        }
        return conn;
    }
}