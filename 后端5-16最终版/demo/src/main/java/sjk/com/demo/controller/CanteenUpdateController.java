package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Canteens;
import sjk.com.demo.service.CanteenUpdateService;

@RestController
public class CanteenUpdateController {

    private final CanteenUpdateService canteenUpdateService;

    @Autowired
    public CanteenUpdateController(CanteenUpdateService canteenUpdateService) {
        this.canteenUpdateService = canteenUpdateService;
    }

    @PostMapping("/updateCanteen")
    public ResponseEntity<?> updateCanteenInfo(@RequestBody Canteens canteen) {
        System.out.println("CanteenUpdateController's updateCanteenInfo method is being called.");
        try {
            canteenUpdateService.updateCanteen(canteen);
            return ResponseEntity.ok().body(new CanteenResponse("Canteen information updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CanteenResponse("Failed to update canteen information"));
        }
    }

    private static class CanteenResponse {
        private final String message;

        public CanteenResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
