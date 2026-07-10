import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n========== LIBRARY INFORMATION SYSTEM ==========");
            System.out.println("1. Add a Book");
            System.out.println("2. List All Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Search a Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        String title;

                        do {
                            System.out.print("Enter book title: ");
                            title = scanner.nextLine().trim();

                            if (title.isEmpty()) {
                                System.out.println("Title cannot be empty.");
                            }

                        } while (title.isEmpty());

                        String author;

                        do {
                            System.out.print("Enter author: ");
                            author = scanner.nextLine().trim();

                            if (author.isEmpty()) {
                                System.out.println("Author cannot be empty.");
                            }

                        } while (author.isEmpty());

                        Book book = new Book(title, author);
                        library.addBook(book);

                        break;

                    case 2:

                        library.listBooks();
                        break;

                    case 3:

                        System.out.print("Enter title to borrow: ");
                        String borrowTitle = scanner.nextLine();

                        if (borrowTitle.trim().isEmpty()) {
                            System.out.println("Title cannot be empty.");
                        } else {
                            library.borrowBook(borrowTitle);
                        }

                        break;

                    case 4:

                        System.out.print("Enter title to return: ");
                        String returnTitle = scanner.nextLine();

                        if (returnTitle.trim().isEmpty()) {
                            System.out.println("Title cannot be empty.");
                        } else {
                            library.returnBook(returnTitle);
                        }

                        break;

                    case 5:

                        System.out.print("Enter title to search: ");
                        String searchTitle = scanner.nextLine();

                        if (searchTitle.trim().isEmpty()) {
                            System.out.println("Title cannot be empty.");
                        } else {
                            library.searchBook(searchTitle);
                        }

                        break;

                    case 0:

                        System.out.println("Goodbye!");
                        break;

                    default:

                        System.out.println("Invalid menu choice.");
                }

            } catch (Exception e) {

                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();

            }

        }

        scanner.close();

    }

}