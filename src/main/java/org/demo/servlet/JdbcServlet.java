package org.demo.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.demo.client.AzureKeyVaultClient;

public class JdbcServlet extends Servlet {
	private static final String DB = "db";
	private static final String DB_USER = "dbuser";
	private static final String DB_PASSWORD = "dbpassword";

	private final AzureKeyVaultClient keyVaultClient = new AzureKeyVaultClient();

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
		response.setContentType(CONTENT_TYPE);

		try (final PrintWriter writer = response.getWriter()) {
			writer.println("<html><body>");
			writer.println("db: " + keyVaultClient.readSecret(DB) + "</BR>");
			writer.println("db user: " + keyVaultClient.readSecret(DB_USER) + "</BR>");
			writer.println("db password: " + keyVaultClient.readSecret(DB_PASSWORD) + "</BR>");
			writer.println("</body></html>");
		}
	}
}
