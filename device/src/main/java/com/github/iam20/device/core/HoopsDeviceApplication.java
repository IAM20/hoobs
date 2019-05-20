package com.github.iam20.device.core;

import com.github.iam20.device.config.ApplicationConfig;

public class HoopsDeviceApplication {
	public static void run() {
		ApplicationConfig.init();
		TempHumidGetter.makeThread().start();
		MacAddressGetter.makeThread().run();
		System.out.println(ApplicationConfig.getCoreInformation().toString());
	}
}
