import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab04 {

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length == 0)
		{
			throw new FileNotFoundException();
		}

		// Read file from command line and create scanner to read file
		File f = new File(args[0]);
		Scanner in = new Scanner(f);
		try 
		{
			// loops while file has another line that isnt empty
			while(in.hasNextLine() && !(in.nextLine().isEmpty()))
			{
				String currentLine = in.next().trim();	// Current set of numbers being read

				String[] strNums = currentLine.split(",");	// assigns each string value of a number in an array
				try
				{
					Integer[] numsI = toIntegerArr(strNums);		// converts those values to Integer type and stores in new array


					Integer[] numsF = sortArr(numsI);	// sorts Integer array in descending order and copies to new array

					printArr(numsF);
				}

				catch (NumberFormatException e)
				{
					// skip line
				}
			}
		}
		catch(NoSuchElementException e)
		{
			// exit program
		}

	}

	public static Integer[] toIntegerArr(String[] strArr) 

	{
		Integer[] arrI = new Integer[5];


		for (int i=0; i<strArr.length; i++)
		{
			int p = Integer.parseInt(strArr[i]);

			arrI[i] = p;
		}

		return arrI;
	}

	public static Integer[] sortArr(Integer[] arr0)
	{
		Integer[] arrF = new Integer[arr0.length];
		Arrays.sort(arr0, Collections.reverseOrder());

		for (int i=0; i<arr0.length; i++)
		{	
			arrF[i] = arr0[i];
		}
		return arrF;
	}

	public static void printArr(Integer[] arr0)
	{
		System.out.print("{ ");
		for(int i = 0; i < arr0.length; i++)
		{
			System.out.print(arr0[i] + " ");
		}
		System.out.println("}");
	}
}
