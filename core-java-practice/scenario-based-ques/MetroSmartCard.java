// MetroSmartCard - Delhi Metro fare deduction system based on distance
// Concepts: Variables, Scanner, Operators, Ternary, Loops, Break/Continue
import java.util.Scanner;

class MetroSmartCard {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define fare slabs as constant variables (no hard-coding)
      double fareShort  = 10.0;   // fare for distance <= 5 km
      double fareMedium = 20.0;   // fare for distance 6-15 km
      double fareLong   = 30.0;   // fare for distance 16-25 km
      double fareMax    = 40.0;   // fare for distance > 25 km

      // Define distance thresholds as constant variables
      int distanceThresholdShort  = 5;
      int distanceThresholdMedium = 15;
      int distanceThresholdLong   = 25;

      // Define quit command as a constant variable
      int quitCommand = 0;

      // Get initial smart card balance from user
      System.out.print("Enter your Smart Card balance (Rs): ");
      double smartCardBalance = input.nextDouble();

      // Validate initial balance is positive
      if (smartCardBalance <= 0) {
         System.out.println("Invalid balance. Please recharge your card.");
         input.close();
         System.exit(0);
      }

      System.out.println("\nWelcome to Delhi Metro Smart Card System!");
      System.out.println("Enter 0 as distance to quit.\n");

      // Loop until balance is exhausted or user quits
      while (smartCardBalance > 0) {
         // Display current balance
         System.out.printf("Current Balance: Rs %.2f%n", smartCardBalance);

         // Ask user for travel distance
         System.out.print("Enter distance to travel (km) [0 to quit]: ");
         int distance = input.nextInt();

         // Break out of loop if user enters 0 to quit
         if (distance == quitCommand) {
            System.out.println("Thank you for using Delhi Metro. Goodbye!");
            break;
         }

         // Validate distance is positive; skip this iteration if invalid
         if (distance < 0) {
            System.out.println("Invalid distance entered. Please try again.\n");
            continue;
         }

         // Calculate fare using ternary operator based on distance slabs
         double fare = (distance <= distanceThresholdShort)  ? fareShort  :
                       (distance <= distanceThresholdMedium) ? fareMedium :
                       (distance <= distanceThresholdLong)   ? fareLong   :
                                                               fareMax;

         // Check if balance is sufficient for the journey
         if (fare > smartCardBalance) {
            System.out.printf("Insufficient balance! Fare is Rs %.2f but balance is Rs %.2f%n",
                              fare, smartCardBalance);
            System.out.println("Please recharge your card. Exiting...");
            break;
         }

         // Deduct fare from smart card balance
         smartCardBalance = smartCardBalance - fare;

         // Display journey summary
         System.out.printf("Distance: %d km | Fare Charged: Rs %.2f | Remaining Balance: Rs %.2f%n%n",
                           distance, fare, smartCardBalance);

         // Warn user if balance is running low
         if (smartCardBalance < fareShort) {
            System.out.println("WARNING: Low balance! Please recharge your Smart Card.\n");
         }
      }

      // Final balance display
      System.out.printf("%nFinal Smart Card Balance: Rs %.2f%n", smartCardBalance);

      // Close Scanner stream
      input.close();
   }
}
