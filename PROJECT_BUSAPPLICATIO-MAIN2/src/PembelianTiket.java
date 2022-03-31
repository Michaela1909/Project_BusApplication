import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PembelianTiket {


    @FXML
    private ImageView Photo1;
    
    @FXML
    private Button Sidebar;

    @FXML
    private Button Caribusavalible;

    @FXML
    private ImageView back;

    @FXML
    private TextField tfAsal;

    @FXML
    private TextField tfJumlahpenumpang;

    @FXML
    private TextField tfTujuan;

    @FXML
    private TextField tfWaktu;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void cariBusavalible(ActionEvent event) throws IOException {
        Stage stage = (Stage) Caribusavalible.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PembelianTiket2.fxml"));
        stage.setTitle("JadwalBus");
        stage.setScene(new Scene(root));

    }

    @FXML
    void OpenSidebar(ActionEvent event) throws IOException {
        Stage stage = (Stage) Caribusavalible.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AkunUser.fxml"));
        stage.setTitle("JadwalBus");
        stage.setScene(new Scene(root));
    }

}
