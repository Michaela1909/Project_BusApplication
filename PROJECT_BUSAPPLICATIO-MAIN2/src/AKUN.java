import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AKUN {

    @FXML
    private ImageView Akun;

    @FXML
    private Text EditAkun;

    @FXML
    private ImageView History;

    @FXML
    private ImageView HubungiKami;

    @FXML
    private ImageView JadwalBus;

    @FXML
    private Text LogOut;

    @FXML
    private Label UsName;

    @FXML
    private Button jadwalbus;

    @FXML
    private Button pemesanansaya;

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
    void EditAkun(MouseEvent event) {
        /*Stage stage =(Stage) AdminButto.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("adMIN.fxml"));
        stage.setTitle("Admin");
        stage.setScene(new Scene(root));*/

    }

    @FXML
    void KemabaliKeHome(MouseEvent event) throws IOException {
        Stage stage =(Stage) LogOut.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Home");
        stage.setScene(new Scene(root));

    }

    @FXML
    void Pemesanan(MouseEvent event) throws IOException {
        Stage stage =(Stage) History.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HistoryPemesanan.fxml"));
        stage.setTitle("Admin");
        stage.setScene(new Scene(root));

    }

    @FXML
    void btnJadwalBus(ActionEvent event) throws IOException {
        Stage stage =(Stage) JadwalBus.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("tvJadwal.fxml"));
        stage.setTitle("BUS LIST");
        stage.setScene(new Scene(root));

    }

    @FXML
    void btnPemesananSaya(ActionEvent event) throws IOException {
        Stage stage =(Stage) History.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HistoryPemesanan.fxml"));
        stage.setTitle("Admin");
        stage.setScene(new Scene(root));

    }

}
