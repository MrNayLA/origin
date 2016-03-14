package sg.nus.edu.iss.usstore;

import java.io.IOException;

public class Member extends Customer {
	
	private String memberName;
	private String memberID;
	private int loyaltyPoint;
	
	@Override
	public void Customer(){
		
		super.type = "M";
		this.loyaltyPoint = -1;/* Initialize as new member when created. */
	}
	
	@Override
	public String getCustomerType(){
		
		return this.type;
	}

	public void registermemberName(String name){
		
		this.memberName = name;
	}
	
	public String getmemberName(){
		
		return this.memberName;
	}
	

	public void registerMemberID(String memberID){
		
		this.memberID = memberID;	
	}
	
	public String getmemberID(){
			
		return this.memberID;
	}
	
	public void setLoyaltyPoint(int loyaltyPoint){
		
		this.loyaltyPoint = loyaltyPoint;
	}
	
	public int getLoyaltyPoint(){
				
		return this.loyaltyPoint;
	}
	
	public void utilizeLoyaltyPoint(int pointUtilized){
		
		try{
			if(this.loyaltyPoint > 0)
			{
				this.loyaltyPoint -= pointUtilized;
				
			}else{
				
				this.loyaltyPoint = 0;
			}
			
		}catch(Exception e){
				
			e.printStackTrace();
		}
	}
			
}
