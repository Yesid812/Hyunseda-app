package co.hyunseda.product.domain.service;

import co.hyunseda.product.domain.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductService {

    boolean save(Product product);
    public List<Product> findAll();
    boolean edit(Long Id, Product newProduct);
    boolean delete(Long id);
    Product findById(Long id);
    Optional<Product> findByName(String name);
    List<Product> searchProductByName(String name);
    List<Product> searchProductByCategory(String name);
}
