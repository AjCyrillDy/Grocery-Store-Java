import java.util.Scanner;

public class Vegetable extends FoodItem{
/**
* CET - CS Academic Level 3
* Student Name: Aj Cyrill Dy
* Student Number: 041113696
* Section #: 311
* Course: CST8130 - Data Structures
* Author/Professor: Narges Tabar
*/
	
	private String farmName;
	
	//No arg constructor
	public Vegetable() {
	}

	@Override
	public boolean addItem(Scanner scanner) {
		if (super.addItem(scanner)) {
			try {
				System.out.print("Enter the name of the farm supplier: ");
				farmName = scanner.nextLine();
				return true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry");
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " farm supplier: " + farmName;
	}
}
