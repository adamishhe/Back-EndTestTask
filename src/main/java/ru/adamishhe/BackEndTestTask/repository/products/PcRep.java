package ru.adamishhe.BackEndTestTask.repository.products;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.adamishhe.BackEndTestTask.entity.products.PC;

import java.util.List;
import java.util.Optional;

@Repository
public interface PcRep extends CrudRepository<PC, Long> {

    Optional<PC> findById(Long id);

    List<PC> findAll();

    PC save(PC pc);
}
