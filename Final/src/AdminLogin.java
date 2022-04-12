import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AdminLogin {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnNoAcc;

    @FXML
    private Label loginMessage;

    @FXML
    private PasswordField password;

    @FXML
    private TextField tf_email;

    Connection con = connection.BusConnecition();

    @FXML
    void Login(ActionEvent event) {
        try {
            if (tf_email.getText().isEmpty() || password.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Username dan password kosong");
                alert.setContentText("Input username dan password!");
                alert.showAndWait();
            }else{
                Statement st = con.createStatement();
                String sql = "SELECT * FROM User WHERE Email = '" + tf_email.getText() + "' AND Password = '" + password.getText() +"'";
                ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                    String status = rs.getString("UserStatus");
                    if(status.equals("A")){
                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
                        stage.setTitle("Bus");
                        stage.setScene(new Scene(root));
                    }else{
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("Anda belum terdaftar sebagai user");
                        alert.setContentText("Silahkan coba lagi atau daftar user!");
                        alert.showAndWait();
                    }

                    
                }else
                    loginMessage.setText("Email/Password yang anda masukan salah");
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void noAccount(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminRegister.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

}
