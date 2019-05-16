package com.github.iam20.device.config;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Properties;

public class ApplicationConfig {
	private static String netMask;
	private static String ipAddr;
	private static String serverIpAddr;
	private static String serverPortNumber;

	public static void init() {
		try {
			InputStream inputStream = ApplicationConfig.class
					.getClassLoader()
					.getResourceAsStream("application.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			serverIpAddr = (String)properties.get("proxyServerIp");
			serverPortNumber = (String)properties.get("proxyServerPort");

			ipAddr = InetAddress.getLocalHost().getHostAddress();
			NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
			int intNetMask = networkInterface.getInterfaceAddresses().get(1).getNetworkPrefixLength();
			netMask = Integer.toString(intNetMask);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static String getProxyServerUri() {
		return "coap://" + serverIpAddr + ":" + serverPortNumber + "/";
	}

	public static String getIpConfig() {
		return ipAddr + "/" + netMask;
	}

	public static String getNetMask() {
		return netMask;
	}

	public static String getIpAddr() {
		return ipAddr;
	}

	public static String getServerIpAddr() {
		return serverIpAddr;
	}

	public static String getServerPortNumber() {
		return serverPortNumber;
	}
}
