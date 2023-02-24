package ru.adamishhe.BackEndTestTask.repository.products;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.adamishhe.BackEndTestTask.entity.products.Laptop;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaptopRep extends CrudRepository<Laptop, Long> {

    Optional<Laptop> findById(Long id);

    List<Laptop> findAll();

    Laptop save(Laptop laptop);
}
