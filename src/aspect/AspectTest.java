package aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

	public static void main(String[] args) {
		IHello hello = new Hello();
		hello.foo();
		hello.addUser(" 悟空", "7788");
		IWorld world = new World();
		world.bar();
		
		System.out.println("========================");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		hello = ctx.getBean("aspecthello",IHello.class);
		hello.foo();
		hello.addUser(" 悟空", "7788");
		
		world = ctx.getBean("aspectworld",IWorld.class);
		world.bar();
		ctx.close();
		
	}
}
