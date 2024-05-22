package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Canteens;
import sjk.com.demo.repository.CanteenRepository;

@Service
public class CanteenService {

    private final CanteenRepository canteenRepository;

    @Autowired
    public CanteenService(CanteenRepository canteenRepository) {
        this.canteenRepository = canteenRepository;
    }

    public Canteens saveCanteen(Canteens canteen) {
        return canteenRepository.save(canteen);
    }
}

