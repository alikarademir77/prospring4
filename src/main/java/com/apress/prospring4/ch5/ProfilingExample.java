package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {

	public static void main(String[] args) {
		WorkerBean worker = getWorkerBean();
		worker.doSomeWork(10000000);

	}
	
	private static WorkerBean getWorkerBean() {
		WorkerBean target = new WorkerBean();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new ProfilingInterceptor());
		
		return (WorkerBean)pf.getProxy();
	}

}
