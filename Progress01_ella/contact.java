public class contact {
    int contactID;
    String nama;
    String email; 
    String phone;
    String message;

    public contact(int inputContactID, String inputNama, String inputEmail, String inputPhone, String inputMessage){
        contactID = inputContactID;
        nama = inputNama;
        email = inputEmail;
        phone = inputPhone;
        message = inputMessage;
    }

    public int getContactID(){
        return contactID;
    }
    public String getNama(){
        return nama;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getMessage(){
        return message;
    }
    public void setContactID(int inputContactID){
        contactID = inputContactID;
    }
    public void setNama(String inputNama){
        nama = inputNama;
    }
    public void setEmail(String inpuEmail){
        email = inpuEmail;
    }
    public void setPhone(String inputPhone){
        phone = inputPhone;
    }
    public void setMessage(String inputMessage){
        message = inputMessage;
    }
    
}
