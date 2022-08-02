
public class Deal {
		
	private String dealID;
	private String itemName;
	private String sellerEmail;
	private String buyerEmail;
	private double transactionPrice;
	private String closeDate; //not sure if this is String
		
	public Deal(String dealID, String itemName, String sellerEmail, String buyerEmail, double transactionPrice, String closeDate) {
		this.dealID = dealID;
		this.itemName = itemName;
		this.sellerEmail = sellerEmail;
		this.buyerEmail = buyerEmail;
		this.transactionPrice = transactionPrice;
		this.closeDate = closeDate;
			
	}
	public String getDealID() {
		return dealID;
		
	}
	public String getItemName() {
		return itemName;
		
	}
	public String getSellerEmail() {
		return sellerEmail;
		
	}
	public String getBuyerEmail() {
		return buyerEmail;
		
	}
	public double getTransactionPrice() {
		return transactionPrice;
		
	}
	public String getCloseDate() {
		return closeDate;
	}
}


