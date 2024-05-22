package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.repository.UniversityRepository;

@Service
public class UniversityDeleteService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityDeleteService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void deleteUniversity(Long universityId) {
        // 根据大学ID删除大学信息
        universityRepository.deleteById(universityId);
    }
}
