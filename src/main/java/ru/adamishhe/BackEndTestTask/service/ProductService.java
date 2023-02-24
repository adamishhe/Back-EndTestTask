package ru.adamishhe.BackEndTestTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adamishhe.BackEndTestTask.DTO.ProductDTO;
import ru.adamishhe.BackEndTestTask.entity.Product;
import ru.adamishhe.BackEndTestTask.repository.ProductRep;
import ru.adamishhe.BackEndTestTask.service.interfaces.ProductServiceInterface;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService implements ProductServiceInterface {

    private final ProductRep productRep;

    @Autowired
    public ProductService(ProductRep productRep) {
        this.productRep = productRep;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productRep.findAll());
    }

    public Product getProductById(Long id)
    {
        return productRep.findById(id).get();
    }

    public void saveOrUpdate(Product product)
    {
        productRep.save(product);
    }

    public void delete(Long id)
    {
        productRep.deleteById(id);
    }

    public ProductDTO update(Long id, ProductDTO updateDTO) {
        Product product = productRep.findById(id).<RuntimeException>orElseThrow(() -> {
            throw new RuntimeException("Article with id <" + id + "> not found.");
        });

        product = ProductMapper.map(updateDTO, product);

        productRep.save(product);

        return ProductMapper.map(product);

    }

    private class ProductMapper{

        public static Product map(ProductDTO newDTO, Product oldEntity) {

            Product newProduct = oldEntity;

            if (newDTO.type() != null && !newDTO.type().equals("")){
                newProduct.setType(newDTO.type());
            }
            if (newDTO.serial() != null && !newDTO.serial().equals("")){
                newProduct.setSerial(newDTO.serial());
            }
            if (newDTO.manufacturer() != null && !newDTO.manufacturer().equals("")){
                newProduct.setManufacturer(newDTO.manufacturer());
            }
            if (newDTO.cost() != null && !newDTO.cost().equals("")){
                newProduct.setCost(newDTO.cost());
            }
            if (newDTO.amount() != null && !newDTO.amount().equals("")){
                newProduct.setAmount(newDTO.amount());
            }

            return newProduct;

        }

        static public ProductDTO map(Product product) {
            ProductDTO dto = new ProductDTO(product.getId(), product.getType(), product.getSerial(), product.getManufacturer(),
                    product.getCost(), product.getAmount());

            return dto;
        }

    }

}
