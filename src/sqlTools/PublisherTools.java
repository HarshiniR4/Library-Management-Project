package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseTools;
import model.Publisher;

public class PublisherTools {

	public Publisher PublisherData(String name) {
		String sql = "SELECT name, address FROM publisher WHERE name = ?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		Publisher publisher = new Publisher();
		try {
			PreparedStatement st =conn.prepareStatement(sql);
			st.setString(1, name);
			rs=st.executeQuery();
			while(rs.next()){
				publisher.setName(rs.getString("name"));
				publisher.setAddress(rs.getString("address"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publisher;
	}

	public List<Publisher> PublisherData() {
		String sql="select name,address from publisher";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs=null;
		List<Publisher> ls=new ArrayList<Publisher>();
		try {
			PreparedStatement st =conn.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()){
				Publisher publisher=new Publisher();
				publisher.setName(rs.getString("name"));
				publisher.setAddress(rs.getString("address"));
				ls.add(publisher);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public int AddPublisher(Publisher publisher) {
		int i=0;
		String sql="insert into publisher (name,address)values(?,?)";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);		
			st.setString(1, publisher.getName());
			st.setString(2, publisher.getAddress());
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}

	public int UpdatePublisher(Publisher publisher) {
		int i=0;
		String sql="update publisher set name=?,address=? where name=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, publisher.getName());
			st.setString(2, publisher.getAddress());
			st.setString(3, publisher.getName());
			i=st.executeUpdate();
			st.close();
			conn.close();
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return i;
	}
}
