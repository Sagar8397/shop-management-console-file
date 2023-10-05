package shop_management;

import java.io.IOException;
import java.util.Scanner;

import product_management.ProductManagement;
import user_management.UserManagement1;

public class appilication_management {

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean canIkeeprunningprogram = true;
		
		System.out.println(" !!!! welcome to shop management !!!! ");
		System.out.println("\n");
		
		System.out.println("Enter login name : ");
		String login = sc.nextLine();
		System.out.println("Enter password : ");
		String pass = sc.nextLine();
		
		if(!UserManagement1.validdatauserandpassword(login, pass))
		{
			System.out.println("Login failed");
			return;
		}
		
		while(canIkeeprunningprogram == true)
		{
			System.out.println("1.User management");
			System.out.println("2.Product management");
			System.out.println("3.QUIT");
			
			int selectaboveoption = sc.nextInt();
			
			if(selectaboveoption == 1)
			{
				UserManagement1.userManagement();
			}
			else if(selectaboveoption == 2)
			{
				ProductManagement.productManagement();
			}
			else if(selectaboveoption == 3)
			{
				System.out.println("Program stopped");
				//canIkeeprunningprogram = false;
				break;
			}
		}
	}
}
