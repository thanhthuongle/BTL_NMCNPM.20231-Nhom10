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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controllers.NhanKhauManagerController.KhaiTuController;
import models.KhaiTuModel;
import services.CitizenIdService;
import utils.SuggestionUtility;

public class DeathCertiFrame extends javax.swing.JFrame {

	private JFrame parentJFrame = null;
	private KhaiTuController controller = null;
	private KhaiTuModel khaiTuModel = new KhaiTuModel();

	private javax.swing.JButton checkBtn1;
	private javax.swing.JButton confirm;
	private javax.swing.JButton Cancel;
	private javax.swing.JButton checkBtn2;
	private com.toedter.calendar.JDateChooser ngayKhai;
	private com.toedter.calendar.JDateChooser ngayChet;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea lyDoChet;
	private javax.swing.JTextField soCMTngkhai;
	private javax.swing.JTextField soGiayKhaiTu;
	private javax.swing.JTextField soCMTngchet;

	public DeathCertiFrame(JFrame parentJFrame) {

		initComponents();
		this.parentJFrame = parentJFrame;
		this.controller = new KhaiTuController();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		parentJFrame.setEnabled(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}

		});
		this.soCMTngkhai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// neu keycode == 10 ~ enter
				if (e.getKeyCode() == 10) {
					checkCMTNguoiKhai();
				}
			}
		});
		this.soCMTngchet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// neu keycode == 10 ~ enter
				if (e.getKeyCode() == 10) {
					checkCMTNguoiChet();
				}
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
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Khai tử");
		soCMTngkhai = new SuggestionUtility(false) {

			@Override
			public List<String> getSuggestions(String textContent) {
				CitizenIdService cidService = new CitizenIdService();
				return cidService.search(textContent);
			}
		};
		soCMTngkhai.setBounds(163, 11, 300, 30);

		soCMTngchet = new SuggestionUtility(false) {

			@Override
			public List<String> getSuggestions(String textContent) {
				CitizenIdService cidService = new CitizenIdService();
				return cidService.search(textContent);
			}
		};
		soCMTngchet.setBounds(163, 61, 300, 30);
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setEnabled(false);
		jPanel1.setBackground(new Color(240, 248, 255));
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(10, 10, 143, 30);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(10, 114, 126, 30);
		soGiayKhaiTu = new javax.swing.JTextField();
		soGiayKhaiTu.setBackground(new Color(255, 255, 255));
		soGiayKhaiTu.setBounds(138, 115, 418, 30);
		confirm = new javax.swing.JButton();
		confirm.setBounds(450, 372, 106, 30);
		Cancel = new javax.swing.JButton();
		Cancel.setBounds(331, 372, 106, 30);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(12, 175, 89, 30);
		ngayKhai = new com.toedter.calendar.JDateChooser();
		ngayKhai.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ngayKhai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ngayKhai.setOpaque(false);
		ngayKhai.getCalendarButton().setBackground(new Color(255, 255, 255));
		ngayKhai.setBackground(new Color(255, 255, 255));
		ngayKhai.setBounds(138, 175, 418, 30);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setBounds(10, 223, 91, 30);
		ngayChet = new com.toedter.calendar.JDateChooser();
		ngayChet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ngayChet.getCalendarButton().setBackground(new Color(255, 255, 255));
		ngayChet.setBackground(new Color(255, 255, 255));
		ngayChet.setBounds(138, 223, 418, 30);
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setBounds(10, 271, 91, 30);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(137, 271, 419, 91);
		lyDoChet = new javax.swing.JTextArea();
		checkBtn1 = new javax.swing.JButton();
		checkBtn1.setBounds(473, 10, 83, 30);
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setBounds(10, 60, 140, 30);
		checkBtn2 = new javax.swing.JButton();
		checkBtn2.setBounds(473, 60, 83, 30);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel1.setText("Số CMT người khai:");

		soCMTngkhai.setFont(new Font("Tahoma", Font.PLAIN, 16));

		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel2.setText("Số giấy khai tử:");

		soGiayKhaiTu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		soGiayKhaiTu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				soGiayKhaiTuActionPerformed(evt);
			}
		});

		confirm.setText("Xác nhận");
		confirm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmActionPerformed(evt);
			}
		});
		confirm.setBackground(new Color(147, 112, 219));
		confirm.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirm.setForeground(new Color(255, 255, 255));
		confirm.setBorderPainted(false);

		Cancel.setText("Hủy");
		Cancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelActionPerformed(evt);
			}
		});
		Cancel.setBackground(new Color(147, 112, 219));
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Cancel.setForeground(new Color(255, 255, 255));
		Cancel.setBorderPainted(false);

		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel4.setText("Ngày khai:");

		jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel5.setText("Ngày chết:");

		jLabel6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel6.setText("Lý do chết:");

		lyDoChet.setColumns(20);
		lyDoChet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lyDoChet.setRows(5);
		lyDoChet.setEnabled(true);
		jScrollPane1.setViewportView(lyDoChet);

		checkBtn1.setBorderPainted(false);
		checkBtn1.setForeground(new Color(255, 255, 255));
		checkBtn1.setBackground(new Color(147, 112, 219));
		checkBtn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBtn1.setText("Check");
		checkBtn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkCMTNguoiKhai();
			}
		});

		jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel7.setText("Số CMT người chết:");

		soCMTngchet.setFont(new Font("Tahoma", Font.PLAIN, 16));

		checkBtn2.setBorderPainted(false);
		checkBtn2.setForeground(new Color(255, 255, 255));
		checkBtn2.setBackground(new Color(147, 112, 219));
		checkBtn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkBtn2.setText("Check");
		checkBtn2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkCMTNguoiChet();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(layout);
		jPanel1.setLayout(null);
		jPanel1.add(Cancel);
		jPanel1.add(confirm);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel5);
		jPanel1.add(jLabel2);
		jPanel1.add(ngayKhai);
		jPanel1.add(soGiayKhaiTu);
		jPanel1.add(ngayChet);
		jPanel1.add(jLabel6);
		jPanel1.add(jScrollPane1);
		jPanel1.add(jLabel1);
		jPanel1.add(soCMTngkhai);
		jPanel1.add(jLabel7);
		jPanel1.add(soCMTngchet);
		jPanel1.add(checkBtn1);
		jPanel1.add(checkBtn2);

		pack();
	}

	private void checkCMTNguoiKhai() {
		String tempCMT = this.soCMTngkhai.getText().trim();
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
		int tempID = controller.checkCMT(this.soCMTngkhai.getText());
		if (tempID != -1) {
			this.khaiTuModel.setIdNguoiKhai(tempID);
			JOptionPane.showMessageDialog(this, "OK!!");
		} else {
			if (JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân khẩu trong hệ thống!! Thử lại?", "Warning!!",
					JOptionPane.OK_CANCEL_OPTION) != 0) {
				close();
			}
		}
	}

	private void checkCMTNguoiChet() {
		String tempCMT = this.soCMTngchet.getText().trim();
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
		int tempID = controller.checkCMT(this.soCMTngchet.getText());
		if (tempID != -1) {
			this.khaiTuModel.setIdNguoiChet(tempID);
			JOptionPane.showMessageDialog(this, "OK!!");
		} else {
			if (JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân khẩu trong hệ thống!! Thử lại?", "Warning!!",
					JOptionPane.OK_CANCEL_OPTION) != 0) {
				close();
			}
		}
	}

	private void soGiayKhaiTuActionPerformed(java.awt.event.ActionEvent evt) {
		close();
	}

	private boolean validateForm() {
		return !(soGiayKhaiTu.getText().trim().isEmpty() || lyDoChet.getText().trim().isEmpty());
	}

	private void confirmActionPerformed(java.awt.event.ActionEvent evt) {
		if (!validateForm()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các trường bắt buộc!", "Warning!!",
					JOptionPane.WARNING_MESSAGE);
		} else {
			this.khaiTuModel.setSoGiayKhaiTu(this.soGiayKhaiTu.getText().trim());
			this.khaiTuModel.setNgayKhai(this.ngayKhai.getDate());
			this.khaiTuModel.setNgayChet(this.ngayChet.getDate());
			this.khaiTuModel.setLyDoChet(this.lyDoChet.getText().trim());
			if (this.controller.addNew(this.khaiTuModel)) {
				JOptionPane.showMessageDialog(null, "Thêm thành công.");
			}
			close();
		}
	}

	private void cancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.soCMTngkhai.setText("");
		this.soCMTngchet.setText("");
		this.lyDoChet.setText("");
	}

}