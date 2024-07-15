package selvin_the_unique.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import selvin_the_unique.Enum.General;
import selvin_the_unique.Enum.Language;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="MOVIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String movieName;

    private Integer duration;

    @Column(scale=2)
    private Double rating;

    private Date releaseDate;

   @Enumerated(value=EnumType.STRING)
   private General general;

   @Enumerated(value= EnumType.STRING)
   private Language language;

   @OneToMany(mappedBy="movie",cascade= CascadeType.ALL)
   private List<Show> shows=new ArrayList<>();
}
