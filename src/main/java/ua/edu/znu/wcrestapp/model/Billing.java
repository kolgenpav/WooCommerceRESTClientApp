package ua.edu.znu.wcrestapp.model;

import lombok.*;

@Data
public class Billing extends Shipping {

    @Builder(builderMethodName = "billingBuilder")
    public Billing(String firstName, String lastName, String company, String address1, String address2,
                   String city, String state, String postcode, String country, String email, String phone) {
        super(firstName, lastName, company, address1, address2, city, state, postcode, country);
        this.email = email;
        this.phone = phone;
    }

    private String email;
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Billing billing)) return false;
        if (!super.equals(o)) return false;

        if (getEmail() != null ? !getEmail().equals(billing.getEmail()) : billing.getEmail() != null) return false;
        return getPhone() != null ? getPhone().equals(billing.getPhone()) : billing.getPhone() == null;
    }
}