package vn.iostar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.iostar.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {
    List<Video> findAll();
    Page<Video> findAll(Pageable pageable);
    Optional<Video> findById(Integer id);
    Video save(Video v);
    void deleteById(Integer id);

    // search
    Page<Video> search(String title, Pageable pageable);
}
