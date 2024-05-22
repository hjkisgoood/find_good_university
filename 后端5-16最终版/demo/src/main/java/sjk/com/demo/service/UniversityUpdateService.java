package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.repository.UniversityRepository;

@Service
public class UniversityUpdateService {

    private final UniversityRepository universitiesRepository;

    @Autowired
    public UniversityUpdateService(UniversityRepository universitiesRepository) {
        this.universitiesRepository = universitiesRepository;
    }

    public void updateUniversity(Universities university) {
        // 根据大学名称查询数据库中的大学信息
        Universities existingUniversity = universitiesRepository.findByName(university.getName());
        if (existingUniversity != null) {
            // 更新大学信息
            existingUniversity.setType(university.getType());
            existingUniversity.setCampusArea(university.getCampusArea());
            existingUniversity.setMinFee(university.getMinFee());
            existingUniversity.setMaxFee(university.getMaxFee());
            existingUniversity.setProvince(university.getProvince());
            existingUniversity.setCity(university.getCity());
            existingUniversity.setAddress(university.getAddress());
            existingUniversity.setClimate(university.getClimate());
            existingUniversity.setApplicationDeadline(university.getApplicationDeadline());

            // 保存更新后的大学信息
            universitiesRepository.save(existingUniversity);
        }
    }
}
