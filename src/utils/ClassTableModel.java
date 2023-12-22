package utils;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import beans.HoKhauBean;
import models.DonationsModel;
import models.FeesModel;
import models.GiaDinhModel;
import models.NhanKhauModel;
import models.TieuSuModel;
import services.DonationsService;
import services.FeesService;

public class ClassTableModel {

	private DefaultTableModel getSampleTableModel(String[] columns) {
		int len_cols = columns.length;
		DefaultTableModel dtm = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnIndex == len_cols ? Boolean.class : String.class;
			}
		};
		dtm.setColumnIdentifiers(columns);
		return dtm;
	}

	public DefaultTableModel setTableNhanKhau(List<NhanKhauModel> people, String[] columns) {
		int len_cols = columns.length;
		DefaultTableModel dtm = getSampleTableModel(columns);
		
		Object[] obj;
		obj = new Object[len_cols];
		people.forEach((NhanKhauModel person) -> {
			obj[0] = person.getID();
			obj[1] = person.getHoTen();
			obj[2] = person.getNamSinh();
			obj[3] = person.getGioiTinh();
			obj[4] = person.getDiaChiHienNay();
			dtm.addRow(obj);
		});
		return dtm;
	}

	public DefaultTableModel setTableTieuSu(List<TieuSuModel> profiles, String[] columns) {
		int column = columns.length;
		DefaultTableModel dtm = getSampleTableModel(columns);
		
		Object[] obj;
		obj = new Object[column];

		profiles.forEach((TieuSuModel profile) -> {
			obj[0] = profile.getTuNgay().toString();
			obj[1] = profile.getDenNgay().toString();
			obj[2] = profile.getDiaChi();
			obj[3] = profile.getNgheNghiep();
			obj[4] = profile.getNoiLamViec();
			dtm.addRow(obj);
		});

		dtm.addRow(new Object[] { "", "", "", "", "" });
		return dtm;
	}

	public DefaultTableModel setTableGiaDinh(List<GiaDinhModel> families, String[] columns) {
		int len_cols = columns.length;
		DefaultTableModel dtm = getSampleTableModel(columns);
		
		Object[] obj;
		obj = new Object[len_cols];

		families.forEach((GiaDinhModel family) -> {
			obj[0] = family.getHoTen();
			obj[1] = family.getNamSinh().toString();
			obj[2] = family.getGioiTinh();
			obj[3] = family.getQuanHeVoiNhanKhau();
			obj[4] = family.getNgheNghiep();
			obj[5] = family.getDiaChiHienTai();
			dtm.addRow(obj);
		});

		dtm.addRow(new Object[] { "", "", "", "", "", "" });
		return dtm;
	}

	public DefaultTableModel setTableHoKhau(List<HoKhauBean> householdBeans, String[] columns) {
		int len_cols = columns.length;
		DefaultTableModel dtm = getSampleTableModel(columns);
		
		Object[] obj;
		obj = new Object[len_cols];
		householdBeans.forEach((HoKhauBean householdBean) -> {
			obj[0] = householdBean.getHoKhauModel().getID();
			obj[1] = householdBean.getHoKhauModel().getMaHoKhau();
			obj[2] = householdBean.getChuHo().getHoTen();
			obj[3] = householdBean.getHoKhauModel().getDiaChi();
			obj[4] = householdBean.getHoKhauModel().getNgayLap();
			dtm.addRow(obj);
		});
		return dtm;
	}

	public DefaultTableModel setTableFees(List<FeesModel> fees, String[] columns) {
		int len_cols = columns.length;
		DefaultTableModel dtm = getSampleTableModel(columns);
		Object[] obj;
		obj = new Object[len_cols];
		FeesService feesService = new FeesService();
		fees.forEach((FeesModel fee) -> {
			obj[0] = fee.getID();
			obj[1] = fee.getTen_khoan_thu();
			obj[2] = fee.getSo_tien();
			obj[3] = fee.getDot_thu();
			obj[4] = feesService.getPaidFee(fee);
			dtm.addRow(obj);
		});
		return dtm;
	}
	
	public DefaultTableModel setTableDonations(List<DonationsModel> donations, String[] columns) {
		int len_cols = columns.length;
		DefaultTableModel dtm = getSampleTableModel(columns);
		Object[] obj;
		obj = new Object[len_cols];
		DonationsService donationsService = new DonationsService();
		donations.forEach((DonationsModel donation) -> {
			obj[0] = donation.getID();
			obj[1] = donation.getTen_khoan_thu();
			obj[2] = donation.getNgay_tao();
			obj[3] = donationsService.getPaidDonation(donation);
			dtm.addRow(obj);
		});
		return dtm;
	}


	public DefaultTableModel setHouseholdFeeTable(List<HoKhauBean> households, List<Integer> paids, List<Integer> needs, List<Boolean> paidStates, String[] columns) {
		int len_cols = columns.length;
		int len_rows = households.size();
		DefaultTableModel dtm = getSampleTableModel(columns);

		Object[] obj = new Object[len_cols];
		for (int i = 0; i < len_rows; ++i) {
			obj[0] = households.get(i).getHoKhauModel().getMaHoKhau();
			obj[1] = households.get(i).getChuHo().getHoTen();
			obj[2] = households.get(i).getHoKhauModel().getDiaChi();
			obj[3] = paids.get(i);
			obj[4] = needs.get(i);
			if (paidStates.get(i).equals(Boolean.TRUE)) {
				obj[5] = "Đã nộp đủ";
			} else {
				obj[5] = "-";
			}
			dtm.addRow(obj);
		}
		return dtm;
	}
	
	public DefaultTableModel setHouseholdDonationTable(List<HoKhauBean> households, List<Integer> paids, String[] columns) {
		int len_cols = columns.length;
		int len_rows = households.size();
		DefaultTableModel dtm = getSampleTableModel(columns);

		Object[] obj = new Object[len_cols];
		for (int i = 0; i < len_rows; ++i) {
			obj[0] = households.get(i).getHoKhauModel().getMaHoKhau();
			obj[1] = households.get(i).getChuHo().getHoTen();
			obj[2] = households.get(i).getHoKhauModel().getDiaChi();
			obj[3] = paids.get(i);
			dtm.addRow(obj);
		}
		return dtm;
	}

}
