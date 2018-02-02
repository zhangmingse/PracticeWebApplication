package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuthAspect {

	@Before("execution(* aspect.*.*(..))")
	public void authority(JoinPoint jp) {
		System.out.println("模拟执行权限检查");
		System.out.println("before 增强处理 被织入增强处理的方法是：" + jp.getSignature().getName());
	}
	
	@AfterReturning(returning="rvt",
			pointcut="execution(* aspect.*.*(..))")
	public void log(Object rvt) {
		System.out.println("获取目标方法的返回值" + rvt);
		System.out.println("模拟记录日志的功能");
	}
}
