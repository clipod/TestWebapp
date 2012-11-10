package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.repository.CredentialsDAO;
import com.repository.CredentialsEntity;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Entering doGet method for LoginServlet");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		RequestDispatcher dispatcher = null;

		if (request.getSession() != null && userName.equals(request.getSession().getAttribute("userName"))) {
			request.getSession().setAttribute("refresh", "Refreshed page");
		} else {
			CredentialsDAO credentialsDAO = new CredentialsDAO();
			CredentialsEntity credentialsEntity = credentialsDAO.getCredentials(userName);
			if (credentialsEntity.getPassword().equals(password) && !userName.isEmpty() && !password.isEmpty()) {
				LOGGER.info("Login Validated");
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("userName", userName);
				httpSession.setAttribute("password", password);

			}
		}
		dispatcher = request.getRequestDispatcher("Result.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
