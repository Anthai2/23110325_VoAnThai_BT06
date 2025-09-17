package vn.iostar.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iostar.entity.Category;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
  List<Category> findByCategoryNameContaining(String name);
  Page<Category> findByCategoryNameContaining(String name, Pageable pageable);
}
