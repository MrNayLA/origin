/**
 * File name : StoreKeeperInfoUpdate.java
 * 
 * Description : JFrame GUI class for handling Storekeeper information
 * 
 * @author : NayLA 
 * 
 * Date :10/03/2016
 * 
 */

package sg.edu.nus.iss.usstore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JTree;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class StoreKeeperInfoUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRetype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreKeeperInfoUpdate frame = new StoreKeeperInfoUpdate();
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
	public StoreKeeperInfoUpdate() {
		
		setTitle("Storekeeper Registration");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 262);		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(131, 45, 183, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 86, 183, 20);
		contentPane.add(passwordField);
		
		JLabel lblRegistrationStatus = new JLabel("          Registration unsuccessful !");
		lblRegistrationStatus.setVisible(false);
		lblRegistrationStatus.setForeground(new Color(65, 105, 225));
		lblRegistrationStatus.setBounds(131, 199, 183, 14);
		contentPane.add(lblRegistrationStatus);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Storekeeper storekeeper = new Storekeeper();/* Added */					
						
				storekeeper.setUsernameAndPassword(usernameField.getText() ,String.valueOf(passwordField.getPassword()));/* Added */
				
				if(storekeeper.updateStoreKeeperInfo()){
				
					usernameField.setText("");/* Clear */
					passwordField.setText("");/* Clear */
					
					dispose();
				
				}else{
					
					lblRegistrationStatus.setVisible(true);
				}
						
			}
		});
		
		/* By Enter Key */
		btnConfirm.addKeyListener(new MyKeyListener(){
			
			/* Override keyPressed() method of MyKeyListener class .*/
			public void keyPressed(KeyEvent evt)
			{
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					
					Storekeeper storekeeper = new Storekeeper();/* Added */					
					
					storekeeper.setUsernameAndPassword(usernameField.getText() ,String.valueOf(passwordField.getPassword()));/* Added */
					
					if(storekeeper.updateStoreKeeperInfo()){
					
						usernameField.setText("");/* Clear */
						passwordField.setText("");/* Clear */
						
						dispose();
					
					}else{
						
						lblRegistrationStatus.setVisible(true);
					}
				}
			}
		});
		
		
		btnConfirm.setBounds(177, 165, 89, 23);
		contentPane.add(btnConfirm);
		
		JLabel lblUsername = new JLabel("Type user name");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setForeground(Color.CYAN);
		lblUsername.setBounds(10, 47, 111, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Type password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(Color.CYAN);
		lblPassword.setBounds(10, 88, 111, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRegistration = new JLabel("       New user registration");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistration.setForeground(Color.CYAN);
		lblRegistration.setBounds(131, 11, 183, 23);
		contentPane.add(lblRegistration);
		
		passwordFieldRetype = new JPasswordField();
		passwordFieldRetype.setBounds(131, 123, 183, 20);
		contentPane.add(passwordFieldRetype);
		
		JLabel lblRetypePassword = new JLabel("Re-type password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRetypePassword.setForeground(new Color(0, 255, 255));
		lblRetypePassword.setBounds(10, 126, 123, 14);
		contentPane.add(lblRetypePassword);
		
		
	}
}
