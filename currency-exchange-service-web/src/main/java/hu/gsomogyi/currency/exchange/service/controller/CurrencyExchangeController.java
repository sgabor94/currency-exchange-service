package hu.gsomogyi.currency.exchange.service.controller;

import hu.gsomogyi.currency.exchange.service.CurrencyExchange;
import hu.gsomogyi.currency.exchange.service.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(CurrencyExchangeController.BASE_URL)
public class CurrencyExchangeController {

    static final String BASE_URL = "/api/currency-exchange";

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeController(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        Optional<CurrencyExchange> byFromAndTo = currencyExchangeRepository.findByFromAndTo(from, to);
        if (byFromAndTo.isPresent()) {
            return byFromAndTo.get();
        } else {
            throw new RuntimeException("Unable to find data for " + from + " and " + to);
        }
    }
}