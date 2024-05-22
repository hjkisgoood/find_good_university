package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Dormitories;
import sjk.com.demo.repository.DormitoryRepository;

@Service
public class DormitoryService {

    private final DormitoryRepository dormitoryRepository;

    @Autowired
    public DormitoryService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    public Dormitories saveDormitory(Dormitories dormitory) {

        return dormitoryRepository.save(dormitory);
    }
}
