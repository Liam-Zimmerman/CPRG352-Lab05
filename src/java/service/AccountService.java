
package service;

import models.User;


public class AccountService {
    
    public User login(String username, String password){
        
        if(username.equals("abe") && password.equals("password"))
        {
            User user = new User("abe", null);
            return user;
        }
        else if(username.equals("barb") && password.equals("password"))
        {
            User user = new User("barb", null);
            return user;
        }
        else
        {
            return null;
        }
    }
}
