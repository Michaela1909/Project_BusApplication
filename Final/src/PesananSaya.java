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
import model.pesanan;

public class PesananSaya implements Initializable{

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<pesanan, String> tcAsal;

    @FXML
    private TableColumn<pesanan, Integer> tcBusID;

    @FXML
    private TableColumn<pesanan, Integer> tcQty;

    @FXML
    private TableColumn<pesanan, String> tcTanggal;

    @FXML
    private TableColumn<pesanan, Integer> tcTransaksiID;

    @FXML
    private TableColumn<pesanan, String> tcTujuan;

    @FXML
    private TableColumn<pesanan, String> tcWaktu;

    @FXML
    private TableColumn<pesanan, String> tcnamaBus;

    @FXML
    private TableView<pesanan> tvPesananSaya;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    LinkedList<pesanan> list = new LinkedList<>();
    Connection con = connection.BusConnecition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tcAsal.setCellValueFactory(new PropertyValueFactory<>("Asal"));
        tcBusID.setCellValueFactory(new PropertyValueFactory<>("BusID"));
        tcQty.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tcTanggal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tcTransaksiID.setCellValueFactory(new PropertyValueFactory<>("TransaksiID"));
        tcTujuan.setCellValueFactory(new PropertyValueFactory<>("Tujuan"));
        tcWaktu.setCellValueFactory(new PropertyValueFactory<>("Waktu"));
        tcnamaBus.setCellValueFactory(new PropertyValueFactory<>("NamaBus"));


        try {
            list.clear();

            Statement st = con.createStatement();
            String sql = "SELECT Transaksi.TransaksiID, Transaksi.BusID, JadwalBus.NamaBus, JadwalBus.Asal, JadwalBus.Tujuan, JadwalBus.Tanggal, JadwalBus.Waktu, Transaksi.Quantity FROM Transaksi INNER JOIN JadwalBus ON Transaksi.BusID = JadwalBus.BusID INNER JOIN User on Transaksi.UserID = User.USerID WHERE Transaksi.UserID = (SELECT UserID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) GROUP BY Transaksi.TransaksiID";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                pesanan pesananSaya = new pesanan(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(pesananSaya);
            }
            tvPesananSaya.getItems().clear();
            tvPesananSaya.getItems().addAll(list);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
