package com.demo.customer_service;

import com.demo.customer_service.domain.Ticker;
import com.demo.customer_service.domain.TradeAction;
import com.demo.customer_service.dto.StockTradeRequest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CustomerServiceApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(CustomerServiceApplicationTests.class);

	@Autowired
	private WebTestClient client;

	@Test
	public void customerInformation() {
		getCustomer(1, HttpStatus.OK)
				.jsonPath("$.name").isEqualTo("Sam")
				.jsonPath("$.balance").isEqualTo(10000)
				.jsonPath("$.holdings").isEmpty();
	}

	@Test
	public void buyAndSell(){
		//buy
		var buyRequest = new StockTradeRequest(Ticker.GOOGLE, 100, 5, TradeAction.BUY);
		trade(2, buyRequest, HttpStatus.OK)
				.jsonPath("$.balance").isEqualTo(9500);
	}

	private WebTestClient.BodyContentSpec getCustomer(Integer customerId, HttpStatus expectedStatus) {
		return this.client.get()
				.uri("/customers/{customerId}", customerId)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody()
				.consumeWith(e -> log.info("{}", new String(Objects.requireNonNull(e.getResponseBody()))));
	}

	private WebTestClient.BodyContentSpec trade(Integer customerId, StockTradeRequest request, HttpStatus expectedStatus) {
		return this.client.post()
				.uri("/customers/{customerId}/trade", customerId)
				.bodyValue(request)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody()
				.consumeWith(e -> log.info("{}", new String(Objects.requireNonNull(e.getResponseBody()))));
	}

}
