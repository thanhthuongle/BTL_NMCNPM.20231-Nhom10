package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

import beans.DanhMucBean;
import views.HouseholdPanel;
import views.DonationsPanel;
import views.FeesPanel;
import views.HomePagePanel;
import views.PeoplePanel;
import views.StatisticPanel;

public class DashboardController {
    private JFrame jfrMain;
    private JPanel root;
    private String kindSelected;
    private List<DanhMucBean> listDanhMuc;
    
    private Color clickColor = new Color(23, 69, 255);
    private Color clickHomeColor = new Color(199, 84, 255);
    private Color pressColor = new Color(162, 181, 255);
    private Color pressHomeColor = new Color(216, 137, 255);
    private Color enterColor = new Color(171,171,255);
    private Color enterHomeColor = new Color(210,117,255);
    private Color exitColor = new Color(102,153,255);
    private Color exitHomeColor = new Color(220,152,255);

    public DashboardController(JPanel root, JFrame jfrMain) {
        this.jfrMain = jfrMain;
        this.root = root;
    }
    
    // set panel for root
    public void setView(JPanel jpnItem, String kind) {
        this.kindSelected = kind;
        jpnItem.setBackground(clickColor);
        JPanel view = new JPanel();
        switch(kind) {
                case "TrangChu":
                    jpnItem.setBackground(clickHomeColor);
                    view = new HomePagePanel();
                    break;
                case "NhanKhau":
                    view = new PeoplePanel(this.jfrMain);
                    break;
                case "HoKhau":
                    view = new HouseholdPanel(this.jfrMain);
                    break;
                case "ThongKe":
                    view = new StatisticPanel(this.jfrMain);
                    break;
                case "ThuPhi":
                    view = new FeesPanel(this.jfrMain);
                    break;
                case "UngHo":
                    view = new DonationsPanel(this.jfrMain);
                    break;
                //any more
                default:
                    break;
            }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(view);
        root.validate();
        root.repaint();
    } 
    
    public void setEvent(List<DanhMucBean> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        this.listDanhMuc.forEach((item) -> {
            item.getJlb().addMouseListener(new LabelEvent(this.jfrMain, item.getKind(), item.getJpn()));
        });
    }
    
    public void setDefaultColor() {
        this.listDanhMuc.forEach((item) -> {
            if (item.getKind().equals("TrangChu")) {
                item.getJpn().setBackground(exitHomeColor);
            } else {
                item.getJpn().setBackground(exitColor);
            }
        });
    }
    
    class LabelEvent implements MouseListener {
        
        private JPanel view;
        private JFrame jfrMain;
        private String kind;
        private JPanel jpnItem;

        public LabelEvent(String kind, JPanel jpnItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
        }

        public LabelEvent(JFrame jfrMain, String kind, JPanel jpnItem) {
            this.jfrMain = jfrMain;
            this.kind = kind;
            this.jpnItem = jpnItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            setDefaultColor();
            jpnItem.setBackground(clickColor);
            switch(kind) {
                case "TrangChu":
                    jpnItem.setBackground(clickHomeColor);
                    view = new HomePagePanel();
                    break;
                case "NhanKhau":
                    view = new PeoplePanel(this.jfrMain);
                    break;
                 case "HoKhau":
                    view = new HouseholdPanel(this.jfrMain);
                    break;
                case "ThongKe":
                    view = new StatisticPanel(this.jfrMain);
                    break;
                case "ThuPhi":
                    view = new FeesPanel(this.jfrMain);
                    break;
                case "UngHo":
                    view = new DonationsPanel(this.jfrMain);
                    break;
                default:
                    break;
            }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(view);
            root.validate();
            root.repaint();
        }        

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(pressColor);
            if(kind.equals("TrangChu")) {
            	jpnItem.setBackground(pressHomeColor);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        	if(!kind.equalsIgnoreCase(kindSelected)) {
                jpnItem.setBackground(enterColor);
                if(kind.equals("TrangChu")) {
                	jpnItem.setBackground(enterHomeColor);
                }
        	}
        }

        @Override
        public void mouseExited(MouseEvent e) {
        	if(!kind.equalsIgnoreCase(kindSelected)) {
                jpnItem.setBackground(exitColor);
                if(kind.equals("TrangChu")) {
                	jpnItem.setBackground(exitHomeColor);
                }
        	}
        }
        
    }
}
