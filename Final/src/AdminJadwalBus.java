import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.jadwal;

public class AdminJadwalBus implements Initializable{
    Connection con = connection.BusConnecition();
    PreparedStatement pst;
    LinkedList<jadwal> list = new LinkedList<>();

    @FXML
    private ImageView back;

    @FXML
    private Button btn_tambahkan;

    @FXML
    private Button btn_Edit;

    @FXML
    private Button btn_Hapus;

    @FXML
    private TableView<jadwal> jadwalBus;

    @FXML
    private DatePicker tanggal;

    @FXML
    private TableColumn<jadwal, String> tc_Asal;

    @FXML
    private TableColumn<jadwal, Integer> tc_BusID;

    @FXML
    private TableColumn<jadwal, Integer> tc_Harga;

    @FXML
    private TableColumn<jadwal, Integer> tc_Kapasitas;

    @FXML
    private TableColumn<jadwal, String> tc_NamaBus;

    @FXML
    private TableColumn<jadwal, String> tc_Tanggal;

    @FXML
    private TableColumn<jadwal, String> tc_Tujuan;

    @FXML
    private TableColumn<jadwal, String> tc_Waktu;

    @FXML
    private TextField tf_BusID;

    @FXML
    private TextField tf_asal;

    @FXML
    private TextField tf_harga;

    @FXML
    private Label label_Kapasitas;

    @FXML
    private TextField tf_namaBus;

    @FXML
    private TextField tf_tujuan;

    @FXML
    private TextField tf_waktu;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }


    @FXML
    void Edit(ActionEvent event) {
        try {
            pst = con.prepareStatement("UPDATE JadwalBus SET NamaBus = ?, Tanggal = ?, Harga = ?, Asal = ?, Tujuan = ?, Waktu = ? WHERE BusID = ?");
            pst.setString(1, tf_namaBus.getText());
            pst.setString(2, String.valueOf(tanggal.getValue()));
            pst.setInt(3, Integer.parseInt(tf_harga.getText()));
            pst.setString(4, tf_asal.getText());
            pst.setString(5, tf_tujuan.getText());
            pst.setString(6, tf_waktu.getText());
            pst.setInt(7, Integer.parseInt(tf_BusID.getText()));
            int status = pst.executeUpdate();
            if(status==-1){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Terjadi kesalahan");
                alert.setContentText("Silahkan coba lagi!");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Selamat!");
                alert.setContentText("Anda Berhasil Mengubah Jadwal Bus.");
                alert.showAndWait();
                clear();
                getBusList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void Hapus(ActionEvent event) {
        try {
            pst = con.prepareStatement("DELETE FROM Seat WHERE BusID = ?");
            pst.setInt(1, Integer.parseInt(tf_BusID.getText()));
            pst.executeUpdate();
            PreparedStatement pst3 = con.prepareStatement("DELETE FROM Transaksi WHERE BusID = ?");
            pst3.setInt(1, Integer.parseInt(tf_BusID.getText()));
            pst3.executeUpdate();
            PreparedStatement pst2 = con.prepareStatement("DELETE FROM JadwalBus WHERE BusID = ?");
            pst2.setInt(1, Integer.parseInt(tf_BusID.getText()));
            int status = pst2.executeUpdate();
            if(status == -1){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Terjadi kesalahan");
                alert.setContentText("Silahkan coba lagi!");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Selamat!");
                alert.setContentText("Anda Berhasil Mengubah Jadwal Bus.");
                alert.showAndWait();
                clear();
                getBusList(); 
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Terjadi kesalahan");
            alert.setContentText("Silahkan coba lagi!");
            alert.showAndWait();
            tf_BusID.setText(null);
            tf_namaBus.setText(null);
            label_Kapasitas.setText(Integer.toString(34));
            tanggal.setValue(null);
            tf_asal.setText(null);
            tf_tujuan.setText(null);
            tf_harga.setText(null);
            tf_waktu.setText(null);
        }
    }

    @FXML
    void getSelected(MouseEvent event) {
        int index = jadwalBus.getSelectionModel().getSelectedIndex();
        tf_BusID.setText(Integer.toString(tc_BusID.getCellData(index)));
        tf_namaBus.setText(tc_NamaBus.getCellData(index));
        label_Kapasitas.setText(Integer.toString(tc_Kapasitas.getCellData(index)));
        tanggal.setValue(LocalDate.parse(tc_Tanggal.getCellData(index)));
        tf_harga.setText(Integer.toString(tc_Harga.getCellData(index)));
        tf_asal.setText(tc_Asal.getCellData(index));
        tf_tujuan.setText(tc_Tujuan.getCellData(index));
        tf_waktu.setText(tc_Waktu.getCellData(index));
    }

    @FXML
    void tambah(ActionEvent event) {
        try {
            pst = con.prepareStatement("INSERT INTO JadwalBus(BusID, NamaBus, Kapasitas, Tanggal, Harga, Asal, Tujuan, Waktu) VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, Integer.parseInt(tf_BusID.getText()));
            pst.setString(2, tf_namaBus.getText());
            pst.setInt(3, Integer.parseInt(label_Kapasitas.getText()));
            pst.setString(4, String.valueOf(tanggal.getValue()));
            pst.setInt(5, Integer.parseInt(tf_harga.getText()));
            pst.setString(6, tf_asal.getText());
            pst.setString(7, tf_tujuan.getText());
            pst.setString(8, tf_waktu.getText());
            int status = pst.executeUpdate();
            if(status!=-1){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Selamat!");
                alert.setContentText("Anda Berhasil Menambahkan Jadwal Bus Baru.");
                alert.showAndWait();
                clear();
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
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Terjadi kesalahan");
                alert.setContentText("Silahkan coba lagi!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Terjadi kesalahan");
            alert.setContentText("Silahkan coba lagi!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label_Kapasitas.setText(Integer.toString(34));

        tc_BusID.setCellValueFactory(new PropertyValueFactory<>("BusID"));
        tc_NamaBus.setCellValueFactory(new PropertyValueFactory<>("NamaBus"));
        tc_Kapasitas.setCellValueFactory(new PropertyValueFactory<>("Kapasitas"));
        tc_Tanggal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tc_Harga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        tc_Asal.setCellValueFactory(new PropertyValueFactory<>("Asal"));
        tc_Tujuan.setCellValueFactory(new PropertyValueFactory<>("Tujuan"));
        tc_Waktu.setCellValueFactory(new PropertyValueFactory<>("Waktu"));
        
        getBusList();
    }

    public void getBusList(){
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
            e.printStackTrace();
            e.getCause();
        }
    }
    public void clear(){
        jadwalBus.getItems().clear();
        list.clear();
        tf_BusID.setText(null);
        tf_namaBus.setText(null);
        label_Kapasitas.setText(Integer.toString(34));
        tanggal.setValue(null);
        tf_asal.setText(null);
        tf_tujuan.setText(null);
        tf_harga.setText(null);
        tf_waktu.setText(null);
    }
}
