package org.demo;

import java.io.PrintWriter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GreetingsTest {

	@Mock
	private PrintWriter writer;

	@Captor
	private ArgumentCaptor<String> captor;

	private final Greetings greetings = new Greetings();

	@Test
	public void printGreetingsTest() {
		greetings.printGreetings(writer);

		verify(writer, times(7)).println(captor.capture());

		assertEquals(7, captor.getAllValues().size());
		assertNotNull(captor.getAllValues().get(3));
		assertEquals("<B> Application version: 1.0</B><BR/>", captor.getAllValues().get(3));
	}
}
