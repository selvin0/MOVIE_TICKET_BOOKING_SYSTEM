package selvin_the_unique.converter;
import selvin_the_unique.Entity.Show;
import selvin_the_unique.Entity.Ticket;
import selvin_the_unique.Response.TicketRepsonse;
public class TicketConverter
{
    public  static TicketRepsonse returnTicket(Show show, Ticket ticket)
    {
       TicketRepsonse ticketRepsonseDto= TicketRepsonse.builder()
                    .bookedSeats(ticket.getBookedSeats())
                    .address(show.getTheater().getAddress())
                    .theaterName(show.getTheater().getName())
                    .movieName(show.getMovie().getMovieName())
                    .date(show.getDate())
                    .time(show.getTime())
                    .totalPrice(ticket.getTotalTicketPrice())
                    .build();
     return ticketRepsonseDto;
    }
}
