package ru.adamishhe.BackEndTestTask.repository.products;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.adamishhe.BackEndTestTask.entity.products.Monitor;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonitorRep extends CrudRepository<Monitor, Long> {

    Optional<Monitor> findById(Long id);

    List<Monitor> findAll();

    Monitor save(Monitor monitor);
}
