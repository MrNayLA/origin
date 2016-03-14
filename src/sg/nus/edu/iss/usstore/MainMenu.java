package sg.nus.edu.iss.usstore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setTitle("Main Menu");
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
	public MainMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistration = new JButton("Add new member");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Storekeeper stkp = new Storekeeper();/* Added */
				
				stkp.updateStoreKeeperInfo();/* Added */
			}
		});
		btnRegistration.setBounds(265, 30, 145, 23);
		contentPane.add(btnRegistration);
		
		JLabel lblRegistration = new JLabel("       Member registration");
		lblRegistration.setBounds(265, 5, 145, 14);
		contentPane.add(lblRegistration);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					USS_Application frameLogin = new USS_Application();
					frameLogin.setTitle("Univeristy Souvenir Store");
					frameLogin.setVisible(true);	
					
					dispose();/* Destroy current frame where the button exits.*/
														
				} catch (Exception logine) {
					logine.printStackTrace();
				}
				
			}
		});
		btnLogout.setToolTipText("Press here to log out!");
		btnLogout.setBounds(265, 206, 145, 45);
		contentPane.add(btnLogout);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(25, 206, 156, 45);
		contentPane.add(btnCancel);
		
		JButton btnAddProduct = new JButton("Add new product");
		btnAddProduct.setBounds(265, 88, 145, 23);
		contentPane.add(btnAddProduct);
		
		JButton btnAddCategory = new JButton("Add new category");
		btnAddCategory.setBounds(265, 142, 145, 23);
		contentPane.add(btnAddCategory);
		
		JButton btnTransaction = new JButton("Add new transaction");
		btnTransaction.setBounds(25, 30, 156, 23);
		contentPane.add(btnTransaction);
		
		JButton btnReport = new JButton("Generate report");
		btnReport.setBounds(25, 142, 156, 23);
		contentPane.add(btnReport);
		
		JButton btnDiscount = new JButton("Manage discounts");
		btnDiscount.setBounds(25, 88, 156, 23);
		contentPane.add(btnDiscount);
	}
}
