package selvin_the_unique.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selvin_the_unique.Request.TicketRequest;
import selvin_the_unique.Response.TicketRepsonse;
import selvin_the_unique.Service.TicketService;
@RestController
@RequestMapping("/ticket")
public class TicketController
{
    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<Object> ticketBooking(@RequestBody TicketRequest ticketRequest)
    {
             try
             {
             TicketRepsonse result = ticketService.ticketBooking(ticketRequest);
             return new ResponseEntity<>(result, HttpStatus.CREATED);
             }
             catch (Exception e)
             {
              return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
             }
    }
}
