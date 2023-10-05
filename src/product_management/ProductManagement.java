package product_management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagement {

	static ArrayList<Product> al = new ArrayList();
	
	public static void productManagement() throws IOException
	{
		loadDataFromFileToArrayList();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("**  WELCOME to program  **");
		
		boolean canIrunprogram = true;
		
		while(canIrunprogram == true)
		{
			System.out.println("\n");
			System.out.println("1.Add product");
			System.out.println("2.Search product");
			System.out.println("3.Delate product");
			System.out.println("4.Edit product");
			System.out.println("5.Exit");
			
			int selectAboveOption = sc.nextInt();
			
			if(selectAboveOption == productOptions.add_product)
			{
				addProduct();
			}
			else if(selectAboveOption == productOptions.QUIT)
			{
				File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\orangeHRM20sep\\src\\product_management\\product.txt");
				
				FileWriter fw = new FileWriter(file,false);
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(Product u:al)
				{
					bw.write(""+ u.name +","+ u.id +","+ u.category +","+ u.price +","+ u.quentity +"\n");
				}
				
				bw.close();
				fw.close();
				file=null;
				
				System.out.println("** Program Closed **");
				canIrunprogram = false;
			}
			else if(selectAboveOption ==productOptions.search_product)
			{
				System.out.println("search product name : ");
				sc.nextLine();
				String sn = sc.nextLine();
				searchProduct(sn);
			}
			else if(selectAboveOption == productOptions.delete_product)
			{
				System.out.println("enter product name to delate : ");
				sc.nextLine();
				String d = sc.nextLine();
				delateProduct(d);
			}
			else if(selectAboveOption == productOptions.edit_product)
			{
				System.out.println("enter product name to edit product : ");
				sc.nextLine();
				String e = sc.nextLine();
				editProduct(e);
			}
		}
		
		System.out.println("  After while looping program  ");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).name);
			System.out.println(al.get(i).id);
			System.out.println(al.get(i).category);
			System.out.println(al.get(i).price);
			System.out.println(al.get(i).quentity);
			System.out.println("\n");
		}
	}
	
	public static void addProduct()
	{
		Scanner sc = new Scanner(System.in);
		Product userObject = new Product();
		
		System.out.println("Product name : ");
		userObject.name = sc.nextLine();
		
		System.out.println("Product id : ");
		userObject.id = sc.nextLine();
		
		System.out.println("Product category : ");
		userObject.category = sc.nextLine();
		
		System.out.println("Product price : ");
		userObject.price = sc.nextLine();
		
		System.out.println("Product quentity : ");
		userObject.quentity = sc.nextLine();
		
		System.out.println("Product name is : " +userObject.name);
		System.out.println("Product id is : " +userObject.id);
		System.out.println("Product category is : " +userObject.category);
		System.out.println("Product price is : " +userObject.price);
		System.out.println("Product quentity is : " +userObject.quentity);
		al.add(userObject);
	}
	
	public static void searchProduct(String name) 
	{
		for(Product u:al)
		{
			if (u.name.equalsIgnoreCase(name)) 
			{
				System.out.println("Product name is : " +u.name);
				System.out.println("Product id is : " +u.id);
				System.out.println("Product category is : " +u.category);
				System.out.println("Product price is : " +u.price);
				System.out.println("Product quentity is : " +u.quentity);
				return;
			}
		}
		System.out.println("product not found");
	}
	
	public static void delateProduct(String name)
	{
		Iterator<Product> userIterator = al.iterator();
		while (userIterator.hasNext())
		{
			Product u = userIterator.next();
			if (u.name.equalsIgnoreCase(name)) 
			{
				userIterator.remove();
				System.out.println("product " +u.name + " has been delated");
				return;
			}
		}
		System.out.println("Product not found");
	}
	
	public static void editProduct(String name)
	{
		for(Product u:al)
		{
			if(u.name.equalsIgnoreCase(name))
			{
				Scanner sc = new Scanner(System.in);
				
				System.out.println("editing product : " +u.name);
				
				System.out.println("enter new product name : ");
				u.name = sc.nextLine();
				
				System.out.println("enter new product id : ");
				u.id = sc.nextLine();
				
				System.out.println("enter new product category : ");
				u.category = sc.nextLine();
				
				System.out.println("enter new product price : ");
				u.price = sc.nextLine();
				
				System.out.println("enter new product quentity : ");
				u.quentity = sc.nextLine();
				
				System.out.println("product information is updated");
				return;
			}
		}
		System.out.println("product not found");
	}

	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\orangeHRM20sep\\src\\product_management\\product.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		
		while((line = br.readLine())!=null)
		{
			Product u = new Product();
			
			String[] a = line.split(",");
			
			if(a.length>4)
			{
				/*u.login=a[0];
				u.pass=a[1];
				u.user=a[2];
				u.type=a[3];
				u.conPass=a[4];*/
				
				u.name=a[0];
				u.id=a[1];
				u.category=a[2];
				u.price=a[3];
				u.quentity=a[4];

				al.add(u);
			}
		}
		br.close();
		fr.close();
		file=null;
	}

}
