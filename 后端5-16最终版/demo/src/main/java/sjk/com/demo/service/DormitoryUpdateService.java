package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Dormitories;
import sjk.com.demo.repository.DormitoryRepository;

@Service
public class DormitoryUpdateService {

    private final DormitoryRepository dormitoryRepository;

    @Autowired
    public DormitoryUpdateService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    public void updateDormitory(Dormitories dormitory) {
        // 根据宿舍ID查询数据库中的宿舍信息
        Dormitories existingDormitory = dormitoryRepository.findById(dormitory.getDormitoryId()).orElse(null);
        if (existingDormitory != null) {
            // 更新宿舍信息
            existingDormitory.setHasPrivateBathroom(dormitory.isHasPrivateBathroom());
            existingDormitory.setHasAirConditioning(dormitory.isHasAirConditioning());
            existingDormitory.setHasBunkBedDesk(dormitory.isHasBunkBedDesk());
            existingDormitory.setRoommateCount(dormitory.getRoommateCount());

            // 保存更新后的宿舍信息
            dormitoryRepository.save(existingDormitory);
        }
    }
}
