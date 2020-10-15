package pw.ddteam.webshop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pw.ddteam.webshop.model.cart.CartService;
import pw.ddteam.webshop.model.product.Product;
import pw.ddteam.webshop.model.product.ProductService;

@Controller
public class CartController {
    private static final Logger logger = Logger.getLogger(ProductController.class.getName());
    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("products", cartService.productsInCart());
        model.addAttribute("totalPrice",cartService.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") int id){
        Product product = productService.findById(id);
        if (product != null){
            cartService.addProduct(product);
            logger.info(String.format("Product with id: %s added to shopping cart.", id));
        }
        return "redirect:/home";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") int id){
        Product product = productService.findById(id);
        if (product != null){
            cartService.removeProduct(product);
            logger.info(String.format("Product with id: %s removed from shopping cart.", id));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearProductsInCart(){
        cartService.clearProducts();
        logger.info("Cart cleared.");

        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout(){
        cartService.cartCheckout();
        logger.info("Cart checkouted.");
        return "redirect:/cart";
    }
}