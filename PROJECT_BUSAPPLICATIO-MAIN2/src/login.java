/*import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class login {

    @FXML
    private Button BacktoHome;

    @FXML
    private Button LognButton;

    @FXML
    private Label loginMessage;

    @FXML
    private Button noAccount;

    @FXML
    private PasswordField password;

    @FXML
    private TextField tf_email;

    @FXML
    void Login(ActionEvent event) throws IOException {
    try{
    String host = "jdbc:mysql://localhost:3306/bus";
    String uName = "root";
    String pw = "Ejgaming1234";
    Connection con = DriverManager.getConnection(host, uName, pw);
    Statement st = con.createStatement();
   /* String email = tf_email.getText();
    String pass = password.getText();
    String sql = "Select * from bus.user where email = '" + tf_email.getText() + "'and password = '"+ password.getText() +"'";
    ResultSet rs = st.executeQuery(sql);
    if(rs.next())
    {
        Stage stage = (Stage) LognButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PembelianTiket.fxml"));
        stage.setTitle("After Login");
        stage.setScene(new Scene(root));
    }else
    {
        loginMessage.setText("username/password yang dimasukan salah");
    }
}   catch(Exception e)
    
    {
    e.getStackTrace();
    e.getMessage();
    }
}
   

    @FXML
    void noAccount(MouseEvent event) throws IOException {
        Stage stage = (Stage) noAccount.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage.setTitle("Register");
        stage.setScene(new Scene(root));
    }

    @FXML
    void backWard(ActionEvent event) throws IOException {
        Stage stage = (Stage) BacktoHome.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Home");
        stage.setScene(new Scene(root));  
    }

}*/

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class login {

    @FXML
    private ImageView back;

    @FXML
    private Button LoginButton;

    @FXML
    private Label loginMessage;

    @FXML
    private Button noAccount;

    @FXML
    private PasswordField password;

    @FXML
    private TextField tf_email;

    @FXML
    void Login(ActionEvent event) {
        try{
            String host = "jdbc:mysql://localhost:3306/busapplication";
            String uName = "root";
            String pw = "Ejgaming1234";
            Connection con = DriverManager.getConnection(host, uName, pw);
            Statement st = con.createStatement();
            String email = tf_email.getText();
            String pass = password.getText();
            String sql = "Select * from busapplication.user where email = '" + email + "'and password = '"+ pass +"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                Stage stage = (Stage) LoginButton.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("PembelianTiket.fxml"));
                stage.setTitle("After Login");
                stage.setScene(new Scene(root));
            }else
            {
                loginMessage.setText("username/password yang dimasukan salah");
            }
        }   catch(Exception e)
            
            {
            e.getStackTrace();
            e.getMessage();
            }
        

    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void noAccount(MouseEvent event) {

    }

}