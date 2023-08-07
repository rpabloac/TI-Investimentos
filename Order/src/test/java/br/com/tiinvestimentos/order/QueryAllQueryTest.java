package br.com.tiinvestimentos.order;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.tiinvestimentos.api.order.OrderGetAllQuery;

@ExtendWith(MockitoExtension.class)
public class QueryAllQueryTest {
	@Mock
	OrderGetAllQuery getAllQuery;
}
