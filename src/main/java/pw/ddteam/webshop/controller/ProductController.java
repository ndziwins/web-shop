//package pw.ddteam.webshop.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import pw.ddteam.webshop.model.Product;
//import pw.ddteam.webshop.model.ProductRepository;
//
//import javax.validation.Valid;
//import java.net.URI;
//import java.util.List;
//
////@RestController
//class ProductController {
//    private final ProductRepository repository;
//
//    ProductController(ProductRepository repository) {
//        this.repository = repository;
//    }
//
////    @PostMapping("/products")
//    ResponseEntity<Product> createProduct(@RequestBody @Valid Product toCreate){
//        Product result = repository.save(toCreate);
//        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
//    }
//
////    @GetMapping("/products")
//    ResponseEntity<List<Product>> readAllProducts() {
//        return ResponseEntity.ok(repository.findAll());
//    }
//}
