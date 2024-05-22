package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.repository.DormitoryRepository;

@Service
public class DormitoryDeleteService {

    private final DormitoryRepository dormitoryRepository;

    @Autowired
    public DormitoryDeleteService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    public void deleteDormitory(Long dormitoryId) {
        // 根据宿舍ID删除数据库中的宿舍信息
        dormitoryRepository.deleteById(dormitoryId);
    }
}
