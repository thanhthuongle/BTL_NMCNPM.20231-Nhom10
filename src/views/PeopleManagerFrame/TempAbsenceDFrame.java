package views.PeopleManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.NhanKhauManagerController.DangKyTamVangController;
import models.AddressModel;
import models.TamVangModel;
import services.CitizenIdService;
import utils.SuggestionUtility;
import views.AddressSuggestion;

public class TempAbsenceDFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame parentJFrame = null;
	private DangKyTamVangController controller = null;
	private TamVangModel tamVangModel = new TamVangModel();
	private AddressSuggestion addrSuggestion;
	private AddressModel addrModel = new AddressModel();
	private JTextField JtxReceiveAddress;

	public TempAbsenceDFrame(JFrame parentJFrame) {
		getContentPane().setBackground(new Color(255, 255, 255));
		initComponents();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		controller = new DangKyTamVangController();
		this.parentJFrame = parentJFrame;
		parentJFrame.setEnabled(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!",
						JOptionPane.YES_NO_OPTION) == 0) {
					close();
				}
			}
		});
		this.soCMTjtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					checkCMT();
				}
			}
		});
	}

	void close() {
		if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!",
				JOptionPane.YES_NO_OPTION)) {
			this.parentJFrame.setEnabled(true);
			dispose();
		}
	}

	private boolean validateForm() {
		return !(maGiayTamVangJtf.getText().trim().isEmpty() || noiTamTruJtf.getText().trim().isEmpty()
				|| lyDoJta.getText().trim().isEmpty());
	}

	private void checkCMT() {
		String tempCMT = this.soCMTjtf.getText().trim();
		if (tempCMT.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT", "Warning!!", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			try {
				long cmt = Long.parseLong(tempCMT);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập So CMT đúng định dạng!", "Warning!!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		int tempID = controller.checkCMT(this.soCMTjtf.getText());
		if (tempID != -1) {
			// khong cho phep sua lai gia tri
			this.soCMTjtf.setEditable(false);
			this.maGiayTamVangJtf.setEnabled(true);
			this.noiTamTruJtf.setEnabled(true);
			this.tuNgayJdc.setEnabled(true);
			this.denNgayJdc.setEnabled(true);
			this.lyDoJta.setEnabled(true);

			this.tamVangModel.setIdNhanKhau(tempID);
			JOptionPane.showMessageDialog(this, "OK!!");
		} else {
			if (JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân khẩu trong hệ thống!! Thử lại?", "Warning!!",
					JOptionPane.OK_CANCEL_OPTION) != 0) {
				close();
			}
		}
	}

	private void initComponents() {
		setTitle("Đăng ký tạm vắng");
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		acceptBtn = new javax.swing.JButton();
		acceptBtn.setBounds(464, 422, 114, 30);
		CancelBtn = new javax.swing.JButton();
		CancelBtn.setBounds(320, 422, 114, 30);

		soCMTjtf = new SuggestionUtility(false) {

			@Override
			public List<String> getSuggestions(String textContent) {
				CitizenIdService cidService = new CitizenIdService();
				return cidService.search(textContent);
			}
		};
		soCMTjtf.setBounds(200, 25, 242, 30);

		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(20, 25, 90, 30);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(543, 21, 15, 30);
		checkBtn = new javax.swing.JButton();
		checkBtn.setBounds(452, 25, 81, 30);
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(20, 93, 136, 30);
		maGiayTamVangJtf = new javax.swing.JTextField();
		maGiayTamVangJtf.setBounds(200, 94, 333, 30);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(543, 93, 15, 30);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setBounds(20, 142, 136, 30);

		noiTamTruJtf = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
		noiTamTruJtf.setEnabled(false);
		noiTamTruJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		noiTamTruJtf.setEditable(false);
		noiTamTruJtf.setBounds(200, 143, 311, 30);
		jPanel1.add(noiTamTruJtf);

		JButton noiTamTruBtn = new JButton("+");
		noiTamTruBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));

		noiTamTruBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JtxReceiveAddress = noiTamTruJtf;
				getAddressAction();

			}
		});
		noiTamTruBtn.setBounds(513, 145, 20, 30);
		jPanel1.add(noiTamTruBtn);

		jLabel6 = new javax.swing.JLabel();
		jLabel6.setBounds(543, 142, 15, 30);
		tuNgayJdc = new com.toedter.calendar.JDateChooser();
		tuNgayJdc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tuNgayJdc.setBounds(200, 191, 333, 30);
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setBounds(543, 191, 15, 30);
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setBounds(20, 191, 136, 30);
		jLabel9 = new javax.swing.JLabel();
		jLabel9.setBounds(20, 239, 127, 30);
		denNgayJdc = new com.toedter.calendar.JDateChooser();
		denNgayJdc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		denNgayJdc.setBounds(200, 239, 333, 30);
		jLabel10 = new javax.swing.JLabel();
		jLabel10.setBounds(543, 239, 15, 30);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(200, 287, 333, 104);
		jLabel11 = new javax.swing.JLabel();
		jLabel11.setBounds(20, 287, 136, 30);
		jLabel12 = new javax.swing.JLabel();
		jLabel12.setBounds(543, 280, 15, 30);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		acceptBtn.setText("Xác nhận");
		acceptBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				acceptBtnActionPerformed(evt);
			}
		});
		acceptBtn.setBackground(new Color(147, 112, 219));
		acceptBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		acceptBtn.setForeground(new Color(255, 255, 255));
		acceptBtn.setBorderPainted(false);

		CancelBtn.setText("Hủy");
		CancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CancelBtnActionPerformed(evt);
			}
		});
		CancelBtn.setBackground(new Color(147, 112, 219));
		CancelBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		CancelBtn.setForeground(new Color(255, 255, 255));
		CancelBtn.setBorderPainted(false);

		soCMTjtf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		soCMTjtf.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				soCMTjtfActionPerformed(evt);
			}
		});

		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel1.setText("Số CMT:");

		jLabel2.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel2.setForeground(new java.awt.Color(255, 0, 0));
		jLabel2.setText("(*)");

		checkBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		checkBtn.setText("Check");
		checkBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkBtnActionPerformed(evt);
			}
		});

		checkBtn.setBackground(new Color(147, 112, 219));
		checkBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkBtn.setForeground(new Color(255, 255, 255));
		checkBtn.setBorderPainted(false);

		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel3.setText("Mã giấy tạm vắng:");

		maGiayTamVangJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maGiayTamVangJtf.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				maGiayTamVangJtfActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel4.setForeground(new java.awt.Color(255, 0, 0));
		jLabel4.setText("(*)");

		jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel5.setText("Nơi tạm trú:");

		jLabel6.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel6.setForeground(new java.awt.Color(255, 0, 0));
		jLabel6.setText("(*)");

		jLabel7.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel7.setForeground(new java.awt.Color(255, 0, 0));
		jLabel7.setText("(*)");

		jLabel8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel8.setText("Từ ngày:");

		jLabel9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel9.setText("Đến ngày:");

		jLabel10.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel10.setForeground(new java.awt.Color(255, 0, 0));
		jLabel10.setText("(*)");

		jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel11.setText("Lý do:");

		jLabel12.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel12.setForeground(new java.awt.Color(255, 0, 0));
		jLabel12.setText("(*)");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE).addContainerGap()));
		jPanel1.setLayout(null);
		jPanel1.add(jLabel1);
		jPanel1.add(soCMTjtf);
		jPanel1.add(jLabel2);
		jPanel1.add(checkBtn);
		jPanel1.add(jLabel3);
		jPanel1.add(maGiayTamVangJtf);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel5);
		jPanel1.add(jLabel8);
		jPanel1.add(jLabel9);
		jPanel1.add(jLabel11);
		jPanel1.add(jScrollPane1);
		lyDoJta = new javax.swing.JTextArea();
		lyDoJta.setEnabled(false);
		lyDoJta.setLineWrap(true);
		jScrollPane1.setViewportView(lyDoJta);

		lyDoJta.setColumns(20);
		lyDoJta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lyDoJta.setRows(5);
		jPanel1.add(tuNgayJdc);
		jPanel1.add(denNgayJdc);
		jPanel1.add(jLabel6);
		jPanel1.add(jLabel7);
		jPanel1.add(jLabel10);
		jPanel1.add(jLabel12);
		jPanel1.add(CancelBtn);
		jPanel1.add(acceptBtn);
		getContentPane().setLayout(layout);

		pack();
	}

	private void soCMTjtfActionPerformed(java.awt.event.ActionEvent evt) {

	}// GEN-LAST:event_soCMTjtfActionPerformed

	private void maGiayTamVangJtfActionPerformed(java.awt.event.ActionEvent evt) {

	}// GEN-LAST:event_maGiayTamVangJtfActionPerformed

	private void noiTamTruJtfActionPerformed(java.awt.event.ActionEvent evt) {

	}// GEN-LAST:event_noiTamTruJtfActionPerformed

	private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (!validateForm()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!", "Warning!!",
					JOptionPane.WARNING_MESSAGE);
		} else {
			this.tamVangModel.setMaGiayTamVang(this.maGiayTamVangJtf.getText().trim());
			this.tamVangModel.setNoiTamTru(this.noiTamTruJtf.getText().trim());
			this.tamVangModel.setTuNgay(this.tuNgayJdc.getDate());
			this.tamVangModel.setDenNgay(this.denNgayJdc.getDate());
			this.tamVangModel.setLyDo(this.lyDoJta.getText().trim());
			if (this.controller.addNew(this.tamVangModel)) {
				JOptionPane.showMessageDialog(null, "Thêm thành công.");
			}
			close();
		}
	}// GEN-LAST:event_acceptBtnActionPerformed

	private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelBtnActionPerformed
		close();
	}// GEN-LAST:event_CancelBtnActionPerformed

	// kiem tra su ton tai cua nhan khau trong he thong
	private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkBtnActionPerformed
		this.checkCMT();
	}
	private javax.swing.JButton CancelBtn;
	private javax.swing.JButton acceptBtn;
	private javax.swing.JButton checkBtn;
	private com.toedter.calendar.JDateChooser denNgayJdc;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea lyDoJta;
	private javax.swing.JTextField maGiayTamVangJtf;
	private javax.swing.JTextField soCMTjtf;
	private com.toedter.calendar.JDateChooser tuNgayJdc;

	private SuggestionUtility noiTamTruJtf;

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