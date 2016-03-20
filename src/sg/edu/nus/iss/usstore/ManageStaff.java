package sg.edu.nus.iss.usstore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ManageStaff extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JPasswordField passwordFieldPW;
	
	Storekeeper newStorekeeper = new Storekeeper();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStaff frameManageStaff = new ManageStaff();
					frameManageStaff.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageStaff() {
		setResizable(false);
		setTitle("Staff management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 286);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Storekeeper registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBounds(92, 24, 159, 23);
		contentPane.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(97, 58, 143, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		passwordFieldPW = new JPasswordField();
		passwordFieldPW.setBounds(97, 102, 143, 20);
		contentPane.add(passwordFieldPW);
		
		
		String[] rightStrings = { "Normal", "Admin"};/* Manually added */
		JComboBox comboBoxRightSelect = new JComboBox(rightStrings);
		comboBoxRightSelect.setBounds(97, 149, 143, 20);
		contentPane.add(comboBoxRightSelect);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/****************** Need to add logic here ***/
		        String statusRight = (String)comboBoxRightSelect.getSelectedItem();
		        
		        newStorekeeper.setUsernameAndPassword(textFieldName.getText() ,String.valueOf(passwordFieldPW.getPassword()));
		        
		        if(statusRight.matches("Normal")){
		        	
		        	newStorekeeper.setRightForStorekeeper(false);
		        	
		        }else if(statusRight.matches("Admin")){
		        	
		        	newStorekeeper.setRightForStorekeeper(true);
		        }
		
		        dispose();
		        /*********************************************/
			}
		});
		
		/* By Enter Key */
		btnAdd.addKeyListener(new MyKeyListener(){
			
			/* Override keyPressed() method of MyKeyListener class .*/
			public void keyPressed(KeyEvent evt)
			{
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					
					/****************** Need to add logic here ***/
			        String statusRight = (String)comboBoxRightSelect.getSelectedItem();
			        
			        newStorekeeper.setUsernameAndPassword(textFieldName.getText() ,String.valueOf(passwordFieldPW.getPassword()));
			        
			        if(statusRight.matches("Normal")){
			        	
			        	newStorekeeper.setRightForStorekeeper(false);
			        	
			        }else if(statusRight.matches("Admin")){
			        	
			        	newStorekeeper.setRightForStorekeeper(true);
			        }
			
			        dispose();
			        /*********************************************/
				}
			}
		});
		
		btnAdd.setBounds(97, 196, 143, 23);
		contentPane.add(btnAdd);
		
		JLabel lblName = new JLabel("Staff's name");
		lblName.setBounds(10, 61, 85, 14);
		contentPane.add(lblName);
		
		JLabel lblPW = new JLabel("Password");
		lblPW.setBounds(10, 105, 66, 14);
		contentPane.add(lblPW);
				
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 152, 46, 14);
		contentPane.add(lblStatus);
	}
}
