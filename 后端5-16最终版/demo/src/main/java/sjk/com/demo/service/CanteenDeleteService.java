package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.repository.CanteenRepository;

@Service
public class CanteenDeleteService {

    private final CanteenRepository canteenRepository;

    @Autowired
    public CanteenDeleteService(CanteenRepository canteenRepository) {
        this.canteenRepository = canteenRepository;
    }

    public void deleteCanteen(Long canteenId) {
        // 根据食堂ID删除数据库中的食堂信息
        canteenRepository.deleteById(canteenId);
    }
}
