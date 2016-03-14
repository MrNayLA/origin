package sg.nus.edu.iss.usstore;

public class Customer {
	
	protected String type;/* Member="M" or Non-member="PUBLIC" */
	
	public void Customer(){
		
		this.type = "PUBLIC";		
	}

	public String getCustomerType(){
				
		return this.type;
	}
}
