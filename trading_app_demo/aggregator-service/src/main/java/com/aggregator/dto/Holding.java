package com.aggregator.dto;

import com.aggregator.domain.Ticker;

public record Holding(Ticker ticker,
                      Integer quantity) {
}