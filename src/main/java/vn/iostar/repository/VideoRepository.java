package vn.iostar.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iostar.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    Page<Video> findByTitleContaining(String title, Pageable pageable);

    // (Tuỳ chọn) lọc theo Category ID nếu cần:
    // Page<Video> findByCategory_Id(Integer categoryId, Pageable pageable);
}
