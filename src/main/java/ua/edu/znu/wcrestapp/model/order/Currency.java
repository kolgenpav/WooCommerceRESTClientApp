package ua.edu.znu.wcrestapp.model.order;

import lombok.Getter;

@Getter
public enum Currency {
    USD("USD"),
    EUR("EUR"),
    UAH("UAH");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }
}
