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
import model.user;

public class DataPengguna implements Initializable {

    Connection con = connection.BusConnecition();
    LinkedList<user> list = new LinkedList<>();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Id.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        NamaLengkap.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        confirmPassword.setCellValueFactory(new PropertyValueFactory<>("ConfirmPassword"));

        try {
            Statement st = con.createStatement();
            String sql = "SELECT UserID, FullName, Email, Password, ConfirmPassword FROM User WHERE UserStatus = 'U'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                user table_dataPengguna = new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(table_dataPengguna);
            }
            table_dataPengguna.getItems().clear();
            table_dataPengguna.getItems().addAll(list);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
