package Book.view;

import java.util.Scanner;

public class Bookviews {
	public Scanner sc = new Scanner(System.in);
	
	public int showMenu() {
		System.out.println("Enter 1 for insert");
		System.out.println("Enter 2 for update");
		System.out.println("Enter 3 for delete");
		System.out.println("Enter 4 for show");
		System.out.println("Enter 5 for sorting in price");
		System.out.println("Enter 6 for sorting in authorName");
		System.out.println("Enter 7 for sorting in bookName");
		System.out.println("Enter 8 for exit...");
		return sc.nextInt();
	}
	
	public int getId() {
		System.out.println("Enter id :");
		return sc.nextInt();
	}
	
	public String getBookName() {
		System.out.println("Enter BookName :");
		sc.nextLine();
		return sc.nextLine();
	}
	
	public String getAuthorName() {
		System.out.println("Enter AuthorName :");
		
		return sc.nextLine();
	}
	
	public double getPrice() {
		System.out.println("Enter Price :");
		return sc.nextDouble();
	}

}
