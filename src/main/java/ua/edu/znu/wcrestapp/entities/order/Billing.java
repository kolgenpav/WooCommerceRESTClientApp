package ua.edu.znu.wcrestapp.entities.order;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billing {
    private String first_name;
    private String  last_name;
    private String company;
    private String address_1;
    private String address_2;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String email;
    private String phone;
}