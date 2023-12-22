package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

import controllers.FeesController;
import views.FeesManagerFrame.EditFeeFrame;
import views.FeesManagerFrame.NewFeeFrame;

public class FeesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private FeesController controller;

	private JFrame parentFrame;

	private JPanel tablePanel;
	private JTextField jtfSearch;
	private JButton addNewBtn;
	private JButton editBtn;

	public FeesPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		init();
		controller = new FeesController(tablePanel, jtfSearch);
		controller.setParentFrame(parentFrame);
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

		addNewBtn = new JButton("Mới");
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
	}

	private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {
		NewFeeFrame addNewFeeFrame = new NewFeeFrame(this.controller, this.parentFrame);
		addNewFeeFrame.setLocationRelativeTo(null);
		addNewFeeFrame.setResizable(false);
		addNewFeeFrame.setVisible(true);
	}

	private void editBtnActionPerformed(ActionEvent evt) {
		EditFeeFrame editFeeFrame = new EditFeeFrame(this.controller, this.parentFrame);
		editFeeFrame.setLocationRelativeTo(null);
		editFeeFrame.setResizable(false);
		editFeeFrame.setVisible(true);
	}

	private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {
	}
}
