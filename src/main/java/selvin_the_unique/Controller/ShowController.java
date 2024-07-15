package selvin_the_unique.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selvin_the_unique.Entity.Show;
import selvin_the_unique.Request.ShowRequest;
import selvin_the_unique.Request.ShowSeatRequest;
import selvin_the_unique.Service.ShowService;
import selvin_the_unique.converter.ShowConverter;

@RestController
@RequestMapping("/show")
public class ShowController
{
    @Autowired
    private ShowService showService;
    @PostMapping("/addNew")
    public ResponseEntity<String> addShow(@RequestBody ShowRequest showRequest)
    {
         try
         {
             String result = showService.addShow(showRequest);
             return  new ResponseEntity<>(result, HttpStatus.CREATED);
         }
         catch(Exception e)
         {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
         }
    }

    @PostMapping("/associateSeats")
    public ResponseEntity<String> associateShowSeats(@RequestBody ShowSeatRequest showSeatRequest)
    {
               try
               {
                  String result=showService.associateShowSeats(showSeatRequest);
                  return new ResponseEntity<>(result,HttpStatus.CREATED);
               }
               catch (Exception e)
               {
                   return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
               }
    }
}
