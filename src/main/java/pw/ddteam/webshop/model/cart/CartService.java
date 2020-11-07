package pw.ddteam.webshop.model.cart;

import pw.ddteam.webshop.model.product.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface CartService {
    void addProduct(Product product);
    void removeProduct(Product product);
    void clearProducts();
    Map<Product, Integer> productsInCart();
    BigDecimal totalPrice();
    void cartCheckout();
}
