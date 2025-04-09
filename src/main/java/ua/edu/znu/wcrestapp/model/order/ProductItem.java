package ua.edu.znu.wcrestapp.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    private Long id;
    private String name;
    private Long productId;
    private Integer quantity;
    private String subtotal;
    private Double total;
    private String sku;
    private Double price;

    public ProductItem(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
