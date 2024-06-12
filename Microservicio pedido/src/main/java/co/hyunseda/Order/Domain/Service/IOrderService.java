package co.hyunseda.Order.Domain.Service;

import co.hyunseda.Order.Domain.Entity.Order;
import co.hyunseda.Order.Domain.Entity.OrderState;
import co.hyunseda.Order.Domain.State.Context.IOrderState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    List<Order> findAllOrders();
    Order findOrderById(long id);
    void changeState(Order order, IOrderState newState);
}
