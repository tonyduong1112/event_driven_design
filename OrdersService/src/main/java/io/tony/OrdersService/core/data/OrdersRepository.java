package io.tony.OrdersService.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrderEntity, String> {

}
