package com.stalkurstock.stalkurstockapi.service;

import com.stalkurstock.stalkurstockapi.dto.Quote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinnHubQuoteService {
    private RestTemplate restTemplate;

    @Value("${finnhub.base.url}")
    private String finnHubBaseUrl;

    @Value("${finnhub.quote.url}")
    private String finnHubQuoteUrl;

    @Value("${finnhub.api.key}")
    private String finnHubApiKey;

    public FinnHubQuoteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Quote fetchRealTimeStockQuote(String symbol) {
        String url = finnHubBaseUrl + finnHubQuoteUrl + symbol + finnHubApiKey;

        ResponseEntity<Quote> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(createHttpHeaders()), Quote.class);

        return responseEntity.getBody();
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}