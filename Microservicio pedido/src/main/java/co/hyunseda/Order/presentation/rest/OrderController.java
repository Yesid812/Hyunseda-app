package co.hyunseda.Order.presentation.rest;

import co.hyunseda.Order.Domain.Entity.Order;
import co.hyunseda.Order.Domain.Entity.OrderState;
import co.hyunseda.Order.Domain.Service.IOrderService;
import co.hyunseda.Order.Domain.State.Context.IOrderState;
import co.hyunseda.Order.Domain.State.Context.OrderStateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PutMapping("/{orderId}/state/{newState}")
    public ResponseEntity<Void> changeOrderState(@PathVariable Long orderId, @PathVariable OrderState newState) {
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        IOrderState state = OrderStateFactory.create(newState); // Crea un nuevo estado
        orderService.changeState(order, state); // Cambia el estado del pedido

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
