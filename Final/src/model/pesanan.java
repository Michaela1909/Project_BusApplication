package model;


public class pesanan {
    private int TransaksiID; 
    private int BusID;
    private String NamaBus;
    private String Asal;
    private String Tujuan;
    private String Tanggal;
    private String Waktu; 
    private int Quantity; 
    
    public pesanan(int inputTransaksiID, int inputBusID, String inputNamaBus, String inputAsal, String inputTujuan, String inputTanggal, String inputWaktu, int inputQuantity){
        this.TransaksiID = inputTransaksiID;
        this.BusID = inputBusID;
        this.NamaBus = inputNamaBus;
        this.Asal = inputAsal;
        this.Tujuan = inputTujuan;
        this.Tanggal = inputTanggal;
        this.Waktu = inputWaktu;
        this.Quantity = inputQuantity;
    }

    public int getTransaksiID(){
        return TransaksiID;
    }
    public void setTransaksiID(int inputTransaksiID){
        TransaksiID = inputTransaksiID;
    }
    public int getBusID(){
        return BusID;
    }
    public void setBusID(int inputBusID){
        BusID = inputBusID;
    }
    public String getNamaBus(){
        return NamaBus;
    }
    public void setNamaBus(String inputNamaBus){
        NamaBus = inputNamaBus;
    }
    public String getAsal(){
        return Asal;
    }
    public void setAsal(String inputAsal){
        Asal = inputAsal;
    }
    public String getTujuan(){
        return Tujuan;
    }
    public void setTujuan(String inputTujuan){
        Tujuan = inputTujuan;
    }
    public String getTanggal(){
        return Tanggal;
    }
    public void setTanggal(String inputTanggal){
        Tanggal = inputTanggal;
    }
    public String getWaktu(){
        return Waktu;
    }
    public void setWaktu(String inputWaktu){
        Waktu = inputWaktu;
    }
    public int getQuantity(){
        return Quantity;
    }
    public void setQuantity(int inputQuantity){
        Quantity = inputQuantity;
    }
}

