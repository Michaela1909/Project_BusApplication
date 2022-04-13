package model;

import java.util.List;

public class Akun {

    private String FullName;
    private String Email; 
    private String Password;
    private String ConfirmPassword;


    public Akun (String inputFullName, String inputEmail, String inputPassword, String inputConfirmPassword){
        this.FullName = inputFullName;
        this.Email = inputEmail;
        this.Password = inputPassword;
        this.ConfirmPassword = inputConfirmPassword;

    }
    /*public int getUserID(){
        return UserID;
    }*/
    /*public void setUserID(int inputUserID){
        UserID = inputUserID;
    }*/
    public String getFullName(){
        return FullName;
    }
    public void setFullName(String inputFullName){
        FullName = inputFullName;
    }
    public String getEmail(){
        return Email;
    }
    public void setEmail(String inputEmail){
        Email =inputEmail;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String inputPassword){
        Password = inputPassword;
    }
    public String getConfirmPassword(){
        return ConfirmPassword;
    }
    public void setConfirmPassword(String inputConfirmPassword){
        ConfirmPassword = inputConfirmPassword;
    }
    /*public String getUserStatus(){
        return UserStatus; 
    }*/
    /*public void setUserStatus(String inputUserStatus){
        UserStatus = inputUserStatus;
    }*/
    public List<Akun> getItems() {
        return null;
    }
  
}
