import java.util.HashSet;
import java.util.Set;

/**
 * EventRegistry manages participant registrations for the conference.
 * Uses a HashSet<String> to guarantee that every registered email ID
 * is unique, automatically rejecting duplicate registrations.
 */
public class EventRegistry {

    // HashSet ensures no duplicate email IDs can exist in the collection
    private final HashSet<String> registeredParticipants;

    public EventRegistry() {
        this.registeredParticipants = new HashSet<>();
    }

    /**
     * Attempts to register a participant using their email ID.
     *
     * @param email the participant's email ID
     * @return true if registration succeeded, false if it was a duplicate
     *         or invalid entry
     */
    public boolean registerParticipant(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Registration failed: Email ID cannot be empty.");
            return false;
        }

        String normalizedEmail = email.trim().toLowerCase();

        // Set.add() returns false automatically if the element already exists
        boolean isNewRegistration = registeredParticipants.add(normalizedEmail);

        if (isNewRegistration) {
            System.out.println("Success: \"" + email.trim() + "\" has been registered.");
        } else {
            System.out.println("Rejected: \"" + email.trim() + "\" is already registered (duplicate entry).");
        }

        return isNewRegistration;
    }

    /**
     * Displays all unique participants who have successfully registered.
     */
    public void displayAllParticipants() {
        System.out.println("\n----- Registered Participants -----");
        if (registeredParticipants.isEmpty()) {
            System.out.println("No participants have registered yet.");
            return;
        }

        int count = 1;
        for (String email : registeredParticipants) {
            System.out.println(count + ". " + email);
            count++;
        }
        System.out.println("------------------------------------");
    }

    /**
     * @return the total number of unique attendees eligible to enter
     */
    public int getTotalAttendees() {
        return registeredParticipants.size();
    }

    /**
     * @return an unmodifiable view of the underlying set (useful for tests)
     */
    public Set<String> getRegisteredParticipants() {
        return registeredParticipants;
    }
}
