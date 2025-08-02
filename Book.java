package Book.model;

public class Book {
	private int id;
	private String bookName;
	private String authorName;
	private double price;

	public void display() {
		System.out.println("Id : "+id);
		System.out.println("Book Name : "+bookName);
		System.out.println("Author Name :"+authorName);
		System.out.println("Price : "+price);
		System.out.println("-----------------------------------------------");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {

		if (price > 0) {

			this.price = price;
		} else {
			throw new IllegalArgumentException("invalid price !!");
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price + "]";
	}

	public Book() {
	}

	public Book(int id, String bookName, String authorName, double price) {
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}
	public Book( String bookName, String authorName, double price) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}
	
	public Book(int id, String authorName) {
		this.id = id;
		this.authorName = authorName;
	}
	public Book(int id) {
		this.id = id;
	}

}
