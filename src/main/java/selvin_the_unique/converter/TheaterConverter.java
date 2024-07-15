package selvin_the_unique.converter;
import selvin_the_unique.Entity.Theater;
import selvin_the_unique.Request.TheaterRequest;
public class TheaterConverter
{
    public static Theater theaterDtoTheater(TheaterRequest theaterRequest)
    {
          Theater theater= Theater.builder()
                    .name(theaterRequest.getName())
                    .address(theaterRequest.getAddress())
                    .build();
          return theater;
    }
}
