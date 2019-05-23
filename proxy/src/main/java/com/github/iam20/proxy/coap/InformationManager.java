package com.github.iam20.proxy.coap;

import com.github.iam20.proxy.config.ApplicationConfig;
import com.github.iam20.proxy.http.HttpClientApplication;
import com.github.iam20.proxy.model.CoreInformation;
import com.github.iam20.proxy.util.ParseCoreInfo;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;

@Slf4j
public class InformationManager extends CoapResource {
	public InformationManager(String name) {
		super(name);
	}

	public InformationManager() {
		this("info");
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		String requestText = exchange.getRequestText();
		JSONObject json = new JSONObject(requestText.toLowerCase());
		CoreInformation coreInformation = ParseCoreInfo.parse(json);
		int code = 200;
		if (!ApplicationConfig.getCoreInformation().equals(coreInformation)) {
			code = HttpClientApplication.send(coreInformation);
		}
		json = new JSONObject();
		if (code / 200 == 1) {
			code = 200;
		}
		json.put("code", code);
		ApplicationConfig.setCoreInformation(coreInformation);

		exchange.respond(CoAP.ResponseCode.CONTENT, json.toString(), MediaTypeRegistry.APPLICATION_JSON);
	}

	@Override
	public void handlePUT(CoapExchange exchange) {
		handlePOST(exchange);
	}
}
