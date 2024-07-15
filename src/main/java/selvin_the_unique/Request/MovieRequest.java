package selvin_the_unique.Request;
import lombok.Data;
import selvin_the_unique.Enum.General;
import selvin_the_unique.Enum.Language;
import java.util.Date;

@Data
public class MovieRequest
{
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private General general;
    private Language language;
}
