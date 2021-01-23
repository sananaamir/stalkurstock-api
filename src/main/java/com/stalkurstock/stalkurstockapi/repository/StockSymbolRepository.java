package com.stalkurstock.stalkurstockapi.repository;

import com.stalkurstock.stalkurstockapi.entity.StockSymbol;
import org.springframework.data.repository.CrudRepository;

public interface StockSymbolRepository extends CrudRepository<StockSymbol, Long> {
    StockSymbol findDistinctBySymbol(String symbol);
}
