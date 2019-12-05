
package challenge.week1;

import java.util.Scanner;
import mainpackage.Problem;

public class Week1Level4 extends Problem
{
    
    public static void main(String[] args) {
        new Week1Level4().start();
    }

    public void start() {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        String line = input.nextLine();                                         // read in the next full line of input
        int totalCases = Integer.parseInt(line);                                // convert to integer
        String[] outputs = new String[totalCases];                              // create array for output lines
        for (int testCase = 1; testCase <= totalCases; testCase++) {            // loop through all test cases
            line = input.nextLine();                                            // read in the next full line of input
            int[] numbers  = getNumbers(line);                                  // get all the numbers from this line as integers
            int highestKid = findHighest(numbers);                              // find the highest in the list of numbers
            int missing    = findMissing(numbers,highestKid);                   // find which number is missing from the list
            if (missing == -1) outputs[testCase-1] = "No one is missing";       // the flag value (-1) means no one is missing
            else               outputs[testCase-1] = "Student " + missing +     
                                                     " is missing!";            // add to outputs who is missing
        }
        for (int i = 0; i < outputs.length; i++) {                              // traverse all outputs
            System.out.println(outputs[i]);                                     // output to the screen
        }
    }

    private static int[] getNumbers(String line) {
        String[] values = line.split("[ ]");                                    // split the line into a string array
        int[] numbers = new int[values.length];                                 // create an int array the same size
        for (int i = 0; i < numbers.length; i++) {                              // traverse array
            numbers[i] = Integer.parseInt(values[i]);                           // parse all indices into integers
        }
        return numbers;                                                         // return array of integers
    }

    private static int findHighest(int[] numbers) {
        int highest = numbers[0];                                               // assume highest is first location
        for (int i = 1; i < numbers.length; i++) {                              // traverse array from second spot up
            if (numbers[i] > highest) {                                         // found new highest value
                highest = numbers[i];                                           // track this new high value
            }
        }
        return highest;                                                         // return highest value
    }

    private static int findMissing(int[] numbers, int highestKid) {
        int currentKid = highestKid;                                            // assume current student is the highest
        for (int i = 0; i < numbers.length; i++) {                              // traverse array
            boolean found = false;                                              // assume not found
            for (int j = 0; j < numbers.length; j++) {                          // traverse array again
                if (currentKid == numbers[j]) {                                 // current student matches this student
                    found = true;                                               // student found
                }
            }
            if (!found) return currentKid;                                      // never found this student, return them
            currentKid--;                                                       // move down student from the highest and start again
        }
        return -1;                                                              // no missing student found, return flag
    }

}
