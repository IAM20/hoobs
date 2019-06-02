package com.github.iam20.proxy.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
	@GetMapping("info")
	public String getNothing() {
		return "Nothing but string";
	}
}
