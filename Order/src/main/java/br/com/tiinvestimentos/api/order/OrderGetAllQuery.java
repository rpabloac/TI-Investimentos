package br.com.tiinvestimentos.api.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderGetAllQuery {
	private final OrderRepository orderRepository;

	public List<OrderResponse> get() {
		List<OrderResponse> response = orderRepository.findAll()
			.stream()
			.map(order -> {
				OrderResponse o = new OrderResponse();
				o.setDescription(order.getDescription());
				o.setPrice(order.getPrice());
				return o;
			})
			.collect(Collectors.toList());
		
		return response;
	}
}
