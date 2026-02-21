import java.util.List;

public class Main {

    public static void main(String[] args) {

        Repository repo = new Repository();

        for (int i = 1; i <= 10; i++) {

            Student s = new Student(
                    i,
                    "First" + i,
                    "Last" + i,
                    18 + i,
                    "Male",
                    "BSIT",
                    1,
                    "A",
                    "student" + i + "@school.com",
                    900000000 + i
            );

            repo.saveStudent(s);
        }

        List<Student> students = repo.findAllStudent();

        System.out.println("=== MASTER LIST OF STUDENTS ===");

        for (Student s : students) {
            System.out.println(
                    s.getStudID() + " - " +
                    s.getFirstName() + " " +
                    s.getLastName() +
                    " | " + s.getCourse()
            );
        }

        repo.close();
    }
}