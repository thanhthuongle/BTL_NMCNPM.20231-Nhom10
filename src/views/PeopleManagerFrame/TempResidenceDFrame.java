
package views.PeopleManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controllers.NhanKhauManagerController.DangKyTamTruController;
import models.TamTruModel;
import services.CitizenIdService;
import utils.SuggestionUtility;

public class TempResidenceDFrame extends javax.swing.JFrame {

	private JFrame parentFrame;
	private DangKyTamTruController controller;
	private TamTruModel tamTruModel;
	private Object tuNgayJdc;
	private Object lyDoJta;
	
	private javax.swing.JButton acceptBtn;
	private javax.swing.JButton cancelBtn;
	private javax.swing.JButton checkBtn;
	private com.toedter.calendar.JDateChooser denNgayDc;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
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
	private javax.swing.JTextArea lyDoTar;
	private javax.swing.JTextField maGiayTamTruJtf;
	private javax.swing.JTextField soCMTJtf;
	private javax.swing.JTextField soDienThoaiJtf;
	private com.toedter.calendar.JDateChooser tuNgayDc;

	public TempResidenceDFrame() {
		getContentPane().setIgnoreRepaint(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		initComponents();
	}

	public TempResidenceDFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		initComponents();
		this.controller = new DangKyTamTruController();
		this.tamTruModel = new TamTruModel();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Đăng ký tạm trú");
		parentFrame.setEnabled(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}

		});
		
		this.soCMTJtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					checkCMT(soCMTJtf.getText());
				}
			}
		});
	}

	void close() {
		if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!",
				JOptionPane.YES_NO_OPTION)) {
			this.parentFrame.setEnabled(true);
			dispose();
		}
	}

	private boolean checkCMT(String cmt) {
		if (cmt.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập số CMT", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			try {
				long temp = Long.parseLong(cmt);
				if (cmt.trim().length() != 9 && cmt.trim().length() != 12) {
					throw new Exception("Sai định dạng");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số CMT!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		int tempID = controller.checkCMT(this.soCMTJtf.getText());

		if (tempID != -1) {
			this.tamTruModel.setIdNhanKhau(tempID);
			JOptionPane.showMessageDialog(this, "OK!!");
		}

		return true;
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));

		soCMTJtf = new SuggestionUtility(false) {

			@Override
			public List<String> getSuggestions(String textContent) {
				CitizenIdService cidService = new CitizenIdService();
				return cidService.search(textContent);
			}
		};
		soCMTJtf.setBounds(160, 23, 215, 30);

		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(20, 23, 130, 30);
		checkBtn = new javax.swing.JButton();
		checkBtn.setBounds(375, 23, 85, 30);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(470, 23, 15, 30);
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(20, 91, 130, 30);
		maGiayTamTruJtf = new javax.swing.JTextField();
		maGiayTamTruJtf.setBounds(160, 90, 300, 30);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(470, 91, 15, 30);
		soDienThoaiJtf = new javax.swing.JTextField();
		soDienThoaiJtf.setBounds(160, 140, 300, 30);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setBounds(470, 141, 15, 30);
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setBounds(20, 141, 130, 30);
		tuNgayDc = new com.toedter.calendar.JDateChooser();
		tuNgayDc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tuNgayDc.setBounds(160, 184, 300, 30);
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setBounds(20, 181, 130, 30);
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setBounds(470, 184, 15, 30);
		jLabel9 = new javax.swing.JLabel();
		jLabel9.setBounds(470, 230, 15, 30);
		denNgayDc = new com.toedter.calendar.JDateChooser();
		denNgayDc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		denNgayDc.setBounds(160, 230, 300, 30);
		jLabel10 = new javax.swing.JLabel();
		jLabel10.setBounds(20, 231, 130, 30);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(160, 280, 300, 105);
		jLabel11 = new javax.swing.JLabel();
		jLabel11.setBounds(20, 281, 130, 30);
		acceptBtn = new javax.swing.JButton();
		acceptBtn.setBounds(346, 401, 112, 30);
		cancelBtn = new javax.swing.JButton();
		cancelBtn.setBounds(194, 401, 112, 30);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		soCMTJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));

		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel1.setText("Số CMT:");

		checkBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
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

		jLabel2.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel2.setForeground(new java.awt.Color(255, 0, 0));
		jLabel2.setText("(*)");

		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel3.setText("Mã giấy tạm trú:");

		maGiayTamTruJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		maGiayTamTruJtf.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				maGiayTamTruJtfActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel4.setForeground(new java.awt.Color(255, 0, 0));
		jLabel4.setText("(*)");

		soDienThoaiJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		soDienThoaiJtf.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				soDienThoaiJtfActionPerformed(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel5.setForeground(new java.awt.Color(255, 0, 0));
		jLabel5.setText("(*)");

		jLabel6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel6.setText("Số điện thoại:");

		jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel7.setText("Từ ngày:");

		jLabel8.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel8.setForeground(new java.awt.Color(255, 0, 0));
		jLabel8.setText("(*)");

		jLabel9.setFont(new java.awt.Font("Tohama", 0, 14));
		jLabel9.setForeground(new java.awt.Color(255, 0, 0));
		jLabel9.setText("(*)");

		jLabel10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel10.setText("Đến ngày:");

		jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel11.setText("Lý do:");

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

		cancelBtn.setText("Hủy");
		cancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelBtnActionPerformed(evt);
			}
		});
		cancelBtn.setBackground(new Color(147, 112, 219));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBorderPainted(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);
		jPanel1.setLayout(null);
		jPanel1.add(jLabel1);
		jPanel1.add(soCMTJtf);
		jPanel1.add(jLabel2);
		jPanel1.add(checkBtn);
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel6);
		jPanel1.add(jLabel7);
		jPanel1.add(jLabel10);
		jPanel1.add(jLabel11);
		jPanel1.add(jScrollPane1);
		lyDoTar = new javax.swing.JTextArea();
		lyDoTar.setLineWrap(true);
		jScrollPane1.setViewportView(lyDoTar);
		lyDoTar.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lyDoTar.setColumns(20);
		lyDoTar.setRows(5);
		jPanel1.add(tuNgayDc);
		jPanel1.add(denNgayDc);
		jPanel1.add(soDienThoaiJtf);
		jPanel1.add(maGiayTamTruJtf);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel5);
		jPanel1.add(jLabel8);
		jPanel1.add(jLabel9);
		jPanel1.add(cancelBtn);
		jPanel1.add(acceptBtn);

		pack();
	}

	private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkCMT(soCMTJtf.getText())) {
			int idNhanKhau = this.controller.checkCMT(soCMTJtf.getText());
			if (idNhanKhau > 0) {
				this.tamTruModel.setIdNhanKhau(idNhanKhau);
//				soCMTJtf.setEnabled(false);
//				checkBtn.setEnabled(false);
//				maGiayTamTruJtf.setEnabled(true);
//				soDienThoaiJtf.setEnabled(true);
//				tuNgayDc.setEnabled(true);
//				denNgayDc.setEnabled(true);
//				lyDoTar.setEnabled(true);
			} else {
				if (JOptionPane.showConfirmDialog(null,
						"Không tìm thấy người có số CMT: " + soCMTJtf.getText() + ". Thêm mới?", "Confirm",
						JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
					NewPeopleFrame addNewPeopleJFrame = new NewPeopleFrame(this);
					addNewPeopleJFrame.setLocationRelativeTo(null);
					addNewPeopleJFrame.setResizable(false);
					addNewPeopleJFrame.setVisible(true);
				}
			}
		}
	}

	private void maGiayTamTruJtfActionPerformed(java.awt.event.ActionEvent evt) {
	}// GEN-LAST:event_maGiayTamTruJtfActionPerformed

	private void soDienThoaiJtfActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}// GEN-LAST:event_soDienThoaiJtfActionPerformed

	private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
		this.soCMTJtf.setText("");
		this.maGiayTamTruJtf.setText("");
		this.soDienThoaiJtf.setText("");
		close();
	}// GEN-LAST:event_cancelBtnActionPerformed

	private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (validateForm()) {
			this.tamTruModel.setMaGiayTamTru(maGiayTamTruJtf.getText().trim());
			this.tamTruModel.setSoDienThoaiNguoiDangKy(soDienThoaiJtf.getText().trim());
			this.tamTruModel.setTuNgay(tuNgayDc.getDate());
			this.tamTruModel.setDenNgay(denNgayDc.getDate());
			this.tamTruModel.setLyDo(lyDoTar.getText().trim());
			if (this.controller.addNew(this.tamTruModel)) {
				JOptionPane.showMessageDialog(null, "Thêm thành công.");
				this.parentFrame.setEnabled(true);
				dispose();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}



	private boolean validateForm() {
		return !(maGiayTamTruJtf.getText().trim().isEmpty() || soDienThoaiJtf.getText().trim().isEmpty()
				|| lyDoTar.getText().trim().isEmpty());
	}
}