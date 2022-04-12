package model;

public class penjualan {
    private int TransaksiID;
    private String NamaBus;
    private String FullName; 
    private int Quantity; 
    private int TotalHarga; 
    private String TanggalTransaksi; 
    private String MetodePembayaran; 

    public penjualan(int inputTransaksiID, String inputNamaBus, String inputFullName, int inputQuantity, int inputTotalHarga, String inputTanggalTransaksi, String inputMetodePembayaran){
        this.TransaksiID = inputTransaksiID;
        this.NamaBus = inputNamaBus;
        this.FullName = inputFullName;
        this.Quantity = inputQuantity;
        this.TotalHarga = inputTotalHarga;
        this.TanggalTransaksi = inputTanggalTransaksi;
        this.MetodePembayaran = inputMetodePembayaran;
    }
    public int getTransaksiID(){
        return TransaksiID;   
    }
    public void setTransaksiID(int inputTransaksiID){
        TransaksiID = inputTransaksiID;
    }
    public String getNamaBus(){
        return NamaBus;
    }
    public void setNamaBus(String inputNamaBus){
        NamaBus = inputNamaBus;
    }
    public String getFullName(){
        return FullName;
    }
    public void setFullName(String inputFullName){
        FullName = inputFullName;
    }
    public int getQuantity(){
        return Quantity;
    }
    public void setQuantity(int inputQuantity){
        Quantity = inputQuantity;
    }
    public int getTotalHarga(){
        return TotalHarga;
    }
    public void setTotalHarga(int inputTotalHarga){
        TotalHarga = inputTotalHarga;
    }
    public String getTanggalTransaksi(){
        return TanggalTransaksi;
    }
    public void setTanggalTransaksi(String inputTanggalTransaksi){
        TanggalTransaksi = inputTanggalTransaksi;
    }
    public String getMetodePembayaran(){
        return MetodePembayaran;
    }
    public void setMetodePembayaran(String inputMetodePembayaran){
        MetodePembayaran = inputMetodePembayaran;
    }
}
