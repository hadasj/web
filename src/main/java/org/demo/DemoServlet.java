package org.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoServlet extends HttpServlet {
	

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

		response.setContentType("text/html");//setting the content type
		final PrintWriter writer=response.getWriter();//get the stream to write the data

		//writing html in the stream
		writer.println("<html><body>");
		writer.println("<BR/><BR/><BR/><center><H1><B> *** Welcome to Jan Demo *** </B></H1></center><BR/><BR/>");
		writer.println("<B> Java version: " + System.getProperty("java.version"));
		writer.println("</body></html>");

		writer.close();//closing the stream
	}
}
