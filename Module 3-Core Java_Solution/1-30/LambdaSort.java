import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Koushi");
        names.add("Siva");
        names.add("Madhu");
        names.add("Maddy");

        // Sort the list using a lambda expression
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // Display the sorted list
        for (String name : names) {
            System.out.println(name);
        }
    }
}
