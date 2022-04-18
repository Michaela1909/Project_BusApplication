import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CheckoutPayment implements Initializable{

    Connection con = connection.BusConnecition();

    @FXML
    private Label LabelTanggalTransaksi;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBayar;

    @FXML
    private ComboBox<String> cbMetodePembayaran;

    @FXML
    private Label labelBusID;

    @FXML
    private Label labelNama;

    @FXML
    private Label labelNamaBus;

    @FXML
    private Label labelQuantity;

    @FXML
    private Label labelTanggal;

    @FXML
    private Label labelTotalHarga;

    @FXML
    private Label labelTransaskiID;

    @FXML
    private ListView<String> lvSeat;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void Bayar(ActionEvent event) throws IOException {
        if(cbMetodePembayaran.getSelectionModel().getSelectedItem()==null){
            MetodePembayaranMsg();
        }else{
            try {
                PreparedStatement pst = con.prepareStatement("UPDATE Transaksi SET MetodePembayaran = ? ORDER BY TransaksiID DESC LIMIT 1");
                pst.setString(1, cbMetodePembayaran.getSelectionModel().getSelectedItem());
                pst.execute();
    
                pst = con.prepareStatement("UPDATE JadwalBus SET Kapasitas = Kapasitas - ? WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)");
                pst.setInt(1, Integer.parseInt(labelQuantity.getText()));
                pst.execute();
    
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Anda Berhasil Melakukan Pembayaran!");
                alert.setContentText("Terima Kasih.");
                alert.showAndWait();
    
                Stage stage = (Stage) btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                stage.setTitle("Bus");
                stage.setScene(new Scene(root));
    
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        } 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbMetodePembayaran.getItems().add("Transfer Bank");
        cbMetodePembayaran.getItems().add("OVO");
        cbMetodePembayaran.getItems().add("GOPAY");
        
        try {
            Statement st = con.createStatement();
            String sql = "SELECT User.FullName, Transaksi.TransaksiID, Transaksi.BusID, JadwalBus.NamaBus, JadwalBus.Tanggal, Transaksi.Quantity, Transaksi.TanggalTransaksi, Transaksi.TotalHarga FROM Transaksi, JadwalBus, User WHERE Transaksi.BusID = JadwalBus.BusID AND Transaksi.UserID = User.UserID ORDER BY TransaksiID DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                labelNama.setText(rs.getString(1));
                labelTransaskiID.setText(rs.getString(2));
                labelBusID.setText(Integer.toString(rs.getInt(3)));
                labelNamaBus.setText(rs.getString(4));
                labelTanggal.setText(rs.getString(5));
                labelQuantity.setText(Integer.toString(rs.getInt(6)));
                LabelTanggalTransaksi.setText(rs.getString(7));
                labelTotalHarga.setText("Rp " + Integer.toString(rs.getInt(8)));
                getSeat();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getSeat(){
        try {
            ObservableList<String> list = FXCollections.observableArrayList();

            Statement st = con.createStatement();
            String sql = "SELECT SeatName FROM Seat WHERE TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString(1));
            }
            lvSeat.setItems(list);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void MetodePembayaranMsg(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Silahkan coba lagi!");
        alert.setContentText("Silahkan pilih metode pembayaran yang ingin digunakan terlebih dahulu!");
        alert.showAndWait();
    }
}
