import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Users> userList = new ArrayList<Users>();
		ArrayList <Bid> bidList = new ArrayList<Bid>();
		
		userList.add(new Users ("JaneTan", "p@sswo0rd"));
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
	//==================== option 1 =============================================
	
	public static void login() {
		
		String username = Helper.readString("Enter Username > ");
		String password = Helper.readString("Enter password > ");
		
		if (username == Users.get(0).getUserName(username) && password == Users.get(0).getPassword(password)) {
			System.out.println("Login Sucessful");
		} else {
			System.out.println("Enter valid username or password");
		}
	}

	//=================== option 2 (new user) ====================================
	
	public static Users inputDetails() {
		String userName = Helper.readString("Enter Password > ");
		String password = Helper.readString("Enter Password > ");
		
		Users newUser = new Users(userName, password);
		return newUser;
		
	}
	
	public static void addnewUsers(ArrayList<Users> userList, Users newUser) {
		userList.add(newUser);
		
		System.out.println("Account Created");
	}
	
	// viewing bid 
	public static void viewBid(ArrayList<Bid> bidList) {
		System.out.println("Bid List");
		
	}
	public static Bid insertBid() {
		String name = Helper.readString("Enter your name >");
		String id = Helper.readString("Enter Bid ID > " );
		String sellerEmail =Helper.readString("Enter seller email > ");
		String buyerEmail = Helper.readString("Enter buyer email > ");
		double bidPrice = Helper.readDouble("Enter bid price for item >");
		
		
		Bid bidList = new Bid (id, name, sellerEmail, buyerEmail,bidPrice);
		return bidList;
		
	}
	public static void viewBit(ArrayList<Bid> bidList) {
		String output = "";
		
		for ( int i = 0; i < bidList.size(); i++ ) {
			output += String.format(" %-10s %-10s %-10s %-10s %-10s"  , "NAME","ID","SELLER EMAIL","BUYER EMAIL","BID PRICE");
			output += String.format(" %-10s %-10s %-10s %-10s %-10.2f", bidList.get(i).getName(),bidList.get(i).getID(),bidList.get(i).getSellerEmail(),bidList.get(i).getBuyerEmail(),bidList.get(i).getBidPrice());
		}
		System.out.println(output);
	
	}
	

}
