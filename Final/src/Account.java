import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.sql.StatementEvent;
import javax.swing.JOptionPane;

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
    
    //int tabel;
    //int myIndex;
    //int UserID;
    //String sql;
    //StatementEvent st;
    PreparedStatement pst;
    Connection con = connection.BusConnecition();


@Override
public void initialize(URL location, ResourceBundle resources) {
    // TODO Auto-generated method stub
    try {
        Statement st = con.createStatement();
        String sql = "SELECT User.UserID,User.FullName, User.Email, User.Password FROM User, Transaksi WHERE Transaksi.UserID = User.UserID ORDER BY Transaksi.TransaksiID DESC LIMIT 1";
        //SELECT User.FullName, User.Email, User.Password FROM User, Transaksi WHERE Transaksi.UserID = User.UserID ORDER BY Transaksi.TransaksiID DESC LIMIT 1;
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            lb_userid.setText(rs.getString(1));
            tf_nama.setText(rs.getString(2));
            tf_email.setText(rs.getString(3));
            tf_password.setText(rs.getString(4));
            
        }
    } catch (Exception e) {
        //TODO: handle exception
    }
    
}



@FXML
void btnEdit(ActionEvent event) {

    /*myIndex = tabel.getSelectionsModel().getSelectedIndex();

    UserID = Integer.parseInt(String.valueOf(table.getitem().get(myIndex).getUserID()));
    nama = tf_nama.getText();
    email = tf_email.getText();
    password = tf_password.getText();*/
   int result = 0;
   try {
    PreparedStatement pst = con.prepareStatement
    ("UPDATE User Set FullName=?, Email=?, Password =?, ConfirmPassword=? WHERE UserID = (SELECT UserID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)");
        pst.setString(1, tf_nama.getText());
        pst.setString(2, tf_email.getText());
        pst.setString(3, tf_password.getText());
        pst.setString(4, tf_password.getText());

    if(pst.executeUpdate() !=0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Edit Gagal");
            alert.setContentText("Check Di data base ");
            alert.showAndWait();
            result = 1;
    }
    else
    {
        Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Anda berhasil mengirimkan pesan anda!");
                alert.setContentText("Terima kasih.");
                alert.showAndWait();  
                
                tf_nama.setText(null);
                tf_email.setText(null);
                tf_password.setText(null);
                lb_userid.setText(null);
    }
      
        } catch (Exception e) {
       //TODO: handle exception
   }
}
        
@FXML
void btnLogout(ActionEvent event) throws IOException {
    Stage stage = (Stage) Logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

}
