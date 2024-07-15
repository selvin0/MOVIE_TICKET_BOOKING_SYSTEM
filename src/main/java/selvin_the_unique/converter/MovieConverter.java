package selvin_the_unique.converter;

import selvin_the_unique.Entity.Movie;
import selvin_the_unique.Request.MovieRequest;

public class MovieConverter
{
    public static Movie movieDtoToMovie(MovieRequest movieRequest)
    {
        Movie movie= Movie.builder()
                    .movieName(movieRequest.getMovieName())
                    .duration(movieRequest.getDuration())
                    .general(movieRequest.getGeneral())
                    .language(movieRequest.getLanguage())
                    .releaseDate(movieRequest.getReleaseDate())
                    .rating(movieRequest.getRating())
                    .build();
          return movie;
    }
}
