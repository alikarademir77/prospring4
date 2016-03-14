package com.apress.prospring4.ch2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MessageSupportFactory {

	private static MessageSupportFactory instance;
	
	private MessageProvider provider;
	private MessageRenderer renderer;
	
	private MessageSupportFactory() {
		
		Properties properties = new Properties();
		
		try{
			properties.load(new FileInputStream(
					"src/main/java/com/apress/prospring4/ch2/msf.properties"));
			String renderClass = properties.getProperty("render.class");
			String providerClass = properties.getProperty("provider.class");
			
			renderer = (MessageRenderer)Class.forName(renderClass).newInstance();
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static {
		instance = new MessageSupportFactory();
	}
	
	public static MessageSupportFactory getInstance() {
		return instance;
	}
	
	public MessageProvider getProvider() {
		return provider;
	}

	public MessageRenderer getRenderer() {
		return renderer;
	}
	
}

