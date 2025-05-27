import java.sql.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(String url, String user, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(String name, int age) throws SQLException {
        String query = "INSERT INTO students (name, age) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.executeUpdate();
        ps.close();
    }

    public void updateStudent(int id, String name, int age) throws SQLException {
        String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, id);
        ps.executeUpdate();
        ps.close();
    }

    public void close() throws SQLException {
        conn.close();
    }
}
