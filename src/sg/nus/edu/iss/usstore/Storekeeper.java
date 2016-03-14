package sg.nus.edu.iss.usstore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storekeeper extends Customer{
	
	private String name;
	private String password;
	
	
	public void updateStoreKeeperInfo(){
		
		BufferedWriter bw = null;
		 
	      try {
	         // APPEND MODE SET HERE
	         bw = new BufferedWriter(new FileWriter("C:/Users/NayLA/java_workspace/UniversitySouvenirStore/data/Storekeepers.dat", true));
	         bw.write("\r\n");
		     bw.write("400:08311998:Inprise Corporation:249.95");/* Replace with text entered from textField.*/
		     //bw.newLine();
		     bw.flush();
	      } catch (IOException ioe) {
	    	  
	    	  ioe.printStackTrace();
	    	  
	      } finally { 
	    	  
		     if (bw != null) try {
		    	 
		        bw.close();/* always close the file */
		        
		     } catch (IOException ioe2) {
		    	 
		    	 ioe2.printStackTrace();
		     }
	    } 
		
	}
	
	public void removeStoreKeeper(){
		
		
		
	}
	
}
