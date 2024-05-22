package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.service.UniversityDeleteService;

@RestController
public class UniversityDeleteController {

    private final UniversityDeleteService universityDeleteService;

    @Autowired
    public UniversityDeleteController(UniversityDeleteService universityDeleteService) {
        this.universityDeleteService = universityDeleteService;
    }

    @DeleteMapping("/universities/{universityId}")
    public String deleteUniversity(@PathVariable Long universityId) {
        // 调用服务层方法删除大学信息
        System.out.println("UniversityDeleteController's deleteUniversity method is being called.");
        universityDeleteService.deleteUniversity(universityId);
        return "University information deleted successfully";
    }
}
