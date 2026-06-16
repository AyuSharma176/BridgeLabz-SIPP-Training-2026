// ParkingLotSystem - Smart parking gate system with Park, Exit, and Show Occupancy
// Concepts: Variables, Scanner, Switch-case, While loop, Break, Operators
import java.util.Scanner;

class ParkingLotSystem {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define parking lot capacity as a constant variable
      int parkingCapacity = 10;

      // Define menu option constants
      int optionPark           = 1;
      int optionExit           = 2;
      int optionShowOccupancy  = 3;
      int optionQuit           = 4;

      // Define parking rate per hour as a constant variable
      double ratePerHour = 30.0;

      // Define current number of parked vehicles initialized to zero
      int parkedVehicles = 0;

      // Define an array to store vehicle numbers of parked cars
      String[] vehicleNumbers = new String[parkingCapacity];

      // Define an array to store entry hours for billing
      int[] entryHours = new int[parkingCapacity];

      System.out.println("=========================================");
      System.out.println("     WELCOME TO SMART PARKING SYSTEM     ");
      System.out.println("=========================================");
      System.out.println("Parking Capacity: " + parkingCapacity + " vehicles");
      System.out.printf("Rate: Rs %.2f per hour%n", ratePerHour);

      // Use while loop to keep the system running until lot is full or user quits
      while (true) {
         // Display the menu options
         System.out.println("\n----- MAIN MENU -----");
         System.out.println(optionPark          + ". Park Vehicle");
         System.out.println(optionExit          + ". Exit Vehicle");
         System.out.println(optionShowOccupancy + ". Show Occupancy");
         System.out.println(optionQuit          + ". Quit");
         System.out.print("Enter your choice: ");
         int choice = input.nextInt();

         // Use switch-case to handle menu selection
         switch (choice) {

            // Option 1: Park a vehicle
            case 1:
               // Check if parking lot is full
               if (parkedVehicles == parkingCapacity) {
                  System.out.println("Parking lot is FULL! No space available.");
                  break;
               }

               // Get vehicle number from user
               System.out.print("Enter Vehicle Number: ");
               String vehicleNumber = input.next();

               // Get entry time (hour) from user
               System.out.print("Enter Entry Hour (0-23): ");
               int entryHour = input.nextInt();

               // Validate entry hour is between 0 and 23
               if (entryHour < 0 || entryHour > 23) {
                  System.out.println("Invalid entry hour. Please enter between 0 and 23.");
                  break;
               }

               // Save vehicle number and entry hour in respective arrays
               vehicleNumbers[parkedVehicles] = vehicleNumber;
               entryHours[parkedVehicles] = entryHour;

               // Increment parked vehicle count
               parkedVehicles++;

               System.out.println("Vehicle " + vehicleNumber + " parked successfully.");
               System.out.println("Available slots: " + (parkingCapacity - parkedVehicles));

               // Break out of main system loop if lot becomes full after parking
               if (parkedVehicles == parkingCapacity) {
                  System.out.println("Parking lot is now FULL.");
               }
               break;

            // Option 2: Exit a vehicle and calculate parking bill
            case 2:
               // Check if parking lot is empty
               if (parkedVehicles == 0) {
                  System.out.println("No vehicles are currently parked.");
                  break;
               }

               // Get vehicle number to exit
               System.out.print("Enter Vehicle Number to Exit: ");
               String exitVehicle = input.next();

               // Get exit hour from user
               System.out.print("Enter Exit Hour (0-23): ");
               int exitHour = input.nextInt();

               // Validate exit hour
               if (exitHour < 0 || exitHour > 23) {
                  System.out.println("Invalid exit hour. Please enter between 0 and 23.");
                  break;
               }

               // Search for the vehicle in the parked vehicles array
               boolean vehicleFound = false;
               for (int i = 0; i < parkedVehicles; i++) {
                  // Check if current slot matches the vehicle to exit
                  if (vehicleNumbers[i].equalsIgnoreCase(exitVehicle)) {
                     vehicleFound = true;

                     // Calculate hours parked (minimum 1 hour)
                     int hoursParked = exitHour - entryHours[i];
                     if (hoursParked <= 0) {
                        hoursParked = 1;
                     }

                     // Calculate total parking fee
                     double parkingFee = hoursParked * ratePerHour;

                     // Display billing information
                     System.out.println("\n----- PARKING BILL -----");
                     System.out.println("Vehicle Number : " + vehicleNumbers[i]);
                     System.out.println("Entry Hour     : " + entryHours[i] + ":00");
                     System.out.println("Exit Hour      : " + exitHour + ":00");
                     System.out.println("Hours Parked   : " + hoursParked);
                     System.out.printf("Parking Fee    : Rs %.2f%n", parkingFee);
                     System.out.println("------------------------");

                     // Shift remaining vehicles to fill the vacated slot
                     for (int j = i; j < parkedVehicles - 1; j++) {
                        vehicleNumbers[j] = vehicleNumbers[j + 1];
                        entryHours[j] = entryHours[j + 1];
                     }

                     // Decrement parked vehicle count after exit
                     parkedVehicles--;

                     System.out.println("Vehicle exited successfully.");
                     System.out.println("Available slots: " + (parkingCapacity - parkedVehicles));
                     break;
                  }
               }

               // Inform user if vehicle was not found
               if (!vehicleFound) {
                  System.out.println("Vehicle " + exitVehicle + " not found in parking lot.");
               }
               break;

            // Option 3: Show current occupancy of the parking lot
            case 3:
               System.out.println("\n----- PARKING OCCUPANCY -----");
               System.out.println("Total Capacity  : " + parkingCapacity);
               System.out.println("Occupied Slots  : " + parkedVehicles);
               System.out.println("Available Slots : " + (parkingCapacity - parkedVehicles));

               // Display list of currently parked vehicles using for loop
               if (parkedVehicles > 0) {
                  System.out.println("\nCurrently Parked Vehicles:");
                  for (int i = 0; i < parkedVehicles; i++) {
                     System.out.println("  Slot " + (i + 1) + ": " + vehicleNumbers[i] +
                           " (Entry: " + entryHours[i] + ":00)");
                  }
               } else {
                  System.out.println("No vehicles currently parked.");
               }
               System.out.println("-----------------------------");
               break;

            // Option 4: Quit the parking system
            case 4:
               System.out.println("Thank you for using Smart Parking System. Goodbye!");
               input.close();
               System.exit(0);
               break;

            // Handle invalid menu choice
            default:
               System.out.println("Invalid choice! Please select from 1 to 4.");
               break;
         }
      }
   }
}
