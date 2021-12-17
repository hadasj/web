package org.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DemoServlet extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html";

	private final Greetings greetings = new Greetings();

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		response.setContentType(CONTENT_TYPE);
		greetings.printGreetings(response.getWriter());
	}
}
