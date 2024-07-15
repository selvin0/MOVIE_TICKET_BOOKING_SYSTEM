package selvin_the_unique.Exception;

public class UserDoesNotExistsException extends RuntimeException
{
     public UserDoesNotExistsException()
     {
         super("user Does not Exists");
     }
}
