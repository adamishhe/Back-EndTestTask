package ru.adamishhe.BackEndTestTask.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.adamishhe.BackEndTestTask.entity.Product;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRep extends CrudRepository<Product, Long> {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product save(Product product);

}
