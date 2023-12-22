package views.HouseholdManagerFrame;

import controllers.HoKhauManagerController.ChoosePeopleController;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import beans.NhanKhauBean;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class ChoosePeople extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private NhanKhauBean nhanKhauBean;
    private NhanKhauBean nhanKhauBeanTemp;
    private JFrame parentJFrame;
    private final ChoosePeopleController controller;
    
   
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField searchJtf;
    private javax.swing.JTextField selectedJtf;
    private javax.swing.JPanel tableJpn;
   
    
    public ChoosePeople(NhanKhauBean nhanKhauBean, JFrame parentJframe) {
    	getContentPane().setBackground(new Color(255, 255, 255));
        initComponents();
        this.nhanKhauBean = nhanKhauBean;
        this.parentJFrame = parentJframe;
        this.nhanKhauBeanTemp = new NhanKhauBean();
        parentJframe.setEnabled(false);
        jPanel1.setLayout(null);
        controller = new ChoosePeopleController(this.nhanKhauBeanTemp, searchJtf, selectedJtf, tableJpn);
        jPanel1.add(tableJpn);
        jPanel1.add(searchJtf);
        jPanel1.add(selectedJtf);
        jPanel1.add(cancelBtn);
        jPanel1.add(confirmBtn);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentJframe.setEnabled(true);
                Close();
            }
            
        });
    }
    
    public void Close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }

    public NhanKhauBean getNhanKhauBean() {
        return nhanKhauBean;
    }

    public void setNhanKhauBean(NhanKhauBean nhanKhauBean) {
        this.nhanKhauBean = nhanKhauBean;
    }

    public JFrame getParentJFrame() {
        return parentJFrame;
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchJtf = new javax.swing.JTextField();
        searchJtf.setBounds(24, 10, 671, 35);
        searchJtf.setText("Search");
        tableJpn = new javax.swing.JPanel();
        tableJpn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tableJpn.setBounds(24, 67, 671, 241);
        tableJpn.setBackground(new Color(255, 255, 255));
        confirmBtn = new javax.swing.JButton();
        confirmBtn.setBounds(601, 329, 94, 35);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.setBounds(484, 329, 94, 35);
        selectedJtf = new javax.swing.JTextField();
        selectedJtf.setFont(new Font("Tahoma", Font.PLAIN, 15));
        selectedJtf.setBounds(24, 329, 419, 36);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(230, 230, 250));

   
        searchJtf.setForeground(Color.GRAY);
		searchJtf.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (searchJtf.getText().equals("Search")) {
		        	searchJtf.setText("");
		        	searchJtf.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (searchJtf.getText().isEmpty()) {
		        	searchJtf.setForeground(Color.GRAY);
		        	searchJtf.setText("Search");
		        }
		    }
		    });
		searchJtf.setSelectionColor(new Color(204, 153, 255));
		searchJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchJtf.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null), new EmptyBorder(0, 10, 0, 0)));
		searchJtf.setColumns(10);

        javax.swing.GroupLayout tableJpnLayout = new javax.swing.GroupLayout(tableJpn);
        tableJpn.setLayout(tableJpnLayout);
        tableJpnLayout.setHorizontalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableJpnLayout.setVerticalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

       confirmBtn.setText("Xác nhận");
       confirmBtn.setBorderPainted(false);
   
       confirmBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
       confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
       confirmBtn.setForeground(new Color(255, 255, 255));
       confirmBtn.setBackground(new Color(147, 112, 219));
       confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               confirmBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Hủy");
        cancelBtn.setBorderPainted(false);
        cancelBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancelBtn.setForeground(new Color(255, 255, 255));
        cancelBtn.setBackground(new Color(147, 112, 219));
        

        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });


        selectedJtf.setEnabled(false);
        selectedJtf.setBackground(new java.awt.Color(240, 248, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Close();
    }

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.nhanKhauBeanTemp.getNhanKhauModel().getHoTen() == null) {
            Close();
        }
        this.nhanKhauBean.setNhanKhauModel(this.nhanKhauBeanTemp.getNhanKhauModel());
        this.nhanKhauBean.setChungMinhThuModel(this.nhanKhauBeanTemp.getChungMinhThuModel());
        this.nhanKhauBean.setListGiaDinhModels(this.nhanKhauBeanTemp.getListGiaDinhModels());
        this.nhanKhauBean.setListTieuSuModels(this.nhanKhauBeanTemp.getListTieuSuModels());
        this.parentJFrame.setEnabled(true);
        NewHouseholdFrame themMoiHoKhau = (NewHouseholdFrame)this.parentJFrame;
        themMoiHoKhau.setDataChuHo();
        dispose();
    }

}
