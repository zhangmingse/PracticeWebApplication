package async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/async",asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<title>异步调用示例</title>");
		out.println("进入servlet的时间是"+new java.util.Date()+"</br>");
		out.flush();
		AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(30*1000);
		asyncContext.start(new Executor(asyncContext));
		out.println("离开servlet的时间是"+new java.util.Date()+"</br>");
		out.flush();
	}
	
}
