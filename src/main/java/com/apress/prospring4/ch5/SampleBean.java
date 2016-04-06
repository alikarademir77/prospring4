package com.apress.prospring4.ch5;

public class SampleBean {
	 public void foo(int x) {
	 System.out.println("Invoked foo() with: " + x);
	 }
	
	 public void bar() {
	 System.out.println("Invoked bar()");
	 }

	public String getName() {
		return "Ali K";
	}

	public void setName(String name) {
	}

	public int getAge() {
		return 32;
	}
}
