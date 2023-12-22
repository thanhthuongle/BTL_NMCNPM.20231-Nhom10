package controllers.HoKhauManagerController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import beans.HoKhauBean;
import beans.MemOfFamily;
import beans.NhanKhauBean;
import services.HoKhauService;
import utils.TableModelHoKhau;

public class ThemMoiController {
    private NhanKhauBean chuHo;
    private List<MemOfFamily> listThanhVien;
    private JPanel memTableJpn;
    private TableModelHoKhau tableModelHoKhau = new TableModelHoKhau();
    private final HoKhauService hoKhauService = new HoKhauService();
    private final String[] COLUMNS= {"Họ tên", "Ngày sinh", "Quan hệ với chủ hộ"};
    
    
    public void setData(List<MemOfFamily> listMember, JPanel tablePanel) {
        DefaultTableModel model_mem = this.tableModelHoKhau.setTableMember(listMember, COLUMNS);
        JTable table_mem = new JTable(model_mem){
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false; 
            }
        };
        table_mem.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table_mem.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table_mem.setRowHeight(30);
        table_mem.validate();
        table_mem.repaint();
        table_mem.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table_mem);
        scroll.getViewport().setBackground(Color.white);
        tablePanel.removeAll();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scroll);
        tablePanel.validate();
        tablePanel.repaint();
    }
    
    public void addNew(HoKhauBean hoKhauBean) throws ClassNotFoundException, SQLException{
        this.hoKhauService.addNew(hoKhauBean);
    }
}
