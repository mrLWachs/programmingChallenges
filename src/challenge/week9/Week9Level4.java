
package challenge.week9;

import java.util.Scanner;
import mainpackage.Problem;


public class Week9Level4 extends Problem
{

    public static void main(String[] args) {
        new Week9Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int i = 0;
        while (!line.equals("0")) {
            int n = Integer.parseInt(line);
            makeRuler(n,i);
            i++;
            line = input.nextLine();
        }
    }

    private void makeRuler(int n, int count) {
        
    }

}