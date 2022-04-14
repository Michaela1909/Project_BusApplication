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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Seat implements Initializable{

    String style1 = String.format("-fx-background-color: #FEB139");
    String style2 = String.format("-fx-background-color: #FF0000");
    String style3 = String.format("-fx-background-color: #33FF00");
    Connection con = connection.BusConnecition();
    
    @FXML
    private Label LabelWaktu;

    @FXML
    private Button btnA1;

    @FXML
    private Button btnA2;

    @FXML
    private Button btnA3;

    @FXML
    private Button btnA4;

    @FXML
    private Button btnB1;

    @FXML
    private Button btnB2;

    @FXML
    private Button btnB3;

    @FXML
    private Button btnB4;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnC1;

    @FXML
    private Button btnC2;

    @FXML
    private Button btnC3;

    @FXML
    private Button btnC4;

    @FXML
    private Button btnD1;

    @FXML
    private Button btnD2;

    @FXML
    private Button btnD3;

    @FXML
    private Button btnD4;

    @FXML
    private Button btnE1;

    @FXML
    private Button btnE2;

    @FXML
    private Button btnE3;

    @FXML
    private Button btnE4;

    @FXML
    private Button btnF1;

    @FXML
    private Button btnF2;

    @FXML
    private Button btnF3;

    @FXML
    private Button btnF4;

    @FXML
    private Button btnG1;

    @FXML
    private Button btnG2;

    @FXML
    private Button btnG3;

    @FXML
    private Button btnG4;

    @FXML
    private Button btnH1;

    @FXML
    private Button btnH2;

    @FXML
    private Button btnH3;

    @FXML
    private Button btnH4;

    @FXML
    private Button btnH5;

    @FXML
    private Button btnH6;

    @FXML
    private Button btnPesan;

    @FXML
    private Button btnRefresh;

    @FXML
    private Label labelAsal;

    @FXML
    private Label labelNamaBus;

    @FXML
    private Label labelQuantity;

    @FXML
    private Label labelTanggal;

    @FXML
    private Label labelTujuan;

    @FXML
    void A1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'A1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'A1' , 1)");
                    pst.execute();
                    btnA1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                    e.getCause();
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void A2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'A2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'A2' , 1)");
                    pst.execute();
                    btnA2.setStyle(style1);
                    getQuantity();
                    
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                    e.getCause();
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void A3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'A3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'A3' , 1)");
                    pst.execute();
                    btnA3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                    e.getCause();
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void A4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'A4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'A4' , 1)");
                    pst.execute();
                    btnA4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                    e.getCause();
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void B1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'B1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'B1' , 1)");
                    pst.execute();
                    btnB1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                    e.getCause();
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void B2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'B2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'B2' , 1)");
                    pst.execute();
                    btnB2.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void B3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'B3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'B3' , 1)");
                    pst.execute();
                    btnB3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void B4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'B4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'B4' , 1)");
                    pst.execute();
                    btnB4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
        e.printStackTrace();
        e.getCause();
        }
    }

    @FXML
    void C1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'C1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'C1' , 1)");
                    pst.execute();
                    btnC1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void C2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'C2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'C2' , 1)");
                    pst.execute();
                    btnC2.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void C3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'C3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'C3' , 1)");
                    pst.execute();
                    btnC3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void C4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'C4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'C4' , 1)");
                    pst.execute();
                    btnC4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void D1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'D1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'D1' , 1)");
                    pst.execute();
                    btnD1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void D2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'D2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'D2' , 1)");
                    pst.execute();
                    btnD2.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void D3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'D3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'D3' , 1)");
                    pst.execute();
                    btnD3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void D4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'D4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'D4' , 1)");
                    pst.execute();
                    btnD4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void E1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'E1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'E1' , 1)");
                    pst.execute();
                    btnE1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void E2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'E2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'E2' , 1)");
                    pst.execute();
                    btnE2.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void E3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'E3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'E3' , 1)");
                    pst.execute();
                    btnE3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void E4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'E4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'E4' , 1)");
                    pst.execute();
                    btnE4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void F1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'F1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'F1' , 1)");
                    pst.execute();
                    btnF1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void F2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'F2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'F2' , 1)");
                    pst.execute();
                    btnF2.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void F3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'F3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'F3' , 1)");
                    pst.execute();
                    btnF3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void F4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'F4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'F4' , 1)");
                    pst.execute();
                    btnF4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void G1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'G1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'G1' , 1)");
                    pst.execute();
                    btnG1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void G2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'G2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'G2' , 1)");
                    pst.execute();
                    btnG2.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void G3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'G3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'G3' , 1)");
                    pst.execute();
                    btnG3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void G4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'G4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'G4' , 1)");
                    pst.execute();
                    btnG4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void H1(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'H1' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'H1' , 1)");
                    pst.execute();
                    btnH1.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void H2(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'H2' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'H2' , 1)");
                    pst.execute();
                    btnH2.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void H3(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'H3' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'H3' , 1)");
                    pst.execute();
                    btnH3.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void H4(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'H4' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'H4' , 1)");
                    pst.execute();
                    btnH4.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void H5(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'H5' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'H5' , 1)");
                    pst.execute();
                    btnH5.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void H6(ActionEvent event) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM Seat WHERE SeatName = 'H6' AND BusID = (SELECT BusID FROM Transaksi WHERE TransaksiID ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                alert();
            }else{
                try {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Seat(TransaksiID, BusID, SeatName, Status) VALUES ((SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), (SELECT Transaksi.BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1), 'H6' , 1)");
                    pst.execute();
                    btnH6.setStyle(style1);
                    getQuantity();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void Pesan(ActionEvent event) throws IOException {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Transaksi SET Quantity = ?  ORDER BY TransaksiID DESC LIMIT 1");
            pst.setInt(1, Integer.parseInt(labelQuantity.getText()));
            pst.execute();

            pst = con.prepareStatement("UPDATE Transaksi SET TotalHarga = (SELECT Harga FROM JadwalBus WHERE Transaksi.BusID = JadwalBus.BusID) * Quantity ORDER BY TransaksiID DESC LIMIT 1");
            pst.execute();

            Stage stage = (Stage) btnPesan.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
            stage.setTitle("Bus");
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        
    }

    @FXML
    void back(ActionEvent event) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Transaksi SET Quantity = null, TotalHarga = null ORDER BY TransaksiID DESC LIMIT 1");
            pst.execute();

            

            pst = con.prepareStatement("DELETE FROM Seat WHERE TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)");
            pst.execute();

            getStatusA1(); getStatusA2(); getStatusA3(); getStatusA4();
            getStatusB1(); getStatusB2(); getStatusB3(); getStatusB4();
            getStatusC1(); getStatusC2(); getStatusC3(); getStatusC4();
            getStatusD1(); getStatusD2(); getStatusD3(); getStatusD4();
            getStatusE1(); getStatusE2(); getStatusE3(); getStatusE4(); 
            getStatusF1(); getStatusF2(); getStatusF3(); getStatusF4();
            getStatusG1(); getStatusG2(); getStatusG3(); getStatusG4();
            getStatusH1(); getStatusH2(); getStatusH3(); getStatusH4(); getStatusH5(); getStatusH6();
            labelQuantity.setText(Integer.toString(0));

            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Pesan.fxml"));
            stage.setTitle("Bus");
            stage.setScene(new Scene(root));

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void refresh(ActionEvent event) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Transaksi SET Quantity = null, TotalHarga = null ORDER BY TransaksiID DESC LIMIT 1");
            pst.execute();

            pst = con.prepareStatement("DELETE FROM Seat WHERE TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)");
            pst.execute();

            getStatusA1(); getStatusA2(); getStatusA3(); getStatusA4();
            getStatusB1(); getStatusB2(); getStatusB3(); getStatusB4();
            getStatusC1(); getStatusC2(); getStatusC3(); getStatusC4();
            getStatusD1(); getStatusD2(); getStatusD3(); getStatusD4();
            getStatusE1(); getStatusE2(); getStatusE3(); getStatusE4(); 
            getStatusF1(); getStatusF2(); getStatusF3(); getStatusF4();
            getStatusG1(); getStatusG2(); getStatusG3(); getStatusG4();
            getStatusH1(); getStatusH2(); getStatusH3(); getStatusH4(); getStatusH5(); getStatusH6();
            labelQuantity.setText(Integer.toString(0));
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT NamaBus, Tanggal, Asal, Tujuan, Waktu FROM JadwalBus WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                labelNamaBus.setText(rs.getString(1));
                labelTanggal.setText(rs.getString(2));
                labelAsal.setText(rs.getString(3));
                labelTujuan.setText(rs.getString(4));
                LabelWaktu.setText(rs.getString(5));
                getQuantity();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        getStatusA1(); getStatusA2(); getStatusA3(); getStatusA4();
        getStatusB1(); getStatusB2(); getStatusB3(); getStatusB4();
        getStatusC1(); getStatusC2(); getStatusC3(); getStatusC4();
        getStatusD1(); getStatusD2(); getStatusD3(); getStatusD4();
        getStatusE1(); getStatusE2(); getStatusE3(); getStatusE4(); 
        getStatusF1(); getStatusF2(); getStatusF3(); getStatusF4();
        getStatusG1(); getStatusG2(); getStatusG3(); getStatusG4();
        getStatusH1(); getStatusH2(); getStatusH3(); getStatusH4(); getStatusH5(); getStatusH6();
    }
    public void getQuantity(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT COUNT(SeatID) FROM Seat WHERE TransaksiID = (SELECT TransaksiID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1)";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                labelQuantity.setText(Integer.toString(rs.getInt(1)));
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            e.getCause();
        }
    }
    public void alert(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gagal");
        alert.setHeaderText("Tempat sudah di booked!");
        alert.setContentText("Silahkan memilih yang lain.");
        alert.showAndWait();
    }
    public void getStatusA1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'A1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnA1.setStyle(style2);
                }
            }else
                btnA1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusA2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'A2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnA2.setStyle(style2);
                }
            }else
                btnA2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusA3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'A3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnA3.setStyle(style2);
                }
            }else
                btnA3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusA4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'A4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnA4.setStyle(style2);
                }
            }else
                btnA4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusB1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'B1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnB1.setStyle(style2);
                }
            }else
                btnB1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusB2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'B2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnB2.setStyle(style2);
                }
            }else
                btnB2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusB3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'B3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnB3.setStyle(style2);
                }
            }else
                btnB3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusB4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'B4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnB4.setStyle(style2);
                }
            }else
                btnB4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusC1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'C1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnC1.setStyle(style2);
                }
            }else
                btnC1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusC2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'C2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnC2.setStyle(style2);
                }
            }else
                btnC2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusC3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'C3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnC3.setStyle(style2);
                }
            }else
                btnC3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusC4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'C4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnC4.setStyle(style2);
                }
            }else
                btnC4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusD1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'D1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnD1.setStyle(style2);
                }
            }else
                btnD1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusD2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'D2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnD2.setStyle(style2);
                }
            }else
                btnD2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusD3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'D3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnD3.setStyle(style2);
                }
            }else
                btnD3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusD4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'D4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnD4.setStyle(style2);
                }
            }else
                btnD4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusE1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'E1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnE1.setStyle(style2);
                }
            }else
                btnE1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusE2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'E2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnE2.setStyle(style2);
                }
            }else
                btnE2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusE3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'E3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnE3.setStyle(style2);
                }
            }else
                btnE3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusE4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'E4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnE4.setStyle(style2);
                }
            }else
                btnE4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusF1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'F1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnF1.setStyle(style2);
                }
            }else
                btnF1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusF2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'F2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnF2.setStyle(style2);
                }
            }else
                btnF2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusF3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'F3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnF3.setStyle(style2);
                }
            }else
                btnF3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusF4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'F4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnF4.setStyle(style2);
                }
            }else
                btnF4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusG1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'G1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnG1.setStyle(style2);
                }
            }else
                btnG1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusG2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'G2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnG2.setStyle(style2);
                }
            }else
                btnG2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusG3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'G3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnG3.setStyle(style2);
                }
            }else
                btnG3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusG4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'G4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnG4.setStyle(style2);
                }
            }else
                btnG4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusH1(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'H1'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnH1.setStyle(style2);
                }
            }else
                btnH1.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusH2(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'H2'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnH2.setStyle(style2);
                }
            }else
                btnH2.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusH3(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'H3'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnH3.setStyle(style2);
                }
            }else
                btnH3.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusH4(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'H4'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnH4.setStyle(style2);
                }
            }else
                btnH4.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusH5(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'H5'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnH5.setStyle(style2);
                }
            }else
                btnH5.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void getStatusH6(){
        try {
            Statement st = con.createStatement();
            String sql = "SELECT Status FROM SEAT WHERE BusID = (SELECT BusID FROM Transaksi ORDER BY TransaksiID DESC LIMIT 1) AND SeatName = 'H6'";
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getInt(1)==1){
                    btnH6.setStyle(style2);
                }
            }else
                btnH6.setStyle(style3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
