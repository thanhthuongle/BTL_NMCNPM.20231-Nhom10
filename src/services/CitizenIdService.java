package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CitizenIdService {
	
	   public List<String> getCids() {
	        List<String> list = new ArrayList<String>();
	        try {
	            Connection connection = SQLConnection.getDbConnection();
	            String query = "SELECT TOP 10 soCMT FROM chung_minh_thu";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()){
	                String cmt = rs.getString("soCMT");
	                list.add(cmt);
	            }
	            preparedStatement.close();
	            connection.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return list;
	    }

    public List<String> search(String keyword) {
        List<String> list = new  ArrayList<String>();
        if (keyword.trim().isEmpty()) {
            return this.getCids();
        }
        
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT TOP 10 soCMT FROM chung_minh_thu "
            	      + "WHERE soCMT LIKE('" + keyword + "%')";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String cmt = rs.getString("soCMT");
                list.add(cmt);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
