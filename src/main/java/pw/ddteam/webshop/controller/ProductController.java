package pw.ddteam.webshop.controller;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.ddteam.webshop.model.product.Product;
import pw.ddteam.webshop.model.product.ProductRepository;
import pw.ddteam.webshop.model.product.ProductServiceImplementation;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class.getName());
    private final ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody @Valid Product toCreate) {
        Product result = repository.save(toCreate);
        logger.info("New product created.");
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping
    ResponseEntity<List<Product>> readAllProducts() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> readProduct(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody @Valid Product toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(product -> {
                    product.updateFrom(toUpdate);
                    repository.save(product);
                });
        logger.info("Product with id: " + id + " updated.");
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/buy/{id}")
    //TODO: check if usefull
    ResponseEntity<?> buy(@PathVariable int id, @RequestBody @Valid Product toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(product -> {
                    product.buy(toUpdate);
                    repository.save(product);
                });
        logger.info("Product with id: " + id + " added to cart.");
        return ResponseEntity.noContent().build();
    }
}
