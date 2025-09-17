package vn.iostar.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iostar.entity.User;
import vn.iostar.repository.UserRepository;
import vn.iostar.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override public List<User> findAll() { return repo.findAll(); }
    @Override public Page<User> findAll(Pageable pageable) { return repo.findAll(pageable); }
    @Override public Optional<User> findById(Integer id) { return repo.findById(id); }
    @Override public User save(User u) { return repo.save(u); }
    @Override public void deleteById(Integer id) { repo.deleteById(id); }
    @Override public Page<User> search(String username, Pageable pageable) {
        return (username == null || username.isBlank())
                ? repo.findAll(pageable)
                : repo.findByUsernameContaining(username, pageable);
    }
}
