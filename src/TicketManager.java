import java.util.ArrayList;

public class TicketManager {

    private ArrayList<Ticket> tickets;

    public TicketManager() {
        tickets = new ArrayList<>();
    }

    public boolean addTicket(Ticket ticket) {
        if (ticket == null) {
            return false;
        }

        if (findTicketById(ticket.getTicketId()) != null) {
            return false;
        }

        tickets.add(ticket);
        return true;
    }

    public int getTicketCount() {
        return tickets.size();
    }

    public Ticket findTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == id) {
                return ticket;
            }
        }
        return null;
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

    public boolean deleteTicket(int id) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketId() == id) {
                tickets.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean updateGuestName(int id, String newName) {
        Ticket ticket = findTicketById(id);

        if (ticket == null || newName == null || newName.trim().isEmpty()) {
            return false;
        }

        ticket.updateGuestName(newName);
        return true;
    }

    public boolean updatePark(int id, String newPark) {
        Ticket ticket = findTicketById(id);

        if (ticket == null || newPark == null || newPark.trim().isEmpty()) {
            return false;
        }

        ticket.updatePark(newPark);
        return true;
    }

    public boolean updateDays(int id, int newDays) {
        Ticket ticket = findTicketById(id);

        if (ticket == null || newDays <= 0) {
            return false;
        }

        ticket.updateDays(newDays);
        return true;
    }

    public boolean updatePricePerDay(int id, double newPrice) {
        Ticket ticket = findTicketById(id);

        if (ticket == null || newPrice < 0) {
            return false;
        }

        ticket.updatePricePerDay(newPrice);
        return true;
    }

    public boolean updateParkHopper(int id, boolean newParkHopper) {
        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            return false;
        }

        ticket.updateParkHopper(newParkHopper);
        return true;
    }

    public double calculateRevenue() {
        double revenue = 0.0;

        for (Ticket ticket : tickets) {
            revenue += ticket.calculateTotalCost();
        }

        return revenue;
    }
}