package ua.edu.znu.wcrestapp.model.order;

import lombok.*;
import ua.edu.znu.wcrestapp.model.Billing;
import ua.edu.znu.wcrestapp.model.Shipping;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Builder(builderMethodName = "orderBuilder")
    public static Order of(OrderStatus status, Currency currency, Double subtotal, Long customer_id,
                           String payment_method, String payment_method_title,
                           Billing billing, Shipping shipping, ProductItem[] line_items) {
        Order order = new Order();
        order.setStatus(status);
        order.setCurrency(currency);
        order.setSubtotal(subtotal);
        order.setCustomer_id(customer_id);
        order.setPayment_method(payment_method);
        order.setPayment_method_title(payment_method_title);
        order.setBilling(billing);
        order.setShipping(shipping);
        order.setLine_items(line_items);
        return order;
    }

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
