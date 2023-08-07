package br.com.tiinvestimentos.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.tiinvestimentos.api.order.OrderController;
import br.com.tiinvestimentos.api.order.OrderCreateCommand;
import br.com.tiinvestimentos.api.order.OrderGetAllQuery;
import br.com.tiinvestimentos.api.order.OrderRequest;
import br.com.tiinvestimentos.api.order.OrderResponse;


@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
	@InjectMocks
	OrderController controller;
	
	@Mock
	OrderCreateCommand createCommand;
	
	@Mock
	OrderGetAllQuery getAllQuery;
	
	@Test
	public void testCreateOrder() throws Exception {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		OrderRequest orderRequest = (
				OrderRequest.builder()
				.description("Produto 1")
				.price(new BigDecimal(15.99))
				.build()
			);
		
		ResponseEntity<?> orderResponse = controller.create(orderRequest);
		
		assertThat(orderResponse.getStatusCode()).isEqualTo(201);
	}
	
	@Test
	public void testGetAllOrders() throws Exception {
		
		List<OrderResponse> orderResponse = controller.getAll();
		
		assertThat(orderResponse.size() > 0);
	}
}
