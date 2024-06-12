package co.hyunseda.Order.Domain.State.Context;

import co.hyunseda.Order.Domain.Entity.Order;

public interface IOrderState {
    public void changeOrderState(Order order);
}
