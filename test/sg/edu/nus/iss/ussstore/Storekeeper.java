/**
 * File name : Storekeeper.java
 * 
 * Description : Implementation of Storekeeper class
 *               which inherits from Customer class 
 *               because Storekeeper can be a customer at some point.
 * 
 * @author : NayLA 
 * 
 * Date :10/03/2016
 * 
 */

package sg.edu.nus.iss.ussstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storekeeper extends Customer{
	
	private String name;
	private String password;
	private Boolean right;
	
	
	public void Storekeeper(){
		
		this.name = null;
		this.password = null;
		this.right = null;
	}
	
	public void setRightForStorekeeper(Boolean right){
		
		this.right = right;
	}
	
	public Boolean getRightForStorekeeper(){
			
		return this.right;
	}
	
	public void setUsernameAndPassword(String name ,String password){
		
		this.name =name;
		this.password = password;		
	}
	
	public String getName(){
		
		return this.name;
	}
	public String getPassword(){
		
		return this.password;
	}
	
	public Boolean updateStoreKeeperInfo(){
		 
	      try {
	    	  
	    	  File dir = new File("./data");/* Instantiation of directory object*/
	    	  File file = new File(dir ,"Storekeepers.dat");/* Instantiation of file object*/
	    	  
	    	  if(!dir.exists()){
	    		  
	    		/* Create directory now. */
	    		  dir.mkdirs();
	    		  
	    		  if (! file.exists( ) )
		          {
		    		  /* Create new file now. */
		              file.createNewFile( );		              
		              /* Write file at the specified path.*/
		              FileWrite(file);
		              					     
					  return true;	              
		              
		          }else{
		    	  		       
		        	  FileWrite(file);
		        	  
				     return true;
		          }	    	
	    		  
	    	  }else{
	    	      	  
		    	  if (! file.exists( ) )
		          {
		    		  /* Create new file now. */
		              file.createNewFile( );
		              /* Write file at the specified path.*/
		              FileWrite(file);
		              				     
					  return true;	              
		              
		          }else{
		    	  			   
		        	  /* Write file at the specified path.*/
		        	  FileWrite(file);
		        	  
				     return true;
		          }
	    	  }
		     
	      } catch (IOException ioe) {
	    	  
	    	  ioe.printStackTrace();
	    	  
	    	  return false;
	    	  
	      } finally { 
	    	  
	    	  /* Do nothing for now. */	    	  		    
	      } 
		
	}
	
	/* Input parameter as file path */
	public Boolean FileWrite(File file){
		
		 BufferedWriter bw = null;
		
		 try{
			/* APPEND MODE SET HERE */
			 bw = new BufferedWriter(new FileWriter(file, true));
			 bw.write(this.name +","+this.password +"\r\n");/* Replace with text entered from textField.*/
			 bw.flush();
		  
			 return true;
		  
		 } catch (IOException ioe) {
	    	  
	    	  ioe.printStackTrace();
	    	  
	    	  return false;
	    	  
	      } finally { 
	    	  
		     if (bw != null) try {
		    	 
		        bw.close();/* always close the file */
		        return true;
		        
		     } catch (IOException ioe3) {
		    	 
		    	 ioe3.printStackTrace();
		     }
	    } 
	}
	
	public ArrayList<String> FileRead(File filePath)throws IOException{
		
		String line = new String();
		ArrayList<String>list =new ArrayList<String> ();
		
		try {			
			BufferedReader br = new BufferedReader(new FileReader(filePath.toString()));
		    
		    while((line = br.readLine()) != null) {
	  	    	  
		    	  list.add(line);/* Add the line (which was read) into the list.*/	              	    
		    }
		      
		    br.close();
		      
			return list;
			
		} catch (IOException e) {
	    	
	        e.printStackTrace();
	    }
				
		return list;
	}
	
	public ArrayList<String> readStorekeepersFile() throws IOException
	{	
		String line = new String();
		ArrayList<String>list =new ArrayList<String> ();
			
		try {
			
	      BufferedReader in = new BufferedReader(new FileReader("./data/Storekeepers.dat"));	
	      
	      while((line = in.readLine()) != null) {
	    	  	    	  
	    	  list.add(line);/* Add the line (which was read) into the list.*/	              	    
	      }
	      
	      in.close();
	        
	    } catch (IOException e) {
	    	
	        e.printStackTrace();
	    }
		
		return list;
	}
	
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
	
	public void removeStoreKeeper(){
		
			
		
	}
	
}
