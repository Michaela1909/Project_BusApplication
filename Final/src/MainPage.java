import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainPage implements Initializable{

    Connection con = connection.BusConnecition();

    @FXML
    private ImageView Akun;

    @FXML
    private ImageView HubungiKami;

    @FXML
    private ImageView JadwalBus;

    @FXML
    private ImageView PemesananSaya;

    @FXML
    private Button btnLogOut;

    @FXML
    private ImageView btnMenu;

    @FXML
    private Button btnPesanTiket;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    void Akun(MouseEvent event) throws IOException {
        Stage stage = (Stage) JadwalBus.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void HubungiKami(MouseEvent event) throws IOException {
        Stage stage = (Stage) HubungiKami.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("UserContactUs.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void JadwalBus(MouseEvent event) throws IOException {
        Stage stage = (Stage) JadwalBus.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("UserJadwalBus.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Transaksi WHERE Quantity IS NULL OR TotalHarga IS NULL");
            pst.execute();

            Stage stage = (Stage) btnLogOut.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            stage.setTitle("Bus");
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    @FXML
    void PemesananSaya(MouseEvent event) throws IOException {
        Stage stage = (Stage) PemesananSaya.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PesananSaya.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void PesanTiket(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnPesanTiket.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Pesan.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }
    public void sideNavMenu(){
        pane1.setVisible(false);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2), pane1);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),pane2);
        translateTransition.setByX(-360);
        translateTransition.play();

        btnMenu.setOnMouseClicked(event -> {


            pane1.setVisible(true);

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(+360);
            translateTransition1.play();
        });

        pane1.setOnMouseClicked(event -> {



            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
            });


            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(-360);
            translateTransition1.play();
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sideNavMenu();
    }
}
