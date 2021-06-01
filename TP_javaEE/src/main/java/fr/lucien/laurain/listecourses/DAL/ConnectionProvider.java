package fr.lucien.laurain.listecourses.DAL;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {

	private static DataSource dataSource;
	
	//upon class load, look for datasource in jndi
	static {
		Context context;
		try {
		context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Accès à la BDD impossible");
		}
	}
	//get a valid connection to the DB from the pool
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}
	
}
