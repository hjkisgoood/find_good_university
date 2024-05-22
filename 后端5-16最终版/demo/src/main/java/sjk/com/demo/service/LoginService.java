package sjk.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjk.com.demo.entity.Users;
import sjk.com.demo.repository.UserRepository;

@Service
public class LoginService {

    private final UserRepository usersRepository;

    @Autowired
    public LoginService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public String loginUser(Users user) {
        Users existingUser = usersRepository.findByUsername(user.getUsername());

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            return "{\"message\": \"Login failed\"}";
        } else {
            return "{\"message\": \"Login successful\", \"userId\": \"" + existingUser.getUserId() +
                    "\", \"userType\": \"" + existingUser.getUserType() + "\"}";
        }
    }
}
