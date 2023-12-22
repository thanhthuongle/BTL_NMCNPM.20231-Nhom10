package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SQLConnection {
	public static String serverName = "";

	public static String databaseName = "quan_ly_nhan_khau";
	public static String userName = "";
	public static String password = "";

	public static void getConfig() {
		try {
			File fileConfig = new File(".\\config.txt");
			Scanner myReader = new Scanner(fileConfig);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String dataConfig[] = data.split("=");
				switch (dataConfig[0].trim()) {
				case "SERVER_NAME": {

					serverName = dataConfig[1].trim();
					break;
				}
				case "USER_NAME": {

					userName = dataConfig[1].trim();
					break;
				}
				case "PASSWORD": {

					password = dataConfig[1].trim();
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + dataConfig[0].trim());
				}
			}
			myReader.close();
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, e);
			// TODO: handle exception
		}
	}

	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		getConfig();
		String url = "jdbc:sqlserver://" + SQLConnection.serverName + ":1433;DatabaseName=" + SQLConnection.databaseName
				+ ";encrypt=true;trustServerCertificate=true;";
		return DriverManager.getConnection(url, SQLConnection.userName, SQLConnection.password);
	}

	public static Connection getDbConnection(String dbName) throws SQLException, ClassNotFoundException {
		getConfig();
		String url = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + dbName
				+ ";encrypt=true;trustServerCertificate=true;";
		Connection conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
}