package co.hyunseda.Order.Domain.State.States;

import co.hyunseda.Order.Domain.Entity.Order;
import co.hyunseda.Order.Domain.Entity.OrderState;
import co.hyunseda.Order.Domain.State.Context.IOrderState;

public class ProcessingState implements IOrderState {

    @Override
    public void changeOrderState(Order order) {
        order.setOrderState(OrderState.PROCESSING);
    }
}
