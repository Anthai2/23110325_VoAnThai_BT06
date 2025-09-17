package vn.iostar.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iostar.entity.Video;
import vn.iostar.repository.VideoRepository;
import vn.iostar.service.VideoService;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository repo;

    public VideoServiceImpl(VideoRepository repo) {
        this.repo = repo;
    }

    @Override public List<Video> findAll() { return repo.findAll(); }
    @Override public Page<Video> findAll(Pageable pageable) { return repo.findAll(pageable); }
    @Override public Optional<Video> findById(Integer id) { return repo.findById(id); }
    @Override public Video save(Video v) { return repo.save(v); }
    @Override public void deleteById(Integer id) { repo.deleteById(id); }
    @Override public Page<Video> search(String title, Pageable pageable) {
        return (title == null || title.isBlank())
                ? repo.findAll(pageable)
                : repo.findByTitleContaining(title, pageable);
    }
}
