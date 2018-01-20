package test;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloWorldTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("hello world my taglib" + new Date());
	}

	
}
