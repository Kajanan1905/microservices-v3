package com.kajanan.microservices.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kajanan.microservices.model.CurrencyConversion;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange-db/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValueFromDb(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
