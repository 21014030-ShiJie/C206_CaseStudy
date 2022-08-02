import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Users> userList = new ArrayList<Users>();
		ArrayList <Bid> bidList = new ArrayList<Bid>();
		
		userList.add(new Users ("JaneTan", "System Administrator","JaneTan@myrp.edu.sg","p@sswo0rd"));
		userList.add(new Users("MaryTan","Buyer","MaryTan@myrp.edu.sg", "p@5sword"));
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
	//==================== option 1 (login) =============================================
 
	
	public static void login(ArrayList<Users> userList) {
		
		String username = Helper.readString("Enter Username > ");
		String role = Helper.readString("Enter role");
		String email = Helper.readString("Enter email address > ");
		String password = Helper.readString("Enter password > ");
		
		for (int i = 0; i <userList.size(); i++) {
			if (userList.get(i).getUserName().equals(username) && userList.get(i).getRole().equals(role) && userList.get(i).equals(email) && userList.get(i).getPassword().equals(password))
			{
				System.out.println("Logoin Successful as" + userList.get(i).getRole());
			
			} else {
				System.out.println("Enter valid username, role, email and passoword");
			}
		}
	}
	

	//=================== option 2 (new user) ====================================
	
	public static Users inputDetails() {
		String userName = Helper.readString("Enter Username > ");
		String role = Helper.readString("Enter role > ");
		String email = Helper.readString("Enter email address > ");
		String password = Helper.readString("Enter Password > ");
		
		Users newUser = new Users(userName, role, email , password);
		return newUser;
		
	}
	
	public static void addnewUsers(ArrayList<Users> userList, Users newUser) {
		userList.add(newUser);
		
		System.out.println("Account Created");
	}
	
	//================== View all Users ============================================
	public static void viewUsers(ArrayList<Users> userList) {
		String us = "";
		
		for (int i = 0; i < userList.size(); i++) {
			us += String.format("%-10s %-10s %-10s", "USERNAME", "ROLE", "EMAIL", "PASSWORD");
			us += String.format("%-10s %-10s %-10s", userList.get(i).getUserName(),userList.get(i).getRole(), userList.get(i).getEmail(), userList.get(i).getPassword());
		}
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
		String bd = "";
		
		for ( int i = 0; i < bidList.size(); i++ ) {
			bd += String.format(" %-10s %-10s %-10s %-10s %-10s"  , "NAME","ID","SELLER EMAIL","BUYER EMAIL","BID PRICE");
			bd += String.format(" %-10s %-10s %-10s %-10s %-10.2f", bidList.get(i).getName(),bidList.get(i).getID(),bidList.get(i).getSellerEmail(),bidList.get(i).getBuyerEmail(),bidList.get(i).getBidPrice());
		}
		System.out.println(bd);
	
	}
	
	public static void addBid(ArrayList<Bid> bidList, Bid bd) {
		bidList.add(bd);
	}

}
