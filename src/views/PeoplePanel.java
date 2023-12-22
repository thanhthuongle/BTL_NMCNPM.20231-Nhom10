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

import controllers.PeoplePanelController;
import views.PeopleManagerFrame.DeathCertiFrame;
import views.PeopleManagerFrame.EditPeopleFrame;
import views.PeopleManagerFrame.NewPeopleFrame;
import views.PeopleManagerFrame.TempAbsenceDFrame;
import views.PeopleManagerFrame.TempResidenceDFrame;

public class PeoplePanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private PeoplePanelController controller;
	private JFrame parentJFrame;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addNewBtn;
	private javax.swing.JButton editBtn;
	private javax.swing.JButton khaiTuBtn;
	private javax.swing.JPanel tablePanel;
	private javax.swing.JButton tamTruBtn;
	private javax.swing.JButton tamVangBtn;
	private JTextField jtfSearch;

	// End of variables declaration//GEN-END:variables

	public PeoplePanel(JFrame parentFrame) {
		this.parentJFrame = parentFrame;
		init();
		controller = new PeoplePanelController(tablePanel, jtfSearch);
		controller.setParentJFrame(parentJFrame);
		controller.setData();
	}

	private void init() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(new Color(249, 250, 254));
		setBounds(0, 0, 806, 593);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(249, 250, 254));
		panel.setBounds(10, 10, 786, 50);
		add(panel);
		panel.setLayout(null);

		addNewBtn = new JButton("Thêm mới");
		addNewBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		addNewBtn.setForeground(new Color(255, 255, 255));
		addNewBtn.setBackground(Color.decode("#409EFF"));
		addNewBtn.setBorderPainted(false);
		addNewBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		addNewBtn.setBounds(0, 10, 130, 30);
		addNewBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addNewBtnActionPerformed(evt);
			}
		});
		panel.add(addNewBtn);

		editBtn = new JButton("Sửa");
		editBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		editBtn.setForeground(new Color(255, 255, 255));
		editBtn.setBackground(Color.decode("#409EFF"));
		editBtn.setBorderPainted(false);
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		editBtn.setBounds(140, 10, 130, 30);
		editBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editBtnActionPerformed(evt);
			}
		});
		panel.add(editBtn);

		tamVangBtn = new JButton("ĐK tạm vắng");
		tamVangBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		tamVangBtn.setForeground(new Color(255, 255, 255));
		tamVangBtn.setBackground(Color.decode("#409EFF"));
		tamVangBtn.setBorderPainted(false);
		tamVangBtn.setBounds(366, 10, 130, 30);
		tamVangBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		tamVangBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tamVangBtnActionPerformed(evt);
			}
		});
		panel.add(tamVangBtn);

		tamTruBtn = new JButton("ĐK tạm trú");
		tamTruBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		tamTruBtn.setForeground(new Color(255, 255, 255));
		tamTruBtn.setBackground(Color.decode("#409EFF"));
		tamTruBtn.setBorderPainted(false);

		tamTruBtn.setBounds(506, 10, 130, 30);
		tamTruBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		tamTruBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tamTruBtnActionPerformed(evt);
			}
		});
		panel.add(tamTruBtn);

		khaiTuBtn = new JButton("Khai Tử");
		khaiTuBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		khaiTuBtn.setForeground(new Color(255, 255, 255));
		khaiTuBtn.setBackground(Color.decode("#409EFF"));
		khaiTuBtn.setBorderPainted(false);

		khaiTuBtn.setBounds(646, 10, 130, 30);
		khaiTuBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		khaiTuBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				khaiTuBtnActionPerformed(evt);
			}
		});
		panel.add(khaiTuBtn);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 90, 786, 493);
		add(panel_1);
		panel_1.setLayout(null);

		tablePanel = new JPanel();
		tablePanel.setBounds(10, 63, 766, 420);
		tablePanel.setBackground(new Color(255, 255, 255));
		tablePanel.setLayout(null);
		panel_1.add(tablePanel);

		jtfSearch = new JTextField("Search");
		jtfSearch.setBounds(10, 10, 766, 43);
		panel_1.add(jtfSearch);
		jtfSearch.setSelectionColor(new Color(204, 153, 255));
		jtfSearch.setForeground(Color.GRAY);
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfSearch.setColumns(10);
		jtfSearch.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new EmptyBorder(0, 10, 0, 0)));
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
	}// </editor-fold>//GEN-END:initComponents

	private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addNewBtnActionPerformed
		NewPeopleFrame addNewPeopleFrame = new NewPeopleFrame(this.controller, this.parentJFrame);
		addNewPeopleFrame.setLocationRelativeTo(null);
		addNewPeopleFrame.setResizable(false);
		addNewPeopleFrame.setVisible(true);
	}// GEN-LAST:event_addNewBtnActionPerformed

	private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editBtnActionPerformed
		EditPeopleFrame editPeopleFrame = new EditPeopleFrame(this.controller, this.parentJFrame);
		editPeopleFrame.setLocationRelativeTo(null);
		editPeopleFrame.setResizable(false);
		editPeopleFrame.setVisible(true);
	}// GEN-LAST:event_editBtnActionPerformed

	private void tamVangBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tamVangBtnActionPerformed
		TempAbsenceDFrame tempAbsenceDFrame = new TempAbsenceDFrame(this.parentJFrame);
		tempAbsenceDFrame.setLocationRelativeTo(null);
		tempAbsenceDFrame.setResizable(false);
		tempAbsenceDFrame.setVisible(true);
	}// GEN-LAST:event_tamVangBtnActionPerformed

	private void tamTruBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tamTruBtnActionPerformed
		TempResidenceDFrame tempResidenceDFrame = new TempResidenceDFrame(this.parentJFrame);
		tempResidenceDFrame.setLocationRelativeTo(null);
		tempResidenceDFrame.setResizable(false);
		tempResidenceDFrame.setVisible(true);
	}// GEN-LAST:event_tamTruBtnActionPerformed

	private void khaiTuBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_khaiTuBtnActionPerformed
		DeathCertiFrame deathCertiFrame = new DeathCertiFrame(this.parentJFrame);
		deathCertiFrame.setLocationRelativeTo(null);
		deathCertiFrame.setResizable(false);
		deathCertiFrame.setVisible(true);
	}// GEN-LAST:event_khaiTuBtnActionPerformed

	private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtfSearchActionPerformed
	}// GEN-LAST:event_jtfSearchActionPerformed
}
