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

package sg.edu.nus.iss.usstore;

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
	
	
	public void Storekeeper(){
		
		this.name = null;
		this.password = null;
	}
	
	
	public void setUsernameAndPassword(String name ,String password){
		
		this.name =name;
		this.password = password;
		
	}
	
	public Boolean updateStoreKeeperInfo(){
		
		BufferedWriter bw = null;
		 
	      try {
	    	  
	    	  File dir = new File("./data");
	    	  File file = new File(dir ,"Storekeepers.dat");
	    	  
	    	  if(!dir.exists()){
	    		  
	    		/* Create directory now. */
	    		  dir.mkdirs();
	    		  
	    		  if ( ! file.exists( ) )
		          {
		    		  /* Create new file now. */
		              file.createNewFile( );
		              
		              FileWrite(file);
		              
		              //bw = new BufferedWriter(new FileWriter("./data/Storekeepers.dat", true));
		              
		              //bw = new BufferedWriter(new FileWriter(file, true));
					  //bw.write(this.name +","+this.password +"\r\n");/* Replace with text entered from textField.*/
					  //bw.flush();
					     
					  return true;	              
		              
		          }else{
		    	  
			         // APPEND MODE SET HERE
			         //bw = new BufferedWriter(new FileWriter("C:/Users/NayLA/java_workspace/MyUniversitySouvenirStore/data/Storekeepers.dat", true));
			         //bw = new BufferedWriter(new FileWriter("./data/Storekeepers.dat", true));
			         
		        	 //bw = new BufferedWriter(new FileWriter(file, true));
				     //bw.write(this.name +","+this.password +"\r\n");/* Replace with text entered from textField.*/
				     //bw.flush();
				     
		        	  FileWrite(file);
		        	  
				     return true;
		          }	    	
	    		  
	    	  }else{
	    	      	  
		    	  if ( ! file.exists( ) )
		          {
		    		  /* Create new file now. */
		              file.createNewFile( );
		              
		              FileWrite(file);
		              
		              //bw = new BufferedWriter(new FileWriter("./data/Storekeepers.dat", true));
		              
		              //bw = new BufferedWriter(new FileWriter(file, true));
					  //bw.write(this.name +","+this.password +"\r\n");/* Replace with text entered from textField.*/
					  //bw.flush();
					     
					  return true;	              
		              
		          }else{
		    	  
			         // APPEND MODE SET HERE
			         //bw = new BufferedWriter(new FileWriter("C:/Users/NayLA/java_workspace/MyUniversitySouvenirStore/data/Storekeepers.dat", true));
			         //bw = new BufferedWriter(new FileWriter("./data/Storekeepers.dat", true));
			         
		        	 //bw = new BufferedWriter(new FileWriter(file, true));
				     //bw.write(this.name +","+this.password +"\r\n");/* Replace with text entered from textField.*/
				     //bw.flush();
				     
		        	  FileWrite(file);
		        	  
				     return true;
		          }
	    	  }
		     
	      } catch (IOException ioe) {
	    	  
	    	  ioe.printStackTrace();
	    	  
	    	  return false;
	    	  
	      } finally { 
	    	  
		     if (bw != null) try {
		    	 
		        bw.close();/* always close the file */
		        return true;
		        
		     } catch (IOException ioe2) {
		    	 
		    	 ioe2.printStackTrace();
		     }
	    } 
		
	}
	
	/* Input parameter as file path */
	public Boolean FileWrite(File file){
		
		 BufferedWriter bw = null;
		
		 try{
			 
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
	
	
	public ArrayList<String> readStorekeepersFile() throws IOException
	{	
		String line = new String();
		ArrayList<String>list =new ArrayList<String> ();
			
		try {
			
	      //BufferedReader in = new BufferedReader(new FileReader("C:/Users/NayLA/java_workspace/MyUniversitySouvenirStore/data/Storekeepers.dat"));
	      BufferedReader in = new BufferedReader(new FileReader("./data/Storekeepers.dat"));	
	      
	      /***********************************************/
	      while((line = in.readLine()) != null) {
	    	  	    	  
	    	  list.add(line);/* Add the line (which was read) into the list.*/	              	    
	      }
	      
	      //System.out.println (list);/* For debugging */     
	      /***********************************************/      
	      in.close();
	        
	    } catch (IOException e) {
	    	
	        //System.out.println("File Read Error");
	        e.printStackTrace();
	    }
		
		return list;
	}
	
	public Boolean checkUserInfo(String usrname,String pw) throws IOException
	{		
		String userInfo = usrname + "," + pw;/* Combine both textFields and add "," in between.*/
		
		ArrayList<String> listRead = readStorekeepersFile();
				
		//list.size();
	    //list.contains(userInfo);
		/* Check whether userInfo is in the list. */
		if(listRead.contains(userInfo))
		{
			//System.out.println("Correct user!");/* For debugging */
			return true;
		}
		else{
						
			//System.out.println("Wrong user!");/* For debugging */
			return false;
		}
			
	}
	
	public void removeStoreKeeper(){
		
		
		
		
	}
	
}
