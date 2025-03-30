package ua.edu.znu.wcrestapp.model;

public enum ProductType {
    SIMPLE("simple"),
    GROUPED("grouped"),
    EXTERNAL("external"),
    VARIABLE("variable");

    private final String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
