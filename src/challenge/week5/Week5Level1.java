
package challenge.week5;


import java.util.Scanner;
import mainpackage.Problem;


public class Week5Level1 extends Problem
{

    public static void main(String[] args) {
        new Week5Level1().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int n = Integer.parseInt(line);
        if (n == 1) {
            // 1   and 0
            System.out.println(1);
        }
        else if (n == 2) {
            // 2 and 0
            // 1 and 1
            System.out.println(2);
        }
        else if (n == 3) {
            // 3 and 0
            // 2 and 1
            System.out.println(2);
        }
        else if (n == 4) {
            // 4 and 0
            // 3 and 1
            // 2 and 2
            System.out.println(3);
        }
        else if (n == 5) {
            // 5 and 0
            // 4 and 1
            // 3 and 2
            System.out.println(3);
        }
        else if (n == 6) {
            // 6 and 0
            // 5 and 1
            // 4 and 2
            // 3 and 3
            System.out.println(4);
        }
        else if (n == 7) {
            // 7 and 0
            // 6 and 1
            // 5 and 2
            // 4 and 3
            System.out.println(4);
        }
        else if (n == 8) {
            // 8 and 0
            // 7 and 1
            // 6 and 2
            // 5 and 3
            // 4 and 4
            System.out.println(5);
        }
        else if (n == 9) {
            // 9 and 0
            // 8 and 1
            // 7 and 2
            // 6 and 3
            // 5 and 4
            System.out.println(5);
        }
        else if (n == 10) {
            // 10 and 0
            // 9 and 1
            // 8 and 2
            // 7 and 3
            // 6 and 4
            // 5 and 5
            System.out.println(6);
        }        
    }

}
