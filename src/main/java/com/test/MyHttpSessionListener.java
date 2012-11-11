package com.test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Session creation time "+event.getSession().getCreationTime());
	}

	public void sessionDestroyed(HttpSessionEvent event) {
	}
}