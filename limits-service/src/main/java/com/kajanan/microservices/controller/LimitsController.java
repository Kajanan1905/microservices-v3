package com.kajanan.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kajanan.microservices.configuration.Configuration;
import com.kajanan.microservices.model.Limits;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(5, 19);
	}

	@GetMapping("/limits-from-properties")
	public Limits retrieveLimitsFromProperties() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}

}
