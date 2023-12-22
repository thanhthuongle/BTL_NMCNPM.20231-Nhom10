package views.HouseholdManagerFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import beans.HoKhauBean;
import beans.MemOfFamily;
import beans.NhanKhauBean;
import controllers.HouseholdPanelController;
import controllers.HoKhauManagerController.SuaController;
import models.AddressModel;
import models.ThanhVienCuaHoModel;
import services.CitizenIdService;
import utils.SuggestionUtility;
import views.AddressSuggestion;

public class EditHouseholdFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	
	private HouseholdPanelController parentController;
	private JFrame parentFrame;
	private AddressSuggestion addrSuggestion;
    private AddressModel addrModel = new AddressModel();
    private JTextField JtxReceiveAddress;
    
	private JPanel contentPane;
    private JTextField maHoKhauJtf;
    private JTextField maKhuVucJtf;
    private JPanel memTableJpn;
    private JTextField ngaySinhChuHoJtf;
    private JButton saveBtn;
    private JButton selectBtn;
    private JTextField soCMTChuHo;
    private JTextField soCMTChuHo_1;
    private JTextField tenChuHoJtf;
    private JButton cancelBtn;
    private SuggestionUtility diaChiJtf;
    private JButton editBtn;
    private NhanKhauBean chuHo = new NhanKhauBean();
    private final List<MemOfFamily> list = new ArrayList<MemOfFamily>();
    private SuaController controller;
    private HoKhauBean hoKhauBean;
    
    public EditHouseholdFrame(JFrame parentJFrame) {
    	init();
        this.parentController = new HouseholdPanelController(){
            @Override
            public void refreshData() {
            }

            @Override
            public void initAction() {
            }
        };
        
        this.parentFrame = parentJFrame;
        //this.parentFrame.setEnabled(false);
        this.hoKhauBean = new HoKhauBean();
        controller = new SuaController();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    close();
            }
            
        });
    }


	/**
	 * @wbp.parser.constructor
	 */
 
	public EditHouseholdFrame(HouseholdPanelController parentController, JFrame parentJFrame) {
		init();
		this.parentController = parentController;
        this.parentFrame = parentJFrame;
        //this.parentFrame.setEnabled(false);
        this.hoKhauBean = new HoKhauBean();
        controller = new SuaController();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });

		setDataThanhVien();
	}
	
	private void init() {
		setTitle("Sửa hộ khẩu");
		setBounds(350, 200, 670, 785);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(new Color(230, 230, 250));
		jPanel2.setBounds(10, 10, 636, 728);
		contentPane.add(jPanel2);
		jPanel2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 23, 600, 53);
		jPanel2.add(panel);
		panel.setLayout(null);
		
		JLabel jLabel1 = new JLabel("Mã hộ khẩu");
		jLabel1.setBounds(10, 10, 174, 33);
		panel.add(jLabel1);
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		maHoKhauJtf = new JTextField();
		maHoKhauJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
        maHoKhauJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maHoKhauJtfActionPerformed(evt);
            }
        });
		maHoKhauJtf.setBounds(190, 10, 392, 33);
		panel.add(maHoKhauJtf);
		maHoKhauJtf.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(10, 86, 600, 53);
		jPanel2.add(panel_1);
		
		JLabel jLabel3 = new JLabel("Mã khu vực");
		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel3.setBounds(10, 10, 174, 33);
		panel_1.add(jLabel3);
		
		maKhuVucJtf = new JTextField();
		maKhuVucJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
        maKhuVucJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKhuVucJtfActionPerformed(evt);
            }
        });
		maKhuVucJtf.setColumns(10);
		maKhuVucJtf.setBounds(190, 10, 392, 33);
		panel_1.add(maKhuVucJtf);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(10, 149, 600, 53);
		jPanel2.add(panel_2);
		
		JLabel jLabel5 = new JLabel("Địa chỉ");
		jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel5.setBounds(10, 10, 174, 33);
		panel_2.add(jLabel5);
		
		
        diaChiJtf = new SuggestionUtility(false) {
			private static final long serialVersionUID = 1L;

			@Override
			public List<String> getSuggestions(String textContent) {
				return null;
			}
		};
        diaChiJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		diaChiJtf.setEditable(false);
		diaChiJtf.setColumns(10);
		diaChiJtf.setBounds(190, 11, 359, 33);
		diaChiJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaChiJtfActionPerformed(evt);
            }
        });
		panel_2.add(diaChiJtf);
		JButton diaChiBtn = new JButton("+");

		diaChiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JtxReceiveAddress= diaChiJtf;
				getAddressAction();

			}
		});
		diaChiBtn.setBounds(553, 11, 26, 33);
		panel_2.add(diaChiBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(240, 248, 255));
		panel_3.setBounds(10, 212, 600, 53);
		jPanel2.add(panel_3);
		
		JLabel jLabel1_3 = new JLabel("Chủ hộ");
		jLabel1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel1_3.setBounds(10, 10, 79, 33);
		panel_3.add(jLabel1_3);
		
		tenChuHoJtf = new JTextField();
		tenChuHoJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tenChuHoJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenChuHoJtfActionPerformed(evt);
            }
        });
		tenChuHoJtf.setColumns(10);
		tenChuHoJtf.setBounds(190, 10, 387, 33);
		panel_3.add(tenChuHoJtf);
		
		selectBtn = new JButton("Chọn");
        selectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });
		selectBtn.setBorderPainted(false);
		selectBtn.setBounds(99, 14, 83, 27);
		selectBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
		selectBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		selectBtn.setForeground(new Color(255, 255, 255));
		selectBtn.setBackground(new Color(147, 112, 219));
		panel_3.add(selectBtn);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(240, 248, 255));
		panel_4.setBounds(10, 275, 600, 53);
		jPanel2.add(panel_4);
		
		JLabel jLabel7 = new JLabel("Ngày sinh chủ hộ");
		jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel7.setBounds(10, 10, 174, 33);
		panel_4.add(jLabel7);
		
		ngaySinhChuHoJtf = new JTextField();
		ngaySinhChuHoJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ngaySinhChuHoJtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngaySinhChuHoJtfActionPerformed(evt);
            }
        });

		ngaySinhChuHoJtf.setHorizontalAlignment(SwingConstants.LEFT);
		ngaySinhChuHoJtf.setColumns(10);
		ngaySinhChuHoJtf.setBounds(190, 10, 385, 33);
		panel_4.add(ngaySinhChuHoJtf);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(240, 248, 255));
		panel_5.setBounds(10, 338, 600, 53);
		jPanel2.add(panel_5);
		
		JLabel jLabel1_5 = new JLabel("Số CMT chủ hộ");
		jLabel1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel1_5.setBounds(10, 10, 174, 33);
		panel_5.add(jLabel1_5);
		
		soCMTChuHo = new JTextField();
		soCMTChuHo.setFont(new Font("Tahoma", Font.BOLD, 15));
        soCMTChuHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soCMTChuHoActionPerformed(evt);
            }
        });
		soCMTChuHo.setColumns(10);
		soCMTChuHo_1 = new SuggestionUtility(false) {
			
			@Override
			public List<String> getSuggestions(String textContent) {
				CitizenIdService cidService = new CitizenIdService();
				return cidService.search(textContent);
			}
		};
		soCMTChuHo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		soCMTChuHo_1.setBounds(190, 10, 386, 33);
		panel_5.add(soCMTChuHo_1);
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(new Color(240, 248, 255));
		jPanel1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jPanel1.setBorder(new TitledBorder(null, "Thành viên chủ hộ", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18)));
		jPanel1.setBounds(10, 401, 600, 248);
		jPanel2.add(jPanel1);
		jPanel1.setLayout(null);
		
		editBtn = new JButton("Sửa");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
		editBtn.setForeground(new Color(255, 255, 255));
		editBtn.setBackground(new Color(147, 112, 219));
		editBtn.setBorderPainted(false);
		editBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		editBtn.setBounds(10, 36, 94, 27);
		jPanel1.add(editBtn);
		
		memTableJpn = new JPanel();
		memTableJpn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		memTableJpn.setBackground(new Color(255, 255, 255));
		memTableJpn.setBounds(10, 73, 572, 146);
		jPanel1.add(memTableJpn);
		
		cancelBtn = new JButton("Hủy");
		cancelBtn.setBackground(new Color(147, 112, 219));
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelBtn.setBorderPainted(false);
		cancelBtn.setBounds(376, 669, 90, 30);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
		jPanel2.add(cancelBtn);
		
		saveBtn = new JButton("Lưu");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
		saveBtn.setBackground(new Color(147, 112, 219));
		saveBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		saveBtn.setForeground(new Color(255, 255, 255));
		saveBtn.setBorderPainted(false);
		saveBtn.setBounds(495, 669, 90, 30);
		jPanel2.add(saveBtn);
	}
	
    private void close() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure to close??", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            //this.parentFrame.setEnabled(true);
            dispose();
        }
    }
	
    public void setDataChuHo() {
        this.tenChuHoJtf.setText(this.chuHo.getNhanKhauModel().getHoTen());
        this.ngaySinhChuHoJtf.setText(this.chuHo.getNhanKhauModel().getNamSinh().toString());
        this.soCMTChuHo_1.setText(this.chuHo.getChungMinhThuModel().getSoCMT());
    }

    public void setDataThanhVien() {
        this.controller.setData(this.list, this.memTableJpn);
    }
    
    private void maHoKhauJtfActionPerformed(java.awt.event.ActionEvent evt) {
    }
    

    private void maKhuVucJtfActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void diaChiJtfActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {
        ChooseEditPeople chooseEditPeople = new ChooseEditPeople(this.chuHo, this);
        chooseEditPeople.setLocationRelativeTo(null);
        chooseEditPeople.setResizable(false);
        chooseEditPeople.setVisible(true);
    }
    private void tenChuHoJtfActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ngaySinhChuHoJtfActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void soCMTChuHoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        close();
    }

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {
        ChangeEditListPeopleJframe changeEditListPeopleJframe = new ChangeEditListPeopleJframe(list, this);
        changeEditListPeopleJframe.setLocationRelativeTo(null);
        changeEditListPeopleJframe.setResizable(false);
        changeEditListPeopleJframe.setVisible(true);
    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.maHoKhauJtf.getText().trim().isEmpty() 
                || this.maKhuVucJtf.getText().trim().isEmpty()
                || this.diaChiJtf.getText().trim().isEmpty()
                || this.chuHo.getNhanKhauModel().getHoTen() == null
                || this.list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập hết các thông tin bắt buộc", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            this.hoKhauBean.setChuHo(chuHo.getNhanKhauModel());
            this.list.forEach(person -> {
                ThanhVienCuaHoModel temp = new ThanhVienCuaHoModel();
                temp.setIdNhanKhau(person.getNhanKhau().getNhanKhauModel().getID());
                temp.setQuanHeVoiChuHo(person.getThanhVienCuaHoModel().getQuanHeVoiChuHo());
                this.hoKhauBean.getListThanhVienCuaHo().add(temp);
            });
            this.hoKhauBean.getHoKhauModel().setMaHoKhau(maHoKhauJtf.getText().trim());
            this.hoKhauBean.getHoKhauModel().setMaKhuVuc(maKhuVucJtf.getText().trim());
            this.hoKhauBean.getHoKhauModel().setDiaChi(diaChiJtf.getText().trim());
            try {
                if (this.controller.editHoKhau(this.hoKhauBean, parentController.getSelectedIdHoKhau())) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công!!");
                    close();
                    parentController.refreshData();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void getAddressAction() {
		addrSuggestion = new AddressSuggestion(this,addrModel) {
			private static final long serialVersionUID = 1L;

			@Override
			public void emmitToParent() {
				String address= this.getAddress();
				JtxReceiveAddress.setText(address);
			}
		};
		addrSuggestion.setVisible(true);
    }
}