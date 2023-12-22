package views.FeesManagerFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.PhiBatBuocBean;
import controllers.FeesController;
import controllers.LoginController;
import controllers.FeesManagerController.EditFeeController;

import models.FeesModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class EditFeeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private FeesController parentController;
	private JFrame parentFrame;
	private PhiBatBuocBean phiBatBuocBean;
	private EditFeeController controller;
	private JTextField dotThuJtf;
	private JTextField soTienJtf;
	private JTextField tenJtf;
	private JButton CancelBtn;
	private JButton EditBtn;

	public EditFeeFrame(FeesController parentController, JFrame parentJFrame) {
		init();
		this.parentController = parentController;
		this.parentFrame = parentJFrame;
		this.parentFrame.setEnabled(false);
		this.phiBatBuocBean = new PhiBatBuocBean();
		controller = new EditFeeController();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
	}

	private void init() {
		setTitle("Sửa thông tin khoản phí");
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBounds(5, 5, 1100, 1100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		jPanel1.setBounds(10, 10, 616, 393);
		jPanel1.setLayout(null);
		contentPane.add(jPanel1);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 25, 596, 285);
		jPanel1.add(panel);
		panel.setLayout(null);

		dotThuJtf = new JTextField();
		dotThuJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dotThuJtf.setBounds(10, 235, 576, 40);
		panel.add(dotThuJtf);
		dotThuJtf.setColumns(10);

		JLabel lblEditLabel = new JLabel("Tên khoản thu");
		lblEditLabel.setBounds(10, 10, 576, 20);
		panel.add(lblEditLabel);
		lblEditLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblEditLabel_1 = new JLabel("Số tiền cần nộp trên 1 người");
		lblEditLabel_1.setBounds(10, 108, 576, 20);
		panel.add(lblEditLabel_1);
		lblEditLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		soTienJtf = new JTextField();
		soTienJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		soTienJtf.setBounds(10, 138, 576, 40);
		panel.add(soTienJtf);
		soTienJtf.setColumns(10);

		JLabel lblEditLabel_2 = new JLabel("Đợt thu");
		lblEditLabel_2.setBounds(10, 205, 576, 20);
		panel.add(lblEditLabel_2);
		lblEditLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		tenJtf = new JTextField();
		tenJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenJtf.setBounds(10, 40, 576, 40);
		panel.add(tenJtf);
		tenJtf.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(10, 320, 596, 63);
		jPanel1.add(panel_3);

		CancelBtn = new JButton("Cancel");
		CancelBtn.setBounds(330, 28, 100, 25);
		CancelBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CancelBtnActionPerformed(evt);
			}
		});
		panel_3.setLayout(null);
		CancelBtn.setBackground(new Color(147, 112, 219));
		CancelBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		CancelBtn.setForeground(new Color(255, 255, 255));
		CancelBtn.setBorderPainted(false);
		panel_3.add(CancelBtn);

		EditBtn = new JButton("Edit");
		EditBtn.setBounds(486, 28, 100, 25);
		EditBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EditBtnActionPerformed(evt);
			}
		});
		EditBtn.setBackground(new Color(147, 112, 219));
		EditBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		EditBtn.setForeground(new Color(255, 255, 255));
		EditBtn.setBorderPainted(false);
		panel_3.add(EditBtn);
	}

	private void CancelBtnActionPerformed(ActionEvent evt) {
		tenJtf.setText("");
		soTienJtf.setText("");
		dotThuJtf.setText("");
	}

	private boolean validateForm() {
		String tenPhi = tenJtf.getText();
		String soTien = soTienJtf.getText();
		String dotThu = dotThuJtf.getText();
		if (tenPhi.trim().isEmpty() || soTien.trim().isEmpty() || dotThu.trim().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		try {
			long d = Long.parseLong(soTien);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, "Số tiền không thể chứa các ký tự", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (validateForm()) {
			FeesModel temp = this.phiBatBuocBean.getFeesModel();
			temp.setTen_khoan_thu(tenJtf.getText());
			temp.setSo_tien(Integer.parseInt(soTienJtf.getText()));
			temp.setDot_thu(dotThuJtf.getText());
			temp.setIdNguoiTao(LoginController.currentUser.getID());
			try {
				if (this.controller.editFee(this.phiBatBuocBean, parentController.getSelectedIdFee())) {
					JOptionPane.showMessageDialog(null, "Sửa thành công!!");
					close();
					parentController.refreshData();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	void close() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!",
				JOptionPane.YES_NO_OPTION) == 0) {
			this.parentFrame.setEnabled(true);
			dispose();
		}
	}
}
