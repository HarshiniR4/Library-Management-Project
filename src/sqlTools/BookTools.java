package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseTools;
import model.Book;

public class BookTools {

	public List<Book> BookData() {
	    String sql = "SELECT idBook, nameBook, price, kind, author, publisher FROM Book";
	    DatabaseTools db = new DatabaseTools();
	    List<Book> ls = new ArrayList<>();
	    try (Connection conn = db.getConn();
	         PreparedStatement st = conn.prepareStatement(sql);
	         ResultSet rs = st.executeQuery()) {
	        
	        while (rs.next()) {
	            Book book = new Book();
	            book.setIdBook(rs.getString("idBook"));
	            book.setNameBook(rs.getString("nameBook"));
	            book.setPrice(rs.getInt("price"));
	            book.setType(rs.getString("kind"));
	            book.setAuthor(rs.getString("author"));
	            book.setPublisher(rs.getString("publisher"));
	            ls.add(book);
	        }
	        rs.close();
	        st.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ls;
	}


	public List<Book> BookData(String nameBook) {
		String sql = "SELECT idBook, nameBook, price, kind, author, publisher FROM Book WHERE nameBook LIKE ?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		List<Book> ls=new ArrayList<Book>();
		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, "%" + nameBook + "%");
			rs=st.executeQuery();
			while(rs.next()){
				Book book=new Book();
				book.setIdBook(rs.getString("idBook"));
				book.setNameBook(rs.getString("nameBook"));
				book.setPrice(rs.getInt("price"));
				book.setType(rs.getString("kind"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				ls.add(book);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public Book Search_Book(String idBook) {
		String sql = "SELECT idBook, nameBook, price, kind, author, publisher FROM Book WHERE idBook = ?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		Book book = null;
		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, idBook);
			rs=st.executeQuery();
			while(rs.next()){
				book=new Book();
				book.setIdBook(rs.getString("idBook"));
				book.setNameBook(rs.getString("nameBook"));
				book.setPrice(rs.getInt("price"));
				book.setType(rs.getString("kind"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public int AddBook(Book book) {
		int i=0;
		String sql="insert into book (idBook,nameBook,price,kind,author,publisher)values(?,?,?,?,?,?)";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);		
			st.setString(1, book.getIdBook());
			st.setString(2, book.getNameBook());
			st.setInt(3, book.getPrice());
			st.setString(4, book.getType());
			st.setString(5, book.getAuthor());
			st.setString(6, book.getPublisher());
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}

	public int UpdateBook(Book book) {
		int i=0;
		String sql="update book set idBook=?,nameBook=?,price=?,kind=?,author=?,publisher=? where idBook=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, book.getIdBook());
			st.setString(2, book.getNameBook());
			st.setInt(3, book.getPrice());
			st.setString(4, book.getType());
			st.setString(5, book.getAuthor());
			st.setString(6, book.getPublisher());
			st.setString(7, book.getIdBook());
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}

	public int DeleteBook(String idbook) {
		int i=0;
		String sql="delete from Book where idBook=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, idbook);
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}
}
