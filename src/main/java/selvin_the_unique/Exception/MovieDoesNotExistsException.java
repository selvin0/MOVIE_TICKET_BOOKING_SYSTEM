package selvin_the_unique.Exception;

public class MovieDoesNotExistsException extends RuntimeException {
    public MovieDoesNotExistsException()
    {
        super("Movie dose not Exists");
    }
}
