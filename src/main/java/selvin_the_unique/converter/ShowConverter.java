package selvin_the_unique.converter;

import selvin_the_unique.Entity.Show;
import selvin_the_unique.Request.ShowRequest;

public class ShowConverter
{
     public static Show showDtoToShow(ShowRequest showRequest)
     {
         Show show= Show.builder()
                 .time(showRequest.getShowStartTime())
                 .date(showRequest.getShowDate())
                 .build();
         return show;
     }
}
