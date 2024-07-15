package selvin_the_unique.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import selvin_the_unique.Enum.Gender;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest
{
    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
    private String roles;
}
