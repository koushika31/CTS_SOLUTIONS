import java.util.*;
import java.util.stream.*;

public class PersonRecordsExample {
    // Define a record named Person
    record Person(String name, int age) {}

    public static void main(String[] args) {
        // Create a list of Person records
        List<Person> people = List.of(
            new Person("Alice", 23),
            new Person("Bob", 17),
            new Person("Charlie", 30),
            new Person("Diana", 15)
        );

        // Print all people
        people.forEach(System.out::println);

        // Filter people aged 18 or above using Streams
        List<Person> adults = people.stream()
                                   .filter(p -> p.age() >= 18)
                                   .toList();

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}
