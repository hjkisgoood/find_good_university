package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sjk.com.demo.entity.Dormitories;

import java.util.List;

public interface DormitoryRepository extends JpaRepository<Dormitories, Long> {
    // 这里可以添加其他需要的自定义查询方法

    // 自定义根据大学ID查询宿舍信息的方法

    // 保存宿舍信息
    Dormitories save(Dormitories dormitory);
    Dormitories findByUniversityId(Long universityId);
}
