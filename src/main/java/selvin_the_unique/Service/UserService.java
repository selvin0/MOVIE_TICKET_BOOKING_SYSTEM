package selvin_the_unique.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selvin_the_unique.Entity.User;
import selvin_the_unique.Exception.UserExistException;
import selvin_the_unique.Repository.UserRepository;
import selvin_the_unique.Request.UserRequest;
import selvin_the_unique.converter.UserConverter;

import java.util.Optional;

@Service
public class UserService
{
     @Autowired
     private UserRepository userRepository;

     public String addUser(UserRequest userRequest)
     {
        Optional<User> useropt= userRepository.findByEmailId(userRequest.getEmailId());
        if(useropt.isPresent())
        {
           throw  new UserExistException();
        }

          User user= UserConverter.userDtoToUser(userRequest);
           userRepository.save(user);
           return "User Saved SuccessFully";
     }
}
