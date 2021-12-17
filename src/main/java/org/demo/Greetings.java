package org.demo;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Greetings {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

	private final String serverInfo;

	public Greetings(final String serverInfo) {
		this.serverInfo = serverInfo;
	}

	public void printGreetings(final PrintWriter writer) {
		try {
			writer.println("<html><body>");

			writer.println("<BR/><BR/><BR/><center><H1><B> *** Welcome to Jan Demo *** </B></H1></center><BR/><BR/>");
			printInfo(writer);

			writer.println("</body></html>");
		} finally {
			writer.close();
		}
	}

	private void printInfo(final PrintWriter writer) {
		writer.println("<B> " + LocalDateTime.now().format(DATE_FORMAT) + "</B><BR/>");
		writer.println("<B> Application version: " + Config.getVersion() + "</B><BR/>");
		writer.println("<B> Server: " + serverInfo + "</B><BR/>");
		writer.println("<B> Java version: " + System.getProperty("java.version") + "</B><BR/>");
		writer.println("<B> Operation system: " + System.getProperty("os.name") + "</B><BR/>");
		writer.println("<BR/>Implemented by jhadas.");
	}
}
