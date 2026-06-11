// YoungestTallestFriendArray - Finds youngest and tallest among 3 friends using arrays
import java.util.Scanner;

class YoungestTallestFriendArray {
   public static void main(String[] args) {
      // Create a Scanner object
      Scanner input = new Scanner(System.in);

      // Define number of friends as a constant variable
      int numberOfFriends = 3;

      // Define names of the friends
      String[] friendNames = {"Amar", "Akbar", "Anthony"};

      // Create two arrays to store ages and heights of the 3 friends
      int[] ages = new int[numberOfFriends];
      double[] heights = new double[numberOfFriends];

      // Take user input for age and height of each friend
      for (int i = 0; i < numberOfFriends; i++) {
         System.out.print("Enter " + friendNames[i] + "'s age: ");
         ages[i] = input.nextInt();

         System.out.print("Enter " + friendNames[i] + "'s height (in cm): ");
         heights[i] = input.nextDouble();
      }

      // Initialize youngest and tallest tracking variables with first element
      int youngestAge = ages[0];
      String youngestFriend = friendNames[0];

      double tallestHeight = heights[0];
      String tallestFriend = friendNames[0];

      // Loop through the array to find the youngest and tallest friend
      for (int i = 1; i < numberOfFriends; i++) {
         // Check if current friend is younger than the current youngest
         if (ages[i] < youngestAge) {
            youngestAge = ages[i];
            youngestFriend = friendNames[i];
         }

         // Check if current friend is taller than the current tallest
         if (heights[i] > tallestHeight) {
            tallestHeight = heights[i];
            tallestFriend = friendNames[i];
         }
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
