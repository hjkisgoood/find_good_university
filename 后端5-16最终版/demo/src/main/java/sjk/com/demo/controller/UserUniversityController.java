package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.service.UserUniversityService;

import java.util.List;

@RestController
public class UserUniversityController {

    private final UserUniversityService userUniversityService;

    @Autowired
    public UserUniversityController(UserUniversityService userUniversityService) {
        this.userUniversityService = userUniversityService;
    }

    // 根据条件筛选查询大学信息
    @GetMapping("/users/universities")
    public List<Universities> getFilteredUniversities(
                                                      @RequestParam(required = false) Double minFee,
                                                      @RequestParam(required = false) Double maxFee,
                                                      @RequestParam(required = false) String type,
                                                      @RequestParam(required = false) String province,
                                                      @RequestParam(required = false) String city) {
        // 输出方法被调用信息
        System.out.println("UserUniversityController's getFilteredUniversities method is being called.");
        return userUniversityService.getFilteredUniversities(minFee, maxFee, type, province, city);
    }
}
