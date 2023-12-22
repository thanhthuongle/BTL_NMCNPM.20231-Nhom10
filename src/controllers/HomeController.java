package controllers;

import javax.swing.JLabel;

import services.HomePageService;


public class HomeController {
    private JLabel tongNhanKhauLb;
    private JLabel tongHoKhauLb;
    private JLabel nhanKhauTamTruLb;
    private JLabel nhanKhauTamVangLb;
    private JLabel noPaidFees;
    
    private HomePageService homeService = new HomePageService(this);

    public HomeController(JLabel tongNhanKhauLb, JLabel tongHoKhau, JLabel nhanKhauTamTruLb, JLabel nhanKhauTamVangLb, JLabel noPaidFees) {
        this.tongNhanKhauLb = tongNhanKhauLb;
        this.tongHoKhauLb = tongHoKhau;
        this.nhanKhauTamTruLb = nhanKhauTamTruLb;
        this.nhanKhauTamVangLb = nhanKhauTamVangLb;
        this.noPaidFees = noPaidFees;
    }
    
    public void setData() {
    	this.tongNhanKhauLb.setText(String.valueOf(this.homeService.getTongNhanKhau()));
    	this.tongHoKhauLb.setText(String.valueOf(this.homeService.getTongHoKhau()));
    	this.nhanKhauTamTruLb.setText(String.valueOf(this.homeService.getTongTamTru()));
    	this.nhanKhauTamVangLb.setText(String.valueOf(this.homeService.getTongTamVang()));
    	this.noPaidFees.setText(String.valueOf(this.homeService.getTongHoKhauConThieu()));
    	
    }

    public JLabel getTongNhanKhauLb() {
        return tongNhanKhauLb;
    }

    public void setTongNhanKhauLb(JLabel tongNhanKhauLb) {
        this.tongNhanKhauLb = tongNhanKhauLb;
    }

    public JLabel getTongHoKhauLb() {
        return tongHoKhauLb;
    }

    public void setTongHoKhau(JLabel tongHoKhauLb) {
        this.tongHoKhauLb = tongHoKhauLb;
    }

    public JLabel getNhanKhauTamTruLb() {
        return nhanKhauTamTruLb;
    }

    public void setNhanKhauTamTruLb(JLabel nhanKhauTamTruLb) {
        this.nhanKhauTamTruLb = nhanKhauTamTruLb;
    }

    public JLabel getNhanKhauTamVangLb() {
        return nhanKhauTamVangLb;
    }

    public void setNhanKhauTamVangLb(JLabel nhanKhauTamVangLb) {
        this.nhanKhauTamVangLb = nhanKhauTamVangLb;
    }
    
    public JLabel getNoPaidFees() {
		return noPaidFees;
	}
    
    public void setNoPaidFees(JLabel noPaidFees) {
		this.noPaidFees = noPaidFees;
	}
    
    
    
}
