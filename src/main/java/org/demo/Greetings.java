package org.demo;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Greetings {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss (z)");
	private static final String ZONE_CET = "CET";

	public void printGreetings(final PrintWriter writer, final String serverInfo) {
		try {
			writer.println("<html><body>");

			writer.println("<BR/><BR/><BR/><center><H1><B> *** Welcome to Jan Demo *** </B></H1></center><BR/><BR/>");
			printInfo(writer, serverInfo);

			writer.println("</body></html>");
		} finally {
			writer.close();
		}
	}

	private void printInfo(final PrintWriter writer, final String serverInfo) {
		final ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(ZONE_CET));
		writer.println("<B> " + now.format(DATE_FORMAT) + " </B><BR/>");
		writer.println("<B> Application version: " + Config.getVersion() + "</B><BR/>");
		writer.println("<B> Server: " + serverInfo + "</B><BR/>");
		writer.println("<B> Java version: " + System.getProperty("java.version") + "</B><BR/>");
		writer.println("<B> Operation system: " + System.getProperty("os.name") + " "
				+ System.getProperty("os.version") + " (" + System.getProperty("os.arch") + ") </B><BR/>");
		writer.println("<BR/>Implemented by jhadas.");
	}
}
