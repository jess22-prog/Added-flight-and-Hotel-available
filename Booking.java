public class Booking {
    private String bookingId;
    private String bookingType;  // "Hotel" or "Flight"
    private boolean availability; // True if available, False if unavailable
    private double price;
    
    // Constructor
    public Booking(String bookingId, String bookingType, boolean availability, double price) {
        this.bookingId = bookingId;
        this.bookingType = bookingType;
        this.availability = availability;
        this.price = price;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public boolean isAvailable() {
        return availability;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Type: " + bookingType + ", Available: " + availability + ", Price: $" + price;
    }
}
