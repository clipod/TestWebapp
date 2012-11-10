package com.test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setMaxInactiveInterval(5);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
	}
}