package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.HouseholdPanelController;
import views.HouseholdManagerFrame.ChangeResidence;
import views.HouseholdManagerFrame.EditHouseholdFrame;
import views.HouseholdManagerFrame.HouseholdSeper;
import views.HouseholdManagerFrame.NewHouseholdFrame;

public class HouseholdPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JFrame parentFrame;
	private HouseholdPanelController controller;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton chuyenDiBtn;
	private JTextField jtfSearch;
	private JPanel tableJpn;
	private JButton tachHoKhauBtn;
	private JButton themMoiBtn;
	private JButton suaBtn;
	private JFrame parentJFrame;

	// End of variables declaration//GEN-END:variables

	public HouseholdPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		init();
		controller = new HouseholdPanelController(jtfSearch, tableJpn);
		controller.setParentJFrame(parentFrame);
	}

	private void init() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(new Color(249, 250, 254));
		setBounds(0, 0, 806, 593);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(249, 250, 254));
		panel_1.setBounds(10, 10, 786, 50);
		add(panel_1);
		panel_1.setLayout(null);

		themMoiBtn = new JButton("Mới");

		themMoiBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				themMoiBtnActionPerformed(evt);
			}
		});
		themMoiBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		themMoiBtn.setForeground(new Color(255, 255, 255));
		themMoiBtn.setBackground(Color.decode("#409EFF"));
		themMoiBtn.setBorderPainted(false);
		themMoiBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		themMoiBtn.setBounds(0, 10, 130, 30);
		panel_1.add(themMoiBtn);

		suaBtn = new JButton("Sửa");
		suaBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				suaBtnActionPerformed(evt);
			}
		});
		suaBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		suaBtn.setForeground(new Color(255, 255, 255));
		suaBtn.setBackground(Color.decode("#409EFF"));
		suaBtn.setBorderPainted(false);
		suaBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		suaBtn.setBounds(140, 10, 130, 30);
		panel_1.add(suaBtn);

		tachHoKhauBtn = new JButton("Tách hộ khẩu");

		tachHoKhauBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tachHoKhauBtnActionPerformed(evt);
			}
		});
		tachHoKhauBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		tachHoKhauBtn.setBackground(Color.decode("#409EFF"));
		tachHoKhauBtn.setForeground(new Color(255, 255, 255));
		tachHoKhauBtn.setBorderPainted(false);
		tachHoKhauBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		tachHoKhauBtn.setBounds(516, 10, 130, 30);
		panel_1.add(tachHoKhauBtn);

		chuyenDiBtn = new JButton("Chuyển nơi ở");

		chuyenDiBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chuyenDiBtnActionPerformed(evt);
			}
		});
		chuyenDiBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		chuyenDiBtn.setBackground(Color.decode("#409EFF"));
		chuyenDiBtn.setForeground(new Color(255, 255, 255));
		chuyenDiBtn.setBorderPainted(false);
		;
		chuyenDiBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		chuyenDiBtn.setBounds(656, 10, 130, 30);
		panel_1.add(chuyenDiBtn);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 90, 786, 493);
		add(panel);
		panel.setLayout(null);

		tableJpn = new JPanel();
		tableJpn.setBounds(10, 63, 766, 420);
		tableJpn.setBackground(new Color(255, 255, 255));
		tableJpn.setLayout(null);
		panel.add(tableJpn);

		jtfSearch = new JTextField("Search");
		jtfSearch.setBounds(10, 10, 766, 43);
		panel.add(jtfSearch);

		jtfSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtfSearchActionPerformed(evt);
			}
		});

		jtfSearch.setForeground(Color.GRAY);
		jtfSearch.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (jtfSearch.getText().trim().equals("Search")) {
					jtfSearch.setForeground(Color.black);
					jtfSearch.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (jtfSearch.getText().isEmpty()) {
					jtfSearch.setForeground(Color.GRAY);
					jtfSearch.setText("Search");
				}
			}
		});
		jtfSearch.setSelectionColor(new Color(204, 153, 255));
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfSearch.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new EmptyBorder(0, 10, 0, 0)));
		jtfSearch.setColumns(10);
	}

	private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfSearchActionPerformed
	}// GEN-LAST:event_jtfSearchActionPerformed

	private void chuyenDiBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_chuyenDiBtnActionPerformed
		ChangeResidence chuyenDiNoiKhac = new ChangeResidence(this.parentFrame);
		chuyenDiNoiKhac.setLocationRelativeTo(null);
		chuyenDiNoiKhac.setResizable(false);
		chuyenDiNoiKhac.setVisible(true);
	}// GEN-LAST:event_chuyenDiBtnActionPerformed

	private void themMoiBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_themMoiBtnActionPerformed
		NewHouseholdFrame themMoiHoKhau = new NewHouseholdFrame(this.parentFrame);
		themMoiHoKhau.setLocationRelativeTo(null);
		themMoiHoKhau.setResizable(false);
		themMoiHoKhau.setVisible(true);
	}// GEN-LAST:event_themMoiBtnActionPerformed

	private void suaBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_themMoiBtnActionPerformed
		EditHouseholdFrame suaHoKhau = new EditHouseholdFrame(this.controller, this.parentJFrame);
		suaHoKhau.setLocationRelativeTo(null);
		suaHoKhau.setResizable(false);
		suaHoKhau.setVisible(true);
	}// GEN-LAST:event_themMoiBtnActionPerformed

	private void tachHoKhauBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tachHoKhauBtnActionPerformed
		HouseholdSeper tachHoKhau = new HouseholdSeper(this.parentFrame);
		tachHoKhau.setLocationRelativeTo(null);
		tachHoKhau.setResizable(false);
		tachHoKhau.setVisible(true);
	}// GEN-LAST:event_tachHoKhauBtnActionPerformed

}
