package selvin_the_unique.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selvin_the_unique.Entity.Theater;
import selvin_the_unique.Entity.TheaterSeat;
import selvin_the_unique.Enum.SeatType;
import selvin_the_unique.Exception.TheaterIsExistException;
import selvin_the_unique.Exception.TheaterIsNotExist;
import selvin_the_unique.Repository.TheaterRepository;
import selvin_the_unique.Request.TheaterRequest;
import selvin_the_unique.Request.TheaterSeatRequest;
import selvin_the_unique.converter.TheaterConverter;

import java.util.List;
@Service
public class TheaterService
{
      @Autowired
      private TheaterRepository theaterRepository;

      public String addTheatre(TheaterRequest theaterRequest)
      {
            if(theaterRepository.findByAddress(theaterRequest.getAddress())!=null)
            {
                throw  new TheaterIsExistException();
            }

         Theater theater= TheaterConverter.theaterDtoTheater(theaterRequest);

            theaterRepository.save(theater);
            return "Theater has been saved Successfully";
      }

      public String addTheaterSeat(TheaterSeatRequest entryDto)
      {
           if(theaterRepository.findByAddress(entryDto.getAddress())==null)
           {
               throw new TheaterIsNotExist();
           }
           Integer noOfSeatInRow= entryDto.getNoOfSeatInRow();
           Integer noOfPreminumSeats= entryDto.getNoOfPremiumSeat();
           Integer noOfClassicSeat=entryDto.getNoOfClassicSeat();
           String address=entryDto.getAddress();

           Theater theater= theaterRepository.findByAddress(address).get();

           List<TheaterSeat> seatList=theater.getTheaterSeatList();

           int counter=1;
           int fill=0;
           char ch='A';

           for(int i=1;i<=noOfClassicSeat;i++)    // 30  10
           {
               String seatNo=Integer.toString(counter)+ch;
               ch++;
               fill++;

               if(fill==noOfSeatInRow)
               {
                  fill=0;
                  counter++;
                  ch='A';
               }

               TheaterSeat theaterSeat=new TheaterSeat();
                           theaterSeat.setSeatNo(seatNo);
                           theaterSeat.setSeatType(SeatType.CLASSIC);
                           theaterSeat.setTheater(theater);
                           seatList.add(theaterSeat);
           }

           for (int i=1;i<=noOfPreminumSeats;i++)
           {
                String seatNo= Integer.toString(counter)+ch;
                ch++;
                fill++;
                if(fill==noOfSeatInRow)
                {
                    fill=0;
                    counter++;
                    ch='A';
                }

               TheaterSeat theaterSeat=new TheaterSeat();
               theaterSeat.setSeatNo(seatNo);
               theaterSeat.setSeatType(SeatType.PREMIUM);
               theaterSeat.setTheater(theater);
               seatList.add(theaterSeat);
           }
           theaterRepository.save(theater);
           return "Theater Seats have been added successfully";
      }

}
