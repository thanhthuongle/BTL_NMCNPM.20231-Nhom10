package models;

import java.sql.Date;

public class PayFeeModel {

	private int idNhanKhau;
	private int idPhiThu;
	private Date ngay_nop;
	private int so_tien;

	private String maHoKhau;
	private String tenKhoanThu;
	private String dot_thu;
	private int soThanhVienCuaHo;
	private int tongTienDaNop;
	private int tongTienCanNop;

	public PayFeeModel() {

	}

	public PayFeeModel(int idNhanKhau, int idPhiThu, Date ngay_nop, int so_tien) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.idPhiThu = idPhiThu;
		this.ngay_nop = ngay_nop;
		this.so_tien = so_tien;
	}

	public PayFeeModel(int idNhanKhau, int idPhiThu, Date ngay_nop, int so_tien, String maHoKhau, String tenKhoanThu,
			String dot_thu, int soThanhVienCuaHo, int tongTienDaNop, int tongTienCanNop) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.idPhiThu = idPhiThu;
		this.ngay_nop = ngay_nop;
		this.so_tien = so_tien;
		this.maHoKhau = maHoKhau;
		this.tenKhoanThu = tenKhoanThu;
		this.dot_thu = dot_thu;
		this.soThanhVienCuaHo = soThanhVienCuaHo;
		this.tongTienDaNop = tongTienDaNop;
		this.tongTienCanNop = tongTienCanNop;
	}

	public String getMaHoKhau() {
		return maHoKhau;
	}

	public String getTenKhoanThu() {
		return tenKhoanThu;
	}

	public String getDot_thu() {
		return dot_thu;
	}

	public int getSoThanhVienCuaHo() {
		return soThanhVienCuaHo;
	}

	public int getTongTienDaNop() {
		return tongTienDaNop;
	}

	public int getTongTienCanNop() {
		return tongTienCanNop;
	}

	public void setMaHoKhau(String maHoKhau) {
		this.maHoKhau = maHoKhau;
	}

	public void setTenKhoanThu(String tenKhoanThu) {
		this.tenKhoanThu = tenKhoanThu;
	}

	public void setDot_thu(String dot_thu) {
		this.dot_thu = dot_thu;
	}

	public void setSoThanhVienCuaHo(int soThanhVienCuaHo) {
		this.soThanhVienCuaHo = soThanhVienCuaHo;
	}

	public void setTongTienDaNop(int tongTienDaNop) {
		this.tongTienDaNop = tongTienDaNop;
	}

	public void setTongTienCanNop(int tongTienCanNop) {
		this.tongTienCanNop = tongTienCanNop;
	}

	public int getIdNhanKhau() {
		return idNhanKhau;
	}

	public int getIdPhiThu() {
		return idPhiThu;
	}

	public Date getNgay_nop() {
		return ngay_nop;
	}

	public int getSo_tien() {
		return so_tien;
	}

	public void setIdNhanKhau(int idNhanKhau) {
		this.idNhanKhau = idNhanKhau;
	}

	public void setIdPhiThu(int idPhiThu) {
		this.idPhiThu = idPhiThu;
	}

	public void setNgay_nop(Date ngay_nop) {
		this.ngay_nop = ngay_nop;
	}

	public void setSo_tien(int so_tien) {
		this.so_tien = so_tien;
	}

}
