package test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import com.sun.xml.internal.bind.v2.runtime.Name;

import db.DbDao;

@WebServlet(name="login",urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String errMsg = "";
		RequestDispatcher requestDispatcher;
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		try {
			DbDao dbDao = new DbDao("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/testdatabase1","root","root");
			ResultSet resultSet = dbDao.query("select userpass from user_table where username = ?", username);
			if(resultSet.next()) {
				if(resultSet.getString("userpass").equals(pass)) {
					HttpSession session = request.getSession(true);
					session.setAttribute("name", username);
					updateUsername(username, session.getId());
					Map<String, String> online = (Map<String, String>)getServletContext().getAttribute(OnlineListener.ONLINE_STR);
					if(online != null) {
						online.put(session.getId(), username);
					}
					response.sendRedirect("welcome.jsp");
//					requestDispatcher = request.getRequestDispatcher("welcome.jsp");
//					requestDispatcher.forward(request, response);
				}
				else {
					errMsg="用户名和密码不匹配";
				}
			}else {
				errMsg="用户名不存在,请先注册";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(errMsg!=null && !errMsg.equals("")) {
			requestDispatcher = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("err", errMsg);
			requestDispatcher.forward(request, response);
		}
		
	}

	private void updateUsername(String username,String sessionid) {
			if(username!=null && !username.equals("")) {
				DbDao dbDao = new DbDao("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/testdatabase1","root","root");
				String sql = "update online_info set username = ? where sessionid = ? ";
				try {
					PreparedStatement pStatement = dbDao.getConnection().prepareStatement(sql);
					pStatement.setObject(1,username);
					pStatement.setObject(2,sessionid);
					pStatement.executeUpdate();
					pStatement.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

	
	

}
