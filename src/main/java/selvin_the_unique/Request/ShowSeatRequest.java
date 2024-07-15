package selvin_the_unique.Request;
import lombok.Data;

@Data
public class ShowSeatRequest
{
    private Integer showId;
    private Integer priceOfPremiumSeat;
    private Integer priceOfClassicSeat;
}
