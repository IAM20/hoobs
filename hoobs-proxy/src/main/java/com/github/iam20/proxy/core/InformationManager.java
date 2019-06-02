package com.github.iam20.proxy.core;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InformationManager extends CoapResource {
	public InformationManager() {
		super("info");
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		log.info("POST REQUEST !!!");
	}

	@Override
	public void handlePUT(CoapExchange exchange) {
		handlePOST(exchange);
	}
}
