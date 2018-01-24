package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FirstAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		ActionContext.getContext().put("tip", "firstAction");
		System.out.println("firstaction");
		return SUCCESS;
	}
	
	

}
