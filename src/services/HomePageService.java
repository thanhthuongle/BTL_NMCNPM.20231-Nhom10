package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.HomeController;

public class HomePageService {

    private HomeController homeController;

    public HomePageService(HomeController homeController) {
        this.homeController = homeController;
    }

    public int getTongNhanKhau() {
        int result = 0;
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT COUNT(*) AS tong FROM nhan_khau";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getInt("tong");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getTongHoKhau() {
        int result = 0;
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT COUNT(*) AS tong FROM ho_khau";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getInt("tong");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getTongTamTru() {
        int result = 0;
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT COUNT(*) AS tong FROM tam_tru WHERE denNgay >= GETDATE()";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getInt("tong");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getTongTamVang() {
        int result = 0;
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT COUNT(*) AS tong FROM tam_vang WHERE denNgay >= GETDATE()";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getInt("tong");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


    public int getTongHoKhauConThieu() {
        int result = 0;
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT ho_khau.ID FROM ho_khau\n" +
                    "EXCEPT\n" +
                    "SELECT ho_khau.ID\n" +
                    "FROM nop_phi\n" +
                    "JOIN phi_bat_buoc ON nop_phi.idPhiThu = phi_bat_buoc.ID\n" +
                    "JOIN nhan_khau ON nop_phi.idNhanKhau = nhan_khau.ID\n" +
                    "JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID\n" +
                    "JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau\n" +
                    "WHERE MONTH(nop_phi.ngay_nop)=MONTH(GETDATE()) and YEAR(nop_phi.ngay_nop)=YEAR(GETDATE())\n" +
                    "GROUP BY ho_khau.ID,phi_bat_buoc.so_tien\n" +
                    "HAVING phi_bat_buoc.so_tien * (SELECT COUNT(*) FROM thanh_vien_cua_ho as F2 WHERE ho_khau.ID = F2.idHoKhau) <= SUM(nop_phi.so_tien)";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result++;
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
