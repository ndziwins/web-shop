package pw.ddteam.webshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pw.ddteam.webshop.model.Product;
import pw.ddteam.webshop.model.ProductRepository;
import pw.ddteam.webshop.model.Quantity;
import pw.ddteam.webshop.model.QuantityRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/quantity")
public class QuantityController {
    private final QuantityRepository repository;

    public QuantityController(QuantityRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<Quantity> createQunantity(@RequestBody @Valid Quantity toCreate) {
        Quantity result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping
    ResponseEntity<List<Quantity>> readAllQunantity() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Quantity> readQunantity(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @PutMapping("/{id}")
    ResponseEntity<?> updateQunantity(@PathVariable int id, @RequestBody @Valid Quantity toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(product -> {
                    product.updateFrom(toUpdate);
                    repository.save(product);
                });
        return ResponseEntity.noContent().build();
    }

}
