package selvin_the_unique.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Entity
@Table(name="TICKETS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ticketId;

    private Integer totalTicketPrice;

    private String bookedSeats;

    @CreationTimestamp
    private Date bookAt;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private User user;
}
