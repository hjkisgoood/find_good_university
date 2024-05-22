package sjk.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.service.UserFavoriteService;

import java.util.List;

@RestController
public class UserFavoriteController {

    private final UserFavoriteService userFavoriteService;

    @Autowired
    public UserFavoriteController(UserFavoriteService userFavoriteService) {
        this.userFavoriteService = userFavoriteService;
    }

    // 获取用户收藏的大学列表
    @GetMapping("/users/{userId}/collections")
    public List<Universities> getUserFavorites(@PathVariable Long userId) {
        System.out.println("UserFavoriteController's getUserFavorites method is being called.");
        return userFavoriteService.getUserFavorites(userId);
    }
}
