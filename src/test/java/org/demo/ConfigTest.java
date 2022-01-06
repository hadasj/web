package org.demo;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConfigTest {

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
	public void getVersionTest() {
		final String version = Config.getVersion();
		assertNotNull(version);
		assertEquals("1.3", version);
	}
}
