package com.apress.prospring4.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class RegexpPointcutExample {

	public static void main(String[] args) {
		RegexpBean target = new RegexpBean();
		Advice advice = new SimpleAdvice();
		JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
		pointcut.setPattern(".*foo.*");
		Advisor aspect = new DefaultPointcutAdvisor(pointcut, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(aspect);
		
		RegexpBean proxy = (RegexpBean)pf.getProxy();
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}

}
