package selvin_the_unique.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import selvin_the_unique.Entity.Theater;

import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater,Integer>
{
       Optional <Theater> findByAddress(String address);
}
