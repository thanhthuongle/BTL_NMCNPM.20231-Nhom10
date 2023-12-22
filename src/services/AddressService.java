package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AddressService {

	public List<String> searchByWard(String key) {
		List<String> list = new ArrayList<String>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT DISTINCT TOP 10 name FROM wards " + "WHERE CONTAINS(name, '\"*" + key + "*\"');";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String ward = rs.getString("name");
				list.add(ward);
			}
			connection.close();
		} catch (Exception e) {
			handleException();
		}
		return list;
	}

	public List<String> searchByDistrict(String key) {
		List<String> list = new ArrayList<String>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT DISTINCT TOP 10 name FROM districts " + "WHERE CONTAINS(name, '\"*" + key + "*\"');";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String ward = rs.getString("name");
				list.add(ward);
			}
			connection.close();
		} catch (Exception e) {
			handleException();
		}
		return list;
	}

	public List<String> searchByProvince(String key) {
		List<String> list = new ArrayList<String>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT DISTINCT TOP 10 name FROM provinces " + "WHERE CONTAINS(name, '\"*" + key + "*\"');";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String ward = rs.getString("name");
				list.add(ward);
			}
			connection.close();
		} catch (Exception e) {
			handleException();
		}
		return list;
	}

	public List<String> getAllProvince() {
		List<String> list = new ArrayList<String>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT name FROM provinces";
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				String nameProvince = res.getString("name");
				list.add(nameProvince);
			}
			;
		} catch (Exception e) {
			// TODO: handle exception
			handleException();
		}
		return list;
	}

	public List<String> getAllDistrictOfProvince(String province) {
		List<String> list = new ArrayList<String>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT districts.name FROM provinces , districts WHERE districts.province_code=provinces.code and provinces.name= N'"+province+"';";
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				String nameProvince = res.getString("name");
				list.add(nameProvince);
			}
			;
		} catch (Exception e) {
			// TODO: handle exception
			handleException();
		}
		return list;
	}
	
	public List<String> getAllWardOfDistricts(String districts,String province) {
		List<String> list = new ArrayList<String>();
		try {
			Connection connection = SQLConnection.getDbConnection("vietnamese_provinces");
			String query = "SELECT wards.name FROM provinces , districts ,wards WHERE wards.district_code=districts.code and districts.province_code=provinces.code and provinces.name= N'"+province+"' and districts.name= N'"+districts+"';";
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				String nameProvince = res.getString("name");
				list.add(nameProvince);
			}
			;
		} catch (Exception e) {
			// TODO: handle exception
			handleException();
		}
		return list;
	}

	private void handleException() {
		JOptionPane.showMessageDialog(null, "Có lỗi xảy ra, thử kiểm tra lại cơ sở dữ liệu", "Warning",
				JOptionPane.ERROR_MESSAGE);
	}

}