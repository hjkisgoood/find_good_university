package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Favorites;
import sjk.com.demo.entity.Universities;
import sjk.com.demo.repository.FavoriteRepository;
import sjk.com.demo.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UniversityRepository universityRepository;

    @Autowired
    public UserFavoriteService(FavoriteRepository favoriteRepository, UniversityRepository universityRepository) {
        this.favoriteRepository = favoriteRepository;
        this.universityRepository = universityRepository;
    }

    // 查看收藏大学
    public List<Universities> getUserFavorites(Long userId) {
        List<Favorites> favorites = favoriteRepository.findByUserId(userId);
        List<Universities> favoriteUniversities = new ArrayList<>();
        for (Favorites favorite : favorites) {
            Universities university = universityRepository.findById(favorite.getUniversityId()).orElse(null);
            if (university != null) {
                favoriteUniversities.add(university);
            }
        }
        return favoriteUniversities;
    }
}
