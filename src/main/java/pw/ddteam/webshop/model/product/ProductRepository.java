package pw.ddteam.webshop.model.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();

    Page<Product> findAll(Pageable page);

    Optional<Product> findById(Integer id);

    Optional<Product> findByName(String name);

    boolean existsById(Integer id);

    Product save(Product entity);
}
