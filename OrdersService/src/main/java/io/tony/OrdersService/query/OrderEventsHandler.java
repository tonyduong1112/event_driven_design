package io.tony.OrdersService.query;

import io.tony.OrdersService.core.data.OrderEntity;
import io.tony.OrdersService.core.data.OrdersRepository;
import io.tony.OrdersService.core.events.OrderCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("order-group")
public class OrderEventsHandler {
    private final OrdersRepository ordersRepository;

    public OrderEventsHandler(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) {
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(event, orderEntity);

        ordersRepository.save(orderEntity);
    }

}
