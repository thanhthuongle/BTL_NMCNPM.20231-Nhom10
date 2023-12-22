package views.HouseholdManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import beans.HoKhauBean;
import controllers.HoKhauManagerController.ChuyenDiNoiKhacController;
import models.AddressModel;
import utils.SuggestionUtility;
import views.AddressSuggestion;

public class ChangeResidence extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private ChuyenDiNoiKhacController controller;
	private HoKhauBean hoKhauBean;
	private JFrame parentJFrame;

	private AddressSuggestion addrSuggestion;
	private AddressModel addrModel = new AddressModel();
	private JTextField JtxReceiveAddress;

	private javax.swing.JButton cancelBtn;
	private javax.swing.JButton confirmBtn;
	private javax.swing.JTextField diaChiHienTaiJtf;

	private SuggestionUtility diaChiChuyenDenJtf;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea lyDoJta;
	private javax.swing.JTextField maHoKhauJtf;
	private javax.swing.JTextField maKhuVucJtf;
	private javax.swing.JTextField searchJtf;
	private javax.swing.JPanel tableJpn;
	private javax.swing.JTextField tenChuHoJtf;

	public ChangeResidence(JFrame parentJFrame) {
		initComponents();

		this.hoKhauBean = new HoKhauBean();
		this.parentJFrame = parentJFrame;
		this.parentJFrame.setEnabled(false);

		controller = new ChuyenDiNoiKhacController(hoKhauBean, searchJtf, tableJpn);
		controller.setDataJtf(maHoKhauJtf, tenChuHoJtf, maKhuVucJtf, diaChiHienTaiJtf);

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				parentJFrame.setEnabled(true);
				close();
			}
		});
	}

	private void close() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			this.parentJFrame.setEnabled(true);
			dispose();
		}
	}

	private void initComponents() {
		this.setTitle("Chuyển nơi ở");
		setBounds(100, 100, 1180, 603);
		getContentPane().setLayout(null);

		jPanel2 = new javax.swing.JPanel();
		jPanel2.setLayout(null);
		jPanel2.setBounds(0, 0, 1170, 563);
		jPanel2.setBackground(new Color(240, 248, 255));
		getContentPane().add(jPanel2);

		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(20, 20, 151, 30);
		jLabel2.setBackground(new Color(255, 255, 255));
		jPanel2.add(jLabel2);
		jLabel2.setText("Nhập mã hộ khẩu");
		jLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
		jLabel2.setForeground(new Color(0, 0, 0));
		jLabel2.setBackground(Color.lightGray);

		searchJtf = new javax.swing.JTextField("Search");
		searchJtf.setBounds(20, 60, 490, 30);
		searchJtf.setForeground(Color.GRAY);
		searchJtf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchJtf.getText().trim().equals("Search")) {
					searchJtf.setForeground(Color.black);
					searchJtf.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (searchJtf.getText().isEmpty()) {
					searchJtf.setForeground(Color.GRAY);
					searchJtf.setText("Search");
				}
			}
		});
		searchJtf.setSelectionColor(new Color(204, 153, 255));
		searchJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchJtf.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new EmptyBorder(0, 10, 0, 0)));
		searchJtf.setColumns(10);
		jPanel2.add(searchJtf);

		tableJpn = new javax.swing.JPanel();
		tableJpn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableJpn.setBounds(20, 100, 490, 380);
		tableJpn.setBackground(new Color(255, 255, 255));
		tableJpn.setLayout(null);
		jPanel2.add(tableJpn);

		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(560, 60, 88, 30);

		maHoKhauJtf = new javax.swing.JTextField();
		maHoKhauJtf.setBounds(710, 60, 411, 30);

		jLabel6 = new javax.swing.JLabel();
		jLabel6.setBounds(1129, 60, 31, 30);

		jLabel9 = new javax.swing.JLabel();
		jLabel9.setBounds(560, 100, 88, 30);

		tenChuHoJtf = new javax.swing.JTextField();
		tenChuHoJtf.setBounds(710, 100, 411, 30);

		jLabel10 = new javax.swing.JLabel();
		jLabel10.setBounds(1129, 100, 31, 30);

		jLabel11 = new javax.swing.JLabel();
		jLabel11.setBounds(560, 140, 102, 30);

		maKhuVucJtf = new javax.swing.JTextField();
		maKhuVucJtf.setBounds(710, 140, 411, 30);

		jLabel12 = new javax.swing.JLabel();
		jLabel12.setBounds(1129, 140, 31, 30);

		diaChiHienTaiJtf = new javax.swing.JTextField();
		diaChiHienTaiJtf.setBounds(710, 180, 411, 30);
		diaChiHienTaiJtf.setBackground(new Color(255, 255, 255));
		diaChiHienTaiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));

		jLabel13 = new javax.swing.JLabel();
		jLabel13.setBounds(560, 180, 123, 30);

		jLabel14 = new javax.swing.JLabel();
		jLabel14.setBounds(1129, 180, 31, 30);

		jLabel15 = new javax.swing.JLabel();
		jLabel15.setBounds(1129, 220, 31, 30);

		jLabel16 = new javax.swing.JLabel();
		jLabel16.setBounds(560, 220, 145, 30);

		diaChiChuyenDenJtf = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		diaChiChuyenDenJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		diaChiChuyenDenJtf.setEditable(false);
		diaChiChuyenDenJtf.setBounds(710, 220, 390, 30);
		jPanel2.add(diaChiChuyenDenJtf);

		JButton diaChiChuyenDenBtn = new JButton("+");
		diaChiChuyenDenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JtxReceiveAddress = diaChiChuyenDenJtf;
				getAddressAction();

			}
		});
		diaChiChuyenDenBtn.setBounds(1101, 220, 20, 30);
		jPanel2.add(diaChiChuyenDenBtn);

		jLabel17 = new javax.swing.JLabel();
		jLabel17.setBounds(1129, 258, 31, 30);
		jLabel18 = new javax.swing.JLabel();
		jLabel18.setBounds(560, 260, 134, 30);

		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane2.setBounds(710, 260, 411, 220);

		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel4.setText("Mã hộ khẩu");

		maHoKhauJtf.setBackground(new Color(255, 255, 255));
		maHoKhauJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));

		jLabel6.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));
		jLabel6.setForeground(new java.awt.Color(255, 0, 0));
		jLabel6.setText("(*)");

		jLabel9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel9.setText("Tên chủ hộ");

		tenChuHoJtf.setBackground(new Color(255, 255, 255));
		tenChuHoJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));

		jLabel10.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));
		jLabel10.setForeground(new java.awt.Color(255, 0, 0));
		jLabel10.setText("(*)");

		jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel11.setText("Mã khu vực");

		maKhuVucJtf.setBackground(new Color(255, 255, 255));
		maKhuVucJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));

		jLabel12.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));

		jLabel12.setForeground(new java.awt.Color(255, 0, 0));
		jLabel12.setText("(*)");

		jLabel13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel13.setText("Địa chỉ hiên tại");

		jLabel14.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));
		jLabel14.setForeground(new java.awt.Color(255, 0, 0));
		jLabel14.setText("(*)");

		jLabel15.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));
		jLabel15.setForeground(new java.awt.Color(255, 0, 0));
		jLabel15.setText("(*)");

		jLabel16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel16.setText("Địa chỉ chuyển đến");

		jLabel17.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));
		jLabel17.setForeground(new java.awt.Color(255, 0, 0));
		jLabel17.setText("(*)");

		jLabel18.setFont(new Font("Tahoma", Font.PLAIN, 15));

		jLabel18.setText("Lý do chuyển đi");

		jPanel2.add(jScrollPane2);

		lyDoJta = new javax.swing.JTextArea();
		lyDoJta.setLineWrap(true);
		lyDoJta.setWrapStyleWord(true);
		lyDoJta.setColumns(20);
		lyDoJta.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 16));
		lyDoJta.setRows(5);
		jScrollPane2.setViewportView(lyDoJta);

		cancelBtn = new javax.swing.JButton();
		cancelBtn.setBounds(895, 500, 100, 30);
		cancelBtn.setText("Hủy");
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(147, 112, 219));
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});
		jPanel2.add(cancelBtn);

		confirmBtn = new javax.swing.JButton();
		confirmBtn.setBounds(1021, 500, 100, 30);
		confirmBtn.setText("Xác nhận");
		confirmBtn.setBorderPainted(false);
		confirmBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmBtn.setForeground(new Color(255, 255, 255));
		confirmBtn.setBackground(new Color(147, 112, 219));
		confirmBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmBtnActionPerformed(evt);
			}
		});
		jPanel2.add(confirmBtn);

		jPanel2.add(jLabel13);
		jPanel2.add(jLabel11);
		jPanel2.add(jLabel9);
		jPanel2.add(jLabel16);
		jPanel2.add(jLabel18);
		jPanel2.add(jLabel4);
		jPanel2.add(maHoKhauJtf);
		jPanel2.add(jLabel6);
		jPanel2.add(tenChuHoJtf);
		jPanel2.add(jLabel10);
		jPanel2.add(maKhuVucJtf);
		jPanel2.add(jLabel12);
		jPanel2.add(diaChiHienTaiJtf);
		jPanel2.add(jLabel14);

		jPanel2.add(jLabel15);
		jPanel2.add(jLabel17);

	}

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
		close();
	}

	private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.diaChiChuyenDenJtf.getText().trim().isEmpty() || this.lyDoJta.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!!", "Warning!",
					JOptionPane.NO_OPTION);
		} else {
			this.controller.getHoKhauService().chuyenDi(this.hoKhauBean.getHoKhauModel().getID(),
					diaChiChuyenDenJtf.getText().trim(), lyDoJta.getText().trim());
			this.parentJFrame.setEnabled(true);
			dispose();
		}
	}

	private void getAddressAction() {
		addrSuggestion = new AddressSuggestion(this, addrModel) {
			private static final long serialVersionUID = 1L;

			@Override
			public void emmitToParent() {
				String address = this.getAddress();
				JtxReceiveAddress.setText(address);
			}
		};
		addrSuggestion.setVisible(true);
	}
}