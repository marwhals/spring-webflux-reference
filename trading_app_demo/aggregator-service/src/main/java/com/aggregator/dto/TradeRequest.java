package com.aggregator.dto;

import com.customer_service.domain.Ticker;
import com.customer_service.domain.TradeAction;

public record TradeRequest(Ticker ticker,
                           TradeAction action,
                           Integer quantity) {
}