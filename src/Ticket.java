public class Ticket {

    private int ticketId;
    private String guestName;
    private String park;
    private int days;
    private double pricePerDay;
    private boolean parkHopper;

    public Ticket(int ticketId, String guestName, String park, int days, double pricePerDay, boolean parkHopper) {
        this.ticketId = ticketId;
        this.guestName = guestName;
        this.park = park;
        this.days = days;
        this.pricePerDay = pricePerDay;
        this.parkHopper = parkHopper;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getPark() {
        return park;
    }

    public int getDays() {
        return days;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isParkHopper() {
        return parkHopper;
    }

    public Ticket updateGuestName(String newName) {
        this.guestName = newName;
        return this;
    }

    public Ticket updatePark(String newPark) {
        this.park = newPark;
        return this;
    }

    public Ticket updateDays(int newDays) {
        this.days = newDays;
        return this;
    }

    public Ticket updatePricePerDay(double newPrice) {
        this.pricePerDay = newPrice;
        return this;
    }

    public Ticket updateParkHopper(boolean newParkHopper) {
        this.parkHopper = newParkHopper;
        return this;
    }

    public double calculateTotalCost() {
        double total = pricePerDay * days;

        if (parkHopper) {
            total += 50;
        }

        return total;
    }

    public String displayTicket() {
        return "TicketID: " + ticketId +
                " | Guest: " + guestName +
                " | Park: " + park +
                " | Days: " + days +
                " | Price/Day: $" + pricePerDay +
                " | Hopper: " + parkHopper;
    }
}