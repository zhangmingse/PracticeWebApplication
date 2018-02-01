package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuthAspect {

	@Before("execution(* aspect.*.*(..))")
	public void authority() {
		System.out.println("模拟执行权限检查");
	}
}
