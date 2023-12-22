package views.infoViews;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InfoJframe extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private String content;
	private JFrame parentJFrame;

	private javax.swing.JLabel contentJlb;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;

	public InfoJframe(String content, JFrame parentJFrame) {
		initComponents();
		this.content = content;
		this.contentJlb.setText(content);
		this.parentJFrame = parentJFrame;
		parentJFrame.setEnabled(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}

		});
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	}

	public void close() {
		this.parentJFrame.setEnabled(true);
		dispose();
	}

	private void initComponents() {
		this.setResizable(false);
		this.setTitle("Thông tin chi tiết");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 200, 1000, 500);
		this.setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(0, 0, 986, 463);
		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
		jScrollPane1.getVerticalScrollBar().setUnitIncrement(1);
		
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setLayout(null);
		jPanel1.add(jScrollPane1);
		jPanel1.setBounds(0, 0, 986, 463);
		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		getContentPane().add(jPanel1);
		

		contentJlb = new javax.swing.JLabel();
		contentJlb.setBackground(new java.awt.Color(255, 255, 255));
		contentJlb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		contentJlb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		contentJlb.setText("jLabel1");
		contentJlb.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		jScrollPane1.setViewportView(contentJlb);

	}// </editor-fold>//GEN-END:initComponents

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public JPanel getjPanel1() {
		return jPanel1;
	}

	public void setjPanel1(JPanel jPanel1) {
		this.jPanel1 = jPanel1;
	}

}
