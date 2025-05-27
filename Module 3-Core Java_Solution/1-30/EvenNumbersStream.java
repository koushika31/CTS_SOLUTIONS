import java.util.*;
import java.util.stream.*;

public class EvenNumbersStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 7, 20, 33, 8, 14);

        // Filter even numbers using Stream API
        List<Integer> evenNums = numbers.stream()
                                       .filter(n -> n % 2 == 0)
                                       .collect(Collectors.toList());

        // Display the even numbers
        System.out.println("Even numbers: " + evenNums);
    }
}
