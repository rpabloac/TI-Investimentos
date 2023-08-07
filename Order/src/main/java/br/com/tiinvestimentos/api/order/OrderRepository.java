package br.com.tiinvestimentos.api.order;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
	@Query("SELECT o FROM Order o WHERE o.description = :p ORDER BY o.description LIMIT 1")
	Optional<Order> findByDescription(@Param("p") String p);
}
