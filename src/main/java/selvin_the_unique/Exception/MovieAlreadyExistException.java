package selvin_the_unique.Exception;

public class MovieAlreadyExistException extends RuntimeException
{
     public MovieAlreadyExistException()
     {
        super("Movie is already exists with same name and language");
     }
}
