package utils;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import beans.HoKhauBean;
import beans.MemOfFamily;
import beans.NhanKhauBean;

public class TableModelHoKhau {
    public DefaultTableModel setTableNhanKhau(List<NhanKhauBean> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((NhanKhauBean item) -> {  
            obj[0] = item.getNhanKhauModel().getHoTen();
            obj[1] = item.getNhanKhauModel().getGioiTinh();
            obj[2] = item.getNhanKhauModel().getNamSinh();
            obj[3] = item.getNhanKhauModel().getDiaChiHienNay();
            obj[4] = item.getChungMinhThuModel().getSoCMT();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableMember(List<MemOfFamily> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((MemOfFamily item) -> {  
            obj[0] = item.getNhanKhau().getNhanKhauModel().getHoTen();
            obj[1] = item.getNhanKhau().getNhanKhauModel().getNamSinh();
            obj[2] = item.getThanhVienCuaHoModel().getQuanHeVoiChuHo();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableHoKhau(List<HoKhauBean> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            private static final long serialVersionUID = 1L;
			@Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((HoKhauBean item) -> {  
            obj[0] = item.getHoKhauModel().getMaHoKhau();
            obj[1] = item.getChuHo().getHoTen();
            obj[2] = item.getHoKhauModel().getDiaChi();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
