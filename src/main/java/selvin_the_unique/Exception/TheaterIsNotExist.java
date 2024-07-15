package selvin_the_unique.Exception;
public class TheaterIsNotExist extends RuntimeException
{
    public TheaterIsNotExist()
    {
        super("Theater is not present in this address");
    }
}
