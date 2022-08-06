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

	
	private Deal deal1;
	private Deal deal2;
	private Deal deal3;

	private ArrayList<Users> userList;
	private ArrayList<Bid> bidList;
	private ArrayList<Item> itemList;
	private ArrayList<Category> catList;
	private ArrayList<Deal> dealList;

	//item data
	private Item I1;
	private Item I2;

	@Before
	public void setUp() throws Exception {
		I1 = new Item("Asus", "A11", 1990.00, true, "23/03", "24/04", 22.00);
		I2 = new Item ("Acer", "A12", 1300.00, false, "09/07", "19/10", 10.00);
		
		user1 = new Users("TomTan","System Administrator", "TomTan@myrp.edu.sg" ,"p@sswo0rd");
		user2 = new Users("MiaTan","Buyer", "MiaTan@myrp.edu.sg","p@5sword");
		user3 = new Users("MikaLee", "Seller", "MikaLee@myrp.edu.sg", " ");
		
		bid1 = new Bid("A1003","Asus","MikaLee@myrp.edu.sg","MiaTan@myrp.edu.sg",1400.00);
		bid2 = new Bid("A1004","Mac","MikaLee@myrp.edu.sg","MiaTan@myrp.edu.sg",1800.00);
		bid3 = new Bid("A1005","Sony","MikaLee@myrp.edu.sg","MiaTan@myrp.edu.sg",1500.00);
		
		c1 = new Category("Laptops");
		c2 = new Category("Cameras");
		c3 = new Category("Books");

		deal1 = new Deal("D1000", "Asus A13", "MiaTan@myrp.edu.sg", "MikaLee@myrp.edu.sg", 1400.00, "15 August 2022");
		deal2 = new Deal("D1001", "Mac OS", "MiaTan@myrp.edu.sg", "MikaLee@myrp.edu.sg", 1800.00, "30 August 2022");
		deal3 = new Deal("D1002", "Sony SS", "MiaTan@myrp.edu.sg", "MikaLee@myrp.edu.sg", 1500.00, "15 October 2022");
		
		userList = new ArrayList<Users>();
		bidList = new ArrayList<Bid>();
		catList = new ArrayList<Category>();
		dealList = new ArrayList<Deal>();
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
		assertSame("Test that the user username is the same", user2, userList.get(2).getUserName());
		assertSame("Test that the user password is the same", user2, userList.get(2).getPassword());

		//User not able to create account 
		C206_CaseStudy.addnewUsers(userList, user3);
		assertSame("Test that user is not able to create account", user3, userList.get(3).getPassword());
	}
	@Test 
	public void testAddItem() {
	// item list is not null, so that will be able to add a new item - boundary
	assertNotNull("Check if there is a valid Item arrayList to add to", itemList);
	
	//Given an empty list, after adding 1 item, the size of the list is 1 - normal
	//The item just added is as same as the first item of the list
	C206_CaseStudy.addItem(itemList, I1);
	assertEquals("Check that item arraylist size is 1", 1, itemList.size());
	assertSame("Check that item is added", I1, itemList.get(0));
	
	//Add another item. test The size of the list is 2? - normal
	//The item just added is as same as the second item of the list
	C206_CaseStudy.addItem(itemList, I2);
	assertEquals("Test that item arraylist size is 2", 2, itemList.size());
	assertSame("Test that item is added", I2, itemList.get(1));
}
	@Test
	public void testDeleteItem() {

	    // Given an empty list, after adding 2 item, the size of the list is 2
	    assertEquals("Test if the item arrayList is 1?", 2, itemList.size());

	    // The bid added is the same as the first bid of the list
	    assertSame("Test that item is added same as the 1st bid of the list", I1, itemList.get(0));

	    // boundary
	    assertNotNull("test if there is valid Item arraylist to delete from", itemList);

	    // Test that the size of the list is back to 1
	    C206_CaseStudy.doDeleteItem(itemList,I1);
		C206_CaseStudy.addItem(itemList, I1);
	    C206_CaseStudy.addItem(itemList, I2);
	    assertEquals("Test that item arrayList size is 1?", 1, itemList.size());
	    assertSame("Test that 2nd item added is the first time of the list?", I2, itemList.get(0));
	  }
	@Test
	public void testRetrieveAllItem() {
		// Test if the Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Item in the arraylist", itemList);
		
		// test if the list of item retrieved from the item list is empty - boundary
		String allItem = C206_CaseStudy.retrieveAllItem(itemList);
		String testOutput = "";
		assertEquals("Check that ViewAllItemList", testOutput, allItem);
		
		// Given an empty list, after adding 2 items =m test i the size of the item list is 2 - normal
		C206_CaseStudy.addItem(itemList, I1);
		C206_CaseStudy.addItem(itemList, I2);
		assertEquals("Test that Item in the arraylist size is 2", 2, itemList.size());
		
		// test if the expected output string is the same as the list of item retrieved from the item list
		allItem = C206_CaseStudy.retrieveAllItem(itemList);
		testOutput = String.format("%-10s %-10s %-15s %-10s %-15 %-30s %-10s\n","Asus", "A11", 1990.00, true, "23/03", "24/04", 22.00);
		testOutput = String.format("%-10s %-10s %-15s %-10s %-15 %-30s %-10s\n", "Acer", "A12", 1300.00, false, "09/07", "19/10", 10.00);
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
	
	@Test
	public void testViewBid() {
		//add bid to the list 
		C206_CaseStudy.addBid(bidList, bid1);
	    C206_CaseStudy.addBid(bidList, bid2);
		//ensure list is not null 
		assertNotNull( "Test if there is a valid Category arraylist to add to", bidList);
		//test if the list of bid is not empty 
		assertEquals("Test if the item arrayList is 1?", 2, bidList.size());
	}

	@Test
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

	
	@Test
	public void testViewCategory() {
		//ensure catList is not null
		assertNotNull("Test if there is a valid Category arraylist to view from", catList);
		
		//given an empty List, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addCategory(catList, c1);
		assertEquals("Test is that Category arraylist size is 1?", 1, catList.size());
		
		//the item added is the same as the second item of the list
		C206_CaseStudy.addCategory(catList, c2);
		assertSame("Test that Category is added same as 2nd Category of the list", c2, catList.get(1));
	}
	
	@Test
	public void testDeleteCategory() {
		//ensure that catList is not null and 
		assertNotNull("Test if there is a valid Category arraylist to delete from", catList);
		
		//given an empty List, after adding 2 items, the size of the list is 2
		C206_CaseStudy.addCategory(catList, c1);
		C206_CaseStudy.addCategory(catList, c2);
		assertSame("Test that Category arrayList size is 2", 2, catList.size());
		
		//Delete an Item. Test that the size of the list is 1
		C206_CaseStudy.doDeleteCat(catList, c1);
		assertEquals("Test that Category arrayList size is 1", 1, catList.size());
		assertSame("Test that remaining object is the 2nd object of the previous list", c2, catList.get(0));
	}
	@Test
	public void testViewDeal() {
		//add bid to the list 
		C206_CaseStudy.addDeal(dealList, deal1);
	    C206_CaseStudy.addDeal(dealList, deal2);
		//ensure list is not null 
		assertNotNull( "Test if there is a valid Deal arraylist to add to", dealList);
		//test if the list of bid is not empty 
		assertEquals("Test if the item arrayList is 1?", 2, dealList.size());
	}

	@Test
	public void testAddDeal() {
		// assure the BidList is not null
		assertNotNull("Test if there is valid Deal arraylist to add to", dealList);
		//given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addDeal(dealList, deal1);
		// the bid just added is as same as the first item of the list 
		assertSame("Test that the Deal has added same as the 1st deal of the list? ", deal1, dealList.get(0));
		//add another bid, test that the size of the list is 2?
		C206_CaseStudy.addDeal(dealList, deal2);
		C206_CaseStudy.addDeal(dealList, deal3);
		assertEquals("Test that Deal arraylist size is 3?", 3, dealList.size());
		assertSame("Test that Deal arraylist is added same as 3rd deal price of the list?", deal3, dealList.get(2));
	}

	@Test
	public void testDeleteDeal() {
		C206_CaseStudy.addDeal(dealList, deal1);
	    C206_CaseStudy.addDeal(dealList, deal2);

	    // Given an empty list, after adding 2 item, the size of the list is 2
	    assertEquals("Test if the item arrayList is 1?", 2, dealList.size());

	    // The bid added is the same as the first bid of the list
	    assertSame("Test that deal is added same as the 1st deal of the list", deal1, dealList.get(0));

	    // boundary
	    assertNotNull("test if there is valid Deal arraylist to delete from", dealList);

	    // Test that the size of the list is back to 1
	    C206_CaseStudy.doDeleteDeal(dealList, deal1);

	    assertEquals("Test that deal arrayList size is 1?", 1, dealList.size());
	    assertSame("Test that 2nd item added is the first time of the list?", deal2, dealList.get(0));
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
		I1 = null;
		I2 = null;
		deal1 = null;
		deal2 = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
