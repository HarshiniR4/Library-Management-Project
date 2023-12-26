package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseTools;
import model.Book;

public class BorrowTools {

	public List<Book> BookData(String idReader) {
		String sql = "SELECT book.idBook, nameBook, price, book.kind, author, publisher " +
	             "FROM reader, borrow, book " +
	             "WHERE book.idBook = borrow.idBook AND reader.idReader = borrow.idReader " +
	             "AND reader.idReader = ?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		List<Book> ls=new ArrayList<Book>();
		try {
			PreparedStatement st =conn.prepareStatement(sql);
			st.setString(1, idReader); 
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

	public List<Book> BookData_Search_idBook(String idBook) {
		String sql = "SELECT book.idBook, nameBook, price, book.kind, author, publisher FROM book WHERE book.idBook = ?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		List<Book> ls=new ArrayList<Book>();
		try {
			PreparedStatement st =conn.prepareStatement(sql);
			st.setString(1, idBook);
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

	public boolean whetherInStock(String idBook) {
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		String sql = "select * from borrow ";
		try {
			PreparedStatement st =conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				if(rs.getString("idBook")!=null){
					if(rs.getString("idBook").equals(idBook)){
						return false;
					}
				}
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public int BorrowBook(String idReader,String idbook) {
		int i=0;
		String sql = "INSERT INTO borrow (idReader, idbook, lendDate, dueDate, overtime) " +
	             "VALUES (?, ?, DATE('now'), DATE('now', '+2 months'), 'no')";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);		
			st.setString(1, idReader);
			st.setString(2, idbook);
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}

	public int ReturnBook(String idbook) {
		int i=0;
		String sql="delete from Borrow where idBook=?";
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
