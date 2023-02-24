package ru.adamishhe.BackEndTestTask.service.interfaces;

import ru.adamishhe.BackEndTestTask.DTO.products.LaptopDTO;
import ru.adamishhe.BackEndTestTask.entity.products.Laptop;

import java.util.List;

public interface LaptopServiceInterface {
    public List<Laptop> getAllLaptops();

    public Laptop getLaptopById(Long id);

    public void saveOrUpdate(Laptop laptop);

    public void delete(Long id);

    public LaptopDTO update(Long id, LaptopDTO update);
}
