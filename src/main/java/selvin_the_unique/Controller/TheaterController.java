package selvin_the_unique.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import selvin_the_unique.Request.TheaterRequest;
import selvin_the_unique.Request.TheaterSeatRequest;
import selvin_the_unique.Service.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheaterController
{
     @Autowired
     private TheaterService theaterService;
      @PostMapping("/addNew")
      public ResponseEntity<String> addTheater(@RequestBody TheaterRequest theaterRequest)
      {
           try {
               String result=theaterService.addTheatre(theaterRequest);
               return new ResponseEntity<>(result, HttpStatus.CREATED);
           }
           catch (Exception e)
           {
           return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
           }
      }

      @PostMapping("/addTheaterSeat")
      public ResponseEntity<String> addTheaterSeat(@RequestBody TheaterSeatRequest entryDto)
      {
             try
              {
                  String result = theaterService.addTheaterSeat(entryDto);
                  return new ResponseEntity<>(result, HttpStatus.CREATED);
              }
             catch(Exception e)
             {
                 return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
             }
      }
}
