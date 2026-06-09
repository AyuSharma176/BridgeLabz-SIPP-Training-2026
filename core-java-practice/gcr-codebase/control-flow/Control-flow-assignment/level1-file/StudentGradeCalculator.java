/**
 * Student Grade Calculator
 * This program calculates the average percentage of a student based on marks in three subjects
 */
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Get marks for Physics from user
        System.out.print("Enter marks for Physics: ");
        double physicsMarks = input.nextDouble();
        
        // Get marks for Chemistry from user
        System.out.print("Enter marks for Chemistry: ");
        double chemistryMarks = input.nextDouble();
        
        // Get marks for Maths from user
        System.out.print("Enter marks for Maths: ");
        double mathsMarks = input.nextDouble();
        
        // Calculate the average percentage of all three subjects
        double averagePercentage = (physicsMarks + chemistryMarks + mathsMarks) / 3;
        
        // Display the calculated percentage
        System.out.println("\nAverage Percentage = " + averagePercentage + "%");
        
        // Close the Scanner resource
        input.close();
    }
}