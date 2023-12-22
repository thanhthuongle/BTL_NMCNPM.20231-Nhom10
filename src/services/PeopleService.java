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

import beans.NhanKhauBean;
import models.ChungMinhThuModel;
import models.GiaDinhModel;
import models.NhanKhauModel;
import models.TieuSuModel;

public class PeopleService {
	
	 public boolean newPeople(NhanKhauBean nhanKhauBean) throws SQLException, ClassNotFoundException{
	        NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
	        ChungMinhThuModel chungMinhThu = nhanKhauBean.getChungMinhThuModel();
	        Connection connection = SQLConnection.getDbConnection();

	        String query = "INSERT INTO nhan_khau (hoTen, bietDanh, namSinh, gioiTinh, noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, TrinhDoChuyenMon, bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, idNguoiTao, ngayTao)" 
	                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, nhanKhau.getHoTen());
	        preparedStatement.setString(2, nhanKhau.getBietDanh());
	        java.sql.Date namSinh = new java.sql.Date(nhanKhau.getNamSinh().getTime());
	        preparedStatement.setDate(3, namSinh);
	        preparedStatement.setString(4, nhanKhau.getGioiTinh());
	        preparedStatement.setString(5, nhanKhau.getNoiSinh());
	        preparedStatement.setString(6, nhanKhau.getNguyenQuan());
	        preparedStatement.setString(7, nhanKhau.getDanToc());
	        preparedStatement.setString(8, nhanKhau.getTonGiao());
	        preparedStatement.setString(9, nhanKhau.getQuocTich());
	        preparedStatement.setString(10, nhanKhau.getSoHoChieu());
	        preparedStatement.setString(11, nhanKhau.getNoiThuongTru());
	        preparedStatement.setString(12, nhanKhau.getDiaChiHienNay());
	        preparedStatement.setString(13, nhanKhau.getTrinhDoHocVan());
	        preparedStatement.setString(14, nhanKhau.getTrinhDoChuyenMon());
	        preparedStatement.setString(15, nhanKhau.getBietTiengDanToc());
	        preparedStatement.setString(16, nhanKhau.getTrinhDoNgoaiNgu());
	        preparedStatement.setString(17, nhanKhau.getNgheNghiep());
	        preparedStatement.setString(18, nhanKhau.getNoiLamViec());
	        preparedStatement.setInt(19, nhanKhau.getIdNguoiTao());
	        java.sql.Date createDate = new java.sql.Date(app.Main.calendar.getTime().getTime());
	        preparedStatement.setDate(20, createDate);
	        
