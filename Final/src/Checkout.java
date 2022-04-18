
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Checkout implements Initializable{

    Connection con = connection.BusConnecition();

    @FXML
    private Button btnBack;

    @FXML
    private Label LabelNamaBus;

    @FXML
    private Button btnBayar;

    @FXML
    private Label labelAsal;

    @FXML
    private Label labelNama;

    @FXML
    private Label labelTanggal;

    @FXML
    private Label labelTotalPembelian;

    @FXML
    private Label labelTujuan;

    @FXML
    private ListView<String> lvSeat;


    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBayar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Seat.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void Bayar(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBayar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CheckoutPayment.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT User.FullName, JadwalBus.NamaBus, JadwalBus.Asal, JadwalBus.Tujuan, JadwalBus.Tanggal, Transaksi.Quantity FROM JadwalBus, Transaksi, User WHERE JadwalBus.BusID = Transaksi.BusID AND User.UserID = Transaksi.UserID ORDER BY Transaksi.TransaksiID DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                labelNama.setText(rs.getString(1));
                LabelNamaBus.setText(rs.getString(2));
                labelAsal.setText(rs.getString(3));
                labelTujuan.setText(rs.getString(4));
                labelTanggal.setText(rs.getString(5));
                labelTotalPembelian.setText(Integer.toString(rs.getInt(6)));
                getSeat();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }    
    }
    public void getSeat(){
        ObservableList<String> list = FXCollections.observableArrayList();

        try {

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
}
