package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDao {
	private Connection connection;
	private String driver;
	private String url;
	private String username;
	private String pass;
	public DbDao() {}
	public DbDao(String driver,String url,String username,String pass) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.pass = pass;
		
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Connection getConnection() throws Exception{
		if(connection == null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,pass);
		}
		return connection;
	}
	public ResultSet query(String sql,Object... args)throws Exception {
		PreparedStatement pStatement = getConnection().prepareStatement(sql);
		for(int i = 0;i<args.length;i++) {
			pStatement.setObject(i+1, args[i]);
		}
		return pStatement.executeQuery();
	}
	public void modify(String sql,Object...args)throws Exception {
		PreparedStatement pStatement = getConnection().prepareStatement(sql);
		for(int i = 0;i<args.length;i++) {
			pStatement.setObject(i+1, args[i]);
		}
		pStatement.executeUpdate();
		pStatement.close();
	}
	public void closeConn()throws Exception{
		if(connection!=null && !connection.isClosed()) {
			connection.close();
		}
	}
	

}
