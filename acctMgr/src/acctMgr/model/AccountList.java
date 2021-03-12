package acctMgr.model;

import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import acctMgr.model.*;
/**
* The AccountList class implements an application that
* keeps track of a Multiple Accounts in an Array List.
* @author  Arya Habibi
* @version 1.1
* @since   2019-010-1 
*/

public class AccountList extends AbstractModel/** AccountList class */
{
	ArrayList<Account> List;
	private int length;
	public AccountList()/** AccountList constructor */
	{
		List = new ArrayList<Account>();
		length = List.size();
	}
	public void addAccount(String balance, String Name, String ID)/** Method - Add account */
	{
		Account ac = new Account(balance, Name, ID);
		List.add(ac);
	}
	public void addAccount(Account temp)/** Method - Add account */
	{
		List.add(temp);
	}
	public void delAccount(int id)/** Method - del account */
	{
		List.remove(id);
	}
	public Account at(int i)/** Method - Gets Account at position i */
	{
		return List.get(i);
	}
	public void write(String filename)/** Method - Write to file */
	{
		//what if account list is empty when write is called?
		//could call an exception, currently just an if statement
		//if list is empty, write does nothing
		if(length >  0)
		{
			FileOutputStream fileStream = null;
			BufferedWriter bw = null;
			try
			{
				fileStream = new FileOutputStream(filename);
				bw = new BufferedWriter(new OutputStreamWriter(fileStream));
				
			}
			catch(IOException err)
			{
				System.out.println("Error creating file output stream: " + err.getMessage());
			}
			//write number of accounts to file
			try
			{ 
				bw.write(Integer.toString(length)); bw.newLine(); 
			}
			catch(IOException err) {System.out.println(err.getMessage()); }
			
			//for each element in list
			for(int i = 0; i < length; ++i)
			{
				try
				{
					//write each member of the current element to filename
					//write curr_ele.getID()
					bw.write(List.get(i).getID());
					bw.newLine();
					//write curr_ele.getName()
					bw.write(List.get(i).getName());
					bw.newLine();
					//write curr_ele.getBalance()
					bw.write(List.get(i).getBal().toPlainString());
					bw.newLine();
				}
				catch(IOException err)
				{
					System.out.println("Error writing to file " + filename + " : " + err.getMessage());
				}
			}
			
			try{ bw.close(); fileStream.close(); }
			catch(IOException err) 
			{ System.out.println("Error closing file " + filename +" : " + err.getMessage()); }
			
		}
	}
	public void read(String filename)/** Method - Read from file */
	{
		File file = new File (filename);
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		}
		catch(FileNotFoundException err)
		{
			System.out.println("Error: " + err.getMessage());
		}
		
		//scanner.useDelimiter("\r\n"); //using default delimiter
		//if list isn't empty, clear list first
		if(length > 0)
		{
			for(int i = length - 1; i < -1; --i)
			{
				this.delAccount(i);
			}
		}
		//read number of accounts
		length = scanner.nextInt();
		//System.out.println(listLength);
		scanner.nextLine();
		//reads an empty line w/ unknown blank char for some reason 
		//calling nextLine() once skips the problem line
		//should try to find a better fix later if time permits
		
		int i = 0;
		while(scanner.hasNext())
		{
			Account temp = new Account();
			
			String nextIn = null;
			//read ID
			nextIn = scanner.nextLine();
			temp.setID(nextIn);
			//System.out.println("[" + i + "] ID: " + nextIn);
			
			//read name
			nextIn = scanner.nextLine();
			temp.setName(nextIn);
			//System.out.println("[" + i + "] Name: " + nextIn);
			
			//read balance
			nextIn = scanner.nextLine();
			temp.deposit(BigDecimal.valueOf(Double.parseDouble(nextIn)));
			//System.out.println("[" + i + "] Balance: " + nextIn);	
			
			//list.add(temp);
			addAccount(temp);
			++i;
		}
		
		scanner.close();
		//notfyChanged(ModelEvent);
	}
	public Iterator<Account> accountsIterator()/** Method - Iterator  */
	{
		return List.iterator();
	}
	public Account[] listAccounts()
	{
		Account[] accounts = new Account[List.size()];
		for (int i = 0; i < List.size(); i++)
		{
			accounts[i] =  List.get(i);
		}
		return accounts;
	}
	public AccountList(String filename)/** Constructor read from file */
	{
		File file = new File (filename);
		Scanner scanner = null;
		try 
		{
			scanner = new Scanner(file);
		}
		catch(FileNotFoundException err)
		{
			System.out.println("Error: " + err.getMessage());
		}
		
		//scanner.useDelimiter("\r\n"); //using default delimiter
		//if list isn't empty, clear list first
		if(length > 0)
		{
			for(int i = length - 1; i < -1; --i)
			{
				this.delAccount(i);
			}
		}
		//read number of accounts
		length = scanner.nextInt();
		//System.out.println(listLength);
		scanner.nextLine();
		//reads an empty line w/ unknown blank char for some reason 
		//calling nextLine() once skips the problem line
		//should try to find a better fix later if time permits
		
		int i = 0;
		while(scanner.hasNext())
		{
			Account temp = new Account();
			
			String nextIn = null;
			//read ID
			nextIn = scanner.nextLine();
			temp.setID(nextIn);
			//System.out.println("[" + i + "] ID: " + nextIn);
			
			//read name
			nextIn = scanner.nextLine();
			temp.setName(nextIn);
			//System.out.println("[" + i + "] Name: " + nextIn);
			
			//read balance
			nextIn = scanner.nextLine();
			temp.deposit(nextIn);
			//System.out.println("[" + i + "] Balance: " + nextIn);	
			
			//list.add(temp);
			addAccount(temp);
			++i;
		}
		
		scanner.close();
	}
}