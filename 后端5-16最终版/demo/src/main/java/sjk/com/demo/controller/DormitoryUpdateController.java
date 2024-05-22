package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Dormitories;
import sjk.com.demo.service.DormitoryUpdateService;

@RestController
public class DormitoryUpdateController {

    private final DormitoryUpdateService dormitoryUpdateService;

    @Autowired
    public DormitoryUpdateController(DormitoryUpdateService dormitoryUpdateService) {
        this.dormitoryUpdateService = dormitoryUpdateService;
    }

    @PostMapping("/updateDormitory")
    public String updateDormitoryInfo(@RequestBody Dormitories dormitory) {
        // 调用服务层方法更新宿舍信息
        System.out.println("DormitoryUpdateController's updateDormitoryInfo method is being called.");
        dormitoryUpdateService.updateDormitory(dormitory);
        return "Dormitory information updated successfully";
    }
}
