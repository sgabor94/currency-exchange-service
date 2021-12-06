package hu.gsomogyi.currencyexchangeservice.controller;

import hu.gsomogyi.currencyexchangeservice.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(CurrencyExchangeController.BASE_URL)
public class CurrencyExchangeController {

    static final String BASE_URL = "/api/currency-exchange";

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        System.out.println("Called");
        return new CurrencyExchange(1000L, from, to, new BigDecimal("50"));
    }
}