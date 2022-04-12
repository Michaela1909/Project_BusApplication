import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AdminDashboard implements Initializable{
    Connection con = connection.BusConnecition();

    @FXML
    private Button btnLogout;

    @FXML
    private Button btn_contactUs;

    @FXML
    private Button btn_dataPengguna;

    @FXML
    private Button btn_jadwal;

    @FXML
    private Button btn_penjualan;

    @FXML
    private Label tiket;

    @FXML
    void Logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void contactUs(ActionEvent event) throws IOException {
        Stage stage = (Stage) btn_contactUs.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminContactUs.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void dataPengguna(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn_dataPengguna.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("DataPengguna.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void jadwal(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn_jadwal.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminJadwalBus.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void penjualan(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn_penjualan.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminPenjualan.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            LocalDateTime now = LocalDateTime.now(); 
             
            Statement st = con.createStatement();
            String sql = "SELECT SUM(Quantity) FROM Transaksi WHERE TanggalTransaksi = '" + dtf.format(now) +"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tiket.setText(Integer.toString(rs.getInt(1)));
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
