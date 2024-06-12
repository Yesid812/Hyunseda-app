package co.hyunseda.Order.Domain.State.States;

import co.hyunseda.Order.Domain.Entity.Order;
import co.hyunseda.Order.Domain.Entity.OrderState;
import co.hyunseda.Order.Domain.State.Context.IOrderState;

public class FailedState implements IOrderState {
    @Override
    public void changeOrderState(Order order) {
        System.out.println("Ha ocurrido un problema con la orden, reintentalo!");
        order.setOrderState(OrderState.FAILED);
    }
}
