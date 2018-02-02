package aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuthAspect {

	@Before("execution(* aspect.*.*(..))")
	public void authority() {
		System.out.println("模拟执行权限检查");
	}
	
	@AfterReturning(returning="rvt",
			pointcut="execution(* aspect.*.*(..))")
	public void log(Object rvt) {
		System.out.println("获取目标方法的返回值" + rvt);
		System.out.println("模拟记录日志的功能");
	}
}
