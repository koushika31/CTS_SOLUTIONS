public class OperatorOrder {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = 2;

        int answer = a + b * c;
        System.out.println("Result of 10 + 5 * 2 = " + answer);

        // Explanation:
        // Multiplication happens before addition, so:
        // 5 * 2 = 10, then 10 + 10 = 20
    }
}
