package org.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static final String CONFIG_FILE_NAME = "config.properties";
	private static final String VERSION = "application.version";
	private static final Properties CONFIG_PROPERTIES = new Properties();
	static {
		try {
			final InputStream configData = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
			if (configData != null) {
				CONFIG_PROPERTIES.load(configData);
			} else {
				throw new IllegalStateException("Missing resource: " + CONFIG_FILE_NAME);
			}
		} catch (IOException e) {
			throw new IllegalStateException("Unexpected IO Error: " + e.getMessage());
		}
	}

	public static String getVersion() {
		return CONFIG_PROPERTIES.getProperty(VERSION);
	}
}
