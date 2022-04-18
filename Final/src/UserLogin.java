import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserLogin {

    Connection con = connection.BusConnecition();
    PreparedStatement pst= null;

    @FXML
    private ImageView BacktoHome;

    @FXML
    private Button btnLogin;

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
        try {
            if (tf_email.getText().isEmpty() || password.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Username dan password kosong");
                alert.setContentText("Input username dan password!");
                alert.showAndWait();
            } else {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM User WHERE Email = '" + tf_email.getText() + "'AND Password = '" + password.getText()+"' AND UserStatus = 'U'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
                        LocalDateTime now = LocalDateTime.now();  
                        
                        pst = con.prepareStatement("insert into Transaksi(UserID, TanggalTransaksi) VALUES ((SELECT UserID FROM User WHERE Email = ?), ?)");
                        pst.setString(1, tf_email.getText());
                        pst.setString(2, dtf.format(now));
                        pst.execute();

                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                        stage.setTitle("Bus");
                        stage.setScene(new Scene(root));
                
                }else{
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Terjadi kesalahan");
                    alert.setContentText("Silahkan coba lagi!");
                    alert.showAndWait();
                }
            }
            
        } catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    @FXML
    void backWard(MouseEvent event) throws IOException {
        Stage stage = (Stage) BacktoHome.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void noAccount(MouseEvent event) throws IOException {
        Stage stage = (Stage) noAccount.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("UserRegister.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }
}
