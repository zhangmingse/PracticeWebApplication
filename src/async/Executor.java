package async;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;

public class Executor implements Runnable {

	private AsyncContext async;
	public Executor(AsyncContext asyncContext) {
		this.async = asyncContext;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5*1000);
			ServletRequest request = async.getRequest();
			List<String> books = new ArrayList<>();
			books.add("疯狂java讲义");
			books.add("经典javaee企业应用实战");
			books.add("疯狂xml讲义");
			request.setAttribute("books", books);
			async.dispatch("/async.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
