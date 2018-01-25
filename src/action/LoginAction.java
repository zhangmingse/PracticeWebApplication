package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import exception.MyException;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("loginaction");
		if(getUsername().equals("exception1")) {
			throw new MyException("用户名不能为exception1");
		}
		if(getUsername().equals("exception2")) {
			throw new java.sql.SQLException("用户名不能为exception2");
		}
		Integer counter = (Integer) ActionContext.getContext().getApplication().get("counter");
		if (counter == null) {
			counter = 1;
		} else {
			counter = counter + 1;
		}
		ActionContext.getContext().getApplication().put("counter", counter);
		
		if (getUsername().equals("test") && getPassword().equals("test")) {

			ActionContext.getContext().getSession().put("user", getUsername());
			ActionContext.getContext().put("tip","您已成功登录");
			return SUCCESS;
		}else {
			ActionContext.getContext().put("tip","服务器提示，登录失败");
			return ERROR;
		}
	}

}
