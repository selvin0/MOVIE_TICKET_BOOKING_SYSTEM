package selvin_the_unique.Exception;
public class SeatNotAvailable extends RuntimeException
{
     public SeatNotAvailable()
     {
         super("Seat is not available");
     }
}
