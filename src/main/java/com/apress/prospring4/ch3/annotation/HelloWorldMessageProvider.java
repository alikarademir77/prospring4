package com.apress.prospring4.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.prospring4.ch3.MessageProvider;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

	private String message;
	
	@Autowired
	public HelloWorldMessageProvider(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
