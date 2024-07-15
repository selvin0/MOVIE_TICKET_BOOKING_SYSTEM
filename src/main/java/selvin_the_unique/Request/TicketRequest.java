package selvin_the_unique.Request;
import lombok.Data;
import java.util.List;
@Data
public class TicketRequest
{
    private Integer showId;
    private Integer userId;
    private List<String> requestSeats;
}
