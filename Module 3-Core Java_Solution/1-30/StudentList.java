import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String studentName;
        String choice;

        do {
            System.out.print("Enter student name: ");
            studentName = input.nextLine();
            names.add(studentName);

            System.out.print("Add another name? (yes/no): ");
            choice = input.nextLine().toLowerCase();
        } while (choice.equals("yes"));

        System.out.println("\nList of student names:");
        for (String name : names) {
            System.out.println(name);
        }

        input.close();
    }
}
