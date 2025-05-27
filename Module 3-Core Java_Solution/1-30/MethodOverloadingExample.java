public class MethodOverloadingExample {

    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public static double add(double x, double y) {
        return x + y;
    }

    // Method to add three integers
    public static int add(int p, int q, int r) {
        return p + q + r;
    }

    public static void main(String[] args) {
        int sum1 = add(5, 10);
        double sum2 = add(3.5, 4.5);
        int sum3 = add(1, 2, 3);

        System.out.println("Sum of two integers: " + sum1);
        System.out.println("Sum of two doubles: " + sum2);
        System.out.println("Sum of three integers: " + sum3);
    }
}
