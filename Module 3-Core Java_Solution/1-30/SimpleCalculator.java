import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double numOne = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double numTwo = scanner.nextDouble();

        System.out.println("Choose operation: +, -, *, /");
        char operator = scanner.next().charAt(0);

        double calculationResult;

        switch (operator) {
            case '+':
                calculationResult = numOne + numTwo;
                break;
            case '-':
                calculationResult = numOne - numTwo;
                break;
            case '*':
                calculationResult = numOne * numTwo;
                break;
            case '/':
                if (numTwo != 0) {
                    calculationResult = numOne / numTwo;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation selected.");
                scanner.close();
                return;
        }

        System.out.println("Result: " + calculationResult);
        scanner.close();
    }
}
