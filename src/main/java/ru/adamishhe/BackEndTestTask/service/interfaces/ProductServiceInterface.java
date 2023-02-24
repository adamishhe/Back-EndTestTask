package ru.adamishhe.BackEndTestTask.service.interfaces;

import ru.adamishhe.BackEndTestTask.DTO.ProductDTO;
import ru.adamishhe.BackEndTestTask.entity.Product;

import java.util.List;

public interface ProductServiceInterface {
    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public void saveOrUpdate(Product product);

    public void delete(Long id);

    public ProductDTO update(Long id, ProductDTO update);
}
