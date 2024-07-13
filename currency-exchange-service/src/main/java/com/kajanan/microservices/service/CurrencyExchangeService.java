package com.kajanan.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kajanan.microservices.model.CurrencyExchange;
import com.kajanan.microservices.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	public CurrencyExchange retrieveExchangeValue(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
