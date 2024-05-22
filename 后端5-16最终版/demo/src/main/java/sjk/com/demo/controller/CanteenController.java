package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Canteens;
import sjk.com.demo.service.CanteenService;

@RestController
public class CanteenController {

    private final CanteenService canteenService;

    @Autowired
    public CanteenController(CanteenService canteenService) {
        this.canteenService = canteenService;
    }

    @PostMapping("/canteens")
    public ResponseEntity<?> addCanteen(@RequestBody Canteens canteen) {
        System.out.println("CanteenController's addCanteen method is being called.");
        try {
            Canteens savedCanteen = canteenService.saveCanteen(canteen);
            return ResponseEntity.ok().body(new CanteenResponse("Canteen information added successfully", savedCanteen.getCanteenId().toString()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CanteenResponse("Failed to add canteen information", null));
        }
    }

    private static class CanteenResponse {
        private final String message;
        private final String canteenId;

        public CanteenResponse(String message, String canteenId) {
            this.message = message;
            this.canteenId = canteenId;
        }

        public String getMessage() {
            return message;
        }

        public String getCanteenId() {
            return canteenId;
        }
    }
}
