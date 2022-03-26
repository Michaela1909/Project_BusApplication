import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ContactUs {

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

    Connection con;
    PreparedStatement pst;
    @FXML
    void Kirim(ActionEvent event) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/busApplication", "root", "Nml_19092002");

            pst = con.prepareStatement("insert into Contact(nama, email, phone, message) VALUES (?, ?, ?, ?)");
            pst.setString(1, tf_name.getText());
            pst.setString(2, tf_email.getText());
            pst.setString(3, tf_phoneNum.getText());
            pst.setString(4, ta_pesan.getText());
            
            int status = pst.executeUpdate();
            if(status == -1){
                JOptionPane.showMessageDialog(null, "record failed");
            }else{
                tf_name.setText(null);
                tf_email.setText(null);
                tf_phoneNum.setText(null);
                ta_pesan.setText(null);

                Stage stage = (Stage) btnKirim.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("ContactUs.fxml"));
                stage.setTitle("Bus");
                stage.setScene(new Scene(root));
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.getStackTrace();
            e.getCause();
        }
    }
    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage.setTitle("Bus");
        stage.setScene(new Scene(root));
    }

}
