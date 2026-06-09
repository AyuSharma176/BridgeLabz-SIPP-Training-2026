import java.util.Scanner;

// Class to convert distance
class DistanceConversion {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take distance in feet
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();

        // Convert to yards
        double distanceInYards = distanceInFeet / 3;

        // Convert to miles
        double distanceInMiles = distanceInYards / 1760;

        // Display result
        System.out.println("The distance in yards is "
                + distanceInYards + " while the distance in miles is "
                + distanceInMiles);

        input.close();
    }
}