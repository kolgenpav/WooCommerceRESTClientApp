package ua.edu.znu.wcrestapp.model.product;

import lombok.Getter;

@Getter
public enum ProductStatus {
    PUBLISH("publish"),
    DRAFT("draft"),
    PENDING("pending"),
    PRIVATE("private");

    private final String status;

    ProductStatus(String status) {
        this.status = status;
    }

}
