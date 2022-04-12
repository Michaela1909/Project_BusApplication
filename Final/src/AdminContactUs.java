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
import model.contact;

public class AdminContactUs implements Initializable{

    Connection con = connection.BusConnecition();

    @FXML
    private ImageView back;

    @FXML
    private TableView<contact> table_contactUs;

    @FXML
    private TableColumn<contact, Integer> tc_contactID;

    @FXML
    private TableColumn<contact, String> tc_email;

    @FXML
    private TableColumn<contact, String> tc_nama;

    @FXML
    private TableColumn<contact, String> tc_noTelp;

    @FXML
    private TableColumn<contact, String> tc_pesan;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    LinkedList<contact> list = new LinkedList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        tc_contactID.setCellValueFactory(new PropertyValueFactory<>("ContactID"));
        tc_nama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        tc_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tc_noTelp.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        tc_pesan.setCellValueFactory(new PropertyValueFactory<>("Message"));

        try {
            Statement st = con.createStatement();
            String sql = "SELECT ContactID, Nama, Email, Phone, Message FROM Contact";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                contact table_contactUS = new contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(table_contactUS);
            }
            table_contactUs.getItems().clear();
            table_contactUs.getItems().addAll(list);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

}
