package br.com.tiinvestimentos.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.tiinvestimentos.api.order.OrderCreateCommand;
import br.com.tiinvestimentos.api.order.OrderEventGateway;
import br.com.tiinvestimentos.api.order.OrderRepository;
import br.com.tiinvestimentos.api.order.OrderRequest;
import br.com.tiinvestimentos.api.order.OrderResponse;
import br.com.tiinvestimentos.util.Mapper;

@ExtendWith(MockitoExtension.class)
public class OrderCreateCommandTest {
	@Mock
	OrderCreateCommand createCommand;
	
	@Mock 
	OrderRepository orderRepository;
	
	@Mock
	OrderEventGateway orderEventGateway;
	
	@Mock
	Mapper mapper;
	
	@Test
	public void testCreateOrder() throws Exception {
		OrderRequest orderRequest = (
				OrderRequest.builder()
				.description("Produto 1")
				.price(new BigDecimal(15.99))
				.build()
			);
		
		OrderResponse orderResponse = createCommand.execute(orderRequest);
		
		assertThat(!orderResponse.equals(null));
	}
}
