package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Users;
import sjk.com.demo.service.Enrollmentusers;

@RestController
public class Enroll {
    private final Enrollmentusers enrollmentusers;

    @Autowired
    public Enroll(Enrollmentusers enrollmentusers) {
        this.enrollmentusers = enrollmentusers;
    }

    @PostMapping("/register")
    public RegistrationResponse registerUser(@RequestBody Users user) {
        System.out.println("Enroll's registerUser method is being called.");
        String userId = enrollmentusers.registerUser(user);
        return new RegistrationResponse("User registered successfully", userId);
    }

    // 内部类用于响应体
    static class RegistrationResponse {
        private final String message;
        private final String userId;

        public RegistrationResponse(String message, String userId) {
            this.message = message;
            this.userId = userId;
        }

        public String getMessage() {
            return message;
        }

        public String getUserId() {
            return userId;
        }
    }
}



