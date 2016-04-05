package com.apress.prospring4.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out.println("Dynamic check for method " + method.getName());
		int arg = ((Integer)args[0]).intValue();
		return (100 == arg);
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			
			@Override
			public boolean matches(Class<?> clazz) {
				return SampleBean.class == clazz;
			}
		};
	}
	
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("Static check for method " + method.getName());
		return "foo".equals(method.getName());
	}
}
