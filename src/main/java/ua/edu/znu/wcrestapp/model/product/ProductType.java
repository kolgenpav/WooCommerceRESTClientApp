package ua.edu.znu.wcrestapp.model.product;

import lombok.Getter;

@Getter
public enum ProductType {
    SIMPLE("simple"),
    GROUPED("grouped"),
    EXTERNAL("external"),
    VARIABLE("variable");

    private final String type;

    ProductType(String type) {
        this.type = type;
    }

}
