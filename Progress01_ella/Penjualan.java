import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Penjualan implements Initializable {

    @FXML
    private TableColumn<?, ?> Id;

    @FXML
    private TableColumn<?, ?> NamaBus;

    @FXML
    private TableColumn<?, ?> NamaPembeli;

    @FXML
    private TableColumn<?, ?> Quantity;

    @FXML
    private TableColumn<?, ?> TanggalTransaksi;

    @FXML
    private TableColumn<?, ?> Total;

    @FXML
    private ImageView back;

    @FXML
    private TableView<?> table_penjualan;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
