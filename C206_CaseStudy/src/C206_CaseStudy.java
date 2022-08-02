import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Users> userList = new ArrayList<Users>();
		ArrayList<Bid> bidList = new ArrayList<Bid>();

		userList.add(new Users("JaneTan", "p@sswo0rd"));
		userList.add(new Users("MaryTan", "p@5sword"));

		int option = 0;

		while (option != 2) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				login();

			} else if (option == 2) {
				System.out.println("Register Account");

				int userType = Helper.readInt("Enter option > ");

				Users newUser = inputDetails();
				userList.addnewUsers(userList, newUser);
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
	// ==================== option 1 =============================================

	public static void login() {

		String username = Helper.readString("Enter Username > ");
		String password = Helper.readString("Enter password > ");

		if (username == Users.get(0).getUserName(username) && password == Users.get(0).getPassword(password)) {
			System.out.println("Login Sucessful");
		}
	}

	// =================== option 2 (new user) ====================================

	public static Users inputDetails() {
		String userName = Helper.readString("Enter Password > ");
		String password = Helper.readString("Enter Password > ");

		Users newUser = new Users(userName, password);
		return newUser;
	}

	public static void addnewUsers(ArrayList<Users> userList, Users newUser) {
		userList.add(newUser);
	}

	// viewing bid
	public static void viewBid(ArrayList<Bid> bidList) {
		System.out.println("Bid List");

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
}