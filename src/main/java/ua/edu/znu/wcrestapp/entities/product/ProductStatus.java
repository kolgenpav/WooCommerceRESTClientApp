package ua.edu.znu.wcrestapp.entities.product;

public enum ProductStatus {
    PUBLISH("publish"),
    DRAFT("draft"),
    PENDING("pending"),
    PRIVATE("private");

    private final String status;

    ProductStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
