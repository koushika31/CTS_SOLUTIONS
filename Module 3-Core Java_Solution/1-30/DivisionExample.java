import java.util.Scanner;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter numerator: ");
        int numerator = input.nextInt();
        
        System.out.print("Enter denominator: ");
        int denominator = input.nextInt();
        
        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }
        
        input.close();
    }
}
