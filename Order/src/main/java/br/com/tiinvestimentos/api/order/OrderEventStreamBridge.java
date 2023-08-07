package br.com.tiinvestimentos.api.order;

import br.com.tiinvestimentos.config.CloudStreamConfig;
import br.com.tiinvestimentos.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventStreamBridge implements OrderEventGateway {

	private final StreamBridge streamBridge;
    private final CloudStreamConfig cloudConfig;
    private final Mapper mapper;
    
	@Override
	public void sendOrderCreatedEvent(Order order) {
		log.info("Order criado " + order.getId());
		
		OrderRequest request = mapper.map(order, OrderRequest.class);
		streamBridge.send(cloudConfig.getOrderCreatedChannel(), request);		
	}
}
