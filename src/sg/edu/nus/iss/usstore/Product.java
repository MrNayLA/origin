package sg.edu.nus.iss.usstore;

public class Product {
	
	private String productID;/* eg. CLO/1 */
	private String productName;
	private String productDescription;
	private int quantityAvailable;
	private double price;
	private int barcodeNumber;
	private int reorderQuantity;/* Threshold */
	private int orderQuantity;
	
	private Vendor productVendor;/* Added */
	
	
	public void Product(){
		
		this.quantityAvailable = 0;/* Not sure , need to check! */
	}
	
	/* Intend to get category code from arraylist from addNewProduct menu (GUI) or manual entry by Storekeeper. */
	/* System will assign sequential number. */
	public void setProductID(Category category , int seqNumber){
		
		this.productID = category.getCategoryCode() + "/" + String.valueOf(seqNumber);
	}
	
	public String getProductID(){
			
		return this.productID;

	}
	
	public String getProductCategoryCode(){
		
		if(this.productID != null)
		{
			return this.productID;
			
		}else{
			
			return "---";
		}
				
	}
	
	
	public String getCategoryCode(Category category , int seqNumber){
		
		this.productID = category.getCategoryCode() + "/" + String.valueOf(seqNumber);
	
		return this.productID;
	}
	
	
	public void getVendor(Vendor vendor){
		
		this.productVendor = vendor;
	}
	
	public void addNewProduct(Category category , int seqNumber){
		
		/* File Write */
		getCategoryCode(category ,seqNumber);
		
	}
	
	/*public void setProductID(){
		
		this.productID = super.getCategoryCode() + "/";
	}
	
	public void addNewProduct(String threeLetterCode){
		
		this.productID = super.addCategoryCode(threeLetterCode) + "/" + String.valueOf(quantityAvailable++);
	}*/
	
	
	
	/*public String getCategoryCode(){
				
		return this.categoryCode;
		
	}*/

}
