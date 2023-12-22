package models;

import java.sql.Date;

public class DonationsModel {

	private int ID;
	private String ten_khoan_thu;
	private Date ngay_tao;
	private int idNguoiTao;

	public DonationsModel() {
	}

	public DonationsModel(int iD, String ten_khoan_thu, Date ngay_tao, int idNguoiTao) {
		super();
		ID = iD;
		this.ten_khoan_thu = ten_khoan_thu;
		this.ngay_tao = ngay_tao;
		this.idNguoiTao = idNguoiTao;
	}

	public int getID() {
		return ID;
	}

	public String getTen_khoan_thu() {
		return ten_khoan_thu;
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

	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}

	public void setIdNguoiTao(int idNguoiTao) {
		this.idNguoiTao = idNguoiTao;
	}



}
