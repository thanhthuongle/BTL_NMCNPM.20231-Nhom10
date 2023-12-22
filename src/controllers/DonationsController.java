package controllers;

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

import beans.PhiUngHoBean;
import models.DonationsModel;
import services.DonationsService;
import utils.ClassTableModel;
import views.DonationsManagerFrame.StatisticDonationsFrame;

public class DonationsController {

	private JPanel jpnView;
	private JTextField jtfSearch;
	private DonationsService donationsService;
	private List<PhiUngHoBean> listPhiUngHoBeans;
	private ClassTableModel classTableModel = null;
	private final String[] COLUMNS = { "ID", "Tên khoản thu", "Ngày lập", "Đã thu" };
	private JFrame parentFrame;
	private JTable table;

	public DonationsController(JPanel jpnView, JTextField jtfSearch) {
		this.jpnView = jpnView;
		this.jtfSearch = jtfSearch;
		classTableModel = new ClassTableModel();
		this.donationsService = new DonationsService();
		this.listPhiUngHoBeans = this.donationsService.allDonations();
		initAction();
	}

	public DonationsController() {
	}

	public void setParentFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void initAction() {
		this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String key = jtfSearch.getText();
				if (!key.trim().equals("") && !key.trim().equals("Search")) {
					listPhiUngHoBeans = donationsService.searchDonationByID(key.trim());
					setData();
				} else if (key.trim().equals("")) {
					listPhiUngHoBeans = donationsService.allDonations();
					setData();
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String key = jtfSearch.getText();
				if (!key.trim().equals("") && !key.trim().equals("Search")) {
					listPhiUngHoBeans = donationsService.searchDonationByID(key.trim());
					setData();
				} else if (key.trim().equals("")) {
					listPhiUngHoBeans = donationsService.allDonations();
					setData();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String key = jtfSearch.getText();
				if (!key.trim().equals("") && !key.trim().equals("Search")) {
					listPhiUngHoBeans = donationsService.searchDonationByID(key.trim());
					setData();
				} else if (key.trim().equals("")) {
					listPhiUngHoBeans = donationsService.allDonations();
					setData();
				}
			}
		});
	}

	public void setData() {
		List<DonationsModel> listItem = new ArrayList<DonationsModel>();
		this.listPhiUngHoBeans.forEach(nhankhau -> {
			listItem.add(nhankhau.getDonationModel());
		});

		DefaultTableModel model = classTableModel.setTableDonations(listItem, COLUMNS);
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
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(80);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectEvt(e);
			}

		});

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBackground(Color.white);
		scroll.getViewport().add(table);
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scroll);
		jpnView.validate();
		jpnView.repaint();
	}

	public int getSelectedIdDonation() {
		int column = 0;
		int row = this.table.getSelectedRow();
		return Integer.parseInt(this.table.getModel().getValueAt(row, column).toString());
	}

	private void selectEvt(MouseEvent e) {
    	if (e.getClickCount() > 1) {
            PhiUngHoBean selectedDonation = listPhiUngHoBeans.get(table.getSelectedRow());
            StatisticDonationsFrame detail = new StatisticDonationsFrame(parentFrame, selectedDonation, this);
            detail.setLocationRelativeTo(null);
            detail.setVisible(true);
        }
    }

	public void refreshData() {
		this.listPhiUngHoBeans = this.donationsService.allDonations();
		setData();
	}

}
