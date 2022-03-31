import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ContactUs {

    @FXML
    private ImageView back;

    @FXML
    private Button btnKirim;

    @FXML
    private TextArea ta_pesan;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_phoneNum;

    @FXML
    void Kirim(ActionEvent event) {

    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage =(Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AkunUser.fxml"));
        stage.setTitle("USERACC");
        stage.setScene(new Scene(root));


    }

}
