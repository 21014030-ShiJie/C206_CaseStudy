import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//prepare test data
	private Users user1;
	private Users user2;
	private Users user3;
	
	private Bid bid1;
	private Bid bid2;
	private Bid bid3;
	
	private Category c1;
	private Category c2;
	private Category c3;
	
	private ArrayList<Users> userList;
	private ArrayList<Bid> bidList;
	private ArrayList<Category> catList;

	@Before
	public void setUp() throws Exception {
		user1 = new Users("TomTan","System Administrator", "TomTan@myrp.edu.sg" ,"p@sswo0rd");
		user2 = new Users("MiaTan","Buyer", "MiaTan@myrp.edu.sg","p@5sword");
		user3 = new Users("MikaLee", "Seller", "MikaLee@myrp.edu.sg", " ");
		
		bid1 = new Bid("A1003","Asus","MikaLee@myrp.edu.sg","MiaTan@myrp.edu.sg",1400.00);
		bid2 = new Bid("A1004","Mac","MikaLee@myrp.edu.sg","MiaTan@myrp.edu.sg",1800.00);
		bid3 = new Bid("A1005","Sony","MikaLee@myrp.edu.sg","MiaTan@myrp.edu.sg",1500.00);
		
		c1 = new Category("Laptops");
		c2 = new Category("Cameras");
		c3 = new Category("Books");
		
		userList = new ArrayList<Users>();
		bidList = new ArrayList<Bid>();
		catList = new ArrayList<Category>();
	}
	
	@Test 
	public void testlogin() {
		
		//User is able to login
		assertSame("Test that the username is the same", user1, userList.get(0).getUserName());
		assertSame("Test that the password is the same", user1, userList.get(0).getPassword());
		
		
		//test error message is displayed when user name is wrong 
		assertEquals("Test that error message is displayed if wrong username", user1, userList.get(0).getUserName());
		
		//Error message is displayed when password is wrong 
		assertEquals("Test display message is shown when password is wrong", user1, userList.get(0).getPassword());
	}

	@Test 
	public void testAddnewUser() {
		
		//User List is not null, so that can add new user
		assertNotNull("Test if there is a valid user arraylist to add to", userList);
		
		//User password and username is the same as the newly added user record 
		C206_CaseStudy.addnewUsers(userList, user2);
		assertSame("Test that the user username is the same", user2, userList.get(1).getPassword());
		assertSame("Test that the user password is the same", user2, userList.get(1).getPassword());
		
		//User not able to create account 
		C206_CaseStudy.addnewUsers(userList, user3);
		assertSame("Test that user is not able to create account", user3, userList.get(2).getPassword());
	}
	@Test
	public void testAddBid() {
		// assure the BidList is not null
		assertNotNull("Test if there is valid Bid arraylist to add to",bidList);
		//given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addBid(bidList, bid1);
		// the bid just added is as same as the first item of the list 
		assertSame("Test that the Bid has added same as the 1st bid of the list? ",bid1,bidList.get(0));
		//add another bid, test that the size of the list is 2?
		C206_CaseStudy.addBid(bidList, bid2);
		C206_CaseStudy.addBid(bidList, bid3);
		assertEquals("Test that Bid arraylist size is 3?",3,bidList.size());
		assertSame("Test that Bid arraylist is added same as 3rd bid price of the list?",bid3,bidList.get(2));
		
	}
	@Test
	public void testDeleteBid() {
		C206_CaseStudy.addBid(bidList, bid1);
	    C206_CaseStudy.addBid(bidList, bid2);

	    // Given an empty list, after adding 2 item, the size of the list is 2
	    assertEquals("Test if the item arrayList is 1?", 2, bidList.size());

	    // The bid added is the same as the first bid of the list
	    assertSame("Test that bid is added same as the 1st bid of the list", bid1, bidList.get(0));

	    // boundary
	    assertNotNull("test if there is valid Bid arraylist to delete from", bidList);

	    // Test that the size of the list is back to 1
	    C206_CaseStudy.doDeleteBid(bidList,bid1);
	    assertEquals("Test that bid arrayList size is 1?", 1, bidList.size());
	    assertSame("Test that 2nd item added is the first time of the list?", bid2, bidList.get(0));
	  }
		
	
	
	public void testAddCategory() {
		//ensure that catList is not null
		assertNotNull("Test if there is a valid Category arraylist to add to", catList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addCategory(catList, c1);
		assertEquals("Test if that Category arraylist size is 1?", 1, catList.size());
		
		//The item added is the same as the first item of the list
		assertSame("Test that Category is added same as the 1st item of the list?", c1, catList.get(0));
		
		//Add another item. Test the size of the list is 3?
		C206_CaseStudy.addCategory(catList, c2);
		C206_CaseStudy.addCategory(catList, c3);
		assertEquals("Test that Category arraylist size is 3?", 3, catList.size());
		assertSame("Test that Camcorder is added same as 3rd Category of the list", c3, catList.get(2));
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		userList = null;
		bid1 = null;
		bid2 = null;
		bid3 = null;
		bidList = null;
	}
	

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
