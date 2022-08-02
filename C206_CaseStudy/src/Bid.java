
public class Bid {
	
	private String ID;
	private String Name;
	private String SellerEmail;
	private String BuyerEmail;
	private double BidPrice;
	
	public Bid(String iD, String name, String sellerEmail, String buyerEmail, double bidPrice) {
		ID = iD;
		Name = name;
		SellerEmail = sellerEmail;
		BuyerEmail = buyerEmail;
		BidPrice = bidPrice;
	}
	public double getBidPrice() {
		return BidPrice;
	}
	public void setBidPrice(int bidPrice) {
		BidPrice = bidPrice;
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public String getSellerEmail() {
		return SellerEmail;
	}
	public String getBuyerEmail() {
		return BuyerEmail;
	}

	
	

}
