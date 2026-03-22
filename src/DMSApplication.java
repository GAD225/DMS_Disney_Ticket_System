import java.io.FileNotFoundException;
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
                    String hopperInput = scanner.nextLine().trim().toLowerCase();

                    if (!hopperInput.equals("true") && !hopperInput.equals("false")) {
                        System.out.println("Park Hopper must be true or false.");
                    } else if (id <= 0) {
                        System.out.println("Ticket ID must be greater than 0.");
                    } else if (name.trim().isEmpty()) {
                        System.out.println("Guest name cannot be empty.");
                    } else if (park.trim().isEmpty()) {
                        System.out.println("Park name cannot be empty.");
                    } else if (days <= 0) {
                        System.out.println("Days must be greater than 0.");
                    } else if (price < 0) {
                        System.out.println("Price cannot be negative.");
                    } else {
                        boolean hopper = Boolean.parseBoolean(hopperInput);
                        Ticket ticket = new Ticket(id, name, park, days, price, hopper);

                        if (manager.addTicket(ticket)) {
                            System.out.println("Ticket added successfully.");
                        } else {
                            System.out.println("Ticket could not be added. ID may already exist.");
                        }
                    }

                } else if (choice == 2) {
                    System.out.println(manager.displayTickets());

                } else if (choice == 3) {
                    System.out.print("Enter Ticket ID to update: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.println("What would you like to update?");
                    System.out.println("1. Guest Name");
                    System.out.println("2. Park");
                    System.out.println("3. Days");
                    System.out.println("4. Price Per Day");
                    System.out.println("5. Park Hopper");
                    System.out.print("Choose an option: ");
                    int updateChoice = Integer.parseInt(scanner.nextLine());

                    boolean updated = false;

                    if (updateChoice == 1) {
                        System.out.print("Enter new guest name: ");
                        String newName = scanner.nextLine();
                        updated = manager.updateGuestName(id, newName);
                    } else if (updateChoice == 2) {
                        System.out.print("Enter new park: ");
                        String newPark = scanner.nextLine();
                        updated = manager.updatePark(id, newPark);
                    } else if (updateChoice == 3) {
                        System.out.print("Enter new number of days: ");
                        int newDays = Integer.parseInt(scanner.nextLine());
                        updated = manager.updateDays(id, newDays);
                    } else if (updateChoice == 4) {
                        System.out.print("Enter new price per day: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        updated = manager.updatePricePerDay(id, newPrice);
                    } else if (updateChoice == 5) {
                        System.out.print("Enter new park hopper value (true/false): ");
                        String hopperInput = scanner.nextLine().trim().toLowerCase();

                        if (hopperInput.equals("true") || hopperInput.equals("false")) {
                            updated = manager.updateParkHopper(id, Boolean.parseBoolean(hopperInput));
                        } else {
                            System.out.println("Park Hopper must be true or false.");
                        }
                    } else {
                        System.out.println("Invalid update option.");
                    }

                    if (updated) {
                        System.out.println("Ticket updated successfully.");
                    } else {
                        System.out.println("Ticket could not be updated.");
                    }

                } else if (choice == 4) {
                    System.out.print("Enter Ticket ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    if (manager.deleteTicket(id)) {
                        System.out.println("Ticket deleted successfully.");
                    } else {
                        System.out.println("Ticket not found.");
                    }

                } else if (choice == 5) {
                    System.out.println("Total Revenue: $" + manager.calculateRevenue());

                } else if (choice == 6) {
                    System.out.print("Enter file path: ");
                    String path = scanner.nextLine();

                    try {
                        int loadedCount = loader.loadFile(path, manager);

                        if (loadedCount > 0) {
                            System.out.println(loadedCount + " tickets loaded successfully.");
                        } else {
                            System.out.println("No tickets were loaded.");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File could not be found.");
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