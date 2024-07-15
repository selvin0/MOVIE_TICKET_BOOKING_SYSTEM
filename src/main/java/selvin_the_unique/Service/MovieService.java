package selvin_the_unique.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selvin_the_unique.Entity.Movie;
import selvin_the_unique.Exception.MovieAlreadyExistException;
import selvin_the_unique.Repository.MovieRepository;
import selvin_the_unique.Request.MovieRequest;
import selvin_the_unique.converter.MovieConverter;
@Service
public class MovieService
{
     @Autowired
     private MovieRepository movieRepository;
     public String addMovie(MovieRequest movieRequest)
     {
        Movie movieName= movieRepository.findByMovieName(movieRequest.getMovieName());
        if(movieName!=null && movieName.getLanguage().equals(movieRequest.getLanguage()))
        {
             throw new MovieAlreadyExistException();
        }
       Movie movie= MovieConverter.movieDtoToMovie(movieRequest);
           movieRepository.save(movie);

           return "The movie has been added Successfully";
     }
}
