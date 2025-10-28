package com.aggregator.dto;

import com.customer_service.domain.Ticker;
import com.customer_service.domain.TradeAction;

public record StockTradeRequest(Ticker ticker,
                                Integer price,
                                Integer quantity,
                                TradeAction action) {

}