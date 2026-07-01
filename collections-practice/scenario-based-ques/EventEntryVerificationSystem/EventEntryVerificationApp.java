import java.util.Scanner;

/**
 * Console-driven application that lets event organizers register
 * participants, view the registration list, and check attendee counts,
 * while automatically preventing duplicate registrations.
 */
public class EventEntryVerificationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventRegistry registry = new EventRegistry();

        boolean running = true;

        System.out.println("=====================================");
        System.out.println(" EVENT ENTRY VERIFICATION SYSTEM");
        System.out.println("=====================================");

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter participant email ID: ");
                    String email = scanner.nextLine();
                    registry.registerParticipant(email);
                    break;

                case "2":
                    registry.displayAllParticipants();
                    break;

                case "3":
                    System.out.println("\nTotal eligible attendees: " + registry.getTotalAttendees());
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting Event Entry Verification System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 4.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1. Register new participant");
        System.out.println("2. Display all registered participants");
        System.out.println("3. Show total number of attendees");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
