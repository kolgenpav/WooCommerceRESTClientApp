package ua.edu.znu.wcrestapp.model.order;

import lombok.*;
import ua.edu.znu.wcrestapp.model.Billing;
import ua.edu.znu.wcrestapp.model.Shipping;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Setter(AccessLevel.NONE)
    private Long id;
    @Setter(AccessLevel.NONE)
    private String number;
    private OrderStatus status;
    private Currency currency;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_created;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_modified;
    private Double subtotal;
    @Setter(AccessLevel.NONE)
    private Double discount_total;
    @Setter(AccessLevel.NONE)
    private Double total;
    private Long customer_id;
    private String payment_method;
    private String payment_method_title;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_paid;
    @Getter(AccessLevel.NONE)
    private Boolean set_paid;
    private Billing billing;
    private Shipping shipping;
    private ProductItem[] line_items;
}
