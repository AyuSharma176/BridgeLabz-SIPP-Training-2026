import java.util.Scanner;

// Class to calculate area of a triangle
class TriangleArea {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take base and height as input
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();

        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();

        // Calculate area in square centimeters
        double areaInSqCm = 0.5 * base * height;

        // Convert to square inches
        double areaInSqIn = areaInSqCm / (2.54 * 2.54);

        // Display result
        System.out.println("The Area of the triangle in sq in is "
                + areaInSqIn + " and sq cm is " + areaInSqCm);

        input.close();
    }
}