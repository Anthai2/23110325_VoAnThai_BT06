package vn.iostar.service;

import org.springframework.data.domain.*;
import java.util.*;
import vn.iostar.entity.*;

public interface UserService {
  List<User> findAll();
  Page<User> findAll(Pageable pageable);
  Optional<User> findById(Integer id);
  User save(User u);
  void deleteById(Integer id);
  Page<User> search(String username, Pageable pageable);
}