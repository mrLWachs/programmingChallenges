
package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level2 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level2().start();
    }

    public void start()  {
        Scanner input = new Scanner(System.in);                                 // Instantiate scanner object
        System.out.println("Enter lower limit of range");                       // Output user instructions
        String lowerInput = input.nextLine();                                   // Read in the next full line of input
        System.out.println("Enter upper limit of range");                       // Output user instructions
        String upperInput = input.nextLine();                                   // Read in the next full line of input
        int lower    = Integer.parseInt(lowerInput);                            // Convert line to lower integer value
        int upper    = Integer.parseInt(upperInput);                            // Convert line to upper integer value
        int rsaCount = 0;                                                       // Track RSA count
        final int MAX_DIVISORS = 4;                                             // The number of divisors
        for (int number = lower; number <= upper; number++) {                   // Loop from lower value to upper value
            int divisorCount = 0;                                               // Track how many divisors
            for (int divisor = 1; divisor <= number; divisor++) {               // Move the divisor from 1 up to the number
                if (number % divisor == 0) divisorCount++;                      // See if it is divisible and then count it
            }
            if (divisorCount == MAX_DIVISORS) rsaCount++;                       // See if the divisors matches the max, if so, count it
        }
        System.out.println("The number of RAS numbers between " +
                lower + " and " + upper + " is " + rsaCount);                   // Display the count to the user
    }

}
