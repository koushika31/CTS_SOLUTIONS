import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int id;
        String name;
        String more;

        do {
            System.out.print("Enter student ID: ");
            id = input.nextInt();
            input.nextLine();  // consume newline

            System.out.print("Enter student name: ");
            name = input.nextLine();

            studentMap.put(id, name);

            System.out.print("Add another student? (yes/no): ");
            more = input.nextLine().toLowerCase();
        } while (more.equals("yes"));

        System.out.print("Enter ID to find student name: ");
        int searchId = input.nextInt();

        if (studentMap.containsKey(searchId)) {
            System.out.println("Student name: " + studentMap.get(searchId));
        } else {
            System.out.println("No student found with ID " + searchId);
        }

        input.close();
    }
}
