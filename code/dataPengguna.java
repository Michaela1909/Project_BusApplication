import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class dataPengguna {

    @FXML
    private TableColumn<?, ?> Id;

    @FXML
    private TableColumn<?, ?> NamaLengkap;

    @FXML
    private ImageView back;

    @FXML
    private TableColumn<?, ?> confirmPassword;

    @FXML
    private TableColumn<?, ?> email;

    @FXML
    private TableColumn<?, ?> password;

    @FXML
    private TableView<?> table_dataPengguna;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

}
