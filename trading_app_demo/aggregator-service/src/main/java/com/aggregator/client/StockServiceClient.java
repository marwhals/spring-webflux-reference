package com.aggregator.client;

import com.aggregator.domain.Ticker;
import com.aggregator.dto.PriceUpdate;
import com.aggregator.dto.StockPriceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

public class StockServiceClient {

    private static final Logger log = LoggerFactory.getLogger(StockServiceClient.class);
    private final WebClient client;

    public StockServiceClient(WebClient client) {
        this.client = client;
    }

    public Mono<StockPriceResponse> getStockPrice(Ticker ticker) {
        return this.client.get()
                .uri("/stock/{ticker}", ticker)
                .retrieve()
                .bodyToMono(StockPriceResponse.class);
    }

    public Flux<PriceUpdate> getPriceUpdates() {
        return this.client.get()
                .uri("/stock/price-stream")
                .accept(MediaType.APPLICATION_NDJSON)
                .retrieve()
                .bodyToFlux(PriceUpdate.class);
    }

}
