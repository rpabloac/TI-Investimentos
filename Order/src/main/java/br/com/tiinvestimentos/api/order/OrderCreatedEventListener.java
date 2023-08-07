package br.com.tiinvestimentos.api.order;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderCreatedEventListener implements Consumer<OrderRequest> {
	@Override
	public void accept(OrderRequest request)  {
		log.info("Order criado recebido " + request.getId());
		
	}
}
