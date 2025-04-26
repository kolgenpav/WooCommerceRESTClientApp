package ua.edu.znu.wcrestapp.model.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class ProductAttribute {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String slug;
    private String type;
    private AttributesOrder order_by;
    private boolean has_archives;
}
