
package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;

public class Week2Level2 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level2().start();
    }

    public void start()  {
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        System.out.println("Enter lower limit of range");
        String lowerInput = input.nextLine();
        System.out.println("Enter upper limit of range");
        String upperInput = input.nextLine();
        int lower    = Integer.parseInt(lowerInput);
        int upper    = Integer.parseInt(upperInput);
        int rsaCount = 0;
        final int MAX_DIVISORS = 4;        
        for (int number = lower; number <= upper; number++) {
            int divisorCount = 0;
            for (int divisor = 1; divisor <= number; divisor++) {
                if (number % divisor == 0) divisorCount++;
            }
            if (divisorCount == MAX_DIVISORS) rsaCount++;
        }
        System.out.println("The number of RAS numbers between " +
                lower + " and " + upper + " is " + rsaCount);
    }

}
