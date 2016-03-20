package sg.edu.nus.iss.usstore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SystemAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textAdminName;
	private JPasswordField passwordAdmin;
	
	
	ManageStaff frameManageStaff = new ManageStaff();
	
	Administrator systemAdmin = new Administrator();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemAdmin frame = new SystemAdmin();
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
	public SystemAdmin() {
		
		setTitle("System administration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 159);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAdminName = new JTextField();
		textAdminName.setBounds(90, 25, 143, 20);
		contentPane.add(textAdminName);
		textAdminName.setColumns(10);
		
		passwordAdmin = new JPasswordField();
		passwordAdmin.setBounds(90, 56, 143, 20);
		contentPane.add(passwordAdmin);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					
			}
		});
		
		/* By Enter Key */
		btnOK.addKeyListener(new MyKeyListener(){
			
			/* Override keyPressed() method of MyKeyListener class .*/
			public void keyPressed(KeyEvent evt)
			{
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					
					String textUserName = textAdminName.getText();/* Get input from textField.*/
					String textPassword = String.valueOf(passwordAdmin.getPassword());/* Get input from passwordField.*/	
										
					
					try{
											
						if(systemAdmin.checkUserInfo(textUserName,textPassword))
						{				
							/* Open Dialog Box if Username and Password is correct.*/							
							try {
								//MainMenu frameHome = new MainMenu();
								frameManageStaff.setTitle( textUserName + " logged in as system administrator.");
								frameManageStaff.setVisible(true);
															
								dispose();/* Destroy current frame where the button exits.*/
								
							} catch (Exception homee) {
								homee.printStackTrace();
							}						
							
						}
						else{
							
							//System.out.println("Wrong user!");
							try {
								UnauthorizedLoginAlert frameAlert = new UnauthorizedLoginAlert();
								frameAlert.setTitle("Login check");
								frameAlert.setVisible(true);
							} catch (Exception logine) {
								logine.printStackTrace();
							}
							
						}
					
					}catch(IOException fioe){
						
						fioe.printStackTrace();
					}
				}
			}
		});
		btnOK.setBounds(116, 87, 89, 23);
		contentPane.add(btnOK);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setBounds(10, 28, 78, 14);
		contentPane.add(lblAdministrator);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 59, 70, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Log in only if you have admininistrator's right !");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBounds(10, 3, 299, 14);
		contentPane.add(lblNewLabel);
	}
}
