package test;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
					requestDispatcher = request.getRequestDispatcher("welcome.jsp");
					requestDispatcher.forward(request, response);
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


	
	

}
