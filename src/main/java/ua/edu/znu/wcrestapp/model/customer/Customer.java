package ua.edu.znu.wcrestapp.model.customer;

import lombok.*;
import ua.edu.znu.wcrestapp.model.Billing;
import ua.edu.znu.wcrestapp.model.Shipping;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_created;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_modified;
    private Billing billing;
    private Shipping shipping;
}
