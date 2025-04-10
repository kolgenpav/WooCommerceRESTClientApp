package ua.edu.znu.wcrestapp.model.order;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PENDING("pending"),
    PROCESSING("processing"),
    ON_HOLD("on-hold"),
    COMPLETED("completed"),
    CANCELLED("cancelled"),
    REFUNDED("refunded"),
    FAILED("failed"),
    TRASH("trash");


    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }
}

