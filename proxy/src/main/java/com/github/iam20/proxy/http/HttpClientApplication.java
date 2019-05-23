package com.github.iam20.proxy.http;

import static com.github.iam20.proxy.config.ApplicationConfig.getHttpRestServerURI;

import com.github.iam20.proxy.model.CoreInformation;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class HttpClientApplication {
	private static RestTemplate restTemplate = new RestTemplate();

	public static int send(CoreInformation coreInformation) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<CoreInformation> coreInformationHttpEntity = new HttpEntity<>(coreInformation, headers);

		ResponseEntity<String> response =
				restTemplate.exchange(getHttpRestServerURI(), HttpMethod.PUT, coreInformationHttpEntity, String.class);
		return response.getStatusCodeValue();
	}
}
