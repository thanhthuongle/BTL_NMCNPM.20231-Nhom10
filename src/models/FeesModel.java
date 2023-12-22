package models;

import java.sql.Date;

public class FeesModel {

	private int ID;
	private String ten_khoan_thu;
	private int so_tien;
	private String dot_thu;
	private Date ngay_tao;
	private int idNguoiTao;
	
	public FeesModel() {
	}
	
	public FeesModel(int iD, String ten_khoan_thu, int so_tien, String dot_thu, Date ngay_tao, int idNguoiTao) {
		super();
		ID = iD;
		this.ten_khoan_thu = ten_khoan_thu;
		this.so_tien = so_tien;
		this.dot_thu = dot_thu;
		this.idNguoiTao = idNguoiTao;
		this.ngay_tao = ngay_tao;
	}
	
	public int getID() {
		return ID;
	}
	public String getTen_khoan_thu() {
		return ten_khoan_thu;
	}
	public int getSo_tien() {
		return so_tien;
	}
	public String getDot_thu() {
		return dot_thu;
	}

	public String getMonthDotThu(){
		return dot_thu.split("-")[1];
	}

	public String getYearDotThu(){
		return dot_thu.split("-")[0];
	}
	
	public Date getNgay_tao() {
		return ngay_tao;
	}
	
	public int getIdNguoiTao() {
		return idNguoiTao;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setTen_khoan_thu(String ten_khoan_thu) {
		this.ten_khoan_thu = ten_khoan_thu;
	}
	public void setSo_tien(int so_tien) {
		this.so_tien = so_tien;
	}
	public void setDot_thu(String dot_thu) {
		this.dot_thu = dot_thu;
	}
	public void setNgay_Tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	public void setIdNguoiTao(int idNguoiTao) {
		this.idNguoiTao = idNguoiTao;
	}
	
	
}
