package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements HttpSessionListener{
	
	public static final String ONLINE_STR = "online";

	@Override
	public void sessionCreated(HttpSessionEvent se) {
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

	
}
