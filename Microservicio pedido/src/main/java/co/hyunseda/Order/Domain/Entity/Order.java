package co.hyunseda.Order.Domain.Entity;

import co.hyunseda.Order.Domain.State.Context.IOrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate = LocalDateTime.now();

    @Column(name = "order_state")
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<ItemDetails> itemsDetails;

    public void changeState(IOrderState newState) {
        newState.changeOrderState(this);
    }


}
