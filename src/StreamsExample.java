import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
    }

    @Test
    public void firstStream() {
        employees
                .forEach(System.out::println);
    }

    @Test
    public void mapOperation() {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
    }

    @Test
    public void flatMapOperation() {
        List<List<String>> allSkills = employees.stream()
                .map(Employee::getSkills)
                .collect(Collectors.toList());

        System.out.println(allSkills);

        List<String> allSkills2 = employees.stream()
                .map(Employee::getSkills)
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allSkills2);
    }
}


