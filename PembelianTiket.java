import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PembelianTiket {

    @FXML
    private ImageView Photo1;

    @FXML
    private Button BackToHome2;

    @FXML
    private TextField tfAsal;

    @FXML
    private TextField tfJumlahpenumpang;

    @FXML
    private TextField tfTujuan;

    @FXML
    private TextField tfWaktu;

    @FXML
    void BackWardToHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) BackToHome2.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Home");
        stage.setScene(new Scene(root)); 
    }

    @FXML
    void cariBusavalible(ActionEvent event) throws IOException {
        Stage stage = (Stage) BackToHome2.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PembelianTiket2.fxml"));
        stage.setTitle("PembelianTiket");
        stage.setScene(new Scene(root)); 

    }

}
