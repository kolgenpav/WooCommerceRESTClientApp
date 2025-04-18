package ua.edu.znu.wcrestapp.model.product;

import lombok.*;
import ua.edu.znu.wcrestapp.model.Image;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String slug;
    @Setter(AccessLevel.NONE)
    private String permalink;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_created;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_modified;
    private ProductType type;
    private ProductStatus productStatus;
    private String description;
    private String short_description;
    private String sku;
    @Setter(AccessLevel.NONE)
    private Double price;
    private Double regular_price;
    @Setter(AccessLevel.NONE)
    private Boolean on_sale;
    private Double sale_price;
    private Double weight;
    private Dimensions dimensions;
    private ProductCategory[] categories;
    private Image[] images;
    private ProductAttribute[] productAttributes;
}

