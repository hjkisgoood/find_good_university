package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.service.CanteenDeleteService;

@RestController
public class CanteenDeleteController {

    private final CanteenDeleteService canteenDeleteService;

    @Autowired
    public CanteenDeleteController(CanteenDeleteService canteenDeleteService) {
        this.canteenDeleteService = canteenDeleteService;
    }

    @DeleteMapping("/canteens/{canteenId}")
    public String deleteCanteen(@PathVariable Long canteenId) {
        // 调用服务层方法删除食堂信息
        System.out.println("CanteenDeleteController's deleteCanteen method is being called.");
        canteenDeleteService.deleteCanteen(canteenId);
        return "Canteen information deleted successfully";
    }
}

