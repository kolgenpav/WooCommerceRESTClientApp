package ua.edu.znu.wcrestapp.model.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import ua.edu.znu.wcrestapp.model.Image;

@Data
public class ProductCategory{
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String slug;
    private Long parent;
    private String description;
    private CategoryDisplayType display;
    private Image image;
    private Integer menu_order;
    @Setter(AccessLevel.NONE)
    private Long count;
}
