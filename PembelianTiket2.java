import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PembelianTiket2 {

    @FXML
    private Button BackToPembelianTiket1;

    @FXML
    private TableColumn<?, ?> Id;

    @FXML
    private TableColumn<?, ?> NamaBus;

    @FXML
    private TableColumn<?, ?> NamaPembeli;

    @FXML
    private TableColumn<?, ?> Quantity;

    @FXML
    private TableColumn<?, ?> Total;

    @FXML
    private TableView<?> table_penjualan;

    @FXML
    void backtoPembelianTiket1(ActionEvent event) throws IOException {
        Stage stage = (Stage) BackToPembelianTiket1.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PembelianTiket.fxml"));
        stage.setTitle("Pembelian Tiket");
        stage.setScene(new Scene(root));
    }

}


