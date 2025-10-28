package com.demo.customer_service.dto;

import com.demo.customer_service.domain.Ticker;

public record Holding(Ticker ticker, Integer quantity) {
}
