package acctMgr.model;
import java.math.BigDecimal;
import java.math.RoundingMode; 
import java.util.*;
/**
* The Account class implements an application that
* keeps track of a single Account.
* @author  Arya Habibi
* @version 1.1
* @since   2019-010-1 
*/
public class Account extends AbstractModel
{
	private BigDecimal balance;
	private String name;
	private String ID;
	
	public Account()/** Account class */
	{
		balance = new BigDecimal(0);
		name = null;
		ID = "0";
	}
	public Account(String balance, String name, String ID)/** Overloaded Account class  constuctor */
	{
		this.balance = new BigDecimal(balance);
		this.name = name;
		this.ID = ID;
		this.balance.setScale(2, RoundingMode.HALF_DOWN);
	}
	public String getID()/** Method - get id */
	{
		return ID;
	}
	public void setID(String id)/** Method - set id */
	{
		ID = id;
	}
	public BigDecimal getBal()/** Method - get bal */
	{
		return this.balance;/** Method - set bal */
	}
	public String getName()/** Method - get name */
	{
		return name;
	}
	public void setName(String n)/** Method - set name */
	{
		name = n;
	}
	public void withdraw(String amount) throws Exception /** Method - Withdraw */
	{
		BigDecimal am = new BigDecimal(amount);
		BigDecimal compare = balance;
		
		try
		{
			if (compare.subtract(am).compareTo(new BigDecimal(0.00)) != -1)
			{
				balance = balance.subtract(am);
				System.out.println("Withdrew");
			}
			else
			{
				throw new Exception("You do not have enough money");
			}
		}
		catch(Exception err)
		{
			System.out.println(err.getMessage());
			
		}

	}
	public void deposit(String amount)/** depoist method*/
	{
		balance = balance.add(new BigDecimal(amount));
	}
	public void deposit(BigDecimal amount)
	{
		balance = balance.add(amount);
	}
	
}