package vn.iostar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.iostar.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    Optional<Category> findById(Integer id);
    Category save(Category c);
    void deleteById(Integer id);

    // search
    List<Category> findByCategoryNameContaining(String name);
    Page<Category> search(String name, Pageable pageable);
}
