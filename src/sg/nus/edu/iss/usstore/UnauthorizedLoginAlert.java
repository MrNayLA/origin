package sg.nus.edu.iss.usstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

public class UnauthorizedLoginAlert extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnauthorizedLoginAlert frame = new UnauthorizedLoginAlert();
					frame.setTitle("Login check");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UnauthorizedLoginAlert() {
		getContentPane().setBackground(new Color(219, 112, 147));
		setBounds(200, 200, 269, 110);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unauthorized access!");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(77, 30, 140, 14);
		getContentPane().add(lblNewLabel);

	}
}
