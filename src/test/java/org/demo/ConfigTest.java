package org.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.demo.Config.CONFIG_FILE_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConfigTest {
	private BufferedReader configReader;

	@Before
	public void setUp() {
		final InputStream configStream = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
		assertNotNull("Expected resource " + CONFIG_FILE_NAME, configStream);

		configReader = new BufferedReader(new InputStreamReader(configStream));
	}

	@After
	public void tearDown() throws IOException {
		if (configReader != null) {
			configReader.close();
		}
	}

	@Test
	public void getCetZoneTest() {
		final String zone = Config.getTimeZone();
		assertNotNull(zone);
		assertEquals("Expected CET as zone","CET", zone);

		// final ZonedDateTime now = ZonedDateTime.now().withZoneSameInstant(ZoneId.of(zone));
		// System.out.println(now);
	}

	@Test
	public void getUserTest() {
		final String user = Config.getUser();
		assertNotNull(user);
		assertEquals("Jan", user);
	}

	@Test
	public void getVersionTest() throws IOException {
		final String version = Config.getVersion();
		assertNotNull(version);
		// version is the first line in the config properties
		final String expectedVersion = configReader.readLine().split("=")[1].trim();
		assertEquals(expectedVersion, version);
	}
}
