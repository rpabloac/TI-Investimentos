package br.com.tiinvestimentos.order;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.notNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tiinvestimentos.api.order.OrderController;
import br.com.tiinvestimentos.api.order.OrderCreateCommand;
import br.com.tiinvestimentos.api.order.OrderGetAllQuery;
import br.com.tiinvestimentos.api.order.OrderRequest;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private OrderController orderController;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void init() {
		
	}
	
	@Test
	public void should_create_one_order() throws Exception {
		OrderRequest order1 = ( OrderRequest.builder()
				.description("produto 1")
				.price(new BigDecimal(15.99))
				.build()
		);
		
		this.mockMvc.perform(post("/v1/orders")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(order1))
			)
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.description", is(order1.getDescription())))
			.andExpect(jsonPath("$.price", is(order1.getPrice())))
			.andDo(print());
	}
	
	@Test
	public void should_invalid_request_witout_price_parameter() throws Exception {
		OrderRequest order1 = ( OrderRequest.builder()
				.description("produto 1")
				.build()				
		);
		
		this.mockMvc.perform(post("/v1/orders")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(order1))
			)
			.andExpect(status().isBadRequest())
			.andDo(print());
	}
	
	@Test
	public void should_invalid_request_witout_description_parameter() throws Exception {
		OrderRequest order1 = ( OrderRequest.builder()
				.price(new BigDecimal(15.99))
				.build()
		);
		
		this.mockMvc.perform(post("/v1/orders")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(order1))
			)
			.andExpect(status().isBadRequest())
			.andDo(print());
	}
	
	@Test
	public void should_retrieve_all_orders() throws Exception {
		mockMvc.perform(get("/v1/orders"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(APPLICATION_JSON))			
			.andExpect(jsonPath("$").isArray())
			.andDo(print());
	}
	
	
}
