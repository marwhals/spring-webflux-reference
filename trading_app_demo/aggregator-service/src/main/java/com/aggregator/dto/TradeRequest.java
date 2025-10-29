package com.aggregator.dto;

import com.aggregator.domain.Ticker;
import com.aggregator.domain.TradeAction;

public record TradeRequest(Ticker ticker,
                           TradeAction action,
                           Integer quantity) {
}