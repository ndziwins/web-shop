package pw.ddteam.webshop.model.product;

public interface ProductService {

    void save(Product product);

    void edit(int id, Product newSource);

    void delete(int id);

    int productsTypeQuantity();
}
