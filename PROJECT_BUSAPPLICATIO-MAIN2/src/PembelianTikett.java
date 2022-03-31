public class PembelianTikett {
    int busID;
    String NamaBus;
    int Kapasitas;
    int Harga; 
    String Asal;
    String Tujuan;
    String Waktu;
    PembelianTikett next;
    PembelianTikett prev;
    
    public PembelianTikett(int inputBusID, String inputNamaBus, int inputKapasitas, String inputTanggal, int inputHarga, String inputAsal, String inputTujuan){
        busID = inputBusID;
        NamaBus = inputNamaBus;
        Kapasitas = inputKapasitas;
        Harga = inputHarga;
        Asal = inputAsal;
        Tujuan = inputTujuan;
        next = null;
        prev = null;
    }
    public int getBusID()
    {
        return busID;
    }
    public String getNamaBus()
    {
        return NamaBus;
    }
    public int getKapasitas()
    {
        return Kapasitas;
    }
    public int getHarga()
    {
        return Harga;
    }
    public String getAsal()
    {
        return Asal;
    }
    public String getTujuan()
    {
        return Tujuan;
    }
    public String getWaktu()
    {
        return Waktu;
    }
    public void setBusID(int inputBusID)
    {
        busID = inputBusID;
    }
    public void setNamaBus(String inputNamaBus)
    {
        NamaBus = inputNamaBus;
    }
    public void setKapasitas(int inputKapasitas)
    {
        Kapasitas = inputKapasitas;
    }
    public void setHarga(int inputHarga)
    {
        Harga = inputHarga;
    }
    public void setAsal(String inputAsal)
    {
        Asal = inputAsal;
    }
    public void setTujuan(String inputTujuan)
    {
        Tujuan = inputTujuan;
    }
    public void setWaktu(String inputWaktu)
    {
        Waktu = inputWaktu;
    }
    public String ToString()
    {
        return busID+" " + NamaBus +" "+ Kapasitas+ "  " +Harga+" "+Asal+" "+Tujuan+" "+Waktu;
    }
    
}

