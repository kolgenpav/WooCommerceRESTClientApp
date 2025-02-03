package ua.edu.znu.wcrestapp.entities.product;

import lombok.*;
import ua.edu.znu.wcrestapp.entities.Image;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class WCProduct {
    private Long id;
    private String name;
    private String slug;
    private String permalink;
    private String date_created;
    private String date_modified;
    private ProductType type;
    private ProductStatus productStatus;
    private String description;
    private String short_description;
    private String sku;
    private Double price;
    private Double regular_price;
    private Boolean on_sale;
    private Double sale_price;
    private Double weight;
    private Dimensions dimensions;
    private Category[] categories;
    private Image[] images;
    private Attribute[] attributes;
}

