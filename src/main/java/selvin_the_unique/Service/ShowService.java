package selvin_the_unique.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selvin_the_unique.Entity.*;
import selvin_the_unique.Enum.SeatType;
import selvin_the_unique.Exception.MovieDoesNotExistsException;
import selvin_the_unique.Exception.ShowDoesNotExistsException;
import selvin_the_unique.Exception.TheaterDoesNotExistsException;
import selvin_the_unique.Repository.MovieRepository;
import selvin_the_unique.Repository.ShowRepository;
import selvin_the_unique.Repository.TheaterRepository;
import selvin_the_unique.Request.ShowRequest;
import selvin_the_unique.Request.ShowSeatRequest;
import selvin_the_unique.converter.ShowConverter;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService
{
     @Autowired
     private MovieRepository movieRepository;
     @Autowired
     private TheaterRepository theaterRepository;
     @Autowired
     private ShowRepository showRepository;

     public String addShow(ShowRequest showRequest)
     {
        Show show=ShowConverter.showDtoToShow(showRequest);

        Optional<Movie> movieopt= movieRepository.findById(showRequest.getMovieId());
            if(movieopt.isEmpty())
            {
                throw  new MovieDoesNotExistsException();
            }

            Optional<Theater> theateropt=theaterRepository.findById(showRequest.getTheaterId());
                if(theateropt.isEmpty())
                {
                    throw new TheaterDoesNotExistsException();
                }

         Movie movie= movieopt.get();
         Theater theater=theateropt.get();

             show.setMovie(movie);
             show.setTheater(theater);
             Show  savedShow= showRepository.save(show);

             movie.getShows().add(show);
             theater.getShowList().add(show);

             movieRepository.save(movie);
             theaterRepository.save(theater);

             return "show has been added SuccessFully";
     }

     public String associateShowSeats(ShowSeatRequest showSeatRequest)
     {
          Optional<Show> showopt=showRepository.findById(showSeatRequest.getShowId());
           if (showopt.isEmpty())
           {
               throw new ShowDoesNotExistsException();
           }

           Show show=showopt.get();
           Theater theater=show.getTheater();

           List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();

           List<ShowSeat> showSeatList= show.getShowSeatList();

           for(TheaterSeat theaterSeat:theaterSeatList) {
               ShowSeat showSeat = new ShowSeat();
               showSeat.setSeatNo(theaterSeat.getSeatNo());
               showSeat.setSeatType(theaterSeat.getSeatType());

               if (showSeat.getSeatType().equals(SeatType.CLASSIC))
               {
                   showSeat.setPrice(showSeatRequest.getPriceOfClassicSeat());
               }
               else
               {
                   showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
               }

               showSeat.setShow(show);
               showSeat.setIsAvailable(Boolean.TRUE);
               showSeat.setIsFoodContains(Boolean.FALSE);

               showSeatList.add(showSeat);
           }
         showRepository.save(show);
      return "show seats have been associated SuccessFully";
     }
}
