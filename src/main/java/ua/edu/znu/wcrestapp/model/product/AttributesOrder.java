package ua.edu.znu.wcrestapp.model.product;

import lombok.Getter;

@Getter
public enum AttributesOrder {
    ID("id"),
    NAME("name"),
    NAME_NUM("name_num"),
    MENU_ORDER("menu_order");

    private final String attribute;

    AttributesOrder(String attribute) {
        this.attribute = attribute;
    }
}
