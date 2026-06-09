/**
 * BMI (Body Mass Index) Calculator
 * BMI is calculated as: weight (kg) / (height (m))^2
 * This program calculates BMI given weight in kilograms and height in centimeters
 */
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get weight from user in kilograms
        System.out.print("Enter weight in kilograms: ");
        double weightKg = input.nextDouble();
        
        // Get height from user in centimeters
        System.out.print("Enter height in centimeters: ");
        double heightCm = input.nextDouble();
        
        // Convert height from centimeters to meters
        double heightMeters = heightCm / 100.0;
        
        // Calculate BMI using the formula: weight / (height * height)
        double bmi = weightKg / (heightMeters * heightMeters);
        
        // Display the calculated BMI
        System.out.println("\nYour BMI is: " + bmi);
        
        // Close the Scanner resource
        input.close();
    }
}