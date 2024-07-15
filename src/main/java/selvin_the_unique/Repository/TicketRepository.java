package selvin_the_unique.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import selvin_the_unique.Entity.Ticket;
public interface TicketRepository extends JpaRepository<Ticket,Integer>
{

}
