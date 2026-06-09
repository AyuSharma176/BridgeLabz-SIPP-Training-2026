// YoungestTallestFriend - Finds youngest and tallest among Amar, Akbar, and Anthony
import java.util.Scanner;

class YoungestTallestFriend {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Get age and height inputs for Amar
      System.out.print("Enter Amar's age: ");
      int amarAge = input.nextInt();
      System.out.print("Enter Amar's height (in cm): ");
      double amarHeight = input.nextDouble();

      // Get age and height inputs for Akbar
      System.out.print("Enter Akbar's age: ");
      int akbarAge = input.nextInt();
      System.out.print("Enter Akbar's height (in cm): ");
      double akbarHeight = input.nextDouble();

      // Get age and height inputs for Anthony
      System.out.print("Enter Anthony's age: ");
      int anthonyAge = input.nextInt();
      System.out.print("Enter Anthony's height (in cm): ");
      double anthonyHeight = input.nextDouble();

      // Find the youngest friend by comparing all three ages
      String youngestFriend = "Amar";
      int youngestAge = amarAge;

      if (akbarAge < youngestAge) {
         youngestAge = akbarAge;
         youngestFriend = "Akbar";
      }
      if (anthonyAge < youngestAge) {
         youngestAge = anthonyAge;
         youngestFriend = "Anthony";
      }

      // Find the tallest friend by comparing all three heights
      String tallestFriend = "Amar";
      double tallestHeight = amarHeight;

      if (akbarHeight > tallestHeight) {
         tallestHeight = akbarHeight;
         tallestFriend = "Akbar";
      }
      if (anthonyHeight > tallestHeight) {
         tallestHeight = anthonyHeight;
         tallestFriend = "Anthony";
      }

      // Display the youngest and tallest friend
      System.out.println("\nThe youngest friend is " + youngestFriend +
                         " with age " + youngestAge);
      System.out.println("The tallest friend is " + tallestFriend +
                         " with height " + tallestHeight + " cm");

      // Close Scanner stream
      input.close();
   }
}
