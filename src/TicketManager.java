import java.util.ArrayList;

public class TicketManager {

    private ArrayList<Ticket> tickets;

    public TicketManager() {
        tickets = new ArrayList<>();
    }

    public String createTicket(Ticket ticket) {
        tickets.add(ticket);
        return "Ticket added successfully.";
    }

    public String displayTickets() {
        if (tickets.isEmpty()) {
            return "No tickets available.";
        }

        String output = "";

        for (Ticket ticket : tickets) {
            output += ticket.displayTicket() + "\n";
        }

        return output;
    }

    public String updateTicket(int id, String newName) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == id) {
                ticket.updateGuestName(newName);
                return "Ticket updated.";
            }
        }

        return "Ticket not found.";
    }

    public String deleteTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketId() == id) {
                tickets.remove(i);
                return "Ticket deleted.";
            }
        }

        return "Ticket not found.";
    }

    public double calculateRevenue() {
        double revenue = 0;

        for (Ticket ticket : tickets) {
            revenue += ticket.calculateTotalCost();
        }

        return revenue;
    }

    public String addBatchTicket(Ticket ticket) {
        tickets.add(ticket);
        return "Batch ticket added.";
    }
}