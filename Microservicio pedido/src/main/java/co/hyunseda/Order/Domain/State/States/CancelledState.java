package co.hyunseda.Order.Domain.State.States;

import co.hyunseda.Order.Domain.Entity.Order;
import co.hyunseda.Order.Domain.Entity.OrderState;
import co.hyunseda.Order.Domain.State.Context.IOrderState;

public class CancelledState implements IOrderState {
    @Override
    public void changeOrderState(Order order) {
        System.out.println("La orden ha sido cancelada!");
        order.setOrderState(OrderState.CANCELLED);
    }
}
