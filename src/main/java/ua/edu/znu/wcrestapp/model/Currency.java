package ua.edu.znu.wcrestapp.model;

public enum Currency {
    USD("USD"),
    EUR("EUR"),
    UAH("UAH");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
