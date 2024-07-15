package selvin_the_unique.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selvin_the_unique.Request.UserRequest;
import selvin_the_unique.Service.UserService;
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;
    @PostMapping("/addNew")
    public ResponseEntity<String> addNewUser(@RequestBody UserRequest userRequest)
    {
               try
               {
               String result = userService.addUser(userRequest);
               return  new ResponseEntity<>(result, HttpStatus.CREATED);
               }
               catch (Exception e)
               {
                    return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
               }
    }
}
