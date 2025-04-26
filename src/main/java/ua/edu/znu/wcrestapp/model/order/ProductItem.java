package ua.edu.znu.wcrestapp.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.znu.wcrestapp.model.product.Product;

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

    public ProductItem(Product product, Integer quantity) {
        this.productId = product.getId();
        this.name = product.getName();
        this.sku = product.getSku();
        this.quantity = quantity;
        this.price = product.getSale_price() != null ? product.getSale_price() : product.getRegular_price();
        this.total = price * quantity;
    }
}
