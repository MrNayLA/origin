package sg.edu.nus.iss.usstore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Administrator extends Storekeeper{
	
	@Override
	public void Storekeeper(){
		
		setRightForStorekeeper(true);
		
		//(String.valueOf(getRightForStorekeeper()));
		
	}
	
	@Override
	public ArrayList<String> readStorekeepersFile() throws IOException
	{	
		String line = new String();
		ArrayList<String>list =new ArrayList<String> ();
			
		try {
			
	      BufferedReader in = new BufferedReader(new FileReader("./data/Admin.dat"));		      
	      /***********************************************/
	      while((line = in.readLine()) != null) {
	    	  	    	  
	    	  list.add(line);/* Add the line (which was read) into the list.*/	              	    
	      }	       
	      /***********************************************/      
	      in.close();
	        
	    } catch (IOException e) {
	    	
	        e.printStackTrace();
	    }
		
		return list;
	}
	
	@Override
	public Boolean checkUserInfo(String usrname,String pw) throws IOException
	{		
		String userInfo = usrname + "," + pw;/* Combine both textFields and add "," in between.*/
		
		ArrayList<String> listRead = readStorekeepersFile();

		/* Check whether userInfo is in the list. */
		if(listRead.contains(userInfo))
		{
			return true;
		}
		else{
						
			return false;
		}
			
	}
}
