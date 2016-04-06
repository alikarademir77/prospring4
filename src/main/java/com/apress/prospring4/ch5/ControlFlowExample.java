package com.apress.prospring4.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowExample {

	public static void main(String[] args) {
		ControlFlowExample ex = new ControlFlowExample();
		ex.run();
	}
	
	private void run() {
		TestBean target = new TestBean();
		
		Pointcut pointcut = new ControlFlowPointcut(ControlFlowExample.class, "test");
		Advisor aspect = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
		ProxyFactory pf = new ProxyFactory();
		
		pf.setTarget(target);
		pf.addAdvisor(aspect);
		
		TestBean proxy = (TestBean)pf.getProxy();
		
		proxy.foo();
		System.out.println("Trying under ControlFlowExample.test()");
		test(proxy);
	}
	private void test(TestBean bean) {
		bean.foo();
	}

}
