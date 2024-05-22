package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Canteens;
import sjk.com.demo.service.UserCanteenService;

import java.util.List;

@RestController
public class UserCanteenController {

    private final UserCanteenService userCanteenService;

    @Autowired
    public UserCanteenController(UserCanteenService userCanteenService) {
        this.userCanteenService = userCanteenService;
    }

    // 获取指定大学的食堂条件详情
    @GetMapping("/universities/{universityId}/canteens")
    public Canteens getCanteensByUniversityId(@PathVariable Long universityId) {
        System.out.println("UserCanteenController's getCanteensByUniversityId method is being called.");
        return userCanteenService.getCanteensByUniversityId(universityId);
    }
}

