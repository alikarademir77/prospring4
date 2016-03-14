package com.apress.prospring4.ch2;

public class HelloWorldDecoupledWithFactory {

	public static void main(String[] args) {
		MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
		MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
		mr.setMessageProvider(mp);
		mr.render();

	}

}
