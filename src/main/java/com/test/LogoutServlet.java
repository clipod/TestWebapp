package com.test;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.repository.CredentialsDAO;
import com.repository.CredentialsEntity;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = LoggerFactory.getLogger(LogoutServlet.class);
	private final String JSESSIONID = "JSESSIONID";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (JSESSIONID.equals(cookies[i].getName()))
				System.out.println("JSessionId from cookies "+cookies[i].getValue());
		}
		session.invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
