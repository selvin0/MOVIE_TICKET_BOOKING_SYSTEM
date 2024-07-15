package selvin_the_unique.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import selvin_the_unique.Enum.SeatType;
@Entity
@Table(name="THEATER_SEATS")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeat
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String seatNo;

    @Enumerated(value=EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}
