package selvin_the_unique.Request;
import lombok.Data;
@Data
public class TheaterSeatRequest
{
     private String address;
     private Integer noOfSeatInRow;
     private Integer noOfPremiumSeat;
     private Integer noOfClassicSeat;
}
