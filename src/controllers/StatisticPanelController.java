package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import beans.NhanKhauBean;
import models.NhanKhauModel;
import services.PeopleService;
import services.StringService;
import utils.ClassTableModel;


public class StatisticPanelController {
    private JComboBox<String> GenderJcb;
    private JComboBox<String> StatusJcb;
    private JTextField tuTuoiJtf;
    private JTextField denTuoiJtf;
    private JTextField tuNamJtf;
    private JTextField denNamJtf;
    private JPanel jpnView;
    private PeopleService peopleService;
    private List<NhanKhauBean> listNhanKhauBeans;
    private ClassTableModel classTableModel;
    private final String[] COLUMNS = {"ID", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ hiện nay"};

    public StatisticPanelController(JComboBox<String> genderJcb, JComboBox<String> statusJcb, JTextField tuTuoiJtf, JTextField denTuoiJtf, JTextField tuNamJtf, JTextField denNamJtf, JPanel jpnView) {
        this.GenderJcb = genderJcb;
        this.StatusJcb = statusJcb;
        this.tuTuoiJtf = tuTuoiJtf;
        this.denTuoiJtf = denTuoiJtf;
        this.tuNamJtf = tuNamJtf;
        this.denNamJtf = denNamJtf;
        this.jpnView = jpnView;
        this.peopleService = new PeopleService();
        this.listNhanKhauBeans = new ArrayList<NhanKhauBean>();
        this.listNhanKhauBeans = this.peopleService.getListNhanKhau();
        this.classTableModel = new ClassTableModel();
    }
    
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public void setData() {
        int tuTuoi = -1;
        int denTuoi = 200;
        int tuNam = 0;
        int denNam = 2100;
        String gender = (String)this.GenderJcb.getSelectedItem().toString();
        String status = StringService.covertToString((String)this.StatusJcb.getSelectedItem());
        try {
            if (!this.tuTuoiJtf.getText().trim().isEmpty()) {
                tuTuoi = Integer.parseInt(this.tuTuoiJtf.getText().trim());
            } else {
                tuTuoi = -1;
            }
            if (!this.denTuoiJtf.getText().trim().isEmpty()) {
                denTuoi = Integer.parseInt(this.denTuoiJtf.getText().trim());
            } else {
                denTuoi = 200;
            }
            if (!this.tuNamJtf.getText().trim().isEmpty()) {
                tuNam = Integer.parseInt(this.tuNamJtf.getText().trim());
            }
            if (!this.denNamJtf.getText().trim().isEmpty()) {
                denNam = Integer.parseInt(this.denNamJtf.getText().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(denTuoiJtf, "Vui lòng nhập đúng kiểu dữ liệu!!", "Warring", JOptionPane.ERROR_MESSAGE);
        }
        this.listNhanKhauBeans = this.peopleService.statisticNhanKhau(tuTuoi, denTuoi, gender, status, tuNam, denNam);
        setDataTable();
    }
    
    public void setDataTable() {
        List<NhanKhauModel> listItem = new ArrayList<NhanKhauModel>();
        this.listNhanKhauBeans.forEach(nhankhau -> {
            listItem.add(nhankhau.getNhanKhauModel());
        });
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;

			@Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
			
            @Override
	        public Component prepareRenderer(TableCellRenderer renderer,int row,int column){
	            Component comp=super.prepareRenderer(renderer,row, column);
	           int modelRow=convertRowIndexToModel(row);
	           if(!isRowSelected(modelRow))
	               comp.setBackground(Color.WHITE);
	           else
	               comp.setBackground(new Color(102, 102, 255));
	           return comp;
	        }
        };
        
      //Set style for table header
        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);
        header.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        header.setOpaque(false);
        header.setBackground(new Color(230, 230, 255));
        header.setForeground(Color.black);
        
        header.setPreferredSize(new Dimension(100, 50));
            

        //Set style for table content
        table.setRowHeight(30);
        table.validate();
        table.repaint();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().setBackground(Color.white);
        scroll.getViewport().add(table);
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public JComboBox<String> getGenderJcb() {
        return GenderJcb;
    }

    public void setGenderJcb(JComboBox<String> GenderJcb) {
        this.GenderJcb = GenderJcb;
    }

    public JComboBox<String> getStatusJcb() {
        return StatusJcb;
    }

    public void setStatusJcb(JComboBox<String> StatusJcb) {
        this.StatusJcb = StatusJcb;
    }

    public JTextField getTuTuoiJtf() {
        return tuTuoiJtf;
    }

    public void setTuTuoiJtf(JTextField tuTuoiJtf) {
        this.tuTuoiJtf = tuTuoiJtf;
    }

    public JTextField getDenTuoiJtf() {
        return denTuoiJtf;
    }

    public void setDenTuoiJtf(JTextField denTuoiJtf) {
        this.denTuoiJtf = denTuoiJtf;
    }

    public JTextField getTuNamJtf() {
        return tuNamJtf;
    }

    public void setTuNamJtf(JTextField tuNamJtf) {
        this.tuNamJtf = tuNamJtf;
    }

    public JTextField getDenNamJtf() {
        return denNamJtf;
    }

    public void setDenNamJtf(JTextField denNamJtf) {
        this.denNamJtf = denNamJtf;
    }
    

}
