
package challenge.week9;

import java.util.Scanner;
import mainpackage.Problem;


public class Week9Level1 extends Problem
{

    public static void main(String[] args) {
        new Week9Level1().start();
    }
    
    public void start() {        
        Scanner input = new Scanner(System.in);                                 // instantiate scanner object
        int month = Integer.parseInt(input.nextLine());
        int day   = Integer.parseInt(input.nextLine());
        check(month,day);    
    }

    private void check(int month, int day) {
        final int FEBRUARY = 2;
        final int DAY      = 18;
        if      (month == FEBRUARY && day == DAY) System.out.println("Special");
        else if (month == FEBRUARY && day <  DAY) System.out.println("Before");
        else if (month < FEBRUARY)                System.out.println("Before");
        else if (month == FEBRUARY && day >  DAY) System.out.println("After");
        else if (month >  FEBRUARY)               System.out.println("After"); 
    }

}