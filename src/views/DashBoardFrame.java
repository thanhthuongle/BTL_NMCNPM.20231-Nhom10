package views;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import beans.DanhMucBean;
import controllers.DashboardController;

public class DashBoardFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel HoKhauBtn;
	private JPanel Home;
	private JPanel NhanKhauBtn;
	private JPanel ThongKeBtn;
	private JPanel ThuPhiBtn;
	private JPanel UngHoBtn;
	private JLabel jlbTrangChu;
	private JLabel jlbHoKhau;
	private JLabel jlbNhanKhau;
	private JLabel jlbThongKe;
	private JLabel jlbThuPhi;
	private JLabel jlbUngHo;
	private JPanel jpnBean;
	private JPanel jpnContainer;
	private JPanel jpnMenu;

	private JButton LogoutBtn;

	private DashboardController controller;

	public DashBoardFrame() {
		init();

		List<DanhMucBean> listDanhMuc = new ArrayList<DanhMucBean>();
		listDanhMuc.add(new DanhMucBean("TrangChu", Home, jlbTrangChu));
		listDanhMuc.add(new DanhMucBean("NhanKhau", NhanKhauBtn, jlbNhanKhau));
		listDanhMuc.add(new DanhMucBean("HoKhau", HoKhauBtn, jlbHoKhau));
		listDanhMuc.add(new DanhMucBean("ThongKe", ThongKeBtn, jlbThongKe));
		listDanhMuc.add(new DanhMucBean("ThuPhi", ThuPhiBtn, jlbThuPhi));
		listDanhMuc.add(new DanhMucBean("UngHo", UngHoBtn, jlbUngHo));

		this.controller = new DashboardController(jpnBean, this);
		controller.setView(Home, "TrangChu");
		controller.setEvent(listDanhMuc);
	}

	private void init() {
		this.setResizable(false);
		this.setTitle("Quản lý nhân khẩu");
		this.setBounds(350, 200, 1000, 650);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm",
						JOptionPane.YES_NO_OPTION) == 0) {
					dispose();
				}
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		jpnContainer = new JPanel();
		jpnContainer.setBackground(new Color(249, 250, 254));
		jpnContainer.setBounds(0, 0, 986, 613);
		jpnContainer.setLayout(null);
		contentPane.add(jpnContainer);

		jpnMenu = new JPanel();
		jpnMenu.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(204, 204, 204)));
		jpnMenu.setBackground(new Color(249, 250, 254));
		jpnMenu.setBounds(10, 10, 140, 593);
		jpnMenu.setLayout(null);
		jpnContainer.add(jpnMenu);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(5, 100, 120, 2);
		jpnMenu.add(panel);

		Home = new JPanel();
		Home.setBorder(new EmptyBorder(0, 0, 0, 0));
		Home.setBackground(new Color(220, 152, 255));
		Home.setBounds(5, 0, 120, 60);
		Home.setLayout(null);
		jpnMenu.add(Home);

		jlbTrangChu = new JLabel("Trang chủ");
		jlbTrangChu.setForeground(new Color(255, 255, 255));
		jlbTrangChu.setFont(new Font("Tahoma", Font.BOLD, 18));
		jlbTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		jlbTrangChu.setBounds(0, 0, 120, 60);
		Home.add(jlbTrangChu);

		NhanKhauBtn = new JPanel();
		NhanKhauBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		NhanKhauBtn.setBackground(new Color(102, 153, 255));
		NhanKhauBtn.setBounds(5, 110, 120, 40);
		NhanKhauBtn.setLayout(null);
		jpnMenu.add(NhanKhauBtn);

		jlbNhanKhau = new JLabel("Nhân khẩu");
		jlbNhanKhau.setToolTipText("Nhân khẩu");
		jlbNhanKhau.setBackground(new Color(204, 204, 255));
		jlbNhanKhau.setBorder(null);
		jlbNhanKhau.setForeground(new Color(255, 255, 255));
		jlbNhanKhau.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlbNhanKhau.setHorizontalAlignment(SwingConstants.CENTER);
		jlbNhanKhau.setBounds(0, 0, 120, 40);
		NhanKhauBtn.add(jlbNhanKhau);

		HoKhauBtn = new JPanel();
		HoKhauBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		HoKhauBtn.setBackground(new Color(102, 153, 255));
		HoKhauBtn.setForeground(new Color(204, 204, 255));
		HoKhauBtn.setBounds(5, 170, 120, 40);
		HoKhauBtn.setLayout(null);
		jpnMenu.add(HoKhauBtn);

		jlbHoKhau = new JLabel("Hộ khẩu");
		jlbHoKhau.setBackground(new Color(102, 153, 255));
		jlbHoKhau.setBorder(null);
		jlbHoKhau.setForeground(new Color(255, 255, 255));
		jlbHoKhau.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlbHoKhau.setBounds(0, 0, 120, 40);
		jlbHoKhau.setHorizontalAlignment(SwingConstants.CENTER);
		jlbHoKhau.setToolTipText("Hộ khẩu");
		HoKhauBtn.add(jlbHoKhau);

		ThongKeBtn = new JPanel();
		ThongKeBtn.setBackground(new Color(102, 153, 255));
		ThongKeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		ThongKeBtn.setBounds(5, 230, 120, 40);
		ThongKeBtn.setLayout(null);
		jpnMenu.add(ThongKeBtn);

		jlbThongKe = new JLabel("Thống kê");
		jlbThongKe.setBackground(new Color(102, 102, 255));
		jlbThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		jlbThongKe.setBounds(0, 0, 120, 40);
		jlbThongKe.setForeground(new Color(255, 255, 255));
		jlbThongKe.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlbThongKe.setToolTipText("Thống kê");
		ThongKeBtn.add(jlbThongKe);

		ThuPhiBtn = new JPanel();
		ThuPhiBtn.setBackground(new Color(102, 153, 255));
		ThuPhiBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		ThuPhiBtn.setBounds(5, 290, 120, 40);
		ThuPhiBtn.setLayout(null);
		jpnMenu.add(ThuPhiBtn);

		jlbThuPhi = new JLabel("Thu phí");
		jlbThuPhi.setBackground(new Color(102, 102, 255));
		jlbThuPhi.setHorizontalAlignment(SwingConstants.CENTER);
		jlbThuPhi.setBounds(0, 0, 120, 40);
		jlbThuPhi.setForeground(new Color(255, 255, 255));
		jlbThuPhi.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlbThuPhi.setToolTipText("Thu phí");
		ThuPhiBtn.add(jlbThuPhi);

		UngHoBtn = new JPanel();
		UngHoBtn.setBackground(new Color(102, 153, 255));
		UngHoBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		UngHoBtn.setBounds(5, 350, 120, 40);
		UngHoBtn.setLayout(null);
		jpnMenu.add(UngHoBtn);

		jlbUngHo = new JLabel("Ủng hộ");
		jlbUngHo.setBackground(new Color(102, 102, 255));
		jlbUngHo.setHorizontalAlignment(SwingConstants.CENTER);
		jlbUngHo.setBounds(0, 0, 120, 40);
		jlbUngHo.setForeground(new Color(255, 255, 255));
		jlbUngHo.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlbUngHo.setToolTipText("Ủng hộ");
		UngHoBtn.add(jlbUngHo);

		LogoutBtn = new JButton("Thoát");
		LogoutBtn.setFocusPainted(false);
		LogoutBtn.setBorderPainted(false);
		LogoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to log out?", "Confirm",
						JOptionPane.YES_NO_OPTION) == 0) {
					dispose();
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.setVisible(true);
				}
			}
		});
		LogoutBtn.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				LogoutBtn.setBackground(new Color(23, 69, 255));
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				LogoutBtn.setBackground(new Color(102, 153, 255));

			}
		});

		LogoutBtn.setForeground(Color.WHITE);
		LogoutBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		LogoutBtn.setBorder(new LineBorder(new Color(255, 204, 255), 1, true));
		LogoutBtn.setBackground(new Color(102, 153, 255));
		LogoutBtn.setBounds(5, 565, 120, 28);
		jpnMenu.add(LogoutBtn);

		jpnBean = new JPanel();
		jpnBean.setBackground(new Color(255, 255, 255));
		jpnBean.setBounds(170, 10, 806, 593);
		jpnContainer.add(jpnBean);
	}
}