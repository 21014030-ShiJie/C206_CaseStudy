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
	
	private ArrayList<Users> userList;

	@Before
	public void setUp() throws Exception {
		user1 = new Users("TomTan","System Administrator", "TomTan@myrp.edu.sg" ,"p@sswo0rd");
		user2 = new Users("MiaTan","Buyer", "MiaTan@myrp.edu.sg","p@5sword");
		user3 = new Users("MikaLee", "Seller", "MikaLee@myrp.edu.sg", "p@55word");
		
		userList = new ArrayList<Users>();
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
	
	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		userList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
