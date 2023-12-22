package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import controllers.LoginController;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel loginPane;
	private JTextField txbUserName;
	private JPasswordField txbPasswd;
	
	private LoginController cont = new  LoginController();

	public LoginFrame() {
		init();
        this.keyListenner(txbUserName);
        this.keyListenner(txbPasswd);
	}
	
	private void init() {
		this.setResizable(false);
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 200, 700, 450);
		this.setLocationRelativeTo(null);
      
		loginPane = new JPanel();
		loginPane.setBackground(new Color(204, 204, 255));
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(loginPane);
		loginPane.setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(248, 248, 255), 1, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(114, 78, 458, 254);
		loginPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign in");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 438, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(65, 45, 102, 22);
		panel.add(lblNewLabel_1);
		
		txbUserName = new JTextField();
		txbUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txbUserName.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(0, 5, 0, 0)));
		txbUserName.setBackground(new Color(245, 245, 245));
		txbUserName.setBounds(65, 72, 326, 29);
	       txbUserName.setName("txtUserName");
	        txbUserName.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                txbUserNameActionPerformed(evt);
	            }
	        });
		panel.add(txbUserName);
		txbUserName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(65, 112, 102, 22);
		panel.add(lblNewLabel_1_1);
		
		txbPasswd = new JPasswordField();
		txbPasswd.setFont(new Font("Tahoma", Font.BOLD, 12));
		txbPasswd.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(0, 5, 0, 0)));
		txbPasswd.setBackground(new Color(245, 245, 245));
		txbPasswd.setBounds(65, 144, 326, 29);
		txbPasswd.setName("txtPasswd");
		panel.add(txbPasswd);
		txbUserName.getAccessibleContext().setAccessibleName("txtPasswod");
		
		JButton btnLogin = new JButton("Sign in");
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(65, 193, 326, 38);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
		panel.add(btnLogin);
	}
	
	private void login() {
        String userName = txbUserName.getText();
        String password = String.copyValueOf(txbPasswd.getPassword());
        try {
            if (this.cont.login(userName, password)) {
                this.dispose();
                DashBoardFrame dashBoard = new DashBoardFrame();
                dashBoard.setLocationRelativeTo(null);
                dashBoard.setResizable(false);
                dashBoard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sai thong tin dang nhap", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!! Vui lòng kiểm tra lại!", "Warning!!", JOptionPane.ERROR_MESSAGE);
        }
	}
	
    private void keyListenner(JTextField jtf) {
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    login();
                }
            }
        }); 
    }
    
    private void txbUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbUserNameActionPerformed
    }//GEN-LAST:event_txbUserNameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       this.login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
    }//GEN-LAST:event_btnLoginMouseClicked
}
