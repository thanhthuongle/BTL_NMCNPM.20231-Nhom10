package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.UserModel;

public class LoginService {

    public static UserModel currentUser = new UserModel();
    
    public boolean login(String userName, String passwod) throws SQLException, ClassNotFoundException{
        Connection connection = SQLConnection.getDbConnection();
        String sql = "SELECT * FROM users WHERE userName=? AND passwd=?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, userName);
        st.setString(2, passwod);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {                
            LoginService.currentUser.setID(rs.getInt("ID"));
            LoginService.currentUser.setUserName(rs.getString("userName"));
            return true;
        }
        connection.close();
        return false;
    }
}
