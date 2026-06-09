import java.util.Scanner;

// Class to find side of a square
class SquareSide {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take perimeter as input
        System.out.print("Enter perimeter of square: ");
        double perimeter = input.nextDouble();

        // Calculate side
        double sideLength = perimeter / 4;

        // Display result
        System.out.println("The length of the side is "
                + sideLength + " whose perimeter is " + perimeter);

        input.close();
    }
}