package app;

import java.util.Calendar;
import javax.swing.UIManager;

import views.LoginFrame;

public class Main {
	public static Calendar calendar = Calendar.getInstance();

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		} catch (Exception e) {

		}
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}
}

