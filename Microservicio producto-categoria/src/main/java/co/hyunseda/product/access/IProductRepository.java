package co.hyunseda.product.access;

import co.hyunseda.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> searchProductByName(String name);

    @Query("SELECT p FROM Product p WHERE p.category.name = :categoryName")
    List<Product> searchProductByCategory(String categoryName);

}
