package co.hyunseda.product.domain.service;

import co.hyunseda.product.domain.entity.Category;

import java.util.List;

public interface ICategoryService {
    boolean save(Category newCategory);
    Category findById(Long id);
    Category findByName(String name);
    boolean delete(Long id);
    boolean edit(Long Id, Category category);
    List<Category> findAll();
}
