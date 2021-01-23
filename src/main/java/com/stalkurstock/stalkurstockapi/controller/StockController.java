package com.stalkurstock.stalkurstockapi.controller;

import com.stalkurstock.stalkurstockapi.dto.Symbol;
import com.stalkurstock.stalkurstockapi.entity.StockSymbol;
import com.stalkurstock.stalkurstockapi.repository.StockSymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/symbols")
public class StockController {

    @Autowired
    private StockSymbolRepository stockSymbolRepository;

    @GetMapping
    public List<Symbol> getAllSymbols() {
        try {
            List<StockSymbol> stockSymbols = (List<StockSymbol>) stockSymbolRepository.findAll();
            List<Symbol> symbols = new ArrayList<>();
            stockSymbols.forEach((s) -> symbols.add(new Symbol(s.getSymbol(), s.getDescription())));
            return symbols;
        } catch (Exception e) {
            System.out.println("*****Couldn't get symbols*******");
            return null;
        }
    }

    @GetMapping("/{symbol}")
    public Symbol getSymbol(@PathVariable String symbol) {
        try {
            StockSymbol stockSymbol = stockSymbolRepository.findDistinctBySymbol(symbol);
            return Symbol.builder()
                    .symbol(stockSymbol.getSymbol())
                    .description(stockSymbol.getDescription())
                    .build();
        } catch (Exception e) {
            System.out.println("**********SYMBOL NOT FOUND***************");
            return null;
        }
    }
}