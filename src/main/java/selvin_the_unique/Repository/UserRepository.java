package selvin_the_unique.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import selvin_the_unique.Entity.User;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Integer>
{
    Optional<User> findByEmailId(String email);
}
