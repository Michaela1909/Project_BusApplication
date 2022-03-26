import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class adminContactUs implements Initializable {

    @FXML
    private ImageView back;

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
    private TableView<contact> table_contactUs;

    @FXML
    void back(MouseEvent event) {

    }
    
    ObservableList<contact> contactList = FXCollections.observableArrayList(); 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        try {
            Connection conn = dbconnection.busConnection();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM busApplication.Contact");

            while(rs.next()){
                contactList.add(new contact(rs.getInt("contactID"), rs.getString("nama"), rs.getString("email"), rs.getString("phone"), rs.getString("message")));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        tc_contactID.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        tc_nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tc_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tc_noTelp.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tc_pesan.setCellValueFactory(new PropertyValueFactory<>("message"));
        table_contactUs.setItems(contactList);
    }
    

}
