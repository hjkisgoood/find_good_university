// UserUniversityService.java

package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Canteens;
import sjk.com.demo.entity.Dormitories;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.repository.CanteenRepository;
import sjk.com.demo.repository.DormitoryRepository;
import sjk.com.demo.repository.UniversityRepository;

import java.util.List;

@Service
public class UserUniversityService {

    private final UniversityRepository universityRepository;


    @Autowired
    public UserUniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;

    }

    // 根据条件筛选查询大学信息
    public List<Universities> getFilteredUniversities(Double minFee, Double maxFee, String type, String province, String city) {
        return universityRepository.findFilteredUniversities(minFee, maxFee, type, province, city);
    }


}
