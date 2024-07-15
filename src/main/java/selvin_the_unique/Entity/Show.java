package selvin_the_unique.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="SHOWS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer showId;

    private Date date;
    private Time time;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @OneToMany(mappedBy="show",cascade= CascadeType.ALL)
    private List<ShowSeat> showSeatList=new ArrayList<>();

    @OneToMany(mappedBy="show",cascade=CascadeType.ALL)
    private List<Ticket> ticketList=new ArrayList<>();

}
