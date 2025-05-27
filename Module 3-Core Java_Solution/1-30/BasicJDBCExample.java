import java.sql.*;

public class BasicJDBCExample {
    public static void main(String[] args) {
        try {
            System.out.println("Loading JDBC driver...");
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver loaded successfully!");

            String url = "jdbc:sqlite:students.db";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection established!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Database error: " + e);
        }
    }
}
