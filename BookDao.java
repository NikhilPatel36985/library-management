package Book.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String UNAME = "jdbc:mysql://localhost:3306/emp_table?useSSL=false";
	private final String USER = "root";
	private final String PSWD = "Nikhil";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(UNAME, USER, PSWD);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void insert(Book bk) {
		Connection con = getConnection();
		try {
			PreparedStatement pps = con.prepareStatement("insert into book(bookName,authorName,price) values(?,?,?)");
			pps.setString(1, bk.getBookName());
			pps.setString(2, bk.getAuthorName());
			pps.setDouble(3, bk.getPrice());

			int i = pps.executeUpdate();

			if (i != 0) {
				System.out.println("sucessfully insert...");
			} else {
				System.out.println("some issue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Book bk) {
		Connection con = getConnection();
		try {
			PreparedStatement pps = con.prepareStatement("update book set authorName=? where id=?");
			pps.setString(1, bk.getAuthorName());
			pps.setInt(2, bk.getId());

			int j = pps.executeUpdate();
			if (j != 0) {
				System.out.println("sucessfully update...");
			} else {
				System.out.println("some issue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Book bk) {
		Connection con = getConnection();
		try {
			PreparedStatement pps = con.prepareStatement("delete from book where id=?");
			pps.setInt(1, bk.getId());

			int j = pps.executeUpdate();
			if (j != 0) {
				System.out.println("sucessfully delete...");
			} else {
				System.out.println("some issue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> show() {
		ArrayList<Book> ar = new ArrayList<Book>();

		try {
			Connection con = getConnection();
			PreparedStatement pps = con.prepareStatement("select*from book");

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String bname = rs.getString("bookName");
				String aname = rs.getString("authorName");
				double price = rs.getDouble("price");

				ar.add(new Book(id, bname, aname, price));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ar;
	}

}
