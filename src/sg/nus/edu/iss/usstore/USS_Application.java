/**
 * File name : USS_Application.java
 * 
 * Description : JFrame GUI class for Login
 * 
 * @author : NayLA 
 * 
 * Date : 08/03/2016
 * 
 */

package sg.nus.edu.iss.usstore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


public class USS_Application extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	
	//private static int state;
	//public static enum ApplicationState{LoginStateStart,LoginStateAuthorized,LoginStateDisposed};
	///*static*/ ApplicationState LoginWindowState;
		
	MainMenu frameMainMenu = new MainMenu();/* Used later (composition)*/
	Storekeeper currentstorekeeper = new Storekeeper();/* Used for checking storekeeper info. (composition)*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//LoginWindowState = ApplicationState.LoginStateStart;
		//LoginWindowState = ApplicationState.LoginStateAuthorized;		
		//USS_Application frameLogin = new USS_Application();
			
		EventQueue.invokeLater(new Runnable() {
				
			public void run() {
				try {
							
					USS_Application frameLogin = new USS_Application();
					frameLogin.setTitle("Univeristy Souvenir Store");
					frameLogin.setVisible(true);
																					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public USS_Application() {
		
		setResizable(false);			
		LoginScreen();					
	}
	
	public static void MainMenuScreen(){	
		
		try {
			MainMenu frameHome = new MainMenu();
			frameHome.setTitle("MainMenu");
			frameHome.setVisible(true);
		} catch (Exception mainmenue) {
			mainmenue.printStackTrace();
		}
				
	}
	
	public static void UnauthorizedAlertScreen(){
	
		try {
			UnauthorizedLoginAlert frameAlert = new UnauthorizedLoginAlert();
			frameAlert.setTitle("Login check");
			frameAlert.setVisible(true);
		} catch (Exception logine) {
			
			logine.printStackTrace();
		}
	}
		
	public  void LoginScreen() {
		
		ContentPanel contentPanel = new ContentPanel();
		contentPanel.setBackground(new Color(244, 164, 96));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
				
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(83, 208, 179, 23);
		contentPanel.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 254, 179, 23);
		contentPanel.add(passwordField);
		
		JButton btnOK = new JButton("OK");
				
		
		btnOK.setBounds(124, 288, 89, 23);
		contentPanel.add(btnOK);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserName.setForeground(new Color(0, 0, 139));
		lblUserName.setBounds(10, 211, 69, 14);
		contentPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(new Color(0, 0, 128));
		lblPassword.setBounds(10, 257, 69, 14);
		contentPanel.add(lblPassword);
	    setSize(380, 324);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 120, 340, 360);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//contentPane.setLayout(new BorderLayout(0, 0));
		
				
		/* By Enter Key */
		btnOK.addKeyListener(new MyKeyListener(){
			
			/* Override keyPressed() method of MyKeyListener class .*/
			public void keyPressed(KeyEvent evt)
			{
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					
					String textUserName = textFieldUserName.getText();/* Get input from textField.*/
					String textPassword = String.valueOf(passwordField.getPassword());/* Get input from passwordField.*/					
					
					try{
						
						if(currentstorekeeper.checkUserInfo(textUserName,textPassword))
						{				
							/* Open Dialog Box if Username and Password is correct.*/							
							try {
								//MainMenu frameHome = new MainMenu();
								frameMainMenu.setTitle("MainMenu Screen : " + "Logged in as "+ textUserName);
								frameMainMenu.setVisible(true);
								
								dispose();/* Destroy current frame where the button exits.*/
								
							} catch (Exception homee) {
								homee.printStackTrace();
							}						
							
						}
						else{
							
							System.out.println("Wrong user!");
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
		
		btnOK.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				String textUserName = textFieldUserName.getText();/* Get input from textField.*/
				String textPassword = String.valueOf(passwordField.getPassword());/* Get input from passwordField.*/
								
				try{
				
					if(currentstorekeeper.checkUserInfo(textUserName,textPassword))
					{				
						/* Open Dialog Box if Username and Password is correct.*/
						
						try {
							MainMenu frameMain = new MainMenu();
							frameMain.setTitle("MainMenu");
							frameMain.setVisible(true);
							
							dispose();/* Destroy current frame where the button exits.*/
							
						} catch (Exception homee) {
							homee.printStackTrace();
						}
																	
					}
					else{
						
						System.out.println("Wrong user!");
						
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
		});
		
	}
	
	/* Inner class */
	//class MyKeyListener extends KeyAdapter {		
	//	  public void keyPressed(KeyEvent evt) {
	//	    /*if (evt.getKeyChar() == 'a') {
	//	      System.out.println("Check for key characters: " + evt.getKeyChar());
	//	    }*/
	//	    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	//	      //System.out.println("Check for key codes: " + evt.getKeyCode());/* For debugging */
	//	    }
	//	  }
	//}
		
}

/* Outer class */

class ContentPanel extends JPanel {
	  Image bgimage = null;
	  
	  Image logoimage = null;

	  ContentPanel() {
	    MediaTracker mt = new MediaTracker(this);
	    bgimage = Toolkit.getDefaultToolkit().getImage("C:/Users/NayLA/java_workspace/MyUniversitySouvenirStore/images/StoreLogo.png");
	    logoimage = Toolkit.getDefaultToolkit().getImage("C:/Users/NayLA/java_workspace/MyUniversitySouvenirStore/images/NUS_ISS.png");
	    //bgimage = Toolkit.getDefaultToolkit().getImage("./../../../../images/universitysouvenirstoreicon.png");
	    
	    mt.addImage(bgimage, 0);	    
	    mt.addImage(logoimage, 1);
	    
	    try {
	      mt.waitForAll();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  }

	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    int imwidth = bgimage.getWidth(null);
	    int imheight = bgimage.getHeight(null);
	    	    
	    g.drawImage(logoimage, 10, 1, null);
	    g.drawImage(bgimage, 15, 110, null);
	    
	    
	  }
	}