package Book.controller;

import java.util.ArrayList;

import Book.model.Book;
import Book.model.BookDao;
import Book.view.Bookviews;

public class BookController {
	public BookDao dao;
	public Bookviews views;

	public BookController(BookDao dao, Bookviews views) {
		this.dao = dao;
		this.views = views;
	}

	public void run() {

		while (true) {
			int choice = views.showMenu();

			switch (choice) {
			case 1:{
				String bookName = views.getBookName();
				String authorName = views.getAuthorName();
				double price = views.getPrice();
				Book bk = new Book(bookName, authorName, price);
				dao.insert(bk);
			}
			break;
			case 2:{
				String authorName = views.getAuthorName();
				int id = views.getId();
				Book bk = new Book(id, authorName);
				dao.update(bk);
			}
			break;
			case 3:{
				int id = views.getId();
				Book bk = new Book(id);
				dao.delete(bk);
			}
				break;
			case 4:{
				ArrayList<Book> ar = dao.show();
				for(Book b :ar) {
					b.display();
				}
			}
				break;
			case 5:{
				ArrayList<Book> ar = dao.show();
				ar.sort((a,b) ->(int)(a.getPrice()-(b.getPrice())));
				for(Book bk :ar) {
					bk.display();
				}
			}
				break;
			case 6:{
				ArrayList<Book> ar = dao.show();
				ar.sort((a,b)-> a.getAuthorName().compareTo(b.getAuthorName()));
				for(Book bk :ar) {
					bk.display();
				}
			}
				break;
			case 7:{
				ArrayList<Book> ar = dao.show();
				ar.sort((a,b)-> b.getBookName().compareTo(a.getBookName()));
				for(Book bk :ar) {
					bk.display();
				}
			}
				break;
			case 8:
				System.out.println("exit..");
				return;
				default:
					System.out.println("invalid number...");
				
			}
		}

	}

}
