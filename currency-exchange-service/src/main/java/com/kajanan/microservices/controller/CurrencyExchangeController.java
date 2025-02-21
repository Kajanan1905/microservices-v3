package com.kajanan.microservices.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kajanan.microservices.model.CurrencyExchange;
import com.kajanan.microservices.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		String port = environment.getProperty("local.server.port");

		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		currencyExchange.setEnvironment(port);

		return currencyExchange;
	}

	@GetMapping("/currency-exchange-db/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValueFromDb(@PathVariable String from, @PathVariable String to) {
		String port = environment.getProperty("local.server.port");

		CurrencyExchange currencyExchange = currencyExchangeService.retrieveExchangeValue(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}
		currencyExchange.setEnvironment(port);

		return currencyExchange;
	}

}
