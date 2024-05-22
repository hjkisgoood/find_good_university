package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Dormitories;
import sjk.com.demo.service.UserDormitoryService;

import java.util.List;

@RestController
public class UserDormitoryController {

    private final UserDormitoryService userDormitoryService;

    @Autowired
    public UserDormitoryController(UserDormitoryService userDormitoryService) {
        this.userDormitoryService = userDormitoryService;
    }

    // 获取指定大学的宿舍环境详情
    @GetMapping("/universities/{universityId}/dormitories")
    public Dormitories getDormitoriesByUniversityId( @PathVariable Long universityId) {
        System.out.println("UserDormitoryController's getDormitoriesByUniversityId method is being called.");
        return userDormitoryService.getDormitoriesByUniversityId(universityId);
    }
}
