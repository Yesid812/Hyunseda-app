package co.hyunseda.Order.Domain.State.Context;

import co.hyunseda.Order.Domain.Entity.OrderState;
import co.hyunseda.Order.Domain.State.Context.IOrderState;
import co.hyunseda.Order.Domain.State.States.*;

public class OrderStateFactory {

    public static IOrderState create(OrderState state) {
        switch (state) {
            case PENDING:
                return new PendingState();
            case PROCESSING:
                return new ProcessingState();
            case COMPLETED:
                return new CompletedState();
            case CANCELLED:
                return new CancelledState();
            case FAILED:
                return new FailedState();
            default:
                throw new IllegalArgumentException("Invalid order state: " + state);
        }
    }
}