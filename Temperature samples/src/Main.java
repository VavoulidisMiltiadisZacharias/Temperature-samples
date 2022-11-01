
/* SCENARIO:
 * 
 * Write a program that prints the temperature closest to 0 among input data.
 * If two numbers are equally close to zero, positive integer has to be considered closest to zero 
 * (for instance, if the temperatures are -5 and 5, then display 5).
 */


import java.util.*;
import java.io.*;
import java.math.*;


class Main 
{
	
	
	
	public static void printArrayList(ArrayList<Integer> arrayList)
	{
		for(int i = 0 ; i < arrayList.size(); i++)
		{
			System.out.println(arrayList.get(i));
		}
	}
	
//MAIN
    public static void main(String args[]) 
    {
    	//Local variables
    	int size; // How many samples are there
    	int temperature; // A sample - integer value
    	int numberOfNegativeTemperatures;
    	int numberOfPositiveTemperatures;
    	String clear;
    	
    	//Temperature temperature = new Temperature();  
    	ArrayList<Integer> allSamples = new ArrayList<Integer>();
        ArrayList<Integer> negativeSamples = new ArrayList<Integer>();
        ArrayList<Integer> positiveSamples = new ArrayList<Integer>();
        
        //Variables initialization
        size = 0;
        temperature = 0;
        numberOfNegativeTemperatures = 0;
        numberOfPositiveTemperatures = 0;
        
        System.out.print("Give amount of samples : ");
        
        Scanner input = new Scanner(System.in);
        size = input.nextInt(); //The number of temperatures to analyze as user input
        clear = input.nextLine(); //clear '/n' escape sequence character
        
        
        //Add all samples in allSamples ArrayList
        for (int i = 0; i < size; i++) 
        {
        	System.out.print("Give " + i + " temperature: ");
        	
            temperature = input.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            //clear = input.nextLine();
            allSamples.add(temperature); //add i-th sample of temperature in allSamples ArrayList
        }
        
        //print the whole sample 
        System.out.println();
        System.out.println("The samples are:");
        printArrayList(allSamples);
       
        
        //Sort the ArrayList (ascending order)
        Collections.sort(allSamples);
        
        //print all the whole sample sorted 
        System.out.println();
        System.out.println("The sorted samples are:");
        printArrayList(allSamples);
        
        
        //Count how many samples are negative
        for(int i = 0 ; i < size; i++)
        {
        	if(allSamples.get(i) < 0)
        	{
        		numberOfNegativeTemperatures++; //Increase by one
        	}
        	else
        		break;
        }
        
        //Fill the negativeSamples and positiveSamples ArrayLists
        for(int i = 0; i < numberOfNegativeTemperatures; i++) //First the negative
        {
        	negativeSamples.add(allSamples.get(i));
        }
        
        for(int i = numberOfNegativeTemperatures; i < size; i++) //Then the positive
        {
        	positiveSamples.add(allSamples.get(i));
        }
        
        //Print negative sample 
        System.out.println();
        System.out.println("The negative temperatures are:");
        printArrayList(negativeSamples);
        
        
        
        //Print positive sample 
        System.out.println();
        System.out.println("The positive temperatures are:");
        printArrayList(positiveSamples);
       
        
        System.out.println();
        //Check which value to print
        
        if(negativeSamples.size() > 0 && positiveSamples.size() == 0) //Only negative temps exist
        	System.out.println("Closest to zero is: " +negativeSamples.get(negativeSamples.size()-1));
        else if(positiveSamples.size() > 0 && negativeSamples.size() == 0) //Only positive temps exist
        	System.out.println("Closest to zero is: " +positiveSamples.get(0));
        else //Both negative and positive temps exist
        {
        	if( Math.abs(positiveSamples.get(0)) < Math.abs(negativeSamples.get(negativeSamples.size()-1)))
            	System.out.println("Closest to zero is: " +positiveSamples.get(0));
            else if(Math.abs(positiveSamples.get(0)) > Math.abs(negativeSamples.get(negativeSamples.size()-1)))
            	System.out.println("Closest to zero is: " +negativeSamples.get(negativeSamples.size()-1));
            else
            	System.out.println("Closest to zero are both: " +negativeSamples.get(negativeSamples.size()-1) +" and " +positiveSamples.get(0));
        }
        
        System.out.println("------------------END----------------");
    }
}