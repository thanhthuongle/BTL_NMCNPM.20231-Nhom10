package views.PeopleManagerFrame;

import controllers.NhanKhauManagerController.TieuSuController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;

import beans.NhanKhauBean;

import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.Font;


public class ProfileFrame extends javax.swing.JFrame {

    private JFrame parentFrame;
    private NhanKhauBean nhanKhauBean;
    private TieuSuController controller;
    
    public ProfileFrame(JFrame parentFrame, NhanKhauBean nhanKhauBean) {
    	getContentPane().setBackground(new Color(255, 255, 255));
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.parentFrame = parentFrame;
        this.nhanKhauBean = nhanKhauBean;
        this.setTitle("Tiểu sử");
        parentFrame.setEnabled(false);
        this.controller = new TieuSuController(tieuSuPanel, giaDinhPanel, nhanKhauBean);
        jPanel1.setLayout(null);
        jPanel1.add(cancelBtn);
        jPanel1.add(acceptBtn);
        jPanel1.add(giaDinhPanel);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel1);
        jPanel1.add(tieuSuPanel);
        this.controller.setDataTable();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Close();
            }
        });
    }

    public void Close() {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!", JOptionPane.YES_NO_OPTION)) {
            this.parentFrame.setEnabled(true);
            dispose();
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tieuSuPanel = new javax.swing.JPanel();
        tieuSuPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tieuSuPanel.setBackground(new Color(255, 255, 255));
        tieuSuPanel.setBounds(10, 47, 675, 190);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(10, 10, 143, 27);
        giaDinhPanel = new javax.swing.JPanel();
        giaDinhPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        giaDinhPanel.setBackground(new Color(255, 255, 255));
        giaDinhPanel.setBounds(10, 319, 675, 190);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(10, 275, 143, 27);
        acceptBtn = new javax.swing.JButton();
        acceptBtn.setBounds(531, 532, 120, 30);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.setBounds(388, 532, 120, 30);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 248, 255));

        javax.swing.GroupLayout tieuSuPanelLayout = new javax.swing.GroupLayout(tieuSuPanel);
        tieuSuPanel.setLayout(tieuSuPanelLayout);
        tieuSuPanelLayout.setHorizontalGroup(
            tieuSuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        tieuSuPanelLayout.setVerticalGroup(
            tieuSuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jLabel1.setText("Tiểu sử:");

        javax.swing.GroupLayout giaDinhPanelLayout = new javax.swing.GroupLayout(giaDinhPanel);
        giaDinhPanel.setLayout(giaDinhPanelLayout);
        giaDinhPanelLayout.setHorizontalGroup(
            giaDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        giaDinhPanelLayout.setVerticalGroup(
            giaDinhPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jLabel2.setText("Gia đình:");

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
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 699, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        Close();
    }
    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Save?", "Confirm", JOptionPane.YES_NO_OPTION)) {
            this.controller.changeData();
            this.parentFrame.setEnabled(true);
            dispose();
        }
    }
    
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel giaDinhPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel tieuSuPanel;
   
}