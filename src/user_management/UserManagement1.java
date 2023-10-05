package user_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManagement1 {

	static ArrayList<User> al = new ArrayList();
	
	static 
	{
		try 
		{
			loadDataFromFileToArrayList();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void userManagement() throws IOException
	{
		//loadDataFromFileToArrayList();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("**  WELCOME to program  **");
		
		boolean canIrunprogram = true;
		
		while(canIrunprogram == true)
		{
			System.out.println("\n");
			System.out.println("1.Add user");
			System.out.println("2.Search user");
			System.out.println("3.Delate user");
			System.out.println("4.Edit user");
			System.out.println("5.Exit");
			
			int selectAboveOption = sc.nextInt();
			
			if(selectAboveOption == userOptions.add_user)
			{
				addUser();
			}
			else if(selectAboveOption == userOptions.Quit)
			{
				File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\orangeHRM20sep\\src\\user_management\\user_information.txt");
				
				FileWriter fw = new FileWriter(file,false);
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(User u:al)
				{
					bw.write(""+ u.user +","+ u.login +","+ u.pass +","+ u.conPass +","+ u.type +"\n");
				}
				
				bw.close();
				fw.close();
				file=null;
				
				System.out.println("** Program Closed **");
				canIrunprogram = false;
			}
			else if(selectAboveOption ==userOptions.search_user)
			{
				System.out.println("search user name : ");
				sc.nextLine();
				String sn = sc.nextLine();
				searchUser(sn);
			}
			else if(selectAboveOption == userOptions.delate_user)
			{
				System.out.println("enter user user name to delate : ");
				sc.nextLine();
				String d = sc.nextLine();
				delateUser(d);
			}
			else if(selectAboveOption == userOptions.edit_user)
			{
				System.out.println("enter user name to edit user : ");
				sc.nextLine();
				String e = sc.nextLine();
				editUser(e);
			}
		}
		
		System.out.println("  After while looping program  ");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).user);
			System.out.println(al.get(i).login);
			System.out.println(al.get(i).pass);
			System.out.println(al.get(i).conPass);
			System.out.println(al.get(i).type);
			System.out.println("\n");
		}
	}
	
	public static void addUser()
	{
		Scanner sc = new Scanner(System.in);
		User userObject = new User();
		
		System.out.println("user name : ");
		userObject.user = sc.nextLine();
		
		System.out.println("login name : ");
		userObject.login = sc.nextLine();
		
		System.out.println("Password : ");
		userObject.pass = sc.nextLine();
		
		System.out.println("Confirm password : ");
		userObject.conPass = sc.nextLine();
		
		System.out.println("User type : ");
		userObject.type = sc.nextLine();
		
		System.out.println("user name is : " +userObject.user);
		System.out.println("login name is : " +userObject.login);
		System.out.println("Password is : " +userObject.pass);
		System.out.println("Confirm password is : " +userObject.conPass);
		System.out.println("user type is : " +userObject.type);
		al.add(userObject);
	}
	
	public static void searchUser(String user) 
	{
		for(User u:al)
		{
			if (u.user.equalsIgnoreCase(user)) 
			{
				System.out.println("user name : " +u.user);
				System.out.println("login name : " +u.login);
				System.out.println("password : " +u.pass);
				System.out.println("Confirm password : " +u.conPass);
				System.out.println("user type : " +u.type);
				return;
			}
		}
		System.out.println("User not found");
	}
	
	public static void delateUser(String user)
	{
		Iterator<User> userIterator = al.iterator();
		while (userIterator.hasNext())
		{
			User u = userIterator.next();
			if (u.user.equalsIgnoreCase(user)) 
			{
				userIterator.remove();
				System.out.println("user " +u.user + " has been delated");
				return;
			}
		}
		System.out.println("user not found");
	}
	
	public static void editUser(String user)
	{
		for(User u:al)
		{
			if(u.user.equalsIgnoreCase(user))
			{
				Scanner sc = new Scanner(System.in);
				
				System.out.println("editing user : " +u.user);
				
				System.out.println("enter new user name : ");
				u.user = sc.nextLine();
				
				System.out.println("enter new login name : ");
				u.login = sc.nextLine();
				
				System.out.println("enter new password : ");
				u.pass = sc.nextLine();
				
				System.out.println("enter new confirm password : ");
				u.conPass = sc.nextLine();
				
				System.out.println("enter new type : ");
				u.type = sc.nextLine();
				
				System.out.println("user information is updated");
				return;
			}
		}
		System.out.println("user not found");
	}

	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\orangeHRM20sep\\src\\user_management\\user_information.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		
		while((line = br.readLine())!=null)
		{
			User u = new User();
			
			String[] a = line.split(",");
			
			if(a.length>4)
			{
				/*u.login=a[0];
				u.pass=a[1];
				u.user=a[2];
				u.type=a[3];
				u.conPass=a[4];*/
				
				u.user=a[0];
				u.login=a[1];
				u.pass=a[2];
				u.conPass=a[3];
				u.type=a[4];

				al.add(u);
			}
		}
		br.close();
		fr.close();
		file=null;
	}
	
	public static boolean validdatauserandpassword(String login, String pass) throws IOException
	{
		Iterator<User> it = al.iterator();
		
		while(it.hasNext())
		{
			User u = it.next();
			if(u.login.equalsIgnoreCase(login) && u.pass.equalsIgnoreCase(pass))
			{
				return true;
			}
		}
		return false;
	}
}
