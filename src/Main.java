import java.util.Scanner;

public class Main {

    static final int MAX_STUDENTS = 10;

    static int[] ids = new int[MAX_STUDENTS];
    static String[] names = new String[MAX_STUDENTS];
    static int[] ages = new int[MAX_STUDENTS];
    static String[] courses = new String[MAX_STUDENTS];
    static double[] grades = new double[MAX_STUDENTS];
    static boolean[] enrolled = new boolean[MAX_STUDENTS];

    static int studentCount = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    viewStatistics();
                    break;
                case 5:
                    System.out.println("\nGoodbye!baii salamat kaayu for using the Student Information System.");
                    running = false;
                    break;
                default:
                    System.out.println("\nMali na choice choice. Please select a number from 1 to 5.");
            }
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n===== STUDENT INFORMATION SYSTEM" +
                " =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search by ID");
        System.out.println("4. View Statistics");
        System.out.println("5. Exit");
        System.out.println("=======================================");
    }

    static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("\nCannot add more students. The list is full na bai (max " + MAX_STUDENTS + ").");
            return;
        }

        System.out.println("\n--- Add ug New Student ---");

        int id = readInt("Student ID megoh: ");

        System.out.print("Full Name please 1: ");
        String name = scanner.nextLine();

        int age = readInt("Age please: ");
        while (age <= 0) {
            System.out.println("Age dapat positive.");
            age = readInt("Age: ");
        }

        System.out.print("Course: ");
        String course = scanner.nextLine();

        double grade = readDouble("Grade (0-100): ");
        while (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            grade = readDouble("Grade (0-100): ");
        }

        boolean isEnrolled = readBoolean("Enrolled? (true/false): ");

        ids[studentCount] = id;
        names[studentCount] = name;
        ages[studentCount] = age;
        courses[studentCount] = course;
        grades[studentCount] = grade;
        enrolled[studentCount] = isEnrolled;

        studentCount++;

        System.out.println("Student added successfully!");
    }

    static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("\nNo students recorded yet.");
            return;
        }

        System.out.println("\n--- All Students ---");
        System.out.printf("%-6s %-20s %-5s %-12s %-8s %-10s %-14s%n",
                "ID", "Name", "Age", "Course", "Grade", "Enrolled", "Standing");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < studentCount; i++) {
            String standing = getStanding(grades[i]);

            System.out.printf("%-6d %-20s %-5d %-12s %-8.2f %-10s %-14s%n",
                    ids[i], names[i], ages[i], courses[i], grades[i],
                    (enrolled[i] ? "Yes" : "No"), standing);
        }
    }

    static String getStanding(double grade) {
        String standing;

        if (grade >= 90) {
            standing = "Dean's Lister";
        } else if (grade >= 75) {
            standing = "Passed";
        } else {
            standing = "Failed";
        }

        return standing;
    }

    // Option 3: Search for a student by ID
    static void searchById() {
        if (studentCount == 0) {
            System.out.println("\nNo students recorded yet.");
            return;
        }

        int searchId = readInt("\nEnter Student ID to search: ");
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (ids[i] == searchId) {
                found = true;
                System.out.println("\n--- Student Found ---");
                System.out.println("ID: " + ids[i]);
                System.out.println("Name: " + names[i]);
                System.out.println("Age: " + ages[i]);
                System.out.println("Course: " + courses[i]);
                System.out.println("Grade: " + grades[i]);
                System.out.println("Enrolled: " + (enrolled[i] ? "Yes" : "No"));
                System.out.println("Standing: " + getStanding(grades[i]));
                break;
            }
        }

        if (!found) {
            System.out.println("\nNo student found with ID " + searchId + ".");
        }
    }

    // Option 4: Display class statistics
    static void viewStatistics() {
        if (studentCount == 0) {
            System.out.println("\nNo students recorded yet.");
            return;
        }

        double total = 0;
        double topGrade = grades[0];
        String topName = names[0];

        for (int i = 0; i < studentCount; i++) {
            total += grades[i];

            if (grades[i] > topGrade) {
                topGrade = grades[i];
                topName = names[i];
            }
        }

        double average = total / studentCount;

        System.out.println("\n--- Class Statistics ---");
        System.out.println("Total Students: " + studentCount);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Top Student: " + topName + " (" + topGrade + ")");
    }

    // ---- Input helper methods ----

    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid whole number.");
            System.out.print(prompt);
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number.");
            System.out.print(prompt);
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline
        return value;
    }

    static boolean readBoolean(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();

        while (!input.equals("true") && !input.equals("false")) {
            System.out.println("Please enter 'true' or 'false'.");
            System.out.print(prompt);
            input = scanner.nextLine().trim().toLowerCase();
        }

        return Boolean.parseBoolean(input);
    }
}
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        IO.println("i = " + i);
    }
}
