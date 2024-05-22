package sjk.com.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.service.UserUniversityService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdminStatisticController {

    private final UserUniversityService userUniversityService;

    @Autowired
    public AdminStatisticController(UserUniversityService userUniversityService) {
        this.userUniversityService = userUniversityService;
    }

    @GetMapping("/universities/statistics/overview")
    public OverviewResponse getUniversitiesOverview() {
        System.out.println("AdminStatisticController's getUniversitiesOverview method is being called.");

        // 查询所有大学信息，将查询条件留空
        List<Universities> allUniversities = userUniversityService.getFilteredUniversities(null, null, null, null, null);

        // 获取大学名称列表
        List<String> universityNames = allUniversities.stream()
                .map(Universities::getName)
                .collect(Collectors.toList());

        // 返回大学名称列表和总数
        return new OverviewResponse(universityNames, allUniversities.size());
    }

    public static class OverviewResponse {
        private final List<String> universities;
        private final long total;

        public OverviewResponse(List<String> universities, long total) {
            this.universities = universities;
            this.total = total;
        }

        public List<String> getUniversities() {
            return universities;
        }

        public long getTotal() {
            return total;
        }
    }
}
