package br.com.tiinvestimentos.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tiinvestimentos.api.order.OrderCreateCommand;
import br.com.tiinvestimentos.api.order.OrderRequest;
import br.com.tiinvestimentos.api.order.OrderResponse;
import br.com.tiinvestimentos.exceptions.DuplicateResourceException;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderCreateCommandTest {
	@Autowired
	private OrderCreateCommand createCommand;
	
	@Test
	public void shoud_create_one_order() {
		OrderRequest order = ( OrderRequest.builder()
				.description("produto " + UUID.randomUUID())
				.price(new BigDecimal(15.99))
				.build()
		);
		
		OrderResponse response = createCommand.execute(order);
		assertThat(response.getDescription() == order.getDescription());
		assertThat(response.getPrice() == order.getPrice());
	}
	
	@Test
	public void shoud_duplicate_exception() {
		OrderRequest order = ( OrderRequest.builder()
				.description("produto " + UUID.randomUUID())
				.price(new BigDecimal(15.99))
				.build()
		);
		
		createCommand.execute(order);
		
		assertThrows(DuplicateResourceException.class, () -> createCommand.execute(order));
	}
	
}
