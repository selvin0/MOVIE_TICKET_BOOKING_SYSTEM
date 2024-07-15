package selvin_the_unique.Exception;

public class TheaterIsExistException extends RuntimeException
{
    public TheaterIsExistException()
    {
        super("Theater is already Present on this Address");
    }
}