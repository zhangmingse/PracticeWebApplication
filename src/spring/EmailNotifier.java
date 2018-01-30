package spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		if(arg0 instanceof EmailEvent) {
			EmailEvent emailEvent = (EmailEvent)arg0;
			System.out.println("邮件接收地址是:" + emailEvent.getAddress());
			System.out.println("邮件内容是:" + emailEvent.getText());
		}else {
			System.out.println("其他事件，不做处理");
		}
		
	}

}
