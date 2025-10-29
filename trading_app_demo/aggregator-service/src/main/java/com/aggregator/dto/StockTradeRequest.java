package com.aggregator.dto;

import com.aggregator.domain.Ticker;
import com.aggregator.domain.TradeAction;

public record StockTradeRequest(Ticker ticker,
                                Integer price,
                                Integer quantity,
                                TradeAction action) {

}