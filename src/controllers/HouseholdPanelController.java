package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import beans.HoKhauBean;
import services.HoKhauService;
import utils.TableModelHoKhau;
import views.infoViews.InfoJframe;

public class HouseholdPanelController {
    private List<HoKhauBean> list;
    private JTextField searchJtf;
    private JPanel tableJpn;
    private final HoKhauService hoKhauService = new HoKhauService();
    private final TableModelHoKhau tableModelHoKhau = new TableModelHoKhau();
    private final String COLUMNS[] = {"Mã hộ khẩu", "Họ tên chủ hộ", "Địa chỉ"};
    private JFrame parentJFrame;
    
    private JTable table;

    public HouseholdPanelController(JTextField searchJtf, JPanel tableJpn) {
        this.searchJtf = searchJtf;
        this.tableJpn = tableJpn;
        this.list = hoKhauService.getListHoKhau();
        setData();
        initAction();
    }

    public HouseholdPanelController() {
		// TODO Auto-generated constructor stub
	}

	public void initAction() {
        this.searchJtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = searchJtf.getText();
                if (!key.trim().equals("") && !key.trim().equals("Search")) {
                    list = hoKhauService.search(key.trim());
                    setData();
                } else if (key.trim().equals("")) {
                    list = hoKhauService.getListHoKhau();
                    setData();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = searchJtf.getText();
                if (!key.trim().equals("") && !key.trim().equals("Search")) {
                    list = hoKhauService.search(key.trim());
                    setData();
                } else if (key.trim().equals("")) {
                    list = hoKhauService.getListHoKhau();
                    setData();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = searchJtf.getText();
                if (!key.trim().equals("") && !key.trim().equals("Search")) {
                    list = hoKhauService.search(key.trim());
                    setData();
                } else if (key.trim().equals("")) {
                    list = hoKhauService.getListHoKhau();
                    setData();
                }
            }
        });
    }

    public void setData() {
        DefaultTableModel model = tableModelHoKhau.setTableHoKhau(list, COLUMNS);

        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                int modelRow = convertRowIndexToModel(row);
                if (!isRowSelected(modelRow))
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
        table.setOpaque(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumnModel().getColumn(0).setMaxWidth(120);
        table.getColumnModel().getColumn(0).setMinWidth(120);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    HoKhauBean temp = list.get(table.getSelectedRow());
                    InfoJframe infoJframe = new InfoJframe(temp.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
        });

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().setBackground(Color.white);
        scroll.getViewport().add(table);
        tableJpn.removeAll();
        tableJpn.setLayout(new BorderLayout());
        tableJpn.add(scroll);
        tableJpn.validate();
        tableJpn.repaint();
    }
	public int getSelectedIdHoKhau() {
		int column = 0;
		int row = this.table.getSelectedRow();
		return Integer.parseInt(this.table.getModel().getValueAt(row, column).toString());
	}
    public void refreshData() {
        this.list = this.hoKhauService.getListHoKhau();
        setData();
    }


    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }

    public List<HoKhauBean> getList() {
        return list;
    }

    public void setList(List<HoKhauBean> list) {
        this.list = list;
    }

    public JTextField getSearchJtf() {
        return searchJtf;
    }

    public void setSearchJtf(JTextField searchJtf) {
        this.searchJtf = searchJtf;
    }

    public JPanel getTableJpn() {
        return tableJpn;
    }

    public void setTableJpn(JPanel tableJpn) {
        this.tableJpn = tableJpn;
    }



}