package selvin_the_unique.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selvin_the_unique.Entity.Show;
import selvin_the_unique.Entity.ShowSeat;
import selvin_the_unique.Entity.Ticket;
import selvin_the_unique.Entity.User;
import selvin_the_unique.Exception.SeatNotAvailable;
import selvin_the_unique.Exception.ShowDoesNotExistsException;
import selvin_the_unique.Exception.UserDoesNotExistsException;
import selvin_the_unique.Repository.ShowRepository;
import selvin_the_unique.Repository.TicketRepository;
import selvin_the_unique.Repository.UserRepository;
import selvin_the_unique.Request.TicketRequest;
import selvin_the_unique.Response.TicketRepsonse;
import selvin_the_unique.converter.TicketConverter;

import java.util.List;
import java.util.Optional;
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UserRepository userRepository;

    public TicketRepsonse ticketBooking(TicketRequest ticketRequest)
    {
        Optional<Show> showOpt = showRepository.findById(ticketRequest.getShowId());
        if (showOpt.isEmpty()) {
            throw new ShowDoesNotExistsException();
        }

        Optional<User> userOpt = userRepository.findById(ticketRequest.getUserId());
        if (userOpt.isEmpty()) {
            throw new UserDoesNotExistsException();
        }

        User user = userOpt.get();
        Show show = showOpt.get();

        Boolean isseatAvail = isSeatAvailable(show.getShowSeatList(), ticketRequest.getRequestSeats());
        if (!isseatAvail) {
            throw new SeatNotAvailable();
        }


        Integer getPriceAndAssignSets = getPriceAndAssignSeats(show.getShowSeatList(), ticketRequest.getRequestSeats());
         String seats=listToString(ticketRequest.getRequestSeats());

        Ticket ticket=new Ticket();
               ticket.setTotalTicketPrice(getPriceAndAssignSets);
               ticket.setBookedSeats(seats);
               ticket.setUser(user);
               ticket.setShow(show);

             Ticket savedTicket=  ticketRepository.save(ticket);

             user.getTicketList().add(ticket);
             show.getTicketList().add(ticket);
             userRepository.save(user);
             showRepository.save(show);

    return TicketConverter.returnTicket(show,ticket);
    }

    private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats) {
        for (ShowSeat showSeat : showSeatList) {
            String seatNo = showSeat.getSeatNo();

            if (requestSeats.contains(seatNo) && !showSeat.getIsAvailable()) {
                return false;
            }

        }
        return true;
    }

    private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats) {
        Integer totalAmount = 0;

        for (ShowSeat showSeat : showSeatList) {
            if (requestSeats.contains(showSeat.getSeatNo())) {
                totalAmount = totalAmount + showSeat.getPrice();
                showSeat.setIsAvailable(Boolean.FALSE);
            }
        }
        return totalAmount;
    }



    private String listToString(List<String> requestSeat)
    {
          StringBuilder sb=new StringBuilder();
                for(String str:requestSeat)
                {
                   sb.append(str).append(",");
                }
                return sb.toString();
    }
}
