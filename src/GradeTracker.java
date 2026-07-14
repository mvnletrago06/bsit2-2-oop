import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeManager manager = new GradeManager();

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n===== Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Class Average");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.next();

                    double grade;

                    while (true) {
                        System.out.print("Enter grade (0-100): ");

                        try {
                            grade = sc.nextDouble();

                            if (grade >= 0 && grade <= 100) {
                                break;
                            }

                            System.out.println("Grade must be between 0 and 100.");

                        } catch (Exception e) {
                            System.out.println("Invalid grade.");
                            sc.nextLine();
                        }
                    }

                    manager.addStudent(name, grade);
                    System.out.println("Student added successfully.");
                    break;


                case 2:
                    manager.displayStudents();
                    break;


                case 3:
                    manager.displayAverage();
                    break;


                case 4:
                    System.out.println("Exiting program...");
                    break;


                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}