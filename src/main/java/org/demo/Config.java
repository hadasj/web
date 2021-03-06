package org.demo;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneOffset;
import java.util.Properties;

public class Config {
	protected static final String CONFIG_FILE_NAME = "config.properties";
	private static final String VERSION = "application.version";
	private static final String TIME_ZONE = "time.zone";
	private static final String USER = "default.user";
	private static final String AZ_LOCATION = "AZ_Location";
	private static final String APP_NAME = "APP_name";
	private static final String KEY_VAULT_URI = "key.vault.uri";

	private static final String DEFAULT_ZONE = ZoneOffset.UTC.getId();
	private static final String DEFAULT_USER = "user";
	private static final String DEFAULT_APP_NAME = "Demo";
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

	public static String getTimeZone() {
		return CONFIG_PROPERTIES.getProperty(TIME_ZONE, DEFAULT_ZONE);
	}

	public static String getUser() {
		return CONFIG_PROPERTIES.getProperty(USER, DEFAULT_USER);
	}

	public static String getLocation() {
		return System.getenv(AZ_LOCATION);
	}

	public static String getApplicationName() {
		final String configuredAppName = System.getenv(APP_NAME);
		return configuredAppName == null ? DEFAULT_APP_NAME : configuredAppName;
	}

	public static String getKeyVaultUri() {
		return CONFIG_PROPERTIES.getProperty(KEY_VAULT_URI);
	}
}
