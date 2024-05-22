package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Dormitories;
import sjk.com.demo.service.DormitoryService;

@RestController
public class DormitoryController {

    private final DormitoryService dormitoryService;

    @Autowired
    public DormitoryController(DormitoryService dormitoryService) {
        this.dormitoryService = dormitoryService;
    }

    @PostMapping("/dormitories")
    public ResponseEntity<?> publishDormitory(@RequestBody Dormitories dormitory) {
        System.out.println("DormitoryController's publishDormitory method is being called.");
        try {
            Dormitories savedDormitory = dormitoryService.saveDormitory(dormitory);
            return ResponseEntity.ok().body(new DormitoryResponse("Dormitory information published successfully", savedDormitory.getDormitoryId().toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DormitoryResponse("Failed to publish dormitory information", null));
        }
    }

    private static class DormitoryResponse {
        private final String message;
        private final String dormitoryId;

        public DormitoryResponse(String message, String dormitoryId) {
            this.message = message;
            this.dormitoryId = dormitoryId;
        }

        public String getMessage() {
            return message;
        }

        public String getDormitoryId() {
            return dormitoryId;
        }
    }
}
