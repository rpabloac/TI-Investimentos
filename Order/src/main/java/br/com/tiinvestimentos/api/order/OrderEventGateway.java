package br.com.tiinvestimentos.api.order;

public interface OrderEventGateway {
	void sendOrderCreatedEvent(Order request);
}
