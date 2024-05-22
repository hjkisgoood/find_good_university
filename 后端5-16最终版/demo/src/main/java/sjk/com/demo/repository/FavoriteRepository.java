package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Favorites;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorites, Long> {
    boolean existsByUserIdAndUniversityId(Long userId, Long universityId);

    Favorites save(Favorites favorites);

    // 根据用户ID查询收藏信息
    List<Favorites> findByUserId(Long userId);
}
