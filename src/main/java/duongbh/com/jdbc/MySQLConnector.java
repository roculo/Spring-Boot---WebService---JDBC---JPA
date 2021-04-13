package duongbh.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

@Component
public class MySQLConnector {

	private static String url = "jdbc:mysql://localhost:3306/jpatest";
	private static String password = "123456";
	private static String username = "root";

	static {
		ResourceBundle labels = ResourceBundle.getBundle("db");
		url = labels.getString("jdbc.url");
		username = labels.getString("jdbc.username");
		password = labels.getString("jdbc.password");
	}

	public static Connection getConnection() {
		System.out.println("url:" + url);
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return connection;
	}

}
