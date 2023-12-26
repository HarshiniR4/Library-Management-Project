package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseTools;
import model.Reader;

public class ReaderTools {

	public List<Reader> ReaderData(String idReader) {
		String sql = "SELECT idReader, nameReader, kind, sex, password FROM Reader WHERE idReader = ?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs = null;
		List<Reader> ls = new ArrayList<Reader>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, idReader);
			rs = st.executeQuery();
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				ls.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List<Reader> ReaderDataSearch(String nameReader) {
		String sql = "select idReader,nameReader,kind,sex,password from Reader where nameReader like'%" + nameReader
				+ "%'";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs = null;
		List<Reader> ls = new ArrayList<Reader>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				ls.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List<Reader> ReaderData() {
		String sql = "select idReader,nameReader,kind,sex,password from Reader";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs = null;
		List<Reader> ls = new ArrayList<Reader>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				ls.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public boolean ReaderLogin(String idReader, String password) {
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			String sql = "SELECT idReader, password FROM reader WHERE idReader = ? AND password = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, idReader);  
		    st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int AddReader(Reader reader) {
		int i = 0;
		String sql = "insert into reader (idReader,nameReader,kind,sex,password)values(?,?,?,?,?)";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, reader.getIdReader());
			st.setString(2, reader.getNameReader());
			st.setString(3, reader.getType());
			st.setString(4, reader.getSex());
			st.setString(5, reader.getPassword());
			i = st.executeUpdate();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int UpdateReader(Reader reader) {
		int i = 0;
		String sql = "update reader set idReader=?,nameReader=?,kind=?,sex=?,password=? where idReader=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, reader.getIdReader());
			st.setString(2, reader.getNameReader());
			st.setString(3, reader.getType());
			st.setString(4, reader.getSex());
			st.setString(5, reader.getPassword());
			st.setString(6, reader.getIdReader());
			i = st.executeUpdate();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int DeleteReader(String idreader) {
		int i = 0;
		String sql = "delete from reader where idReader=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, idreader);
			i = st.executeUpdate();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
