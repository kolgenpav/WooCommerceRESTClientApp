package ua.edu.znu.wcrestapp.model.customer;

import lombok.*;
import ua.edu.znu.wcrestapp.model.Billing;
import ua.edu.znu.wcrestapp.model.Shipping;

import java.time.LocalDateTime;

@Data
public class Customer {
    @Builder(builderMethodName = "customerBuilder")
    public static Customer of(String first_name, String last_name, String email, String username,
                              String password, Billing billing, Shipping shipping) {
        Customer customer = new Customer();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setEmail(email);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setBilling(billing);
        customer.setShipping(shipping);
        return customer;
    }

    @Setter(AccessLevel.NONE)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    @Getter(AccessLevel.NONE)
    private String password;
    @Setter(AccessLevel.NONE)
    private CustomerRole role;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_created;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_modified;
    private Billing billing;
    private Shipping shipping;
    @Setter(AccessLevel.NONE)
    private boolean is_paying_customer;
    @Setter(AccessLevel.NONE)
    private String avatar_url;
    /*You should set customer meta_data if they exist*/
    private CustomerMetaData[] meta_data;
}
