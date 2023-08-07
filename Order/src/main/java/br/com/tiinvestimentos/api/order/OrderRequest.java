package br.com.tiinvestimentos.api.order;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	private UUID id;
	
	@NotNull(message = "{required.validation}")
	private String description;
	
	@NotNull(message = "{required.validation}")
	private BigDecimal price;
}
