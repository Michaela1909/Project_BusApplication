import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminDashboard {

    @FXML
    private Button btn_dataPengguna;

    @FXML
    private Button btn_jadwal;

    @FXML
    private Button btn_penjualan;

    @FXML
    private Label logOut;

    @FXML
    private Label tiket;

    @FXML
    void dataPengguna(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn_dataPengguna.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("dataPengguna.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void jadwal(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn_dataPengguna.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("jadwalBus.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    void penjualan(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn_dataPengguna.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("penjualan.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

}
