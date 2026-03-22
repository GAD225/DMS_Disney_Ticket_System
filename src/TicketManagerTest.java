import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {

    @Test
    public void testAddTicket() {
        TicketManager manager = new TicketManager();
        Ticket ticket = new Ticket(1, "Gerald", "Magic Kingdom", 3, 120, true);

        boolean result = manager.addTicket(ticket);

        assertTrue(result);
        assertEquals(1, manager.getTicketCount());
    }

    @Test
    public void testDeleteTicket() {
        TicketManager manager = new TicketManager();
        Ticket ticket = new Ticket(1, "Gerald", "Magic Kingdom", 3, 120, true);

        manager.addTicket(ticket);
        boolean result = manager.deleteTicket(1);

        assertTrue(result);
    }

    @Test
    public void testUpdateGuestName() {
        TicketManager manager = new TicketManager();
        Ticket ticket = new Ticket(1, "Gerald", "Magic Kingdom", 3, 120, true);

        manager.addTicket(ticket);
        manager.updateGuestName(1, "Gerald Updated");

        assertEquals("Gerald Updated", manager.findTicketById(1).getGuestName());
    }

    @Test
    public void testRevenue() {
        TicketManager manager = new TicketManager();

        manager.addTicket(new Ticket(1, "A", "Magic Kingdom", 2, 100, true));
        manager.addTicket(new Ticket(2, "B", "Epcot", 1, 150, false));

        assertEquals(400.0, manager.calculateRevenue());
    }
    @Test
    public void testLoadFile() throws Exception {
        TicketManager manager = new TicketManager();
        FileLoader loader = new FileLoader();

        int loadedCount = loader.loadFile("tickets.txt", manager);

        assertTrue(loadedCount > 0);
    }
}