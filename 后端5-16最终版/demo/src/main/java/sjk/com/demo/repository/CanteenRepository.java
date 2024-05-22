package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Canteens;

public interface CanteenRepository extends JpaRepository<Canteens, Long> {
    // 根据大学ID查询食堂信息
    Canteens findByUniversityId(Long universityId);
}
