package br.com.tiinvestimentos.api.order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/orders")
public class OrderController {
	private final OrderCreateCommand createCommand;
	private final OrderGetAllQuery getAllQuery;
	
	@PostMapping
	public ResponseEntity<?> create(
			@Validated
			@RequestBody 
			OrderRequest request
		) {

		return new ResponseEntity<OrderResponse>(
				createCommand.execute(request), HttpStatus.CREATED
			);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<OrderResponse>>(
				getAllQuery.get(), HttpStatus.OK
			);
	}
}
