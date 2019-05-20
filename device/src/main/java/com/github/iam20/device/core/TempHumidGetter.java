package com.github.iam20.device.core;

import com.github.iam20.device.config.ApplicationConfig;
import com.github.iam20.device.model.TempHumid;
import com.github.iam20.device.model.TempHumidBuilder;

public class TempHumidGetter {
	public static Thread makeThread() {
		return new Thread(() -> {
			TempHumid tempHumid = new TempHumidBuilder()
					.humid(77.8)
					.celcius(17.0)
					.build();
			ApplicationConfig.setTempHumid(tempHumid);
		});
	}
}
