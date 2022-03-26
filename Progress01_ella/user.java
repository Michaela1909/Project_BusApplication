public class user {
    int userID; 
    String fullName;
    String email;
    String password;
    String confirmPass; 

    public user(int inputUserID, String inputFullName, String inputEmail, String inputPass, String inputConfirmPass ){
        userID = inputUserID;
        fullName = inputFullName;
        email = inputEmail;
        password = inputPass;
        confirmPass = inputConfirmPass;
    }
    
    public int getUserID(){
        return userID;
    }
    public String getFullName(){
        return fullName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getConfirmPass(){
        return confirmPass;
    }
    public void setUserID(int inputUserID){
        userID = inputUserID;
    }
    public void setFullName(String inputFullName){
        fullName = inputFullName;
    }
    public void setEmail(String inputEmail){
        email = inputEmail;
    }
    public void setPass(String inputPass){
        password = inputPass;
    }
    public void setConfirmPass(String inputConfirmPass){
        confirmPass = inputConfirmPass;
    }
}
