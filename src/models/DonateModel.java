package models;

import java.sql.Date;

public class DonateModel {

	private String hoTen;
	private String quanHeVoiChuHo;
	private String ten_khoan_thu;
	private int so_tien;
	private Date ngay_nop;
	private Date ngay_Tao;
	
	public DonateModel() {
	}
	
	public DonateModel(String hoTen, String quanHeVoiChuHo, String ten_khoan_thu, int so_tien, Date ngay_nop,
			Date ngay_Tao) {
		super();
		this.hoTen = hoTen;
		this.quanHeVoiChuHo = quanHeVoiChuHo;
		this.ten_khoan_thu = ten_khoan_thu;
		this.so_tien = so_tien;
		this.ngay_nop = ngay_nop;
		this.ngay_Tao = ngay_Tao;
	}




	public String getHoTen() {
		return hoTen;
	}
	public String getQuanHeVoiChuHo() {
		return quanHeVoiChuHo;
	}
	public String getTen_khoan_thu() {
		return ten_khoan_thu;
	}
	public int getSo_tien() {
		return so_tien;
	}
	public Date getNgay_nop() {
		return ngay_nop;
	}
	public Date getNgay_Tao() {
		return ngay_Tao;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
		this.quanHeVoiChuHo = quanHeVoiChuHo;
	}
	public void setTen_khoan_thu(String ten_khoan_thu) {
		this.ten_khoan_thu = ten_khoan_thu;
	}
	public void setSo_tien(int so_tien) {
		this.so_tien = so_tien;
	}
	public void setNgay_nop(Date ngay_nop) {
		this.ngay_nop = ngay_nop;
	}
	public void setNgay_Tao(Date ngay_Tao) {
		this.ngay_Tao = ngay_Tao;
	}
	
}
