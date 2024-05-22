package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Canteens;
import sjk.com.demo.repository.CanteenRepository;

@Service
public class CanteenUpdateService {

    private final CanteenRepository canteenRepository;

    @Autowired
    public CanteenUpdateService(CanteenRepository canteenRepository) {
        this.canteenRepository = canteenRepository;
    }

    public void updateCanteen(Canteens canteen) {
        // 根据食堂ID查询数据库中的食堂信息
        Canteens existingCanteen = canteenRepository.findById(canteen.getCanteenId()).orElse(null);
        if (existingCanteen != null) {
            // 更新食堂信息
            existingCanteen.setAverageMealPrice(canteen.getAverageMealPrice());
            existingCanteen.setHasSichuan(canteen.isHasSichuan());
            existingCanteen.setHasShandong(canteen.isHasShandong());
            existingCanteen.setHasGuangdong(canteen.isHasGuangdong());

            // 保存更新后的食堂信息
            canteenRepository.save(existingCanteen);
        }
    }
}

