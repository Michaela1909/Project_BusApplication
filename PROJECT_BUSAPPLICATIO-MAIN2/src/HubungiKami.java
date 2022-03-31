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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HubungiKami {

    @FXML
    private ImageView Akun;

    @FXML
    private ImageView History;

    @FXML
    private ImageView HubungiKami;

    @FXML
    private ImageView JadwalBus;

    @FXML
    private Text LogOut;

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
    void AkunUser(MouseEvent event) throws IOException {
        Stage stage =(Stage) Akun.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AkunUser.fxml"));
        stage.setTitle("USERACC");
        stage.setScene(new Scene(root));

    }

    @FXML
    void BusTersedia(MouseEvent event) throws IOException {
        Stage stage =(Stage) JadwalBus.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("tvJadwal.fxml"));
        stage.setTitle("BUS LIST");
        stage.setScene(new Scene(root));

    }

    @FXML
    void ContactUs(MouseEvent event) throws IOException {
        Stage stage =(Stage) HubungiKami.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ContactUs.fxml"));
        stage.setTitle("HubungiKami");
        stage.setScene(new Scene(root));

    }

    @FXML
    void KemabaliKeHome(MouseEvent event) throws IOException {
        Stage stage =(Stage) LogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Home");
        stage.setScene(new Scene(root));

    }

    @FXML
    void Kirim(ActionEvent event) {

    }

    @FXML
    void Pemesanan(MouseEvent event) throws IOException {
        Stage stage =(Stage) History.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HistoryPemesanan.fxml"));
        stage.setTitle("Admin");
        stage.setScene(new Scene(root));

    }

}
