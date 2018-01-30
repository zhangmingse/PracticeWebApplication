package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Person person = ctx.getBean("chinese",Person.class);
		person.useAxe();
		ctx.close();
	}

}
