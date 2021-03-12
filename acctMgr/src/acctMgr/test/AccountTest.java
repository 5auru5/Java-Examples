package acctMgr.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import acctMgr.model.Account;

public class AccountTest {
	Account testaccount = new Account();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void BalTest() throws Exception {
		testaccount.setID("023");
		testaccount.setName("James");
		testaccount.deposit("100.00");
		System.out.println(testaccount.getBal());
		System.out.println(testaccount.getID());
		System.out.println(testaccount.getName());
		
	}
	@Test
	public void IDTest() throws Exception {
		testaccount.setID("023");
		testaccount.setName("James");
		testaccount.deposit("100.00");
		System.out.println(testaccount.getID());
		testaccount.setID("232435");
		System.out.println(testaccount.getID());
		
	}
	@Test
	public void nameTest() throws Exception {
		testaccount.setID("023");
		testaccount.setName("James");
		testaccount.deposit("100.00");
		System.out.println(testaccount.getName());
		testaccount.setName("Jamie");
		System.out.println(testaccount.getName());
		
	}
	@Test
	public void withdrawexceptionTest() throws Exception
	{
		testaccount.withdraw("101.00");
	}
	@Test
	public void depositTest() throws Exception
	{
		
		testaccount.deposit("101.00");
		System.out.println(testaccount.getBal());
	}

}
