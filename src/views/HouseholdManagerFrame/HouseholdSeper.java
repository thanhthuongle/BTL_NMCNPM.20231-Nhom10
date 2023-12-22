package views.HouseholdManagerFrame;
//khong hien thi het nhu ben chuyen noi o

import controllers.HoKhauManagerController.TachHoKhauController;
import models.AddressModel;
import utils.SuggestionUtility;
import views.AddressSuggestion;

import java.awt.event.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

public class HouseholdSeper extends JFrame {

    private static final long serialVersionUID = 1L;
    private AddressSuggestion addrSuggestion;
    private AddressModel addrModel = new AddressModel();
    private JTextField JtxReceiveAddress;

    private TachHoKhauController controller;
    private JFrame parentJFrame;
    private JPanel contentPane;
    private JButton acceptBtn;
    private JButton addBtn;
    private JButton cancelBtn;
    private JTextField chuHoHienTaiJtf;
    private JTextField chuHoMoiJtf;
    private SuggestionUtility diaChiJtf;
    private JLabel jLabel1;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField maHoKhauMoiJtf;
    private JTextField maKhuVucJtf;
    private JButton removeBtn;
    private JTextField searchJtf;
    private JPanel tableBotJpn;
    private JPanel tableRigthJtf;
    private JPanel tableTopJpn;
    private JPanel panelMahk;


    public JFrame getParentJFrame() {
        return parentJFrame;
    }

    public HouseholdSeper(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
        init();
        controller = new TachHoKhauController(this);
        controller.setAcceptBtn(acceptBtn);
        controller.setAddBtn(addBtn);
        controller.setCancelBtn(cancelBtn);
        controller.setChuHoHienTaiJtf(chuHoHienTaiJtf);
        controller.setChuHoMoiJtf(chuHoMoiJtf);
        controller.setDiaChiJtf(diaChiJtf);
        controller.setMaHoKhauMoiJtf(maHoKhauMoiJtf);
        controller.setMaKhuVucJtf(maKhuVucJtf);
        controller.setRemoveBtn(removeBtn);
        controller.setSearchJtf(searchJtf);
        controller.setTableBotJpn(tableBotJpn);
        controller.setTableRightJpn(tableRigthJtf);
        controller.setTableTopJpn(tableTopJpn);

        panelMahk = new JPanel();
        panelMahk.setBounds(27, 15, 170, 30);
        panelMahk.setBackground(new Color(240, 248, 255));
        jPanel2.add(panelMahk);
        jLabel2 = new JLabel();
        panelMahk.add(jLabel2);

        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabel2.setText("Nhập mã hộ khẩu");
        controller.init();
    }

