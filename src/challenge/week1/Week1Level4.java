
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;


public class Week1Level4 extends Problem
{
    
    public static void main(String[] args) {
        new Week1Level4().start();
    }

    public void start() {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        String line = input.nextLine();                                         // Read in the next full line of input
        int totalCases = Integer.parseInt(line);                                // Convert to integer
        String[] outputs = new String[totalCases];                              // Create array for output lines
        for (int testCase = 1; testCase <= totalCases; testCase++) {            // Loop through all test cases
            line = input.nextLine();                                            // Read in the next full line of input
            int[] numbers  = getNumbers(line);                                  // Get all the numbers from this line as integers
            int highestKid = findHighest(numbers);                              // Find the highest in the list of numbers
            int missing    = findMissing(numbers,highestKid);                   // Find which number is missing from the list
            if (missing == -1) outputs[testCase-1] = "No one is missing";       // The flag value (-1) means no one is missing
            else               outputs[testCase-1] = "Student " + missing +     
                                                     " is missing!";            // Add to outputs who is missing
        }
        for (int i = 0; i < outputs.length; i++) {                              // Traverse all outputs
            System.out.println(outputs[i]);                                     // Output to the screen
        }
    }

    private static int[] getNumbers(String line) {
        String[] values = line.split("[ ]");                                    // Split the line into a string array
        int[] numbers = new int[values.length];                                 // Create an int array the same size
        for (int i = 0; i < numbers.length; i++) {                              // Traverse array
            numbers[i] = Integer.parseInt(values[i]);                           // Parse all indices into integers
        }
        return numbers;                                                         // Return array of integers
    }

    private static int findHighest(int[] numbers) {
        int highest = numbers[0];                                               // Assume highest is first location
        for (int i = 1; i < numbers.length; i++) {                              // Traverse array from second spot up
            if (numbers[i] > highest) {                                         // Found new highest value
                highest = numbers[i];                                           // Track this new high value
            }
        }
        return highest;                                                         // Return highest value
    }

    private static int findMissing(int[] numbers, int highestKid) {
        int currentKid = highestKid;                                            // Assume current student is the highest
        for (int i = 0; i < numbers.length; i++) {                              // Traverse array
            boolean found = false;                                              // Assume not found
            for (int j = 0; j < numbers.length; j++) {                          // Traverse array again
                if (currentKid == numbers[j]) {                                 // Current student matches this student
                    found = true;                                               // Student found
                }
            }
            if (!found) return currentKid;                                      // Never found this student, return them
            currentKid--;                                                       // Move down student from the highest and start again
        }
        return -1;                                                              // No missing student found, return flag
    }

}
