package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import beans.HoKhauBean;
import beans.PhiUngHoBean;
import models.DonateModel;
import models.DonationsModel;
import models.HoKhauModel;
import models.PayDonationModel;

public class DonationsService {

	public List<PhiUngHoBean> allDonations() {
		List<PhiUngHoBean> list = new ArrayList<PhiUngHoBean>();
		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = "SELECT TOP 100 ID, ten_khoan_thu, ngay_tao FROM phi_ung_ho ORDER BY phi_ung_ho.ID";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PhiUngHoBean donationBean = new PhiUngHoBean();
				DonationsModel donation = donationBean.getDonationModel();
				donation.setID(rs.getInt("ID"));
				donation.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
				donation.setNgay_tao(rs.getDate("ngay_Tao"));
				list.add(donationBean);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			exceptionHandle(e.getMessage());
		}
		return list;
	}

	public List<PhiUngHoBean> searchDonationByID(String keyword) {
		List<PhiUngHoBean> list = new ArrayList<PhiUngHoBean>();
		if (keyword.trim().isEmpty()) {
			return this.allDonations();
		}

		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = "SELECT ID, ten_khoan_thu, ngay_tao FROM phi_ung_ho " + "WHERE ID LIKE('%" + keyword
					+ "%');";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PhiUngHoBean donationBean = new PhiUngHoBean();
				DonationsModel donation = donationBean.getDonationModel();
				donation.setID(rs.getInt("ID"));
				donation.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
				donation.setNgay_tao(rs.getDate("ngay_Tao"));
				list.add(donationBean);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			exceptionHandle(e.getMessage());
		}
		return list;
	}

	public boolean newDonation(PhiUngHoBean phiUngHoBean) throws SQLException, ClassNotFoundException {
		DonationsModel donation = phiUngHoBean.getDonationModel();
		Connection connection = SQLConnection.getDbConnection();

		String query = "INSERT INTO phi_ung_ho ( ten_khoan_thu, ngay_tao, idNguoiTao)" + " values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, donation.getTen_khoan_thu());
		preparedStatement.setDate(2, new Date(app.Main.calendar.getTime().getTime()));
		preparedStatement.setInt(3, LoginService.currentUser.getID());

		preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		connection.close();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean editDonation(PhiUngHoBean phiUngHoBean, int idDonation) {
		DonationsModel donation = phiUngHoBean.getDonationModel();
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			String query = "UPDATE phi_ung_ho " + " SET" + " ten_khoan_thu = ?" + " WHERE ID = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, donation.getTen_khoan_thu());
			preparedStatement.setInt(2, idDonation);

			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				return true;
			}
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//
	public List<PayDonationModel> payByHouseholdId(int householdId) {
		List<PayDonationModel> list = new ArrayList<PayDonationModel>();
		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = 
					"SELECT ho_khau.maHoKhau, phi_ung_ho.ten_khoan_thu, phi_ung_ho.so_tien, COUNT(*) AS SoThanhVienTrongHo, SUM(ung_ho.so_tien) AS TongTienDaNop FROM ho_khau\r\n"
					+ "JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idHoKhau = ho_khau.ID\r\n"
					+ "JOIN ung_ho ON ung_ho.idNhanKhau = thanh_vien_cua_ho.idNhanKhau\r\n"
					+ "JOIN phi_ung_ho ON phi_ung_ho.ID = ung_ho.idPhiThu\r\n"
					+ "WHERE ho_khau.ID = ?\r\n"
					+ "GROUP BY ho_khau.maHoKhau, phi_ung_ho.ten_khoan_thu, phi_ung_ho.so_tien;";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setInt(1, householdId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PayDonationModel model = new PayDonationModel();
				model.setMaHoKhau(rs.getString("maHoKhau"));
				model.setTenKhoanThu(rs.getString("ten_khoan_thu"));
				model.setSo_tien(rs.getInt("so_tien"));
				model.setSoThanhVienCuaHo(rs.getInt("SoThanhVienTrongHo"));
				model.setTongTienDaNop(rs.getInt("TongTienDaNop"));
				list.add(model);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			exceptionHandle(e.getMessage());
		}
		return list;
	}

    public boolean checkDuplicate(DonationsModel value) {
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT * FROM phi_ung_ho" + "WHERE ten_khoan_thu = N'" + value.getTen_khoan_thu() + "'" + "LIMIT 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException | ClassNotFoundException error) {
            error.printStackTrace();
            return false;
        }
        return true;
    }
	
	public Integer getPaid(HoKhauBean householdBean, DonationsModel donationModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			HoKhauModel household = householdBean.getHoKhauModel();
			String maHoKhau = household.getMaHoKhau();
			int idKhoanThu = donationModel.getID();
			String paid = "SELECT SUM(so_tien) AS tong_tien FROM ung_ho"
					+ " JOIN nhan_khau ON nhan_khau.ID = ung_ho.idNhanKhau"
					+ " JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idNhanKhau = nhan_khau.ID"
					+ " JOIN ho_khau ON ho_khau.ID = thanh_vien_cua_ho.idHoKhau" + " WHERE ho_khau.maHoKhau = '"
					+ maHoKhau + "' AND ung_ho.idKhoanThu = " + idKhoanThu + ";";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(paid);
				rs.next();
				int tong_tien = rs.getInt("tong_tien");
				connection.close();
				return tong_tien;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return -1;
	}

	public Integer getPaidDonation(DonationsModel donationModel) {
		Connection connection;
		try {
			connection = SQLConnection.getDbConnection();
			int idKhoanThu = donationModel.getID();
			String paid = "SELECT SUM(so_tien) AS tong_tien FROM ung_ho" + " WHERE ung_ho.idKhoanThu = " + idKhoanThu
					+ ";";
			try {
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(paid);
				rs.next();
				int tong_tien = rs.getInt("tong_tien");
				connection.close();
				return tong_tien;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return -1;
	}

	public List<DonateModel> donateByHouseholdId(int householdId) {
		List<DonateModel> list = new ArrayList<DonateModel>();
		try {
			Connection connection = SQLConnection.getDbConnection();
			String query = 
					"SELECT nhan_khau.hoTen, quanHeVoiChuHo, phi_ung_ho.ten_khoan_thu, ung_ho.so_tien, ung_ho.ngay_nop, phi_ung_ho.ngay_tao FROM ho_khau\r\n"
					+ "JOIN thanh_vien_cua_ho ON thanh_vien_cua_ho.idHoKhau = ho_khau.ID\r\n"
					+ "JOIN nhan_khau ON nhan_khau.ID = thanh_vien_cua_ho.idNhanKhau\r\n"
					+ "JOIN ung_ho ON ung_ho.idNhanKhau = nhan_khau.ID\r\n"
					+ "JOIN phi_ung_ho ON phi_ung_ho.id = ung_ho.idKhoanThu\r\n"
					+ "WHERE ho_khau.ID = ?\r\n"
					+ "GROUP BY nhan_khau.hoTen, quanHeVoiChuHo, phi_ung_ho.ten_khoan_thu, ung_ho.so_tien, ung_ho.ngay_nop, phi_ung_ho.ngay_tao;";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setInt(1, householdId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				DonateModel model = new DonateModel();
				model.setHoTen(rs.getString("hoTen"));
				model.setQuanHeVoiChuHo(rs.getString("quanHeVoiChuHo"));
				model.setTen_khoan_thu(rs.getString("ten_khoan_thu"));
				model.setSo_tien(rs.getInt("so_tien"));
				model.setNgay_nop(rs.getDate("ngay_nop"));
				model.setNgay_Tao(rs.getDate("ngay_tao"));
				list.add(model);
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			exceptionHandle(e.getMessage());
		}
		return list;
	}
	public boolean payDonation(PayDonationModel payDonationModel, int idDonation) {
        Connection connection;
        try {
            connection = SQLConnection.getDbConnection();
            String query = "INSERT INTO ung_ho(idNhanKhau, idKhoanThu, ngay_nop, so_tien)" + " values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, payDonationModel.getIdNhanKhau());
            preparedStatement.setInt(2, idDonation);
            preparedStatement.setDate(3, new Date(app.Main.calendar.getTime().getTime()));
            preparedStatement.setInt(4, payDonationModel.getSo_tien());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return true;
            }
            connection.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
	
	private void exceptionHandle(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
	}

}
