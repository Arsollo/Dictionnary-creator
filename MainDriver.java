//-----------------------------------------------------------
//Assignment #4
//Written by: Arsany Fahmy (40157267)
//-----------------------------------------------------------

//-----------------------------------------------------------
//This program takes an input file from user and outputs
//a sub-dictionary with all valid words assorted alphabetically
//-----------------------------------------------------------


import java.util.Scanner;

/**
 * @author Arsany
 * Main driver class
 */
public class MainDriver 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//creating Keyboard scanner
		Scanner Keyboard = new Scanner(System.in);
		
		//Welcome message
		System.out.println("Welcome to disctionary creator");
		System.out.print("Please enter file name:");
		String fileName = Keyboard.next();
		
		subDictionary test = new subDictionary(fileName);
		
		test.createDictionary();

	}

}
