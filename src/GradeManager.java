import java.util.ArrayList;

public class GradeManager {

    ArrayList<Student> roster;

    public GradeManager() {
        roster = new ArrayList<>();
    }

    public void addStudent(String name, double grade) {
        roster.add(new Student(name, grade));
    }

    public void displayStudents() {

        if (roster.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudent List");
        System.out.println("-------------------------");

        for (Student s : roster) {
            System.out.println(
                    "Name: " + s.name +
                            " | Grade: " + s.grade +
                            " | Letter: " + s.getLetterGrade()
            );
        }
    }

    public void displayAverage() {

        if (roster.isEmpty()) {
            System.out.println("No students to compute average.");
            return;
        }

        double total = 0;

        for (Student s : roster) {
            total += s.grade;
        }

        double average = total / roster.size();

        System.out.printf("Class Average: %.2f%n", average);
    }
}