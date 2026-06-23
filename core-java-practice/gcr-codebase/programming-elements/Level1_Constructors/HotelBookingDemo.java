// Program 4: Hotel Booking System with default, parameterized, and copy constructors
import java.util.Scanner;

class HotelBooking {
    // Attributes
    private String guestName;
    private String roomType;
    private int nights;

    // Fixed room rates per night
    private static final double DELUXE_RATE    = 3500.0;
    private static final double SUITE_RATE     = 7000.0;
    private static final double STANDARD_RATE  = 1500.0;

    // Default constructor
    public HotelBooking() {
        this.guestName = "Walk-in Guest";
        this.roomType  = "Standard";
        this.nights    = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType  = roomType;
        this.nights    = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType  = other.roomType;
        this.nights    = other.nights;
    }

    // Private helper to calculate total cost
    private double calculateTotalCost() {
        double rate;
        if (roomType.equalsIgnoreCase("Deluxe")) {
            rate = DELUXE_RATE;
        } else if (roomType.equalsIgnoreCase("Suite")) {
            rate = SUITE_RATE;
        } else {
            rate = STANDARD_RATE;
        }
        return rate * nights;
    }

    // Getters and Setters
    public String getGuestName()        { return guestName; }
    public String getRoomType()         { return roomType; }
    public int getNights()              { return nights; }
    public void setGuestName(String g)  { this.guestName = g; }
    public void setRoomType(String r)   { this.roomType = r; }
    public void setNights(int n)        { this.nights = n; }

    // Display booking details
    public void displayBookingDetails() {
        System.out.println("Guest Name  : " + guestName);
        System.out.println("Room Type   : " + roomType);
        System.out.println("Nights      : " + nights);
        System.out.printf("Total Cost  : Rs. %.2f%n", calculateTotalCost());
    }
}

class HotelBookingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Default constructor
        System.out.println("--- Default Booking ---");
        HotelBooking defaultBooking = new HotelBooking();
        defaultBooking.displayBookingDetails();

        // Parameterized constructor
        System.out.println("\nEnter new booking details:");
        System.out.print("Guest Name (e.g. Ravi Sharma)          : ");
        String guestName = sc.nextLine();
        System.out.print("Room Type  (Standard / Deluxe / Suite) : ");
        String roomType  = sc.nextLine();
        System.out.print("Number of Nights                       : ");
        int nights = sc.nextInt();

        HotelBooking newBooking = new HotelBooking(guestName, roomType, nights);
        System.out.println("\n--- Parameterized Booking ---");
        newBooking.displayBookingDetails();

        // Copy constructor
        HotelBooking copiedBooking = new HotelBooking(newBooking);
        copiedBooking.setGuestName("Copy Guest");
        System.out.println("\n--- Copied Booking (guest name changed) ---");
        copiedBooking.displayBookingDetails();

        sc.close();
    }
}
