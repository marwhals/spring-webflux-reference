package com.demo.customer_service.dto;

import com.demo.customer_service.domain.Ticker;
import com.demo.customer_service.domain.TradeAction;

public record StockTradeRequest(Ticker ticker, Integer price, Integer quantity, TradeAction action) {
}
