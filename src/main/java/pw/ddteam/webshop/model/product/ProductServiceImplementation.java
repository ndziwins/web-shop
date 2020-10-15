package pw.ddteam.webshop.model.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(int id, Product newSource) {
        Product found = productRepository.getOne(id);
        found.setName(newSource.getName());
        found.setDescription(newSource.getDescription());
        found.setGrossPrice(newSource.getGrossPrice());
        found.setPicturePath(newSource.getPicturePath());
        found.setQuantity(newSource.getQuantity());
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public int productsTypeQuantity() {
        return (int) productRepository.count();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }
}
