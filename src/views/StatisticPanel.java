package views;

import controllers.StatisticPanelController;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class StatisticPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	private javax.swing.ButtonGroup GenderChoose;
	private javax.swing.JComboBox<String> GenderJcb;
	private javax.swing.JComboBox<String> StatusJcb;
	private javax.swing.JTextField denNamJtf;
	private javax.swing.JTextField denTuoiJtf;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.ButtonGroup statusChoose;
	private javax.swing.JTextField tuNamJtf;
	private javax.swing.JTextField tuTuoiJtf;

	private JFrame parentFrame;
	private StatisticPanelController controller;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel tableJpn;
	private JPanel panel_3;

	public StatisticPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		init();
		this.controller = new StatisticPanelController(GenderJcb, StatusJcb, tuTuoiJtf, denTuoiJtf, tuNamJtf, denNamJtf,
				tableJpn);
		this.controller.setDataTable();
	}

	private void init() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(new Color(249, 250, 254));
		setBounds(0, 0, 806, 593);
		setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBounds(10, 10, 786, 146);
		panel_1.setLayout(null);
		add(panel_1);

		jLabel7 = new javax.swing.JLabel("Giới tính");
		jLabel7.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setBounds(10, 20, 100, 30);
		panel_1.add(jLabel7);

		GenderJcb = new javax.swing.JComboBox<String>();
		GenderJcb.setBounds(120, 20, 130, 30);
		GenderJcb.setFont(new Font("Tahoma", Font.BOLD, 13));
		GenderJcb.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Toàn bộ", "Nam", "Nữ" }));
		panel_1.add(GenderJcb);

		jLabel1 = new javax.swing.JLabel("Tình trạng:");
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setBounds(300, 20, 100, 30);
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(jLabel1);

		StatusJcb = new javax.swing.JComboBox<String>();
		StatusJcb.setBounds(410, 20, 130, 30);
		StatusJcb.setFont(new Font("Tahoma", Font.BOLD, 13));
		StatusJcb.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { "Toàn bộ", "Thường trú", "Tạm trú", "Tạm vắng" }));
		panel_1.add(StatusJcb);

		jButton1 = new javax.swing.JButton("Show");
		jButton1.setFont(new Font("Tahoma", Font.BOLD, 13));
		jButton1.setBounds(646, 20, 130, 30);
		jButton1.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		jButton1.setForeground(new Color(255, 255, 255));
		jButton1.setBackground(Color.decode("#409EFF"));
		jButton1.setBorderPainted(false);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		panel_1.add(jButton1);

		panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(0, 0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 73, 766, 63);
		panel_3.setLayout(null);
		panel_1.add(panel_3);

		jLabel2 = new JLabel("Độ tuổi");
		jLabel2.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setBounds(10, 20, 100, 30);
		panel_3.add(jLabel2);

		jLabel3 = new JLabel("Từ");
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setBounds(110, 20, 50, 30);
		jLabel3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(jLabel3);

		tuTuoiJtf = new JTextField();
		tuTuoiJtf.setFont(new java.awt.Font("Tahoma", 0, 15));
		tuTuoiJtf.setBounds(160, 20, 70, 30);
		panel_3.add(tuTuoiJtf);

		jLabel4 = new javax.swing.JLabel("đến");
		jLabel4.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setBounds(240, 20, 50, 30);
		panel_3.add(jLabel4);

		denTuoiJtf = new JTextField();
		denTuoiJtf.setFont(new java.awt.Font("Tahoma", 0, 15));
		denTuoiJtf.setBounds(290, 21, 70, 30);
		panel_3.add(denTuoiJtf);

		jLabel9 = new JLabel("Năm:");
		jLabel9.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setBounds(406, 20, 100, 30);
		panel_3.add(jLabel9);

		jLabel10 = new JLabel("Từ");
		jLabel10.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel10.setBounds(506, 20, 50, 30);
		panel_3.add(jLabel10);

		tuNamJtf = new JTextField();
		tuNamJtf.setFont(new java.awt.Font("Tahoma", 0, 15));
		tuNamJtf.setBounds(556, 20, 70, 30);
		panel_3.add(tuNamJtf);

		jLabel11 = new JLabel("đến");
		jLabel11.setFont(new Font("Tahoma", Font.BOLD, 13));
		jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel11.setBounds(636, 20, 50, 30);
		panel_3.add(jLabel11);

		denNamJtf = new JTextField();
		denNamJtf.setFont(new java.awt.Font("Tahoma", 0, 14));
		denNamJtf.setBounds(686, 20, 80, 30);
		panel_3.add(denNamJtf);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 166, 786, 417);
		add(panel_2);

		tableJpn = new JPanel();
		tableJpn.setLayout(null);
		tableJpn.setBackground(Color.WHITE);
		tableJpn.setBounds(10, 10, 766, 397);
		panel_2.add(tableJpn);

		GenderChoose = new javax.swing.ButtonGroup();
		statusChoose = new javax.swing.ButtonGroup();
		jLabel6 = new javax.swing.JLabel();
		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15));
		jLabel6.setBounds(729, 105, 0, 30);
		add(jLabel6);

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.controller.setData();
	}

}
