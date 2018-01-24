package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
