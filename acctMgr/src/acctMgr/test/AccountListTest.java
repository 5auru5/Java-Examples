package acctMgr.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import acctMgr.model.Account;
import acctMgr.model.AccountList;

public class AccountListTest {
	AccountList list = new AccountList();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void methodTest() {
		
		list.addAccount("10.00", "Johnson", "234234");
		list.write("data.txt");
		Account[] test = list.listAccounts();
		for (Account i:test)
		{
			System.out.println(i.getID());
			System.out.println(i.getName());
			System.out.println(i.getBal());
			
		}
		}
	}
	
