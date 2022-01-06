package org.demo;

import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Greetings {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss (z)");
	protected static final String USER_PARAMETER = "user";

	public void printGreetings(final PrintWriter writer, final String serverInfo, final Map<String, String[]> parameters) {
		try {
			final String[] userParameters = parameters.get(USER_PARAMETER);
			final String user = userParameters != null && userParameters.length > 0 ? userParameters[0] : Config.getUser();

			writer.println("<html><body>");
			writer.println("<BR/><BR/><BR/><center><H1><B> *** Welcome to " + user +
					" Demo *** </B></H1></center><BR/><BR/>");
			printInfo(writer, serverInfo);

			writer.println("</body></html>");
		} finally {
			writer.close();
		}
	}

	private void printInfo(final PrintWriter writer, final String serverInfo) {
		// server time is in UTC
		final ZonedDateTime utcTime = ZonedDateTime.now();
		// convert server time to the configured user time zone
		final ZoneId userTimeZone = ZoneId.of(Config.getTimeZone());
		final ZonedDateTime userTime = utcTime.withZoneSameInstant(userTimeZone);

		writer.println("<B> " + userTime.format(DATE_FORMAT) + " </B><BR/>");
		writer.println("<B> Application version: " + Config.getVersion() + "</B><BR/>");
		writer.println("<B> Server: " + serverInfo + "</B><BR/>");
		writer.println("<B> Java version: " + System.getProperty("java.version") + "</B><BR/>");
		writer.println("<B> Operation system: " + System.getProperty("os.name") + " "
				+ System.getProperty("os.version") + " (" + System.getProperty("os.arch") + ") </B><BR/>");
		writer.println("<BR/>Implemented by jhadas.");
	}
}
