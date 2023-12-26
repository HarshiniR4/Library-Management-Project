package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseTools;
import model.Author;

public class AuthorTools {

	public List<Author> AuthorData(String name) {
		String sql = "SELECT name, workplace FROM author WHERE name = ?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		List<Author> ls=new ArrayList<Author>();
		try {
			PreparedStatement st =conn.prepareStatement(sql);
			st.setString(1, name); 
			rs=st.executeQuery();
			while(rs.next()){
				Author author=new Author();
				author.setName(rs.getString("name"));
				author.setWorkplace(rs.getString("workplace"));
				ls.add(author);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List<Author> AuthorData() {
		String sql="select name,workplace from author";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		List<Author> ls=new ArrayList<Author>();
		try {
			PreparedStatement st =conn.prepareStatement(sql);
			rs=st.executeQuery(sql);
			while(rs.next()){
				Author author=new Author();
				author.setName(rs.getString("name"));
				author.setWorkplace(rs.getString("workplace"));
				ls.add(author);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public int AddAuthor(Author author) {
		int i=0;
		String sql="insert into author (name,workplace)values(?,?)";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);		
			st.setString(1, author.getName());
			st.setString(2, author.getWorkplace());
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}

	public int UpdateAuthor(Author author) {
		int i=0;
		String sql="update author set name=?,workplace=? where name=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, author.getName());
			st.setString(2, author.getWorkplace());
			st.setString(3, author.getName());
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}
}
