package ua.edu.znu.wcrestapp.model;

import lombok.*;

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
    private String date_created;
    @Setter(AccessLevel.NONE)
    private String date_modified;
    private Billing billing;
    private Shipping shipping;
}
