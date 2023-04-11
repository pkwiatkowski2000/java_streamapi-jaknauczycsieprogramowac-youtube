import lombok.*;
import org.junit.jupiter.api.Tag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Employee {

    private String firstName;
    private String lastName;
    int age;

    private List<String> skills;
}
