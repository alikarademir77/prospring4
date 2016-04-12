package com.apress.prospring4.ch5;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionExample {

	public static void main(String[] args) {

		TargetBean target = new TargetBean();
		IntroductionAdvisor aspect = new IsModifiedAdvisor();
		
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(aspect);
		pf.setOptimize(true);
		
		TargetBean proxy = (TargetBean)pf.getProxy();
		
		System.out.println("IsModified?" + ((IsModified)proxy).isModified());
		System.out.println("Setting Name..");
		proxy.setName("set name..");
		System.out.println("IsModified?" + ((IsModified)proxy).isModified());
		
		
		
	}

}
