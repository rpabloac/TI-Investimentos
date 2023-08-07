package br.com.tiinvestimentos.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tiinvestimentos.api.order.OrderGetAllQuery;
import br.com.tiinvestimentos.api.order.OrderResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderGetAllQueryTest {
	
	@Autowired
	private OrderGetAllQuery query;
	
	@Test
	public void should_retrive_all_orders() {
		List<OrderResponse> list = query.get();
		
		assertThat(list.getClass().isArray());
	}
}
