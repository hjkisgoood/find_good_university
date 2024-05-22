package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Dormitories;
import sjk.com.demo.repository.DormitoryRepository;

import java.util.List;

@Service
public class UserDormitoryService {

    private final DormitoryRepository dormitoryRepository;

    @Autowired
    public UserDormitoryService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    // 获取指定大学的宿舍环境详情
    public Dormitories getDormitoriesByUniversityId( Long universityId) {
        // Implement the logic to get dormitories by universityId from repository
        return dormitoryRepository.findByUniversityId(universityId);
    }
}
