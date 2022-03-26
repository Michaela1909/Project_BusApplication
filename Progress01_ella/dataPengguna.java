import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class dataPengguna implements Initializable{

    @FXML
    private TableColumn<user, Integer> Id;

    @FXML
    private TableColumn<user, String> NamaLengkap;

    @FXML
    private ImageView back;

    @FXML
    private TableColumn<user, String> confirmPassword;

    @FXML
    private TableColumn<user, String> email;

    @FXML
    private TableColumn<user, String> password;

    @FXML
    private TableView<user> table_dataPengguna;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    ObservableList<user> userList = FXCollections.observableArrayList(); 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        try {
            Connection conn = dbconnection.busConnection();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM User");

            while(rs.next()){
                userList.add(new user(rs.getInt("userID"), rs.getString("fullName"), rs.getString("email"), rs.getString("password"), rs.getString("confirmPassword")));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        Id.setCellValueFactory(new PropertyValueFactory<>("userID"));
        NamaLengkap.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        confirmPassword.setCellValueFactory(new PropertyValueFactory<>("confirmPass"));
        table_dataPengguna.setItems(userList);
    }
    

}
