package selvin_the_unique.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import selvin_the_unique.Enum.Gender;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USERS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private Integer age;
    private String address;

    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String mobileNo;

    @Column(unique = true)
    private String emailId;

    @OneToMany(mappedBy="user",cascade= CascadeType.ALL)
    private List<Ticket> ticketList=new ArrayList<>();
}
