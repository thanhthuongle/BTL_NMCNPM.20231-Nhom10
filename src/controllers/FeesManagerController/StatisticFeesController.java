package controllers.FeesManagerController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import beans.PhiBatBuocBean;
import models.FeesModel;
import services.*;
import utils.ClassTableModel;
import views.infoViews.InfoJframe;

public class StatisticFeesController {

	private List<HoKhauBean> list;
	private JTextField searchJtf;
	private JPanel tableJpn;
	private FeesModel feesModel;
	private FeesService feesService;
	private JComboBox<String> selectStateJcb;
	private JLabel summaryLbl;

	private final HoKhauService hoKhauService = new HoKhauService();
	private final ClassTableModel tableModelHoKhau = new ClassTableModel();
	private final String COLUMNS[] = {"Mã hộ khẩu", "Họ tên chủ hộ", "Địa chỉ", "Đã nộp", "Cần nộp", "Trạng thái"};
	private JFrame parentJFrame;

	public StatisticFeesController(JPanel tableJpn, JTextField searchJtf, JComboBox<String> selectStateJcb, PhiBatBuocBean selectedFee, JLabel summaryLbl) {
		this.searchJtf = searchJtf;
		this.tableJpn = tableJpn;
		this.feesModel = selectedFee.getFeesModel();
		this.feesService = new FeesService();
		this.list = hoKhauService.getListHoKhau();
		this.selectStateJcb = selectStateJcb;
		this.summaryLbl = summaryLbl;
		List<Integer> paids = allPaids(list, feesModel);
		List<Integer> needs = allNeeds(list, feesModel);
		List<Boolean> paidStates = allPaidStates(paids, needs);
		this.summaryLbl.setText("Số hộ khẩu đã nộp là: " + Integer.toString(numOfCompletePaids(paidStates)));
		initAction();
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

	public List<Integer> allPaids(List<HoKhauBean> householdBeans, FeesModel feesModel) {
		List<Integer> paids = new ArrayList<Integer>();
		for (int i = 0; i < householdBeans.size(); ++i) {
			paids.add(feesService.getPaid(householdBeans.get(i), feesModel));
		}
		return paids;
	}

	public List<Integer> allNeeds(List<HoKhauBean> householdBeans, FeesModel feesModel) {
		List<Integer> needs = new ArrayList<Integer>();
		for (int i = 0; i < householdBeans.size(); ++i) {
			needs.add(feesService.getNeed(householdBeans.get(i), feesModel));
		}
		return needs;
	}

	public List<Boolean> allPaidStates(List<Integer> paids, List<Integer> needs) {
		List<Boolean> paidStates = new ArrayList<Boolean>();
		for (int i = 0; i < paids.size(); ++i) {
			paidStates.add(paids.get(i) >= needs.get(i));
		}
		return paidStates;
	}

	public int numOfCompletePaids(List<Boolean> allPaidStates) {
		int cnt = 0;
		for (Boolean state : allPaidStates) {
			if (state.equals(Boolean.TRUE)) {
				cnt += 1;
			}
		}
		return cnt;
	}

	private JTable setStyleTable(JTable table) {
		// Set style for table header
		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);
		header.setFont(new Font("Tahoma", Font.BOLD, 15));

		header.setOpaque(false);
		header.setBackground(new Color(230, 230, 255));
		header.setForeground(Color.black);

		header.setPreferredSize(new Dimension(100, 50));

		// Set style for table content
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

		return table;
	}

	public void setData() {
		List<Integer> paids = allPaids(list, feesModel);
		List<Integer> needs = allNeeds(list, feesModel);
		List<Boolean> paidStates = allPaidStates(paids, needs);
		DefaultTableModel model = tableModelHoKhau.setHouseholdFeeTable(list, paids, needs, paidStates, COLUMNS);
		JTable table = new JTable(model) {
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

		table = setStyleTable(table);

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBackground(Color.white);
		scroll.getViewport().add(table);
		tableJpn.removeAll();
		tableJpn.setLayout(new BorderLayout());
		tableJpn.add(scroll);
		tableJpn.validate();
		tableJpn.repaint();
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

	public void refreshData() {
		setData();
	}

	public void filterFee(FeesModel fee, String condition)  {
		this.list = hoKhauService.getListHoKhau();
		if(!condition.equals(new String("Tất cả"))) {
			List<Integer> paids = allPaids(list, feesModel);
			List<Integer> needs = allNeeds(list, feesModel);
			List<Boolean> paidStates = allPaidStates(paids, needs);
			List<HoKhauBean> temp = new ArrayList<HoKhauBean>();
			int len_rows = list.size();
			for (int i = 0; i < len_rows; ++i) {
				if (paidStates.get(i).equals(Boolean.TRUE) && condition.equals(new String("Đã nộp")) ) {
					temp.add(list.get(i));
				} else if (paidStates.get(i).equals(Boolean.FALSE) && condition.equals(new String("Còn thiếu")) ) {
					temp.add(list.get(i));
				}
			}
			this.list.clear();
			list.addAll(temp);
		}
		setData();
	}
}

