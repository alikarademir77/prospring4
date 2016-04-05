package com.apress.prospring4.ch5;

@AdviceRequired
public class SampleAnnotationBean {

	public void foo(int x) {
		System.out.println("Invoked foo() with: " + x);
	}

	public void bar() {
		System.out.println("Invoked bar()");
	}
}
