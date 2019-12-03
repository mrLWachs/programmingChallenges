
package challenge.week4;

import java.util.Scanner;
import mainpackage.Problem;


public class Week4Level1 extends Problem
{

    public static void main(String[] args) {
        new Week4Level1().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int p = Integer.parseInt(line);
        line = input.nextLine();
        int n = Integer.parseInt(line);
        line = input.nextLine();
        double r = Double.parseDouble(line);        
        double payment = p * r * Math.pow((1 + r),n) / (Math.pow((1 + r),n) - 1);
        System.out.println("The monthy payment is $" + payment);        
    }

}
