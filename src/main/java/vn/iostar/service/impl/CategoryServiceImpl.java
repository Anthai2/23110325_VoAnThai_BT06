package vn.iostar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.iostar.entity.Category;
import vn.iostar.repository.CategoryRepository;
import vn.iostar.service.CategoryService;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository repo;

  @Autowired
  public CategoryServiceImpl(CategoryRepository repo) {   
    this.repo = repo;
  }

  @Override public List<Category> findAll() { return repo.findAll(); }
  @Override public Page<Category> findAll(Pageable pageable) { return repo.findAll(pageable); }
  @Override public Optional<Category> findById(Integer id) { return repo.findById(id); }
  @Override public Category save(Category c) { return repo.save(c); }
  @Override public void deleteById(Integer id) { repo.deleteById(id); }
  @Override public List<Category> findByCategoryNameContaining(String name) { return repo.findByCategoryNameContaining(name); }
  @Override public Page<Category> search(String name, Pageable pageable) {
    return (name == null || name.isBlank()) ? repo.findAll(pageable)
                                            : repo.findByCategoryNameContaining(name, pageable);
  }
}
