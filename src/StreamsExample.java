import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class StreamsExample {

    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Honkytonk", "Cumbercooch", 25, List.of("Java", "JavaScript", "Python"));
        Employee employee2 = new Employee("Brewery", "Chickenstrips", 31, List.of("C#"));
        Employee employee3 = new Employee("Beetlejuice", "Snugglesnatch", 23, List.of("Java", "Haskell", "Scala"));
        Employee employee4 = new Employee("Boobytrap", "Humperdinck", 42, List.of("PHP", "JavaScript", "React", "Angular"));
        Employee employee5 = new Employee("Buttermilk", "Bumbersplat", 38, List.of("Java", "Scala"));
        Employee employee6 = new Employee("Rinkydink", "Curdlesnoot", 30, List.of("C#", "C++"));
        Employee employee7 = new Employee("Cogglesnatch", "Splishnsplash", 27, List.of("Rust", "Python"));
        Employee employee8 = new Employee("Tiddleywomp", "Charmander", 51, List.of("Java", "Spring", "Hibernate", "Java"));
    }
}
