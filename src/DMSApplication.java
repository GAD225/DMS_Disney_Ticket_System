import java.util.Scanner;

public class DMSApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicketManager manager = new TicketManager();
        FileLoader loader = new FileLoader();

        int choice = 0;

        while (choice != 7) {
            System.out.println("\nDisney Ticket DMS");
            System.out.println("1. Add Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Calculate Revenue");
            System.out.println("6. Load Tickets From File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Enter Ticket ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Guest Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Park Name: ");
                    String park = scanner.nextLine();

                    System.out.print("Enter Number of Days: ");
                    int days = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Price Per Day: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Park Hopper (true/false): ");
                    boolean hopper = Boolean.parseBoolean(scanner.nextLine());

                    Ticket ticket = new Ticket(id, name, park, days, price, hopper);
                    System.out.println(manager.createTicket(ticket));
                } else if (choice == 2) {
                    System.out.println(manager.displayTickets());
                } else if (choice == 3) {
                    System.out.print("Enter Ticket ID to update: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter new guest name: ");
                    String newName = scanner.nextLine();

                    System.out.println(manager.updateTicket(id, newName));
                } else if (choice == 4) {
                    System.out.print("Enter Ticket ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.println(manager.deleteTicket(id));
                } else if (choice == 5) {
                    System.out.println("Total Revenue: $" + manager.calculateRevenue());
                } else if (choice == 6) {
                    System.out.print("Enter file path: ");
                    String path = scanner.nextLine();
                    int loadedCount = loader.loadFile(path, manager);

                    if (loadedCount > 0) {
                        System.out.println(loadedCount + " tickets loaded successfully.");
                    } else {
                        System.out.println("No tickets were loaded.");
                    }
                } else if (choice == 7) {
                    System.out.println("Program closed.");
                } else {
                    System.out.println("Invalid menu option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }
}