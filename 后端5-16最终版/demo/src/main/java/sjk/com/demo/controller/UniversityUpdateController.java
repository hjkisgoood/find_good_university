package sjk.com.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.service.UniversityUpdateService;

@RestController
public class UniversityUpdateController {

    private final UniversityUpdateService universityUpdateService;

    @Autowired
    public UniversityUpdateController(UniversityUpdateService universityUpdateService) {
        this.universityUpdateService = universityUpdateService;
    }

    @PostMapping("/updateUniversity")
    public String updateUniversityInfo(@RequestBody Universities university) {
        // 调用服务层方法更新大学信息
        System.out.println("UniversityUpdateController's updateUniversityInfo method is being called.");
        universityUpdateService.updateUniversity(university);
        return "University information updated successfully";
    }
}
