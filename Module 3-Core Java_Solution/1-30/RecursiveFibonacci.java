import java.util.Scanner;

public class RecursiveFibonacci {

    public static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer (n): ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int fibResult = fibonacci(n);
            System.out.println("Fibonacci number at position " + n + " is: " + fibResult);
        }

        scanner.close();
    }
}
