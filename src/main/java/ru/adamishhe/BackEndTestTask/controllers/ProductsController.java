package ru.adamishhe.BackEndTestTask.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adamishhe.BackEndTestTask.DTO.ProductDTO;
import ru.adamishhe.BackEndTestTask.entity.Product;
import ru.adamishhe.BackEndTestTask.service.interfaces.ProductServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {


    private final ProductServiceInterface productService;

    @Autowired
    public ProductsController(ProductServiceInterface productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id)
    {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        productService.delete(id);
    }


    private Product productDtoToEntity(ProductDTO productDTO){
        Product product = new Product();

        product.setId(productDTO.id());
        product.setAmount(productDTO.amount());
        product.setCost(productDTO.cost());
        product.setManufacturer(productDTO.manufacturer());
        product.setSerial(productDTO.serial());
        product.setType(productDTO.type());

        return product;
    }


}
