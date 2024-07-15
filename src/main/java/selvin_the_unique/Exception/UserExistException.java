package selvin_the_unique.Exception;
public class UserExistException extends RuntimeException
{
      public UserExistException()
      {
          super("User already Exists");
      }
}
