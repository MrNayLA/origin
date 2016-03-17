/**
 * File name : MainMenu.java
 * 
 * Description : JFrame GUI class for handling MainMenu after login
 * 
 * @author : NayLA 
 * 
 * Date :10/03/2016
 * 
 */

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
import java.awt.Font;

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
		setBounds(100, 100, 461, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistration = new JButton("Add new storekeeper");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				try {
					StoreKeeperInfoUpdate frame = new StoreKeeperInfoUpdate();
					frame.setVisible(true);
				} catch (Exception rege) {
					rege.printStackTrace();
				}
			}
		});
		btnRegistration.setBounds(265, 256, 156, 23);
		contentPane.add(btnRegistration);
		
		JLabel lblRegistration = new JLabel("  Member registration");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistration.setForeground(Color.CYAN);
		lblRegistration.setBounds(265, 11, 156, 23);
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
		btnLogout.setBounds(25, 256, 156, 51);
		contentPane.add(btnLogout);
		
		JButton btnAddProduct = new JButton("Add new product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddProduct.setBounds(265, 114, 156, 23);
		contentPane.add(btnAddProduct);
		
		JButton btnAddCategory = new JButton("Add new category");
		btnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddCategory.setBounds(265, 184, 156, 23);
		contentPane.add(btnAddCategory);
		
		JButton btnTransaction = new JButton("New transaction");
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnTransaction.setBounds(25, 36, 156, 51);
		contentPane.add(btnTransaction);
		
		JButton btnReport = new JButton("Generate report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnReport.setBounds(25, 179, 156, 54);
		contentPane.add(btnReport);
		
		JButton btnDiscount = new JButton("Manage discounts");
		btnDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnDiscount.setBounds(25, 114, 156, 51);
		contentPane.add(btnDiscount);
		
		JButton btnNewMember = new JButton("Add new member");
		btnNewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewMember.setBounds(265, 36, 156, 23);
		contentPane.add(btnNewMember);
		
		JButton btnRemoveMember = new JButton("Remove member");
		btnRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRemoveMember.setBounds(265, 64, 156, 23);
		contentPane.add(btnRemoveMember);
		
		JButton btnRemoveProduct = new JButton("Remove product");
		btnRemoveProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRemoveProduct.setBounds(265, 142, 156, 23);
		contentPane.add(btnRemoveProduct);
		
		JButton btnRemoveCategory = new JButton("Remove category");
		btnRemoveCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRemoveCategory.setBounds(265, 210, 156, 23);
		contentPane.add(btnRemoveCategory);
		
		JButton btnRemoveStorekeeper = new JButton("Remove storekeeper");
		btnRemoveStorekeeper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRemoveStorekeeper.setBounds(265, 283, 156, 23);
		contentPane.add(btnRemoveStorekeeper);
	}
}
