package models;

import java.sql.Date;

public class PayDonationModel {

	private int idNhanKhau;
	private int idPhiThu;
	private Date ngay_nop;
	private int so_tien;
	private String maHoKhau;
	private String tenKhoanThu;
	private int soThanhVienCuaHo;
	private int tongTienDaNop;

	public PayDonationModel() {

	}

	public PayDonationModel(int idNhanKhau, int idPhiThu, Date ngay_nop, int so_tien) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.idPhiThu = idPhiThu;
		this.ngay_nop = ngay_nop;
		this.so_tien = so_tien;
	}

	public PayDonationModel(int idNhanKhau, int idPhiThu, Date ngay_nop, int so_tien, String maHoKhau, String tenKhoanThu,
		 int soThanhVienCuaHo, int tongTienDaNop) {
		super();
		this.idNhanKhau = idNhanKhau;
		this.idPhiThu = idPhiThu;
		this.ngay_nop = ngay_nop;
		this.so_tien = so_tien;
		this.maHoKhau = maHoKhau;
		this.tenKhoanThu = tenKhoanThu;
		this.soThanhVienCuaHo = soThanhVienCuaHo;
		this.tongTienDaNop = tongTienDaNop;
	}

	public String getMaHoKhau() {
		return maHoKhau;
	}

	public String getTenKhoanThu() {
		return tenKhoanThu;
	}


	public int getSoThanhVienCuaHo() {
		return soThanhVienCuaHo;
	}

	public int getTongTienDaNop() {
		return tongTienDaNop;
	}
	public void setMaHoKhau(String maHoKhau) {
		this.maHoKhau = maHoKhau;
	}

	public void setTenKhoanThu(String tenKhoanThu) {
		this.tenKhoanThu = tenKhoanThu;
	}

	public void setSoThanhVienCuaHo(int soThanhVienCuaHo) {
		this.soThanhVienCuaHo = soThanhVienCuaHo;
	}

	public void setTongTienDaNop(int tongTienDaNop) {
		this.tongTienDaNop = tongTienDaNop;
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
