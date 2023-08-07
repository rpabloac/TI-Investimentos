package br.com.tiinvestimentos.api.order;

import org.springframework.stereotype.Component;

import br.com.tiinvestimentos.exceptions.DuplicateResourceException;
import br.com.tiinvestimentos.util.Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderCreateCommand {
	private final OrderRepository orderRepository;
	private final OrderEventGateway orderEventGateway;
	private final Mapper mapper;

	public OrderResponse execute (OrderRequest request) {
		
		Order order = (
			Order.builder()
			.description(request.getDescription())
			.price(request.getPrice())
			.build()
		);
		
		if (orderRepository.findByDescription(request.getDescription()).isPresent()) {
			throw new DuplicateResourceException("Produto já existe!");
		}
		
		orderRepository.save(order);
		orderEventGateway.sendOrderCreatedEvent(order);
		
		OrderResponse response = mapper.map(order, OrderResponse.class);			
		return response;
	}
}
