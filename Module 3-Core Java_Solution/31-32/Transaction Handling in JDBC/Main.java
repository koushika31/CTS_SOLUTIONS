public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "root";

        try {
            AccountDAO dao = new AccountDAO(url, user, password);

            // Simulate transfer of 200 from Alice (1) to Bob (2)
            dao.transferMoney(1, 2, 200.00);

            dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
