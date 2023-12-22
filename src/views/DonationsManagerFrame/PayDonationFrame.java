package views.DonationsManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import beans.NhanKhauBean;
import beans.PhiUngHoBean;
import controllers.DonationsManagerController.PayDonationController;
import controllers.DonationsManagerController.StatisticDonationsController;
import models.PayDonationModel;

public class PayDonationFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private StatisticDonationsController parentController;
	private JFrame parentFrame;
	private PhiUngHoBean selectedDonation;
	private PayDonationController controller;
	private PayDonationModel payDonationModel;
	private NhanKhauBean selectPerson;
	
	private JTextField soTienJtf;
	private JTextField idSelectedPersonJtf;
	private JButton CancelBtn;
	private JButton CreateBtn;
	private JTextField nameSelectedPersonJtf;
	private JButton selectPersonBtn;

	public PayDonationFrame(StatisticDonationsController parentController, JFrame parentJFrame, PhiUngHoBean selectedDonation) {
		init();
		this.parentController = parentController;
		this.parentFrame = parentJFrame;
		this.parentFrame.setEnabled(false);
		this.selectedDonation = selectedDonation;
		this.selectPerson = new NhanKhauBean();
		controller = new PayDonationController();
		this.payDonationModel = new PayDonationModel();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
	}

	private void init() {
		setTitle("Ủng hộ");
		setBounds(100, 100, 650, 310);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBounds(5, 5, 1100, 1100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		jPanel1.setBounds(10, 10, 616, 253);
		jPanel1.setLayout(null);
		contentPane.add(jPanel1);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 10, 596, 190);
		jPanel1.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID người ủng hộ");
		lblNewLabel.setBounds(10, 10, 116, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("Số tiền");
		lblNewLabel_1.setBounds(10, 90, 576, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		soTienJtf = new JTextField();
		soTienJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		soTienJtf.setBounds(10, 120, 576, 40);
		panel.add(soTienJtf);
		soTienJtf.setColumns(10);

		idSelectedPersonJtf = new JTextField();
		idSelectedPersonJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idSelectedPersonJtf.setBounds(10, 40, 116, 40);
		panel.add(idSelectedPersonJtf);
		idSelectedPersonJtf.setColumns(10);
		
		selectPersonBtn = new JButton("Select");
		selectPersonBtn.setForeground(Color.WHITE);
		selectPersonBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		selectPersonBtn.setBorderPainted(false);
		selectPersonBtn.setBackground(new Color(147, 112, 219));
		selectPersonBtn.setBounds(509, 0, 77, 25);
		selectPersonBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPersonAction(e);
			}
		});
		panel.add(selectPersonBtn);
		
		nameSelectedPersonJtf = new JTextField();
		nameSelectedPersonJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameSelectedPersonJtf.setColumns(10);
		nameSelectedPersonJtf.setBounds(136, 40, 450, 40);
		panel.add(nameSelectedPersonJtf);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(10, 200, 596, 43);
		jPanel1.add(panel_3);

		CancelBtn = new JButton("Cancel");
		CancelBtn.setBounds(330, 10, 100, 25);
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

		CreateBtn = new JButton("Pay");
		CreateBtn.setBounds(486, 10, 100, 25);
		CreateBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CreateBtnActionPerformed(evt);
			}
		});
		CreateBtn.setBackground(new Color(147, 112, 219));
		CreateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		CreateBtn.setForeground(new Color(255, 255, 255));
		CreateBtn.setBorderPainted(false);
		panel_3.add(CreateBtn);
	}

	private void CancelBtnActionPerformed(ActionEvent evt) {
		idSelectedPersonJtf.setText("");
		soTienJtf.setText("");
	}

	private boolean validateForm() {
		String tenNguoiNop = idSelectedPersonJtf.getText();
		String soTien = soTienJtf.getText();
		if (tenNguoiNop.trim().isEmpty() || soTien.trim().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		try {
			long d = Long.parseLong(soTien);
			if (d <= 0 || d >= 1000000) {
				JOptionPane.showMessageDialog(rootPane, "Số tiền không hợp lệ", "Warning",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, "Số tiền sai định dạng hoặc vượt quá phạm vi cho phép", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {
		if (validateForm()) {
			this.payDonationModel.setIdNhanKhau(Integer.parseInt(idSelectedPersonJtf.getText()));;
			this.payDonationModel.setSo_tien(Integer.parseInt(soTienJtf.getText()));
			try {
				if (this.controller.payDonation(this.payDonationModel, this.selectedDonation.getDonationModel().getID())) {
					JOptionPane.showMessageDialog(null, "Thêm thành công!!");
					closeWithNoDiaglog();
					parentController.refreshData();
				}else {
					JOptionPane.showMessageDialog(rootPane, "Số tiền nhập không hợp lệ", "Warning",
							JOptionPane.WARNING_MESSAGE);
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
			this.parentController.setData();
			dispose();
		}
	}
	
	void closeWithNoDiaglog() {
		this.parentFrame.setEnabled(true);
		this.parentController.setData();
		dispose();
	}
	
	public void setDataPerson() {
		this.idSelectedPersonJtf.setText(Integer.toString(selectPerson.getNhanKhauModel().getID()));
		this.nameSelectedPersonJtf.setText(selectPerson.getNhanKhauModel().getHoTen());
	}
	
	private void selectPersonAction(ActionEvent e) {
        ChoosePayDonationPersonFrame choosePeople = new ChoosePayDonationPersonFrame(this.selectPerson, this);
        choosePeople.setLocationRelativeTo(null);
        choosePeople.setResizable(false);
        choosePeople.setVisible(true);
	}
}
