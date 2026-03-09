import java.io.File;
import java.util.Scanner;

public class FileLoader {

    public int loadFile(String path, TicketManager manager) {
        int count = 0;

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length == 6) {
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String park = data[2].trim();
                    int days = Integer.parseInt(data[3].trim());
                    double price = Double.parseDouble(data[4].trim());
                    boolean hopper = Boolean.parseBoolean(data[5].trim());

                    Ticket ticket = new Ticket(id, name, park, days, price, hopper);
                    manager.addBatchTicket(ticket);
                    count++;
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        return count;
    }
}