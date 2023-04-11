import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
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

    @Test
    public void filterOperation() {
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .forEach(System.out::println);
    }

    @Test
    public void sortedOpreation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);

    }

    @Test
    public void limitOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void skipOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void countCoperation() {
        long numberOfEmployees = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .count();

        System.out.println(numberOfEmployees);
    }

    @Test
    public void minOperation() {
        Employee youngestEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getAge)).get();

        System.out.println(youngestEmployee);
    }

    @Test
    public void maxOperation() {
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge)).get();

        System.out.println(oldestEmployee);
    }

    @Test
    public void findFirstOperation() {
        Employee employee = employees.stream()
                .filter(emp -> emp.getFirstName().startsWith("B"))
                .findFirst().get();

        System.out.println(employee);
    }

    @Test
    public void findAnyOperation() {
        Employee employee = employees.stream()
                .filter(emp -> emp.getFirstName().startsWith("B"))
                .findAny().get();

        System.out.println(employee);
    }

    @Test
    public void allMatchOperation() {
        boolean b = employees.stream()
                .allMatch(emp -> emp.getFirstName().startsWith("B"));

        System.out.println(b);
    }

    @Test
    public void anyMatchOperation() {
        boolean a = employees.stream()
                .anyMatch(emp -> emp.getFirstName().contains("a"));

        System.out.println(a);
    }

    @Test
    public void noneMatchOperation() {
        boolean z = employees.stream()
                .noneMatch(emp -> emp.getFirstName().startsWith("Z"));

        System.out.println(z);


    }

    @Test
    public void reduceOperation() {
        Integer sumOfAllAges = employees.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum)
                .get();

        System.out.println(sumOfAllAges);

        int sumOfAllAges2 = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);

        System.out.println(sumOfAllAges2);

        Integer sumOfAllAges3 = employees.stream()
                .reduce(0, (age, employee) -> age + employee.getAge(), Integer::sum);

        System.out.println(sumOfAllAges3);

        String allNames = employees.stream()
                .map(Employee::getFirstName)
                .reduce((name, name2) -> name + ", " + name2)
                .get();

        System.out.println(allNames);

    }

    @Test

    // metoda takeWhile używa się zawsze na posortowanych streamach

    public void takeWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test

    // metoda dropWhile używa się zawsze na posortowanych streamach

    public void dropWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);

    }

    @Test
    public void forEachOrdered() {
        String sentence = "Jak nauczyć się programowania?";

        sentence.chars().forEach(s -> System.out.print((char) s));
        System.out.println();
        sentence.chars().parallel().forEach(s -> System.out.print((char) s));
        System.out.println();
        sentence.chars().parallel().forEachOrdered(s -> System.out.print((char) s));
    }

    @Test

    // metoda peek używa się tylko do podglądania elementów streama podczas debugowania kodu


    public void peekOperation() {
        List<Employee> newEmployees = employees.stream()
                .peek(employee -> employee.setFirstName("Kamil"))
                .collect(Collectors.toList());

        System.out.println(newEmployees);
        System.out.println();
        System.out.println(employees);
    }
}


