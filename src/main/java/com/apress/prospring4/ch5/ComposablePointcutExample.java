package com.apress.prospring4.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;

public class ComposablePointcutExample {

	public static void main(String[] args) {
		SampleBean target = new SampleBean();
		ComposablePointcut pointcut = new ComposablePointcut(ClassFilter.TRUE, new GetMethodMatcher());
		SampleBean proxy = getProxy(target, pointcut);
		System.out.println("\nTest with Get Method Matcher");
		test(proxy);

		pointcut.union(new SetMethodMatcher());
		proxy = getProxy(target, pointcut);
		System.out.println("\nTest with Get Method Matcher Union Set Method Matcher");
		test(proxy);

		pointcut.intersection(new GetAgeMethodMatcher());
		proxy = getProxy(target, pointcut);
		System.out.println("\nTest with Get Method Matcher Union Set Method Matcher intersect GetAge Method matcher");
		test(proxy);
		
	}

	private static void test(SampleBean proxy) {
		proxy.getName();
		proxy.setName("Test");
		proxy.getAge();
	}
	private static SampleBean getProxy(SampleBean target, Pointcut pointcut) {
		Advisor aspect = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(aspect);
		
		return (SampleBean)pf.getProxy();
	}
	
	private static class GetMethodMatcher extends StaticMethodMatcher{

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.getName().startsWith("get");
		}
		
	}

	private static class SetMethodMatcher extends StaticMethodMatcher{

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.getName().startsWith("set");
		}
		
	}

	private static class GetAgeMethodMatcher extends StaticMethodMatcher{

		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return method.getName().startsWith("getAge");
		}
		
	}
	
}
