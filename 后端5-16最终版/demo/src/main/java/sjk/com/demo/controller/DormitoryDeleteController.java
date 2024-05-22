package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.service.DormitoryDeleteService;

@RestController
public class DormitoryDeleteController {

    private final DormitoryDeleteService dormitoryDeleteService;

    @Autowired
    public DormitoryDeleteController(DormitoryDeleteService dormitoryDeleteService) {
        this.dormitoryDeleteService = dormitoryDeleteService;
    }

    @DeleteMapping("/dormitories/{dormitoryId}")
    public String deleteDormitory(@PathVariable Long dormitoryId) {
        // 调用服务层方法删除宿舍信息
        System.out.println("DormitoryDeleteController's deleteDormitory method is being called.");
        dormitoryDeleteService.deleteDormitory(dormitoryId);
        return "Dormitory information deleted successfully";
    }
}
