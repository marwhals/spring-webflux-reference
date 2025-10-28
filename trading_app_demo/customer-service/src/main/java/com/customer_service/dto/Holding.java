package com.customer_service.dto;

import com.customer_service.domain.Ticker;

public record Holding(Ticker ticker, Integer quantity) {
}
