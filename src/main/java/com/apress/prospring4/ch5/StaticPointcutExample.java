package com.apress.prospring4.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutExample {

	public static void main(String[] args) {
		Pointcut staticPointcut = new SimpleStaticPointcut();
		Advice simpleAdvice = new SimpleAdvice();
		PointcutAdvisor defaultAdvisor = new DefaultPointcutAdvisor(staticPointcut, simpleAdvice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(defaultAdvisor);
		pf.setTarget(new BeanOne());
		
		BeanOne one = (BeanOne)pf.getProxy();
		

		pf = new ProxyFactory();
		pf.addAdvisor(defaultAdvisor);
		pf.setTarget(new BeanTwo());
		
		BeanTwo two = (BeanTwo)pf.getProxy();

		one.foo();
		one.bar();
		
		two.foo();
		two.bar();
		

	}

}
