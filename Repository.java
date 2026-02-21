package main.java;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private Connection connection;

    public Repository() {
        try {
            String url = "jdbc:sqlite:student_information.db";
            connection = DriverManager.getConnection(url);
            createTable();
        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }

    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "studID INTEGER PRIMARY KEY, " +
                "firstName TEXT, " +
                "lastName TEXT, " +
                "age INTEGER, " +
                "gender TEXT, " +
                "course TEXT, " +
                "yearLevel INTEGER, " +
                "section TEXT, " +
                "email TEXT, " +
                "contactNum INTEGER)";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void saveStudent(Student s) {
        String sql = "INSERT INTO students VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, s.getStudID());
            pstmt.setString(2, s.getFirstName());
            pstmt.setString(3, s.getLastName());
            pstmt.setInt(4, s.getAge());
            pstmt.setString(5, s.getGender());
            pstmt.setString(6, s.getCourse());
            pstmt.setInt(7, s.getYearLevel());
            pstmt.setString(8, s.getSection());
            pstmt.setString(9, s.getEmail());
            pstmt.setInt(10, s.getContactNum()); // <-- FIXED

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    public List<Student> findAllStudent() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                students.add(new Student(
                        rs.getInt("studID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("course"),
                        rs.getInt("yearLevel"),
                        rs.getString("section"),
                        rs.getString("email"),
                        rs.getInt("contactNum")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Query Error: " + e.getMessage());
        }

        return students;
    }

    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println("Close Error: " + e.getMessage());
        }
    }
}