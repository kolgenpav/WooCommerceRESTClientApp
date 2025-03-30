package ua.edu.znu.wcrestapp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Setter(AccessLevel.NONE)
    private Long id;
    @Setter(AccessLevel.NONE)
    private String number;
    private String status;
    private Currency currency;
    @Setter(AccessLevel.NONE)
    private String date_created;
    @Setter(AccessLevel.NONE)
    private String date_modified;
    private String subtotal;
    @Setter(AccessLevel.NONE)
    private String discount_total;
    @Setter(AccessLevel.NONE)
    private String total;
    private Long customer_id;
    private String payment_method;
    private String payment_method_title;
    @Setter(AccessLevel.NONE)
    private String date_paid;
    @Getter(AccessLevel.NONE)
    private Boolean set_paid;
    private Billing billing;
    private Shipping shipping;
    private ProductItem[] line_items;
}
