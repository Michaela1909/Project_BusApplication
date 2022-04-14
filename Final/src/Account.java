import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Account implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Label lb_userid;

    @FXML
    private Button Logout;
    
    @FXML
    private Button edit;
    
    @FXML
    private TextField tf_email;
    
    @FXML
    private TextField tf_nama;
    
    @FXML
    private TextField tf_password;

    PreparedStatement pst;
    Connection con = connection.BusConnecition();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT User.UserID,User.FullName, User.Email, User.Password FROM User, Transaksi WHERE Transaksi.UserID = User.UserID ORDER BY Transaksi.TransaksiID DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lb_userid.setText("User ID: " + rs.getString(1));
                tf_nama.setText(rs.getString(2));
                tf_email.setText(rs.getString(3));
                tf_password.setText(rs.getString(4));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        
    }



    @FXML
    void btnEdit(ActionEvent event) {
    try {
        PreparedStatement pst = con.prepareStatement
        ("UPDATE User Set FullName=?, Email=?, Password =?, ConfirmPassword=? WHERE UserID = (SELECT UserID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)");
            pst.setString(1, tf_nama.getText());
            pst.setString(2, tf_email.getText());
            pst.setString(3, tf_password.getText());
            pst.setString(4, tf_password.getText());

            if(pst.executeUpdate() ==-1) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Edit Gagal");
                alert.setContentText("Check Di data base ");
                alert.showAndWait();    
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Anda berhasil merubah profil akun!");
                alert.setContentText("Terima kasih.");
                alert.showAndWait();  
                    
            }
        
        } catch (Exception e) {
        e.printStackTrace();
        e.getCause();
    }
    }
            
    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        Stage stage = (Stage) Logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }
}
