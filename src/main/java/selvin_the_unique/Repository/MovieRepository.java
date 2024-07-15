package selvin_the_unique.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import selvin_the_unique.Entity.Movie;
public interface MovieRepository extends JpaRepository<Movie,Integer>
{
     Movie findByMovieName(String name);
}
