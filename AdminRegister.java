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
import javafx.stage.Stage;

public class AdminRegister {

    @FXML
    private Button BackButton;

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

    @FXML
    void Mundur(ActionEvent event) throws IOException {
        Stage stage = (Stage) BackButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("adMIN.fxml"));
        stage.setTitle("ADMIN");
        stage.setScene(new Scene(root));
    }

    @FXML
    void Resgister(ActionEvent event) {

    }

}
