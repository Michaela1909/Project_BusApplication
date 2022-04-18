import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.jadwal;

public class Pesan implements Initializable{

    Connection con = connection.BusConnecition();
    private ObservableList<jadwal> data;
    PreparedStatement pst; 
    ResultSet rs;


    @FXML
    private Button btnBack;

    @FXML
    private Button btnCari;

    @FXML
    private Button btnPesan;

    @FXML
    private ComboBox<String> cbAsal;

    @FXML
    private ComboBox<String> cbTujuan;

    @FXML
    private DatePicker dpTanggal;

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
    void Cari(ActionEvent event) {
        String asal = cbAsal.getValue();
        String tujuan = cbTujuan.getValue();
        String tanggal = dpTanggal.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        setCellTable();

        try {
            jadwalBus.getItems().clear();
            data.clear();
            pst = con.prepareStatement("SELECT * FROM JadwalBus WHERE Asal = '" + asal +"' AND Tujuan = '" + tujuan+"' AND Tanggal = '" + tanggal +"'");
            rs = pst.executeQuery();
            if(rs.next()){
                data.add(new jadwal(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }else
                alert();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        jadwalBus.setItems(data);
    }

    @FXML
    void btnPesan(ActionEvent event) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Transaksi SET BusID = ? WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1");
            pst.setInt(1, jadwalBus.getSelectionModel().getSelectedItem().getBusID());
            pst.execute();
            
            Stage stage = (Stage) btnPesan.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Seat.fxml"));
            stage.setTitle("Bus");
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
   
    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = FXCollections.observableArrayList();
        getCBAsal();
        getCBTujuan();
        
    }
    public void getCBAsal(){
        try {
            ObservableList<String> asal= FXCollections.observableArrayList();

            Statement st = con.createStatement();
            String sql = "SELECT Asal FROM JadwalBus GROUP BY Asal";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                asal.add(rs.getString(1));
            }
            cbAsal.setItems(asal);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getCBTujuan(){
        try {
            ObservableList<String> tujuan = FXCollections.observableArrayList();

            Statement st = con.createStatement();
            String sql = "SELECT Tujuan FROM JadwalBus GROUP BY Tujuan";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                tujuan.add(rs.getString(1));
            }
            cbTujuan.setItems(tujuan);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    private void setCellTable(){
        tcBusID.setCellValueFactory(new PropertyValueFactory<>("BusID"));
        tcNamaBus.setCellValueFactory(new PropertyValueFactory<>("NamaBus"));
        tcKapasitas.setCellValueFactory(new PropertyValueFactory<>("Kapasitas"));
        tcTanggal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tcHarga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        tcAsal.setCellValueFactory(new PropertyValueFactory<>("Asal"));        
        tcTujuan.setCellValueFactory(new PropertyValueFactory<>("Tujuan"));
        tcWaktu.setCellValueFactory(new PropertyValueFactory<>("Waktu"));
    }
    public void alert(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gagal");
        alert.setHeaderText("Tidak ada jadwal bus yang tersedia.");
        alert.setContentText("Mohon maaf!");
        alert.showAndWait();
    }
}
