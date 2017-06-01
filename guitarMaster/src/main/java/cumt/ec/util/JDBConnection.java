package cumt.ec.util;

import java.sql.*;

public class JDBConnection {
	private String dbDriver = "org.sqlite.JDBC"; 
	private static final String FILENAME = "db/instrument.db"; 
	public Connection connection = null;
	public JDBConnection() {
		try {
			Class.forName(dbDriver).newInstance(); 
			connection = DriverManager.getConnection("jdbc:sqlite:"+FILENAME); 
		} catch (Exception ex) {
			System.out.println("连接失败");
		}
		System.out.println("连接成功");
	}
}
