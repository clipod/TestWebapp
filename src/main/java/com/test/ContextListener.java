package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.repository.CredentialsDAO;
import com.repository.CredentialsEntity;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servlet context listener started ************************");
		CredentialsDAO credentialsDAO = new CredentialsDAO();
		List<CredentialsEntity> list = new ArrayList<CredentialsEntity>();
		list.add(new CredentialsEntity("nithin", "nithin"));
		list.add(new CredentialsEntity("venkat", "venkat"));
		list.add(new CredentialsEntity("chinni", "chinni"));

		for (CredentialsEntity entity : list) {
			credentialsDAO.saveCredentials(entity);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servlet context listener destroyed");
	}

}
