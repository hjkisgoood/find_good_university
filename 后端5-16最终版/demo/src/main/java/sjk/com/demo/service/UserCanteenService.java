package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Canteens;
import sjk.com.demo.repository.CanteenRepository;

import java.util.List;

@Service
public class UserCanteenService {

    private final CanteenRepository canteenRepository;

    @Autowired
    public UserCanteenService(CanteenRepository canteenRepository) {
        this.canteenRepository = canteenRepository;
    }

    // 获取指定大学的食堂条件详情
    public Canteens getCanteensByUniversityId( Long universityId) {
        // Implement the logic to get canteens by universityId from repository
        return canteenRepository.findByUniversityId(universityId);
    }
}