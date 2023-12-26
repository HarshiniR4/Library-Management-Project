package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseTools;

public class LibrarianTools {

	public boolean LibrarianLogin(String nameUser, String password) {
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			String sql = "SELECT nameUser, password FROM librarian WHERE nameUser = ? AND password = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nameUser);
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
}
