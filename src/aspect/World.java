package aspect;

public class World implements IWorld{

	@Override
	public void bar() {
		System.out.println("执行world组件的bar方法");
	}
}