    private void init() {
        this.setResizable(false);
        this.setTitle("Tách hộ khẩu");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(350, 200, 1000, 670);
        this.setLocationRelativeTo(null);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }

        });
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        setContentPane(contentPane);

        jPanel2 = new JPanel();
        jPanel2.setBounds(10, 10, 966, 615);
        tableTopJpn = new JPanel();
        tableTopJpn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tableTopJpn.setBounds(10, 85, 355, 205);
        jPanel1 = new JPanel();
        jPanel1.setBounds(394, 85, 562, 205);
        jLabel4 = new JLabel();
        jLabel4.setBounds(10, 10, 116, 33);
        chuHoHienTaiJtf = new JTextField();
        chuHoHienTaiJtf.setBounds(136, 10, 382, 32);
        jLabel5 = new JLabel();
        jLabel5.setBounds(10, 161, 116, 33);
        chuHoMoiJtf = new JTextField();
        chuHoMoiJtf.setBounds(136, 164, 382, 32);
        chuHoMoiJtf.setBackground(new Color(255, 255, 255));
        jLabel6 = new JLabel();
        jLabel6.setBounds(528, 9, 19, 30);
        jLabel7 = new JLabel();
        jLabel7.setBounds(528, 157, 19, 30);
        jLabel12 = new JLabel();
        jLabel12.setBounds(528, 46, 19, 30);
        jLabel13 = new JLabel();
        jLabel13.setBounds(10, 50, 116, 33);
        maKhuVucJtf = new JTextField();
        maKhuVucJtf.setBounds(136, 49, 382, 32);
        jLabel14 = new JLabel();
        jLabel14.setBounds(10, 87, 116, 33);


        diaChiJtf = new SuggestionUtility(false) {
            private static final long serialVersionUID = 1L;

            @Override
            public List<String> getSuggestions(String textContent) {
                return null;
            }
        };
        diaChiJtf.setEditable(false);
        diaChiJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
        diaChiJtf.setBounds(136, 88, 361, 32);
        JButton diachiBtn = new JButton("+");

        diachiBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JtxReceiveAddress = diaChiJtf;
                getAddressAction();

            }
        });
        diachiBtn.setBounds(498, 90, 20, 30);

        jPanel1.add(diachiBtn);


        jLabel15 = new JLabel();
        jLabel15.setBounds(528, 83, 19, 30);
        jLabel16 = new JLabel();
        jLabel16.setBounds(10, 123, 116, 33);
        maHoKhauMoiJtf = new JTextField();
        maHoKhauMoiJtf.setBounds(136, 126, 382, 32);
        jLabel17 = new JLabel();
        jLabel17.setBounds(528, 120, 19, 30);
        jLabel1 = new JLabel();
        jLabel1.setBounds(10, 55, 170, 30);
        searchJtf = new JTextField();
        tableBotJpn = new JPanel();
        tableBotJpn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tableBotJpn.setBounds(27, 350, 355, 205);
        jLabel3 = new JLabel();
        jLabel3.setBounds(10, 310, 225, 30);
        tableRigthJtf = new JPanel();
        tableRigthJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tableRigthJtf.setBounds(480, 342, 476, 205);
        jLabel18 = new JLabel();
        jLabel18.setBounds(480, 310, 225, 30);
        addBtn = new JButton();
        addBtn.setBounds(394, 346, 60, 30);
        removeBtn = new JButton();

        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        removeBtn.setBounds(394, 400, 60, 30);
        acceptBtn = new JButton();
        cancelBtn = new JButton();


        jPanel2.setBackground(new Color(230, 230, 250));


        tableTopJpn.setBackground(new Color(255, 255, 255));

        jPanel1.setBackground(new Color(240, 248, 255));

        jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel4.setText("Chủ hộ hiện tại");

        chuHoHienTaiJtf.setBackground(new Color(255, 255, 255));
        chuHoHienTaiJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));

        jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel5.setText("Chủ hộ mới");

        chuHoMoiJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("(*)");

        jLabel7.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("(*)");

        jLabel12.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("(*)");

        jLabel13.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel13.setText("Mã khu vực");

        maKhuVucJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));

        jLabel14.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel14.setText("Địa chỉ");

        diaChiJtf.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));

        jLabel15.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("(*)");

        jLabel16.setFont(new Font("Tahoma", Font.PLAIN, 16));
        jLabel16.setText("Mã hộ khẩu mới");

        maHoKhauMoiJtf.setFont(new Font("Tahoma", Font.PLAIN, 16));

        jLabel17.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 15));
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("(*)");

        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabel1.setText("Chọn hộ cần tách");


        searchJtf.setForeground(new Color(0, 0, 0));
        searchJtf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchJtf.getText().trim().equals("Search")) {
                    searchJtf.setForeground(Color.black);
                    searchJtf.setText("");
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
        searchJtf.setBounds(259, 15, 652, 30);
        jPanel2.add(searchJtf);
        searchJtf.setColumns(10);

        tableBotJpn.setBackground(new Color(255, 255, 255));

        jLabel3.setFont(new Font("Tahoma", Font.BOLD, 16));

        jLabel3.setText("Chọn người sang hộ mới");

        tableRigthJtf.setBackground(new Color(255, 255, 255));

        jLabel18.setFont(new Font("Tahoma", Font.BOLD, 16));

        jLabel18.setText("Những người ở hộ mới");

        addBtn.setText(">>");
        addBtn.setBorderPainted(false);
        addBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        addBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        addBtn.setForeground(new Color(255, 255, 255));
        addBtn.setBackground(new Color(147, 112, 219));

        removeBtn.setText("<<");
        removeBtn.setForeground(new Color(255, 255, 255));
        removeBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        removeBtn.setBorderPainted(false);
        removeBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        removeBtn.setBackground(new Color(147, 112, 219));

        acceptBtn.setText("Xác nhận");
        acceptBtn.setBorderPainted(false);
        acceptBtn.setBounds(825, 560, 100, 36);
        acceptBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        acceptBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        acceptBtn.setForeground(new Color(255, 255, 255));
        acceptBtn.setBackground(new Color(147, 112, 219));
        acceptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Hủy");
        cancelBtn.setBorderPainted(false);
        cancelBtn.setBounds(700, 560, 100, 36);
        cancelBtn.setBorder(new LineBorder(new Color(186, 85, 211), 1, true));
        cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancelBtn.setForeground(new Color(255, 255, 255));
        cancelBtn.setBackground(new Color(147, 112, 219));


        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        tableTopJpn.getAccessibleContext().setAccessibleName("");

        contentPane.setLayout(null);

        jPanel2.setLayout(null);
        jPanel2.add(searchJtf);
        jPanel2.add(jLabel1);
        jPanel2.add(tableTopJpn);
        tableTopJpn.setLayout(null);
        jPanel2.add(tableBotJpn);
        tableBotJpn.setLayout(null);
        jPanel2.add(jLabel3);
        jPanel2.add(cancelBtn);
        jPanel2.add(acceptBtn);
        jPanel2.add(removeBtn);
        jPanel2.add(addBtn);
        jPanel2.add(jLabel18);
        jPanel2.add(tableRigthJtf);
        tableRigthJtf.setLayout(null);
        jPanel2.add(jPanel1);
        jPanel1.setLayout(null);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel13);
        jPanel1.add(jLabel14);
        jPanel1.add(jLabel16);
        jPanel1.add(chuHoHienTaiJtf);
        jPanel1.add(chuHoMoiJtf);
        jPanel1.add(maKhuVucJtf);
        jPanel1.add(diaChiJtf);
        jPanel1.add(maHoKhauMoiJtf);
        jPanel1.add(jLabel6);
        jPanel1.add(jLabel7);
        jPanel1.add(jLabel12);
        jPanel1.add(jLabel15);
        jPanel1.add(jLabel17);
        contentPane.add(jPanel2);

    }

    public void close() {
        if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure to close?", "Warning!!", JOptionPane.YES_NO_OPTION)) {
            this.parentJFrame.setEnabled(true);
            dispose();
        }
    }


    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        close();
    }

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void getAddressAction() {
        addrSuggestion = new AddressSuggestion(this, addrModel) {
            private static final long serialVersionUID = 1L;

            @Override
            public void emmitToParent() {
                String address = this.getAddress();
                JtxReceiveAddress.setText(address);
            }
        };
        addrSuggestion.setVisible(true);
    }


}