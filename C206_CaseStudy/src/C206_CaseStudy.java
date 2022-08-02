import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Users> userList = new ArrayList<Users>();
		ArrayList<Bid> bidList = new ArrayList<Bid>();

		userList.add(new Users("JaneTan", "System Administrator", "JaneTan@myrp.edu.sg", "p@sswo0rd"));
		userList.add(new Users("MaryTan", "Buyer", "MaryTan@myrp.edu.sg", "p@5sword"));
		userList.add(new Users("TomTan", "Seller", "TomTan@myrp.edu.sg", "p@55word"));

		int option = 0;

		while (option != 2) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				login(userList);

			} else if (option == 2) {
				System.out.println("Register Account");

				int userType = Helper.readInt("Enter option > ");

				Users newUser = inputDetails();
				C206_CaseStudy.addnewUsers(userList, newUser);
				System.out.println("New User Added!");

			} else {
				System.out.println("Invalid Option");
			}
		}
	}

	public static void menu() {
		System.out.println("CAMPUS ONLINE AUCTION SHOP SYSTEM (COAS)");
		System.out.println("1. Login");
		System.out.println("2. Register Account");
	}
	// ==================== option 1 (login)
	// =============================================

	public static void login(ArrayList<Users> userList) {

		String username = Helper.readString("Enter Username > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email address > ");
		String password = Helper.readString("Enter password > ");

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserName().equals(username) && userList.get(i).getRole().equals(role)
					&& userList.get(i).equals(email) && userList.get(i).getPassword().equals(password)) {
				System.out.println("Logoin Successful as" + userList.get(i).getRole());

			} else {
				System.out.println("Enter valid username, role, email and password");
			}
		}	
	}

	// =================== option 2 (new user) ====================================

	public static Users inputDetails() {
		String userName = Helper.readString("Enter Username > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email address > ");
		String password = Helper.readString("Enter Password > ");

		Users newUser = new Users(userName, role, email, password);
		return newUser;

	}

	public static void addnewUsers(ArrayList<Users> userList, Users newUser) {
		userList.add(newUser);

		System.out.println("Account Created");
	}

	// ================== View all Users
	// ============================================
	public static void viewUsers(ArrayList<Users> userList) {
		String us = "";

		for (int i = 0; i < userList.size(); i++) {
			us += String.format("%-10s %-10s %-10s", "USERNAME", "ROLE", "EMAIL", "PASSWORD");
			us += String.format("%-10s %-10s %-10s", userList.get(i).getUserName(), userList.get(i).getRole(),
					userList.get(i).getEmail(), userList.get(i).getPassword());
		}
	}
	
	// =============================================== (viewing all items) ===================================================================================================
	// viewing bid
	public static void viewBid(ArrayList<Bid> bidList) {
		System.out.println("Bid List");

	}
	// =============================================== (viewing all items) ===================================================================================================
	public static void viewItems(ArrayList<Item> itemList) {
		System.out.println("Item List");
	}

	public static Item insertItem() {
		String name = Helper.readString("Enter your name > ");
		String description = Helper.readString("Enter a description >");
		double minimum_bid_price = Helper.readDouble("Enter minimum bid price > ");
		boolean isAvailable = Helper.readBoolean("Enter the availability > ");
		String auctionstartdate = Helper.readString("Enter the auction start date > ");
		String end_date = Helper.readString("Enter the end date > ");
		double bid_increment = Helper.readDouble("Enter the bid increment > ");

		Item itemList = new Item(name, description, minimum_bid_price, isAvailable, 
				auctionstartdate, end_date, bid_increment);
		return itemList;
	}

	public static void viewItem(ArrayList<Item> itemList) {
		String it = "";

		for (int i = 0; i < itemList.size(); i++) {
			it += String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "NAME", "DESCRIPTION", "MINIMUM_BID_PRICE",
					"AUCTIONSTARTDATE", "END DATE", "BID INCREMENT");
			it += String.format("%-10s %-10s %-10s %-10s %-10s %-10s", itemList.get(i).getName(),
					itemList.get(i).getDescription(), itemList.get(i).getMininum_bid_price(),
					itemList.get(i).getAuctionstartdate(), itemList.get(i).getEnd_date(),
					itemList.get(i).getBid_increment());
		}

		System.out.println(it);
	}

	public static void addItem(ArrayList<Item> itemList, Item it) {
		itemList.add(it);
	}

	public static Bid insertBid() {
		String name = Helper.readString("Enter your name >");
		String id = Helper.readString("Enter Bid ID > ");
		String sellerEmail = Helper.readString("Enter seller email > ");
		String buyerEmail = Helper.readString("Enter buyer email > ");
		double bidPrice = Helper.readDouble("Enter bid price for item >");

		Bid bidList = new Bid(id, name, sellerEmail, buyerEmail, bidPrice);
		return bidList;

	}
	public static void viewBit(ArrayList<Bid> bidList) {
		String bd = "";

		for (int i = 0; i < bidList.size(); i++) {
			bd += String.format(" %-10s %-10s %-10s %-10s %-10s", "NAME", "ID", "SELLER EMAIL", "BUYER EMAIL",
					"BID PRICE");
			bd += String.format(" %-10s %-10s %-10s %-10s %-10.2f", bidList.get(i).getName(), bidList.get(i).getID(),
					bidList.get(i).getSellerEmail(), bidList.get(i).getBuyerEmail(), bidList.get(i).getBidPrice());
		}
		System.out.println(bd);

	}

	public static void addBid(ArrayList<Bid> bidList, Bid bd) {
		bidList.add(bd);
	}

	// ======================== deal ===========================================
	public static void viewDeals(ArrayList<Deal> dealList) {
		System.out.println("Deal List");
	}
	
	public static Deal addDeal() {

		String id = Helper.readString("Enter deal ID: ");
		String name = Helper.readString("Enter Item Name: ");
		String sellerEmail = Helper.readString("Enter Seller Email: ");
		String buyerEmail = Helper.readString("Enter Buyer Email: ");
		double transPrice = Helper.readDouble("Enter Transaction Price: ");
		String closeDate = Helper.readString("Enter Close Date: ");

		Deal dealList = new Deal(id, name, sellerEmail, buyerEmail, transPrice, closeDate);
		return dealList;

	}

	public static void viewDeal(ArrayList<Deal> dealList) {
		String output = "";

		for (int i = 0; i > dealList.size(); i++) {
			output += String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "ID", "ITEM NAME", "SELLER EMAIL",
					"BUYER EMAIL", "TRANSACTION PRICE", "CLOSE DATE");
			output += String.format("%-10s %-10s %-10s %-10s %-10d %-10s", dealList.get(i).getDealID(),
					dealList.get(i).getItemName(), dealList.get(i).getSellerEmail(), dealList.get(i).getBuyerEmail(),
					dealList.get(i).getTransactionPrice(), dealList.get(i).getCloseDate());
		}
		System.out.println(output);

	}

	public static void addDeal(ArrayList<Deal> dealList, Deal output) {
		dealList.add(output);
	}

	// deleting deal
	public static void deleteDeal(ArrayList<Deal> dealList) {
		
	    String dealID = Helper.readString("Enter Deal ID to delete: ");
	    
	    boolean exist = doExistDeal(dealList, dealID);

	    if (exist == false) {
	      System.out.println("Deal ID not found!");

	    } else {
	    	for (int i = 0; i > dealList.size(); i++) {
	    		if(dealID.equals(dealList.get(i).getItemName())) {
	    			dealList.remove(i);
	    		}
	    		System.out.println("Deal Deleted");
	          
	        }
	    }
	  }

	private static boolean doExistDeal(ArrayList<Deal> dealList, String dealID) {
		// TODO Auto-generated method stub
		return false;
	}
}
