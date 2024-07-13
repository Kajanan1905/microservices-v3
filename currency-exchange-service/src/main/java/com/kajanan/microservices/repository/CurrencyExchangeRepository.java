package com.kajanan.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kajanan.microservices.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
