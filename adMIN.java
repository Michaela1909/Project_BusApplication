import java.io.IOException;

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

public class adMIN {

    @FXML
    private Button Mundur;

    @FXML
    private Button LoginButton2;

    @FXML
    private Label loginMessage;

    @FXML
    private Button noAccount;

    @FXML
    private PasswordField password;

    @FXML
    private TextField tf_email;

    @FXML
    void backWard(ActionEvent event) throws IOException {
        Stage stage = (Stage) Mundur.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Home");
        stage.setScene(new Scene(root));
    }

    @FXML
    void Login(ActionEvent event) {

    }

    @FXML
    void noAccount(MouseEvent event) throws IOException {
        Stage stage = (Stage) noAccount.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminRegister.fxml"));
        stage.setTitle("Register");
        stage.setScene(new Scene(root));

    }
}
