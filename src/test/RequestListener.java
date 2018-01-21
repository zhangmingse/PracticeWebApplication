package test;

import java.sql.ResultSet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.DbDao;

@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestListener requestInitialized");
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		HttpSession session = request.getSession(true);
		String id = session.getId();
		String ip = request.getRemoteAddr();
		String page = request.getRequestURI();
		String user = (String)session.getAttribute("name");
		user = (user ==null?"游客":user);
		DbDao dbDao = new DbDao("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/testdatabase1","root","root");
		try {
			ResultSet rSet = dbDao.query("select * from online_info where sessionid = ? ", id);
			if(rSet.next()) {
				rSet.updateString("u_timestamp", ""+System.currentTimeMillis());
				rSet.updateString("page", page);
				rSet.updateRow();
				rSet.close();
				
			}
			else {
				dbDao.insert("insert into online_info(sessionid,username,ip,page,u_timestamp) values(?,?,?,?,?)", 
						id,user,ip,page,""+System.currentTimeMillis());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
