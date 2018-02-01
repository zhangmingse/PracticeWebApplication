package aspect;

public class Hello  implements IHello{

	@Override
	public void foo() {
		System.out.println("执行hello组件的foo方法");
	}
	
	@Override
	public int addUser(String name,String pass) {
		System.out.println("执行hello组件的addUser方法"+name +"  " + pass);
		return 20;
	}
}