	        preparedStatement.executeUpdate();
	        ResultSet rs = preparedStatement.getGeneratedKeys();
	        if (rs.next()) {
	            int genID = rs.getInt(1);
	            String sql = "INSERT INTO chung_minh_thu(idNhanKhau, soCMT)" 
	                        + " values (?, ?)";
	            PreparedStatement prst = connection.prepareStatement(sql);
	            prst.setInt(1, genID);
	            prst.setString(2, chungMinhThu.getSoCMT());
	            prst.execute();
	            nhanKhauBean.getListTieuSuModels().forEach(tieuSu -> {
	                try {
	                    String sql_tieu_su = "INSERT INTO tieu_su(idNhanKhau, tuNgay, denNgay, diaChi, ngheNghiep, noiLamViec)" 
	                        + " values (?, ?, ?, ?, ?, ?)";
	                    PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
	                    preStatement.setInt(1, genID);
	                    Date tuNgay = new Date(tieuSu.getTuNgay().getTime());
	                    preStatement.setDate(2, tuNgay);
	                    preStatement.setDate(3, new Date(tieuSu.getDenNgay().getTime()));
	                    preStatement.setString(4, tieuSu.getDiaChi());
	                    preStatement.setString(5, tieuSu.getNgheNghiep());
	                    preStatement.setString(6, tieuSu.getNoiLamViec());
	                    preStatement.execute();
	                    preStatement.close();
	                } catch (Exception e) {
	                    System.out.println(e);
	                }
	            });
	            nhanKhauBean.getListGiaDinhModels().forEach(giaDinh -> {
	                try {
	                    String sql_tieu_su = "INSERT INTO gia_dinh(idNhanKhau, hoTen, namSinh, gioiTinh, quanHeVoiNhanKhau, ngheNghiep, diaChiHienTai)" 
	                        + " values (?, ?, ?, ?, ?, ?, ?)";
	                    PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
	                    preStatement.setInt(1, genID);
	                    preStatement.setString(2, giaDinh.getHoTen());
	                    preStatement.setDate(3, new Date(giaDinh.getNamSinh().getTime()));
	                    preStatement.setString(4, giaDinh.getGioiTinh());
	                    preStatement.setString(5, giaDinh.getQuanHeVoiNhanKhau());
	                    preStatement.setString(6, giaDinh.getNgheNghiep());
	                    preStatement.setString(7, giaDinh.getDiaChiHienTai());
	                    preStatement.execute();
	                    preStatement.close();
	                } catch (Exception e) {
	                    System.out.println("controllers.NhanKhauManagerController.AddNewController.addNewPeople()");
	                }
	            });
	        }
	        connection.close();
	        return true;
	    }
	 public boolean editPeople(NhanKhauBean nhanKhauBean, int idNhanKhau) throws SQLException, ClassNotFoundException{
	        NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
	        ChungMinhThuModel chungMinhThu = nhanKhauBean.getChungMinhThuModel();
	        Connection connection = SQLConnection.getDbConnection();

	        String query = "UPDATE nhan_khau "
	        + " SET" 
	        + " hoTen = ?,"
	        + " bietDanh = ?,"
	        + " namSinh = ?,"
	        + " gioiTinh = ?,"
	        + " noiSinh = ?,"
	        + " nguyenQuan = ?,"
	        + " danToc = ?,"
	        + " tonGiao = ?,"
	        + " quocTich = ?,"
	        + " soHoChieu = ?,"
	        + " noiThuongTru = ?,"
	        + " diaChiHienNay = ?,"
	        + " trinhDoHocVan = ?,"
	        + " TrinhDoChuyenMon = ?,"
	        + " bietTiengDanToc = ?,"
	        + " trinhDoNgoaiNgu = ?,"
	        + " ngheNghiep = ?,"
	        + " noiLamViec = ?,"
	        + " idNguoiTao = ?,"
	        + " ngayTao = ?"
	        + " WHERE ID = ?;";
	        
	        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        preparedStatement.setString(1, nhanKhau.getHoTen());
	        preparedStatement.setString(2, nhanKhau.getBietDanh());
	        java.sql.Date namSinh = new java.sql.Date(nhanKhau.getNamSinh().getTime());
	        preparedStatement.setDate(3, namSinh);
	        preparedStatement.setString(4, nhanKhau.getGioiTinh());
	        preparedStatement.setString(5, nhanKhau.getNoiSinh());
	        preparedStatement.setString(6, nhanKhau.getNguyenQuan());
	        preparedStatement.setString(7, nhanKhau.getDanToc());
	        preparedStatement.setString(8, nhanKhau.getTonGiao());
	        preparedStatement.setString(9, nhanKhau.getQuocTich());
	        preparedStatement.setString(10, nhanKhau.getSoHoChieu());
	        preparedStatement.setString(11, nhanKhau.getNoiThuongTru());
	        preparedStatement.setString(12, nhanKhau.getDiaChiHienNay());
	        preparedStatement.setString(13, nhanKhau.getTrinhDoHocVan());
	        preparedStatement.setString(14, nhanKhau.getTrinhDoChuyenMon());
	        preparedStatement.setString(15, nhanKhau.getBietTiengDanToc());
	        preparedStatement.setString(16, nhanKhau.getTrinhDoNgoaiNgu());
	        preparedStatement.setString(17, nhanKhau.getNgheNghiep());
	        preparedStatement.setString(18, nhanKhau.getNoiLamViec());
	        preparedStatement.setInt(19, nhanKhau.getIdNguoiTao());
	        java.sql.Date createDate = new java.sql.Date(app.Main.calendar.getTime().getTime());
	        preparedStatement.setDate(20, createDate);
	        preparedStatement.setInt(21, idNhanKhau);
	        
	        preparedStatement.executeUpdate();
	        ResultSet rs = preparedStatement.getGeneratedKeys();
	        if (rs.next()) {
	           // int genID = rs.getInt(1);
	            String sql = "UPDATE chung_minh_thu "
		        + " SET" 
		        + " soCMT = ?"
		        + " WHERE idNhanKhau = ?;";
		        
	            PreparedStatement prst = connection.prepareStatement(sql);
	            prst.setString(1, chungMinhThu.getSoCMT());
	            prst.setInt(2, idNhanKhau);
	            prst.execute();
	            nhanKhauBean.getListTieuSuModels().forEach(tieuSu -> {
	                try {                    
	        	        String sql_tieu_su = "UPDATE tieu_su "
	        	    	        + " SET" 
	        	    	        + " tuNgay = ?,"
	        	    	        + " denNgay = ?,"
	        	    	        + " diaChi = ?,"
	        	    	        + " ngheNghiep = ?,"
	        	    	        + " noiLamViec = ?"
	        	    	        + " WHERE ID = ?;";
	                    PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
	                    Date tuNgay = new Date(tieuSu.getTuNgay().getTime());
	                    preStatement.setDate(1, tuNgay);
	                    preStatement.setDate(2, new Date(tieuSu.getDenNgay().getTime()));
	                    preStatement.setString(3, tieuSu.getDiaChi());
	                    preStatement.setString(4, tieuSu.getNgheNghiep());
	                    preStatement.setString(5, tieuSu.getNoiLamViec());
	                    preStatement.setInt(6, idNhanKhau);
	                    preStatement.execute();
	                    preStatement.close();
	                } catch (Exception e) {
	                    System.out.println(e);
	                }
	            });
	            nhanKhauBean.getListGiaDinhModels().forEach(giaDinh -> {
	                try {
	                	
	                	String sql_tieu_su = "UPDATE gia_dinh "
	        	    	        + " SET" 
	        	    	        + " hoTen = ?,"
	        	    	        + " namSinh = ?,"
	        	    	        + " gioiTinh = ?,"
	        	    	        + " quanHeVoiNhanKhau = ?,"
	        	    	        + " ngheNghiep = ?,"
	        	    	        + " diaChiHienTai = ?"
	        	    	        + " WHERE ID = ?;";
	                    
	                    PreparedStatement preStatement = connection.prepareStatement(sql_tieu_su);
	                    preStatement.setString(1, giaDinh.getHoTen());
	                    preStatement.setDate(2, new Date(giaDinh.getNamSinh().getTime()));
	                    preStatement.setString(3, giaDinh.getGioiTinh());
	                    preStatement.setString(4, giaDinh.getQuanHeVoiNhanKhau());
	                    preStatement.setString(5, giaDinh.getNgheNghiep());
	                    preStatement.setString(6, giaDinh.getDiaChiHienTai());
	                    preStatement.setInt(7, idNhanKhau);
	                    preStatement.execute();
	                    preStatement.close();
	                } catch (Exception e) {
	                    System.out.println("controllers.NhanKhauManagerController.EditController.editPeople()");
	                }
	            });
	        }
	        connection.close();
	        return true;
	    }

    
    public NhanKhauBean getNhanKhau(String cmt) {
        NhanKhauBean nhanKhauBean = new NhanKhauBean();  
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT * FROM nhan_khau JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau WHERE soCMT = '" + cmt + "'";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int idNhanKhau = -1;
            while (rs.next()){
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                idNhanKhau = rs.getInt("idNhanKhau");
                nhanKhau.setID(idNhanKhau);
                nhanKhau.setBietDanh(rs.getString("bietDanh"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhanKhau.setTonGiao(rs.getString("tonGiao"));
                nhanKhau.setDanToc(rs.getString("danToc"));
                nhanKhau.setQuocTich(rs.getString("quocTich"));
                nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
                nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                // con nhieu nua
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
            }
            preparedStatement.close();
            if (idNhanKhau > 0) {
                query = "SELECT * FROM tieu_su WHERE idNhanKhau = " + idNhanKhau;
                preparedStatement = (PreparedStatement)connection.prepareStatement(query);
                rs = preparedStatement.executeQuery();
                List<TieuSuModel> listTieuSuModels = new ArrayList<TieuSuModel>();
                while (rs.next()) {                    
                    TieuSuModel tieuSuModel = new TieuSuModel();
                    tieuSuModel.setID(rs.getInt("ID"));
                    tieuSuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                    tieuSuModel.setTuNgay(rs.getDate("tuNgay"));
                    tieuSuModel.setDenNgay(rs.getDate("denNgay"));
                    tieuSuModel.setDiaChi(rs.getString("diaChi"));
                    tieuSuModel.setNgheNghiep(rs.getString("ngheNghiep"));
                    tieuSuModel.setNoiLamViec(rs.getString("noiLamViec"));
                    listTieuSuModels.add(tieuSuModel);
                }
                nhanKhauBean.setListTieuSuModels(listTieuSuModels);
                preparedStatement.close();
                
                query = "SELECT * FROM gia_dinh WHERE idNhanKhau = " + idNhanKhau;
                preparedStatement = (PreparedStatement)connection.prepareStatement(query);
                rs = preparedStatement.executeQuery();
                List<GiaDinhModel> listGiaDinhModels = new ArrayList<GiaDinhModel>();
                while (rs.next()) {
                    GiaDinhModel giaDinhModel = new GiaDinhModel();
                    giaDinhModel.setID(rs.getInt("ID"));
                    giaDinhModel.setHoTen(rs.getString("hoTen"));
                    giaDinhModel.setNamSinh(rs.getDate("namSinh"));
                    giaDinhModel.setGioiTinh(rs.getString("gioiTinh"));
                    giaDinhModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                    giaDinhModel.setDiaChiHienTai(rs.getString("diaChiHienTai"));
                    giaDinhModel.setNgheNghiep(rs.getString("ngheNghiep"));
                    giaDinhModel.setQuanHeVoiNhanKhau(rs.getString("quanHeVoiNhanKhau"));
                    listGiaDinhModels.add(giaDinhModel);
                }                    
                nhanKhauBean.setListGiaDinhModels(listGiaDinhModels);
                preparedStatement.close();
            }
            connection.close();
        } catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return nhanKhauBean;
    }
    
    public List<NhanKhauBean> getListNhanKhau() {
        List<NhanKhauBean> list = new ArrayList<NhanKhauBean>();
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT TOP 100 * FROM nhan_khau JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau ORDER BY nhan_khau.ID";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public List<NhanKhauBean> statisticNhanKhau(int TuTuoi, int denTuoi, String gender, String Status, int tuNam, int denNam) {
        List<NhanKhauBean> list = new ArrayList<NhanKhauBean>();
        
        String query = "SELECT * FROM nhan_khau "
                    + " JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau"
                    + " LEFT JOIN tam_tru ON nhan_khau.ID = tam_tru.idNhanKhau "
                    + " LEFT JOIN tam_vang ON nhan_khau.ID = tam_vang.idNhanKhau "
                    + " WHERE ROUND(DATEDIFF(dayofyear, namSinh, GETDATE())/365 , 0) >= "
                    + TuTuoi
                    + " AND ROUND(DATEDIFF(dayofyear, namSinh, GETDATE())/365 , 0) <= "
                    + denTuoi;
        if (!gender.equalsIgnoreCase("Toàn bộ")) {
            query += " AND nhan_khau.gioiTinh = N'" + gender + "'";
        }
        if (Status.equalsIgnoreCase("Toàn bộ")) {
            query += " AND (tam_tru.denNgay >= GETDATE() OR tam_tru.denNgay IS NULL)"
                    + " AND (tam_vang.denNgay <= GETDATE() OR tam_vang.denNgay IS NULL)";
        } else if (Status.equalsIgnoreCase("Thuong tru")) {
            query += " AND tam_tru.denNgay IS NULL";
            
        } else if (Status.equalsIgnoreCase("Tam tru")) {
            query += " AND (YEAR(tam_tru.tuNgay) BETWEEN "
                    + tuNam
                    + " AND "
                    + denNam
                    + ")";
        } else if (Status.equalsIgnoreCase("Tam vang")) {
            query += " AND (YEAR(tam_vang.tuNgay) BETWEEN "
                    + tuNam
                    + " AND "
                    + denNam
                    + ")";
        }
        query += " ORDER BY ngayTao DESC";
         try {
            Connection connection = SQLConnection.getDbConnection();
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            int idNhanKhau = -1;
            while (rs.next()){
                NhanKhauBean  nhanKhauBean = new NhanKhauBean();
                NhanKhauModel nhanKhau = nhanKhauBean.getNhanKhauModel();
                ChungMinhThuModel chungMinhThuModel = nhanKhauBean.getChungMinhThuModel();
                idNhanKhau = rs.getInt("idNhanKhau");
                nhanKhau.setID(idNhanKhau);
                nhanKhau.setBietDanh(rs.getString("bietDanh"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setNguyenQuan(rs.getString("nguyenQuan"));
                nhanKhau.setTonGiao(rs.getString("tonGiao"));
                nhanKhau.setDanToc(rs.getString("danToc"));
                nhanKhau.setQuocTich(rs.getString("quocTich"));
                nhanKhau.setSoHoChieu(rs.getString("soHoChieu"));
                nhanKhau.setNoiThuongTru(rs.getString("noiThuongTru"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                // con nhieu nua
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                
                if (idNhanKhau > 0) {
                    String sql = "SELECT * FROM tieu_su WHERE idNhanKhau = " + idNhanKhau;
                    PreparedStatement prst = (PreparedStatement)connection.prepareStatement(sql);
                    ResultSet rs_temp = prst.executeQuery();
                    List<TieuSuModel> listTieuSuModels = new ArrayList<TieuSuModel>();
                    while (rs_temp.next()) {                    
                        TieuSuModel tieuSuModel = new TieuSuModel();
                        tieuSuModel.setID(rs_temp.getInt("ID"));
                        tieuSuModel.setIdNhanKhau(rs_temp.getInt("idNhanKhau"));
                        tieuSuModel.setTuNgay(rs_temp.getDate("tuNgay"));
                        tieuSuModel.setDenNgay(rs_temp.getDate("denNgay"));
                        tieuSuModel.setDiaChi(rs_temp.getString("diaChi"));
                        tieuSuModel.setNgheNghiep(rs_temp.getString("ngheNghiep"));
                        tieuSuModel.setNoiLamViec(rs_temp.getString("noiLamViec"));
                        listTieuSuModels.add(tieuSuModel);
                    }
                    nhanKhauBean.setListTieuSuModels(listTieuSuModels);
                    prst.close();

                    sql = "SELECT * FROM gia_dinh WHERE idNhanKhau = " + idNhanKhau;
                    prst = (PreparedStatement)connection.prepareStatement(sql);
                    rs_temp = prst.executeQuery();
                    List<GiaDinhModel> listGiaDinhModels = new ArrayList<GiaDinhModel>();
                    while (rs_temp.next()) {
                        GiaDinhModel giaDinhModel = new GiaDinhModel();
                        giaDinhModel.setID(rs_temp.getInt("ID"));
                        giaDinhModel.setHoTen(rs_temp.getString("hoTen"));
                        giaDinhModel.setNamSinh(rs_temp.getDate("namSinh"));
                        giaDinhModel.setGioiTinh(rs_temp.getString("gioiTinh"));
                        giaDinhModel.setIdNhanKhau(rs_temp.getInt("idNhanKhau"));
                        giaDinhModel.setDiaChiHienTai(rs_temp.getString("diaChiHienTai"));
                        giaDinhModel.setNgheNghiep(rs_temp.getString("ngheNghiep"));
                        giaDinhModel.setQuanHeVoiNhanKhau(rs_temp.getString("quanHeVoiNhanKhau"));
                        listGiaDinhModels.add(giaDinhModel);
                    }                    
                    nhanKhauBean.setListGiaDinhModels(listGiaDinhModels);
                    prst.close();
                }
                list.add(nhanKhauBean);
            }
            preparedStatement.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    /*
     * ham tim kiem nhan khau theo ten
     */
    public List<NhanKhauBean> search(String keyword) {
        List<NhanKhauBean> list = new  ArrayList<NhanKhauBean>();
        if (keyword.trim().isEmpty()) {
            return this.getListNhanKhau();
        }
        
        try {
            Connection connection = SQLConnection.getDbConnection();
            String query = "SELECT * FROM nhan_khau "
            	      + "JOIN chung_minh_thu ON nhan_khau.ID = chung_minh_thu.idNhanKhau "
            	      + "WHERE CONTAINS(hoTen,'\"*"
            	      + keyword
            	      + "*\"') OR CONTAINS(bietDanh, '\"*" 
            	      + keyword
            	      + "*\"');";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                NhanKhauBean temp = new NhanKhauBean();
                NhanKhauModel nhanKhau = temp.getNhanKhauModel();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("hoTen"));
                nhanKhau.setGioiTinh(rs.getString("gioiTinh"));
                nhanKhau.setNamSinh(rs.getDate("namSinh"));
                nhanKhau.setDiaChiHienNay(rs.getString("diaChiHienNay"));
                
                ChungMinhThuModel chungMinhThuModel = temp.getChungMinhThuModel();
                chungMinhThuModel.setIdNhanKhau(rs.getInt("idNhanKhau"));
                chungMinhThuModel.setSoCMT(rs.getString("soCMT"));
                chungMinhThuModel.setNgayCap(rs.getDate("ngayCap"));
                chungMinhThuModel.setNoiCap(rs.getString("noiCap"));
                list.add(temp);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
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

   public List<String> searchByCid(String keyword) {
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
