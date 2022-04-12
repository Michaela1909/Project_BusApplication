import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

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

public class UserRegister {

    @FXML
    private Button RegisterButton;

    @FXML
    private ImageView back;

    @FXML
    private Label regisMessage;

    @FXML
    private TextField tf_FullName;

    @FXML
    private PasswordField tf_Password;

    @FXML
    private PasswordField tf_confirmPassword;

    @FXML
    private TextField tf_email;

    Connection con = connection.BusConnecition();
    PreparedStatement pst; 

    @FXML
    void Resgister(ActionEvent event) {
        try {
            pst = con.prepareStatement("INSERT INTO User(FullName, Email, Password, ConfirmPassword, UserStatus) VALUES (?,?,?,?,'U')");
            pst.setString(1, tf_FullName.getText());
            pst.setString(2, tf_email.getText());
            pst.setString(3, tf_Password.getText());
            pst.setString(4, tf_confirmPassword.getText());
            if(tf_FullName.getText().isEmpty()||tf_email.getText().isEmpty()||tf_Password.getText().isEmpty()||tf_confirmPassword.getText().isEmpty()){
                regisMessage.setText("please fill out all requiered fields!");
            }
            while(tf_Password.getText().equals(tf_confirmPassword.getText())){
                int status = pst.executeUpdate();

                if(status == -1){
                    JOptionPane.showMessageDialog(null, "record failed");
                }else{
                    Stage stage = (Stage) back.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
                    stage.setTitle("Bus");
                    stage.setScene(new Scene(root));
                }
            }
            regisMessage.setText("password invalid");
            tf_FullName.setText(null);
            tf_email.setText(null);
            tf_Password.setText(null);
            tf_confirmPassword.setText(null);

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

}
