package views.DonationsManagerFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import beans.PhiUngHoBean;
import controllers.DonationsController;
import controllers.DonationsManagerController.StatisticDonationsController;
import models.DonationsModel;

public class StatisticDonationsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private StatisticDonationsController controller;
	private JFrame parentFrame;
	private PhiUngHoBean selectedDonation;
	private DonationsModel donationsModel;
	
	private DonationsController rootController;

	private JPanel tablePanel;
	private JTextField jtfSearch;
	private JButton filterBtn;;
	private JComboBox<String> selectStateJcb;
	private JLabel summaryLbl;
	private JButton payBtn;

	public StatisticDonationsFrame(JFrame parentFrame, PhiUngHoBean selectedDonation, DonationsController rootController) {
		this.parentFrame = parentFrame;
		this.selectedDonation = selectedDonation;
		this.donationsModel = selectedDonation.getDonationModel();
		this.rootController = rootController;

		init();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		parentFrame.setEnabled(false);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm",
						JOptionPane.YES_NO_OPTION) == 0) {
					parentFrame.setEnabled(true);
					rootController.refreshData();
					dispose();
				}
			}
		});

		controller = new StatisticDonationsController(tablePanel, jtfSearch, selectStateJcb, selectedDonation, summaryLbl);
		controller.setParentJFrame(parentFrame);
		controller.setData();
	}

	private void init() {
		this.setTitle(this.donationsModel.getTen_khoan_thu());
		setBounds(100, 100, 909, 531);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBounds(5, 5, 1100, 1100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		jPanel1.setBounds(10, 10, 875, 474);
		jPanel1.setLayout(null);
		contentPane.add(jPanel1);

		jtfSearch = new JTextField("Search");
		jtfSearch.setSelectionColor(new Color(204, 153, 255));
		jtfSearch.setForeground(Color.GRAY);
		jtfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfSearch.setColumns(10);
		jtfSearch.setBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null),
						new EmptyBorder(0, 10, 0, 0)));
		jtfSearch.setBounds(10, 67, 600, 43);
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
		jPanel1.add(jtfSearch);

		tablePanel = new JPanel();
		tablePanel.setBounds(10, 120, 855, 344);
		tablePanel.setBackground(new Color(255, 255, 255));
		tablePanel.setLayout(null);
		jPanel1.add(tablePanel);
		
		selectStateJcb = new JComboBox<String>();
		selectStateJcb.setForeground(Color.BLACK);
		selectStateJcb.setBackground(new Color(255, 255, 255));
		selectStateJcb.setFont(new Font("Tahoma", Font.BOLD, 15));
		selectStateJcb.setBounds(620, 67, 117, 43);
		selectStateJcb.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Tất cả", "Đã nộp"}
			)
		);
		jPanel1.add(selectStateJcb);
		
		filterBtn = new JButton("Lọc");
		filterBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
		filterBtn.setForeground(new Color(255, 255, 255));
		filterBtn.setBackground(new Color(102, 102, 255));
		filterBtn.setBorderPainted(false);
		filterBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		filterBtn.setBounds(747, 67, 118, 43);
		filterBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				filterBtnActioPerformed();
			}
		});
        jPanel1.add(filterBtn);
        
        summaryLbl = new JLabel("New label");
        summaryLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        summaryLbl.setBorder(new EmptyBorder(0, 30, 0, 0));
        summaryLbl.setBounds(10, 10, 727, 47);
        jPanel1.add(summaryLbl);
        payBtn = new JButton("Nộp");
        payBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                payBtnActionPerformed(e);
            }
        });
        payBtn.setForeground(Color.WHITE);
        payBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        payBtn.setBorderPainted(false);
        payBtn.setBorder(new LineBorder(new Color(153, 102, 255), 4, true));
        payBtn.setBackground(new Color(102, 102, 255));
        payBtn.setBounds(747, 10, 118, 45);
        jPanel1.add(payBtn);
    }

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
    private void filterBtnActioPerformed() {
        this.controller.filterDonation(selectedDonation.getDonationModel(),selectStateJcb.getSelectedItem().toString());
    }
    private void payBtnActionPerformed(ActionEvent evt) {
        PayDonationFrame payDonationFrame = new PayDonationFrame(this.controller, this.parentFrame, this.selectedDonation);
        payDonationFrame.setLocationRelativeTo(null);
        payDonationFrame.setResizable(false);
        payDonationFrame.setVisible(true);
    }
   
}
