package com.github.iam20.proxy.config;

import com.github.iam20.proxy.model.CoreInformation;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ApplicationConfig {
	private static CoreInformation coreInformation;
	private static String restServerIp;
	private static String restServerPort;

	public static void init() {
		try {
			InputStream inputStream = ApplicationConfig.class
					.getClassLoader()
					.getResourceAsStream("application.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			restServerIp = (String)properties.get("restServerIp");
			restServerPort = (String)properties.get("restServerPort");

			log.debug("REST Server IP : {}", restServerIp);
			log.debug("REST Server port : {}", restServerPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static String getHttpRestServerURI() {
		return "http://" + restServerIp + ":" + restServerPort + "/info";
	}

	public static void setCoreInformation(CoreInformation coreInformation) {
		ApplicationConfig.coreInformation = coreInformation;
	}

	public static CoreInformation getCoreInformation() {
		return coreInformation;
	}
}
