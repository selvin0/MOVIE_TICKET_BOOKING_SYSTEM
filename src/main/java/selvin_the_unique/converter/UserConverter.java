package selvin_the_unique.converter;
import selvin_the_unique.Entity.User;
import selvin_the_unique.Request.UserRequest;

public class UserConverter
{
    public static User userDtoToUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .gender(userRequest.getGender())
                .mobileNo(userRequest.getMobileNo())
                .emailId(userRequest.getEmailId())
                .build();

        return user;
    }
}
