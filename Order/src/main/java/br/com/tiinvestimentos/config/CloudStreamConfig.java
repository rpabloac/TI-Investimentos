package br.com.tiinvestimentos.config;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class CloudStreamConfig {
private static final String SERVICE_STREAM_NAME = "orderService";
	
	private String orderCreatedChannel = "orderCreatedSupplier-out-" + SERVICE_STREAM_NAME;
}
