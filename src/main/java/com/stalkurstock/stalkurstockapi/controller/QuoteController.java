package com.stalkurstock.stalkurstockapi.controller;

import com.stalkurstock.stalkurstockapi.dto.Quote;
import com.stalkurstock.stalkurstockapi.service.FinnHubQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {

    @Autowired
    private FinnHubQuoteService finnHubQuoteService;

    @GetMapping
    public Quote getQuoteBySymbol(@RequestParam("symbol") String symbol) {
        return finnHubQuoteService.fetchRealTimeStockQuote(symbol);
    }
}
