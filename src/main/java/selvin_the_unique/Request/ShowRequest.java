package selvin_the_unique.Request;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import selvin_the_unique.Entity.Movie;
import selvin_the_unique.Entity.ShowSeat;
import selvin_the_unique.Entity.Theater;
import selvin_the_unique.Entity.Ticket;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ShowRequest
{
    private Time showStartTime;
    private Date showDate;
    private Integer theaterId;
    private Integer movieId;
}
