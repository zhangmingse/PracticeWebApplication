package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SecondAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		ActionContext.getContext().put("tip", "secondAction");
		System.out.println("secondAction");
		return SUCCESS;
	}
}
