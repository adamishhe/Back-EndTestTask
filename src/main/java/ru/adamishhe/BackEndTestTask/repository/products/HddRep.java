package ru.adamishhe.BackEndTestTask.repository.products;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.adamishhe.BackEndTestTask.entity.products.Hdd;

import java.util.List;
import java.util.Optional;

@Repository
public interface HddRep extends CrudRepository<Hdd, Long> {

    Optional<Hdd> findById(Long id);

    List<Hdd> findAll();

    Hdd save(Hdd hdd);
}
