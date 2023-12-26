package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTools {
    public Connection conn = null;

    public Connection getConn() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");					
			String DBURL= "jdbc:mysql://localhost:3306/librarymanagement";	
			String DBUSER = "root";										
			String DBPASS = "root";										
			conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
        	
//			Class.forName("org.sqlite.JDBC");
//        	String DBURL = "jdbc:sqlite:C:\\sqlite\\libraryMgmt.db";
//            conn = DriverManager.getConnection(DBURL);
//            if (conn == null) {
//                throw new IllegalStateException("Connection was not established.");
//            }
//            System.out.println("Connection to SQLite has been established.");
//        } catch (ClassNotFoundException e) {
//			e.printStackTrace();
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return conn;
    }
}


