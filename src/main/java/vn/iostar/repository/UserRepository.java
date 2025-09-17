package vn.iostar.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iostar.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByUsernameContaining(String username, Pageable pageable);
}
