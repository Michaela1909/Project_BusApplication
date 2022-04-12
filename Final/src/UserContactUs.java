import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserContactUs {

    Connection con = connection.BusConnecition();
    PreparedStatement pst; 

    @FXML
    private ImageView back;

    @FXML
    private Button btnKirim;

    @FXML
    private TextArea ta_pesan;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_phoneNum;

    @FXML
    void Kirim(ActionEvent event) {
        try {
            pst = con.prepareStatement("insert into Contact(Nama, Email, Phone, Message) VALUES (?, ?, ?, ?)");
            pst.setString(1, tf_name.getText());
            pst.setString(2, tf_email.getText());
            pst.setString(3, tf_phoneNum.getText());
            pst.setString(4, ta_pesan.getText());
            
            int status = pst.executeUpdate();
            if(status == -1){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Terjadi kesalahan");
                alert.setContentText("Silahkan coba lagi!");
                alert.showAndWait();            
            }else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Anda berhasil mengirimkan pesan anda!");
                alert.setContentText("Terima kasih.");
                alert.showAndWait();  
                
                tf_name.setText(null);
                tf_email.setText(null);
                tf_phoneNum.setText(null);
                ta_pesan.setText(null);

            }
        } catch (Exception e) {
            //TODO: handle exception
            e.getStackTrace();
            e.getCause();
        }
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) btnKirim.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

}
