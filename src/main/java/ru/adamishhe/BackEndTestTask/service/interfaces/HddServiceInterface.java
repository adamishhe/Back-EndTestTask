package ru.adamishhe.BackEndTestTask.service.interfaces;

import ru.adamishhe.BackEndTestTask.DTO.products.HddDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Hdd;

import java.util.List;

public interface HddServiceInterface {
    public List<Hdd> getAllHdd();

    public Hdd getHddById(Long id);

    public void saveOrUpdate(Hdd hdd);

    public void delete(Long id);

    public HddDTO update(Long id, HddDTO update);
}
