package co.hyunseda.Order.Domain.Service;

import co.hyunseda.Order.Access.IOrderRepository;
import co.hyunseda.Order.Domain.Entity.Order;
import co.hyunseda.Order.Domain.Entity.OrderState;
import co.hyunseda.Order.Domain.State.Context.IOrderState;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{


    @Autowired
    IOrderRepository orderRepository;


    /**
     * @Brief Listar todas las ordenes
     * @return Lista de todos los pedidos
     */
    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }


    /**
     * @Brief Buscar una order por su id
     * @param id Id del producto a buscar
     * @return Producto buscado
     */
    @Override
    public Order findOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }


    /**
     * Cambia el estado de una orden
     * @param order Orden a cambiar su estado
     * @param newState El nuevo estado que tendrá la orden
     */
    @Override
    public void changeState(Order order, IOrderState newState) {
        order.changeState(newState);
        orderRepository.save(order);
    }
}
