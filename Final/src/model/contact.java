package model;

public class contact {
    private int ContactID;
    private String Nama; 
    private String Email; 
    private String Phone; 
    private String Message;

    public contact(int inputContactID, String inputNama, String inputEmail, String inputPhone, String inputMessage){
        this.ContactID = inputContactID;
        this.Nama = inputNama;
        this.Email = inputEmail;
        this.Phone = inputPhone;
        this.Message = inputMessage;
    }
    public int getContactID(){
        return ContactID;
    }
    public void setContactID(int inputContactID){
        ContactID = inputContactID;
    }
    public String getNama(){
        return Nama;
    }
    public void setNama(String inputNama){
        Nama = inputNama;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String inputEmail){
        Email = inputEmail;
    }
    public String getPhone(){
        return Phone;
    }
    public void setPhone(String inputPhone){
        Phone = inputPhone;
    }
    public String getMessage(){
        return Message;
    }
    public void setMessage(String inputMessage){
        Message= inputMessage;
    }
}
