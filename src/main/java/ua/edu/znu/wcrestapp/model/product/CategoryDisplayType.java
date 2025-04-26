package ua.edu.znu.wcrestapp.model.product;

import lombok.Getter;

@Getter
public enum CategoryDisplayType {

    DEFAULT("default"),
    PRODUCTS("products"),
    SUBCATEGORIES("subcategories"),
    BOTH("both");

    private final String displayType;

    CategoryDisplayType(String displayType) {
        this.displayType = displayType;
    }
}
