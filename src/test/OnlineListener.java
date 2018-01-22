package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.org.apache.bcel.internal.generic.NEW;

import db.DbDao;

@WebListener
public class OnlineListener implements HttpSessionListener ,ServletContextListener{
	
	public static final String ONLINE_STR = "online";

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("OnlineListener sessionCreated");
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		String sessionid = session.getId();
		if(session.isNew()) {
			String user = (String)session.getAttribute("name");
			if(user == null) {
				user = "游客";
			}
			Map<String, String> online = (Map<String, String>)application.getAttribute(ONLINE_STR);
			if(online == null) {
				online = new Hashtable<String,String>();
			}
			online.put(sessionid, user);
			application.setAttribute(ONLINE_STR, online);
			
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext application = session.getServletContext();
		String sessionid = session.getId();
		Map<String, String> online = (Map)application.getAttribute(ONLINE_STR);
		if(online != null) {
			online.remove(sessionid);
		}
		application.setAttribute(ONLINE_STR, online);
		
	}

	private final int MAX_MILLS = 1 * 60 * 1000;
	private final int INTERVAL = 5 * 1000;// 5 seconds
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		new javax.swing.Timer(INTERVAL, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DbDao dbDao = new DbDao("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/testdatabase1","root","root");
					ResultSet rSet = dbDao.query("select * from online_info");
					StringBuffer beRemoved = new StringBuffer("(");
					while(rSet.next()) {
						long lasttime =Long.parseLong( rSet.getString("u_timestamp"));
						
						if((System.currentTimeMillis() - lasttime) > MAX_MILLS) {//time out
							beRemoved.append("'");
							beRemoved.append(rSet.getString("sessionid"));
							beRemoved.append("' , ");
						}
					}
					if(beRemoved.length()>3) {
						beRemoved.setLength(beRemoved.length()-3);
						beRemoved.append(")");
						dbDao.modify("delete from online_info where sessionid in "+beRemoved);
					}
					dbDao.closeConn();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		}).start();
	}

	

}
