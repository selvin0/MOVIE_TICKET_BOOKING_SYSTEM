package selvin_the_unique.Exception;

public class ShowDoesNotExistsException extends RuntimeException
{
    public ShowDoesNotExistsException()
    {
        super("Show does not exists");
    }
}
