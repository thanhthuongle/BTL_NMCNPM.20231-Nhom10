package views.HouseholdManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import beans.MemOfFamily;
import controllers.HoKhauManagerController.ChangeListPeopleController;

public class ChangeListPeopleJframe extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<MemOfFamily> listMember;
    private List<MemOfFamily> listMemberTemp;
    private ChangeListPeopleController controller;
    private JFrame parentJframe;

    public ChangeListPeopleJframe(List<MemOfFamily> listMember, JFrame parentJFrame) {
    	getContentPane().setBackground(new Color(255, 255, 255));
        initComponents();
        this.setTitle("Sửa danh sách");
        this.listMember = listMember;
        this.listMemberTemp = new ArrayList<MemOfFamily>();
        this.listMemberTemp.addAll(listMember);
        this.parentJframe = parentJFrame;
        this.controller = new ChangeListPeopleController(this.listMemberTemp, addBtn, removeBtn, searchJtf, PeopleTableJpn, MemTableJpn);
        MemTableJpn.setLayout(null);
        PeopleTableJpn.setLayout(null);
        this.parentJframe.setEnabled(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
            
        });
    }
    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            this.parentJframe.setEnabled(true);
            dispose();
        }
    }
    
    @SuppressWarnings("unchecked")

    private void initComponents() {


        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        JPanel Jpanel1 = new JPanel();
        Jpanel1.setBackground(new Color(230, 230, 250));

   
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(Jpanel1, GroupLayout.PREFERRED_SIZE, 1012, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(Jpanel1, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        			.addContainerGap())
        );
        Jpanel1.setLayout(null);
        searchJtf = new javax.swing.JTextField();
        searchJtf.setBounds(64, 26, 501, 37);
        searchJtf.setForeground(Color.GRAY);
        searchJtf.setForeground(new Color(192, 192, 192));
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
		searchJtf.setSelectionColor(new Color(186, 85, 211));
		searchJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchJtf.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 102, 255), null, null, null), new EmptyBorder(0, 10, 0, 0)));
		searchJtf.setColumns(10);
        Jpanel1.add(searchJtf);
        
        searchJtf.setFont(new java.awt.Font("Tohama", 1, 15));
                PeopleTableJpn = new javax.swing.JPanel();
                PeopleTableJpn.setBounds(24, 93, 444, 470);
                Jpanel1.add(PeopleTableJpn);
                PeopleTableJpn.setBackground(new Color(255, 255, 255));
                
                addBtn = new javax.swing.JButton();
                addBtn.setBounds(490, 112, 51, 25);
                Jpanel1.add(addBtn);
                addBtn.setText(">>");
                addBtn.setForeground(Color.WHITE);
                addBtn.setBorderPainted(false);
                addBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
                addBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
                addBtn.setForeground(new Color(255, 255, 255));
                addBtn.setBackground(new Color(147, 112, 219));
                addBtn.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                
                        addBtn.setFont(new java.awt.Font("Tohama", 1, 15)); 
                        addBtn.setText(">>");
                        
                        
                        removeBtn = new javax.swing.JButton();
                        removeBtn.setBounds(490, 160, 51, 25);
                        Jpanel1.add(removeBtn);
                        removeBtn.setText("<<");
                        removeBtn.setForeground(Color.WHITE);
                        removeBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
                        removeBtn.setBorderPainted(false);
                        removeBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
                        removeBtn.setBackground(new Color(147, 112, 219));
                        removeBtn.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        
                                removeBtn.setFont(new java.awt.Font("Tohama", 1, 15)); 
                                removeBtn.setText("<<");
                                saveBtn = new javax.swing.JButton();
                                saveBtn.setBounds(740, 26, 140, 37);
                                Jpanel1.add(saveBtn);
                                saveBtn.setForeground(Color.WHITE);
                                saveBtn.setBorderPainted(false);
                                saveBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
                                saveBtn.setBackground(new Color(147, 112, 219));
                                saveBtn.setFont(new Font("Tahoma", Font.BOLD, 16)); 
                                saveBtn.setText("Lưu thay đổi");
                                MemTableJpn = new javax.swing.JPanel();
                                MemTableJpn.setBounds(563, 93, 430, 470);
                                Jpanel1.add(MemTableJpn);
                                MemTableJpn.setBackground(new Color(255, 255, 255));
                                saveBtn.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        saveBtnActionPerformed(evt);
                                    }
                                });
        getContentPane().setLayout(layout);

        pack();
    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.listMember.clear();
        this.listMember.addAll(this.listMemberTemp);
        NewHouseholdFrame themMoiHoKhau = (NewHouseholdFrame)this.parentJframe;
        themMoiHoKhau.setDataThanhVien();
        close();
    }
    private javax.swing.JPanel MemTableJpn;
    private javax.swing.JPanel PeopleTableJpn;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField searchJtf;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton saveBtn;
}