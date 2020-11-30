package services;

import dataaccess.UserDB;
import java.util.HashMap;
import models.User;


public class AccountService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
        
    }
    
    public boolean forgotPassword(String email, String path){
        
        UserDB userDB = new UserDB();
        
        try{
            User user = userDB.get(email);
            
            String to = user.getEmail();
            String subject = "Notes App Forgotten Password";
            String template = path+"/emailtemplates/forgotpassword.html";
            
            HashMap<String, String> tags = new HashMap<>();
            
            tags.put("firstname", user.getFirstName());
            tags.put("lastname", user.getLastName());
            tags.put("date", (new java.util.Date().toString()));
            tags.put("password", user.getPassword());
            
            GmailService.sendMail(user.getEmail(), subject, template , tags);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    
    
}
