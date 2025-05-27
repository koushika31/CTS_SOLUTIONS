public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "root"; // use your actual password

        try {
            StudentDAO dao = new StudentDAO(url, user, password);

            // Insert a student
            dao.insertStudent("David", 21);
            System.out.println("Inserted student David.");

            // Update a student (assuming ID 1 exists)
            dao.updateStudent(1, "Alice Smith", 23);
            System.out.println("Updated student with ID 1.");

            dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
