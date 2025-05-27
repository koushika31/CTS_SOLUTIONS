import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int count = input.nextInt();

        int[] numbers = new int[count];
        int total = 0;

        System.out.println("Enter " + count + " numbers:");
        for (int i = 0; i < count; i++) {
            numbers[i] = input.nextInt();
            total += numbers[i];
        }

        double average = (count > 0) ? (double) total / count : 0;

        System.out.println("Sum of elements: " + total);
        System.out.println("Average of elements: " + average);

        input.close();
    }
}
