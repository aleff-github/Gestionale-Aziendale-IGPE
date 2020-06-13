package util_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	public static Connection getConnectionDatabase() throws SQLException  {
		Connection connection = DriverManager.getConnection("jdbc:sqlite:invio_facile.db");
		return connection;
	}
}
