package com.apress.prospring4.ch5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutExample {

	public static void main(String[] args) {
		SampleAnnotationBean target = new SampleAnnotationBean();
		Advice advice = new SimpleAdvice();
		AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forClassAnnotation(AdviceRequired.class);
		Advisor aspect = new DefaultPointcutAdvisor(pointcut, advice);
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(aspect);
		
		
		SampleAnnotationBean proxy = (SampleAnnotationBean)pf.getProxy();
		
		proxy.foo(100);
		
		proxy.bar();
		
		

	}

}
