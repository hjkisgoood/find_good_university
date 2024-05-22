package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.service.UniversityService;

@RestController
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/universities")
    public ResponseEntity<?> publishUniversity(@RequestBody Universities university) {
        System.out.println("UniversityController's publishUniversity method is being called.");
        try {
            Universities savedUniversity = universityService.saveUniversity(university);
            return ResponseEntity.ok().body(new UniversityResponse("University information published successfully", savedUniversity.getUniversityID().toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new UniversityResponse("Failed to publish university information",null));
        }
    }

    private static class UniversityResponse {
        private final String message;
        private final String universityId;

        public UniversityResponse(String message, String universityId) {
            this.message = message;
            this.universityId = universityId;
        }

        public String getMessage() {
            return message;
        }

        public String getUniversityId() {
            return universityId;
        }
    }
}
