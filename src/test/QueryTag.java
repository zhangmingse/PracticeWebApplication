package test;

import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import db.DbDao;

public class QueryTag extends SimpleTagSupport {

	private String driver;
	private String url;
	private String user;
	private String pass;
	private String sql;
	@Override
	public void doTag() throws JspException, IOException {
		try {
			DbDao dbDao = new DbDao(driver,url,user,pass);
			ResultSet rSet = dbDao.query(sql);
			Writer out = getJspContext().getOut();
			out.write("<table border='1' bgColor='#9999cc' width='400'>");
			int colunmnCount = rSet.getMetaData().getColumnCount();
			while(rSet.next()) {
				out.write("<tr>");
				for(int i =0;i<colunmnCount;i++) {
					out.write("<td>");
					out.write(rSet.getString(i+1));
					out.write("</td>");
				}
				out.write("</tr>");
			}
			out.write("</table>");
			dbDao.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
