import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Home {

    @FXML
    private Button AdminButton;

    @FXML
    private Button LoginButton;

    @FXML
    private Button RegisterButton;

    @FXML
    void Login(MouseEvent event) throws IOException  {
        Stage stage = (Stage) LoginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
     }

    @FXML
    void Register(MouseEvent event) throws IOException {
        Stage stage =(Stage) RegisterButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage.setTitle("Register");
        stage.setScene(new Scene(root));

    }

    @FXML
    void adMIN(MouseEvent event) throws IOException {
        Stage stage =(Stage) AdminButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("adMIN.fxml"));
        stage.setTitle("Admin");
        stage.setScene(new Scene(root));
    }

}