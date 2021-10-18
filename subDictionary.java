//----------------------------------------------------
//Assignment #4
//Written by: Arsany Fahmy (40157267)
//----------------------------------------------------

//-----------------------------------------------------------
//This program takes an input file from user and outputs
//a sub-dictionary with all valid words assorted alphabetically
//-----------------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author Arsany
 *	This program takes an input file from user and outputs
 *  a sub-dictionary with all valid words assorted alphabetically
 */
public class subDictionary 
{
	private String inputFile;             //the file which the user is going to pass to the program
	private BufferedReader inputBuff;     //Buffered Reader to read user files
	private ArrayList<String> inputLines = new ArrayList<String>(); //arraylist containing lines of the user's file
	private ArrayList<String> inputLinesFiltered = new ArrayList<String>(); //arraylist containing the lines of the created dictionary
	private ArrayList<String> inputWords = new ArrayList<String>();  //arraylist holding content of input file in words
	private PrintWriter outputWriter;     //Printwriter that will output a dictionary file
	private static int number = 1;        //how many files are being created
	
	/**
	 * 
	 * @param fileName file name given by user
	 */
	public subDictionary(String fileName)
	{
		inputFile = fileName;
	}
	
	
	/**
	 * Main method where all the actions get executed
	 */
	public void createDictionary()
	{
		//loading File into buffered Reader
		try 
		{
			inputBuff = new BufferedReader(new FileReader(inputFile));
		}catch(FileNotFoundException e)
		{
			System.out.println("Error: Dictionary not created, couldn't find the file " + inputFile + 
					", Program stopped.");
		}
		
		//Putting user's file into an array of lines
		String tempLine = "string"; //temporary string holding the value of each line in file
		while(tempLine != null)
		{
			try 
			{
				//reading next line
				tempLine = inputBuff.readLine();
				if (tempLine != null)
				{
					inputLines.add(tempLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//**Filtering the contents of inputLines by removing characters**
		for(int i = 0; i < inputLines.size(); i++)
		{
			String temp = inputLines.get(i); //temporary variable storing content of each line
			
			//removing all special characters
			temp = temp.replace(",", "");
			temp = temp.replace("`", "");
			temp = temp.replace("~", "");
			temp = temp.replace("!", "");
			temp = temp.replace("@", "");
			temp = temp.replace("#", "");
			temp = temp.replace("$", "");
			temp = temp.replace("%", "");
			temp = temp.replace("^", "");
			temp = temp.replace("&", "");
			temp = temp.replace("*", "");
			temp = temp.replace("(", "");
			temp = temp.replace(")", "");
			temp = temp.replace("_", "");
			temp = temp.replace("+", "");
			temp = temp.replace("=", "");
			temp = temp.replace("<", "");
			temp = temp.replace(">", "");
			temp = temp.replace(".", "");
			temp = temp.replace("?", "");
			temp = temp.replace("/", "");
			temp = temp.replace(":", "");
			temp = temp.replace(";", "");
			//temp = temp.replace("'", "");
		
			//adding the filtered value to the new arraylist
			inputLinesFiltered.add(temp);

		}
		
		//**removing repeated words**
		//1- filling content of file into words 
		String line;
		String[] arr;
		
		//input lines to input words
		for(int x = 0; x < inputLinesFiltered.size(); x++)
		{
			line = inputLinesFiltered.get(x);
			arr = line.split(" ");
			
			for (int y = 0; y < arr.length; y++)
			{
				inputWords.add(arr[y]);
			}
		}
		
		
		//2- eliminating repeated words
		String comp;
		int size = inputWords.size();
		//ArrayList<Integer> indexRepeats = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++)
		{
			comp = inputWords.get(i);
			
			for(int x = 0; x < size; x++)
			{
				if (comp.equalsIgnoreCase(inputWords.get(x)) && (x != i))
				{
					inputWords.remove(x);
					x--;
					size--;
				}
			}
		}
		
		
		//**eliminating empty fields in the list**
		int size2 = inputWords.size();
		
		for(int i = 0; i < size2; i++)
		{
			if(inputWords.get(i).equals(" ") || inputWords.get(i).equals(""))
			{
				inputWords.remove(i);
				i--;
				size2--;
			}
		}
		
		//**eliminating single letters unless its an a or an i
		int size3 = inputWords.size();
		
		for(int i = 0; i < size3; i++)
		{
			//if the word stored contains only one letter
			if(inputWords.get(i).length() < 2)
			{
				//if that letter is not an a or an i
				if ((inputWords.get(i).equalsIgnoreCase("a") == false) &&
						(inputWords.get(i).equalsIgnoreCase("i") == false))
				{
					inputWords.remove(i);
					i--;
					size3--;
				}
			}
		}
		
		//**removing words that have numerical values
		int size4 = inputWords.size();
		
		for(int i = 0; i < size4; i++)
		{
			//if that letter is not an a or an i
			if ((inputWords.get(i).contains("0")) || (inputWords.get(i).contains("1")) || 
					(inputWords.get(i).contains("2")) || (inputWords.get(i).contains("3")) || 
					(inputWords.get(i).contains("4")) || (inputWords.get(i).contains("5")) || 
					(inputWords.get(i).contains("6")) || (inputWords.get(i).contains("7")) || 
					(inputWords.get(i).contains("8")) || (inputWords.get(i).contains("9")))
			{
				inputWords.remove(i);
				i--;
				size4--;
			}
			
		}
		
		//**removing 's and 'm **
		for(int i = 0; i < inputWords.size(); i++)
		{
			if (inputWords.get(i).contains("'s"))
			{
				 inputWords.set(i, inputWords.get(i).substring(0, inputWords.get(i).indexOf('\'')));
			}
		}
		for(int i = 0; i < inputWords.size(); i++)
		{
			if (inputWords.get(i).contains("'m"))
			{
				 inputWords.set(i, inputWords.get(i).substring(0, inputWords.get(i).indexOf('\'')));
			}
		}
		
		
		
		
		//**filling the arraylist that contain the output file**
		
		//1- create the file 
		File outputFile = new File("SubDictionary" + number + ".txt");
		
		//creating a printwriter
		try 
		{
			outputWriter = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		//2- Convert everything to uppercase
		for(int i = 0; i < inputWords.size(); i++)
		{
			inputWords.set(i, inputWords.get(i).toUpperCase());
		}
		
		
		//3- Sorting the arraylist alphabetically 
		int size5 = inputWords.size();
		String sort;
		int count = 0;
		int remove = 0;
	
		for(int j = 0; j < size5; j++)
		{
			remove = -1;
			sort = inputWords.get(count);
			
			for(int i = count; i < size5 ; i++)
			{
				if (sort.compareTo(inputWords.get(i)) > 0)
				{
					remove = i;
					sort = inputWords.get(i);
					i = count;
				}
			}
			if (remove == -1)
			{
			}
			else
			{
				inputWords.remove(remove);
				inputWords.add(count,sort);
			}
		
			count++;
		}
	
		//4- Writing the output file
		inputWords.add(" ");
		char letter = '8';
		char letter2;
		
		for (int i = 0; i < inputWords.size()-1;)
		{
			//writing first two line 
			if (i == 0)
			{
				outputWriter.println("The document produced this sub-dictionary, which includes " + (inputWords.size()-1) + " entries.");
				outputWriter.println(" ");
			}
			
			//starting a new section with a new letter
			letter = inputWords.get(i).charAt(0); //first letter of word 1
			letter2 = inputWords.get(i+1).charAt(0); //first letter of word 2
			
			
			outputWriter.println(" ");
			outputWriter.println(letter);
			outputWriter.println("==");
			
			
			do
			{
				letter = inputWords.get(i).charAt(0); //first letter of word 1
				letter2 = inputWords.get(i+1).charAt(0); //first letter of word 2
		
				outputWriter.println(inputWords.get(i));
				i++;
				outputWriter.flush();
				
			}while(letter == letter2);
			
		}
		outputWriter.close();
		number++;
		
	}
	
}
