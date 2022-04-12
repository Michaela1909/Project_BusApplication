import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.jadwal;

public class UserJadwalBus implements Initializable{

    Connection con = connection.BusConnecition();
    LinkedList<jadwal> list = new LinkedList<>();

    @FXML
    private Button btnBack;

    @FXML
    private TableView<jadwal> jadwalBus;

    @FXML
    private TableColumn<jadwal, String> tcAsal;

    @FXML
    private TableColumn<jadwal, Integer> tcBusID;

    @FXML
    private TableColumn<jadwal, Integer> tcHarga;

    @FXML
    private TableColumn<jadwal, Integer> tcKapasitas;

    @FXML
    private TableColumn<jadwal, String> tcNamaBus;

    @FXML
    private TableColumn<jadwal, String> tcTanggal;

    @FXML
    private TableColumn<jadwal, String> tcTujuan;

    @FXML
    private TableColumn<jadwal, String> tcWaktu;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcBusID.setCellValueFactory(new PropertyValueFactory<>("BusID"));
        tcNamaBus.setCellValueFactory(new PropertyValueFactory<>("NamaBus"));
        tcKapasitas.setCellValueFactory(new PropertyValueFactory<>("Kapasitas"));
        tcTanggal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tcHarga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        tcAsal.setCellValueFactory(new PropertyValueFactory<>("Asal"));
        tcTujuan.setCellValueFactory(new PropertyValueFactory<>("Tujuan"));
        tcWaktu.setCellValueFactory(new PropertyValueFactory<>("Waktu"));
        
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM JadwalBus";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                jadwal jadwalBus = new jadwal(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8));
                list.add(jadwalBus);
            }
            jadwalBus.getItems().clear();
            jadwalBus.getItems().addAll(list);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }        
    }

}
