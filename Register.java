import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

//import com.mysql.cj.PreparedQuery;
//import com.mysql.cj.jdbc.Driver;
//import com.mysql.cj.xdevapi.PreparableStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Register {

    @FXML
    private Button Back;

    @FXML
    private Button RegisterButton;

    @FXML
    private TextField firstName;


    @FXML
    private Label message;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password2;

    @FXML
    private Label regisMessage;

    @FXML
    private TextField tf_email;

    Connection con;
    PreparedStatement pst;
    @FXML
    void Resgister(ActionEvent event) {
        String fname = firstName.getText();
        String email = tf_email.getText();
        String pass = password.getText();
        String repass = password2.getText();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "root", "Ejgaming1234");

            pst = con.prepareStatement("insert into bus.account(fullName,email, password, Confirm_password) value (?, ?, ?, ?, ?)");
            pst.setString(1, fname);
            pst.setString(3, email);
            pst.setString(4, pass);
            pst.setString(5, repass);

            while(password.getText().equals(password2.getText()))
                {
                int status = pst.executeUpdate();

                if(status ==1)
                {
                    firstName.setText("");
                    tf_email.setText("");
                    password.setText("");
                    password2.setText("");
                    //firstName.requestFocus();
                    Stage stage = (Stage) RegisterButton.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    stage.setTitle("login");
                    stage.setScene(new Scene(root));
                }else
                {
                    JOptionPane.showMessageDialog(null, "record failed");
                }
            }
            message.setText("gagal");
            firstName.setText("");
            tf_email.setText("");
            password.setText("");
            password2.setText("");
            
        }catch(Exception e)
        {
            e.getStackTrace();
            e.getCause();
        }
    }



@FXML
void backtoHome(ActionEvent event) throws IOException {
    Stage stage = (Stage) Back.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    stage.setTitle("Home");
    stage.setScene(new Scene(root));
    }
}