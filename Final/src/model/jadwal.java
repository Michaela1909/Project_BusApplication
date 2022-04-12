package model;

public class jadwal {
    private int BusID;
    private String NamaBus;
    private int Kapasitas; 
    private String Tanggal;
    private int Harga;
    private String Asal;
    private String Tujuan;
    private String Waktu; 

    public jadwal(int inputBusID, String inputNamaBus, int inputKapasitas, String inputTanggal, int inputHarga, String inputAsal, String inputTujuan, String inputWaktu){
        this.BusID = inputBusID;
        this.NamaBus = inputNamaBus;
        this.Kapasitas = inputKapasitas;
        this.Tanggal = inputTanggal;
        this.Harga = inputHarga;
        this.Asal = inputAsal;
        this.Tujuan = inputTujuan;
        this.Waktu = inputWaktu;
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
    public int getKapasitas(){
        return Kapasitas;
    }
    public void setKapasitas(int inputKapasitas){
        Kapasitas = inputKapasitas;
    }
    public String getTanggal(){
        return Tanggal;
    }
    public void setTanggal(String inputTanggal){
        Tanggal = inputTanggal;
    }
    public int getHarga(){
        return Harga;
    }
    public void setHarga(int inputHarga){
        Harga = inputHarga;
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
    public String getWaktu(){
        return Waktu;
    }
    public void setWaktu(String inputWaktu){
        Waktu = inputWaktu;
    }
}
