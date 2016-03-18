package sg.edu.nus.iss.usstore;

import java.util.ArrayList;

public class Category {
	
	private String categoryCode;
	private String categoryName;
	
	private ArrayList<Product> product = new ArrayList<Product>();/* Added */
		
	public String addCategoryCode(String threeLetterCode){
			
		return this.categoryCode = threeLetterCode;
	}
	
	public String getCategoryCode(){
			
		return this.categoryCode;
	}

	public void addCategoryName(String  categoryName){
		
		this.categoryName = categoryName;
	}
	
	public String getCategoryName(){
		
		return this.categoryName;
	}
	
}
