import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Student Name: Aj Cyrill Dy
 * Student Number: 041113696
 * Section #: 311
 * Course: CST8130 - Data Structures
 * Author/Professor: Narges Tabar
 */

public class Preserve extends FoodItem{

	private int jarSize;
	
	//No arg constructor
	public Preserve() {
	}

	@Override
	public boolean addItem(Scanner scanner) {
	    if (super.addItem(scanner)) { // If the addItem method of the superclass returns true
	        while (true) { // Start an infinite loop
	            try { // Try to execute the following code
	                System.out.print("Enter the size of the jar in milliliters: "); // Print a message to the console
	                if (!scanner.hasNextInt()) { // If the next input is not an integer
	                    System.out.println("Invalid entry"); // Print an error message
	                    scanner.next(); // Consume the invalid input
	                } else { // If the next input is an integer
	                    jarSize = scanner.nextInt(); // Read the jar size
	                    return true; // Return true
	                }
	            } catch (InputMismatchException e) { // If an InputMismatchException is thrown
	                System.out.println("Invalid entry"); // Print an error message
	                scanner.next(); // Consume the invalid input
	            }
	        }
	    }
	    return false; // If the addItem method of the superclass returns false, return false
	}

	@Override
	public String toString() {
		return super.toString() + " size: " + jarSize + "mL";
	}
}
