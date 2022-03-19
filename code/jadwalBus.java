import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.sql.Statement;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class jadwalBus implements Initializable{

    @FXML
    private ImageView back;

    @FXML
    private Button btn_tambahkan;

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
    private TextField tf_kapasitas;

    @FXML
    private TextField tf_namaBus;

    @FXML
    private TextField tf_tujuan;

    @FXML
    private TextField tf_waktu;

    String query = null;
    Connection connection = dbconnection.jadwalConnection();
    ResultSet rs = null;
    PreparedStatement pst;
    Statement st =null;
    private ObservableList<jadwal> data;

    /*public void Linkedlist(){
        LinkedList<String> ll = new LinkedList<String>();
        jadwal jadwal_bus;
        Connection con = dbconnection.jadwalConnection();
        try {
            st = con.createStatement();
            rs=st.executeQuery("SELECT * FROM jadwalBus");
            while(rs.next()){
                Integer inputBusID = rs.getInt("BusID");
                String inputNamaBus = rs.getString("NamaBus");
                Integer inputKapasitas = rs.getInt("Kapasitas");
                String inputTanggal = rs.getString("Tanggal");
                Integer inputHarga = rs.getInt("Harga");
                String inputAsal = rs.getString("Asal");
                String inputTujuan = rs.getString("Tujuan");
                String inputWaktu = rs.getString("Waktu");

                jadwal_bus = new jadwal(inputBusID,inputNamaBus,inputKapasitas,inputTanggal,inputHarga,inputAsal,inputTujuan,inputWaktu);
                ll.add(jadwal_bus.ToString());
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        for(String s : ll)
        System.out.println(s);
    }*/
    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void tambah(ActionEvent event) {
        //connection = dbconnection.jadwalConnection();
        String id = tf_BusID.getText();
        String nama = tf_namaBus.getText();
        String kapasitas = tf_kapasitas.getText();
        String tgl = String.valueOf(tanggal.getValue());
        String harga = tf_harga.getText();
        String asal = tf_asal.getText();
        String tujuan = tf_tujuan.getText();
        String waktu = tf_waktu.getText();

        if(id.isEmpty() ||nama.isEmpty()||kapasitas.isEmpty()||tgl.isEmpty()||harga.isEmpty()||asal.isEmpty()||tujuan.isEmpty()||waktu.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("please fill all data");
            alert.showAndWait();
        }else{
            getQuery();
            insert();
            clean();
            setCellTable();
            loadData();
            //Linkedlist();
        }
    }
    private void getQuery(){
        query = "INSERT INTO busApplication.jadwalBus(BusID, NamaBus, Kapasitas, Tanggal, Harga, Asal, Tujuan,Waktu) VALUES(?,?,?,?,?,?,?,?)";
    }
    private void insert(){
        try{
            pst = connection.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(tf_BusID.getText()));
            pst.setString(2, tf_namaBus.getText());
            pst.setInt(3, Integer.parseInt(tf_kapasitas.getText()));
            pst.setString(4, String.valueOf(tanggal.getValue()));
            pst.setInt(5, Integer.parseInt(tf_harga.getText()));
            pst.setString(6, tf_asal.getText());
            pst.setString(7, tf_tujuan.getText());
            pst.setString(8, tf_waktu.getText());
            pst.execute();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    private void clean(){
        tf_BusID.setText(null);
        tf_namaBus.setText(null);
        tf_kapasitas.setText(null);
        tanggal.setValue(null);
        tf_harga.setText(null);
        tf_asal.setText(null);
        tf_tujuan.setText(null);
        tf_waktu.setText(null);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        connection = dbconnection.jadwalConnection();
        data = FXCollections.observableArrayList();
        setCellTable();
        loadData();
    }
    private void setCellTable(){
        tc_BusID.setCellValueFactory(new PropertyValueFactory<>("BusID"));
        tc_NamaBus.setCellValueFactory(new PropertyValueFactory<>("NamaBus"));
        tc_Kapasitas.setCellValueFactory(new PropertyValueFactory<>("Kapasitas"));
        tc_Tanggal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tc_Harga.setCellValueFactory(new PropertyValueFactory<>("Harga"));
        tc_Asal.setCellValueFactory(new PropertyValueFactory<>("Asal"));        
        tc_Tujuan.setCellValueFactory(new PropertyValueFactory<>("Tujuan"));
        tc_Waktu.setCellValueFactory(new PropertyValueFactory<>("Waktu"));
    }
    private void loadData(){
        data.clear();
        try {
            pst = connection.prepareStatement("SELECT * FROM jadwalBus");
            rs = pst.executeQuery();
            while(rs.next()){
                data.add(new jadwal(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        jadwalBus.setItems(data);
    }
}


