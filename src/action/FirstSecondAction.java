package action;

import com.opensymphony.xwork2.ActionSupport;

public class FirstSecondAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		System.out.println("first second action");
		return SUCCESS;
	}

}
