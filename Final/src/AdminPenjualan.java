import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.penjualan;

public class AdminPenjualan implements Initializable{
    Connection con = connection.BusConnecition();
    LinkedList<penjualan> list = new LinkedList<>();

    @FXML
    private ImageView back;

    @FXML
    private TableView<penjualan> table_penjualan;

    @FXML
    private TableColumn<penjualan,Integer> tcID;

    @FXML
    private TableColumn<penjualan, String> tcMetodePembayaran;

    @FXML
    private TableColumn<penjualan, String> tcNamaBus;

    @FXML
    private TableColumn<penjualan, String> tcNamaPembeli;

    @FXML
    private TableColumn<penjualan, Integer> tcQty;

    @FXML
    private TableColumn<penjualan, String> tcTanggalTransaksi;

    @FXML
    private TableColumn<penjualan, Integer> tcTotal;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        tcID.setCellValueFactory(new PropertyValueFactory<>("TransaksiID"));
        tcNamaBus.setCellValueFactory(new PropertyValueFactory<>("NamaBus"));
        tcNamaPembeli.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        tcQty.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tcTotal.setCellValueFactory(new PropertyValueFactory<>("TotalHarga"));
        tcTanggalTransaksi.setCellValueFactory(new PropertyValueFactory<>("TanggalTransaksi"));
        tcMetodePembayaran.setCellValueFactory(new PropertyValueFactory<>("MetodePembayaran"));

        try {
            Statement st = con.createStatement();
            String sql = "SELECT Transaksi.TransaksiID, JadwalBus.NamaBus, User.FullName, Transaksi.Quantity, Transaksi.TotalHarga, Transaksi.TanggalTransaksi, Transaksi.MetodePembayaran FROM Transaksi, User, JadwalBus WHERE JadwalBus.BusID = Transaksi.BusID AND Transaksi.UserID = User.UserID;";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                penjualan table_penjualan = new penjualan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                list.add(table_penjualan);
            }
            table_penjualan.getItems().clear();
            table_penjualan.getItems().addAll(list);

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
        
    }

}
