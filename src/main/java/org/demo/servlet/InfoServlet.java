package org.demo.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.demo.service.Greetings;

public class InfoServlet extends Servlet {
	private final Greetings greetings = new Greetings();
	private ServletConfig servletConfig;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		servletConfig = config;
		super.init(config);
	}
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		response.setContentType(CONTENT_TYPE);
		greetings.printGreetings(response.getWriter(), servletConfig.getServletContext().getServerInfo(),
				request.getParameterMap());
	}
}
