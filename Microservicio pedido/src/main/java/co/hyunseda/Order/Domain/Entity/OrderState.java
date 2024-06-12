package co.hyunseda.Order.Domain.Entity;

public enum OrderState {
    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED,
    CANCELLED
}
