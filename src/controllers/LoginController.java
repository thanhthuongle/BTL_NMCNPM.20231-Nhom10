
package controllers;

import java.sql.SQLException;
import models.UserModel;
import services.LoginService;

public class LoginController {
    
    public static UserModel currentUser = LoginService.currentUser;
    private LoginService loginService = new LoginService();
    
    public boolean login(String userName, String passwod) throws SQLException, ClassNotFoundException{
    	return loginService.login(userName, passwod);
    }
}
