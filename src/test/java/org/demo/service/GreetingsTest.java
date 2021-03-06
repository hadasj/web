package org.demo.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.demo.Config;
import org.demo.service.Greetings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GreetingsTest {
	private static final String SERVER = "Tomcat 9.0.41";
	private static final String USER = "tester4";
	private static final int EXPECTED_LINES = 12;

	@Mock
	private PrintWriter writer;

	@Captor
	private ArgumentCaptor<String> captor;

	private final Greetings greetings = new Greetings();

	@Test
	public void printGreetingsTest() {
		final Map<String, String[]> parameters = new HashMap<>();
		parameters.put(Greetings.USER_PARAMETER, new String[] {USER});

		greetings.printGreetings(writer, SERVER, parameters);

		verify(writer, times(EXPECTED_LINES)).println(captor.capture());

		assertEquals("Expected greetings with 12 lines of HTML", EXPECTED_LINES, captor.getAllValues().size());
		assertNotNull(captor.getAllValues().get(3));
		assertEquals("<B> Application version: " + Config.getVersion() + "</B><BR/>", captor.getAllValues().get(3));
	}
}
