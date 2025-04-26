package ua.edu.znu.wcrestapp.model.customer;

public enum CustomerRole {
    CUSTOMER("customer"),
    SHOP_MANAGER("shop_manager");

    private final String role;

    CustomerRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
