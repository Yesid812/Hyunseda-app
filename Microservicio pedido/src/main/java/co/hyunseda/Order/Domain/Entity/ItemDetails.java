package co.hyunseda.Order.Domain.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "item_details")
public class ItemDetails  implements Serializable {

    @EmbeddedId
   private ItemDetailsPk id;


    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;
}