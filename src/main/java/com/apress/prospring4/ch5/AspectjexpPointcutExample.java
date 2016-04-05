package com.apress.prospring4.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectjexpPointcutExample {

	public static void main(String[] args) {
		AspectjexpBean target = new AspectjexpBean();
		Advice advice = new SimpleAdvice();
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* foo*(..))");
		Advisor aspect = new DefaultPointcutAdvisor(pointcut, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(aspect);
		pf.setTarget(target);
		
		AspectjexpBean proxy = (AspectjexpBean)pf.getProxy();
		
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
		
	}

}
