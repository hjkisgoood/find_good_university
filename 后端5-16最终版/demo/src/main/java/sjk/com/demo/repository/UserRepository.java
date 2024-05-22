package sjk.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjk.com.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsernameAndPasswordAndInviteCode(String username, String password, String inviteCode);

    boolean existsByUsername(String username);



    Users findByUsername(String username);
}
