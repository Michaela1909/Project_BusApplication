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
    private ImageView BacktoHome;

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
            String host = "jdbc:mysql://localhost:3306/busApplication";
            String user = "root";
            String pw = "Nml_19092002";
            Connection con = DriverManager.getConnection(host, user, pw);
            Statement st = con.createStatement();
            String email = tf_email.getText();
            String pass = String.valueOf(password.getText());
            String sql = "Select * from busaccount.account where email = '" + email + "'and password = '"+pass+"'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                Stage stage = (Stage) noAccount.getScene().getWindow();
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
    void backWard(MouseEvent event) {

    }

    @FXML
    void noAccount(MouseEvent event) {

    }

}
