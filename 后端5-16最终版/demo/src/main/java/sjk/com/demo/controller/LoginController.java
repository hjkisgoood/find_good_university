package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Users;
import sjk.com.demo.service.LoginService;

@RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users user) {

        // 输出方法被调用信息
        System.out.println("LoginController's loginUser method is being called.");
        return loginService.loginUser(user);
    }
}
