package br.com.tiinvestimentos.api.order;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	//@ColumnDefault("gen_random_uuid()")
	private UUID id;
	
	@Column
	private String description;
	
	@Column
	private BigDecimal price;
	
	@PrePersist
    public void prePersist() {		
		if (id==null) this.id = UUID.randomUUID();
    }
}
