package pw.ddteam.webshop.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface QuantityRepository extends JpaRepository<Quantity, Integer> {

    List<Quantity> findAll();

    Optional<Quantity> findById(Integer id);

    boolean existsById(Integer id);

    Quantity save(Quantity entity);
}
