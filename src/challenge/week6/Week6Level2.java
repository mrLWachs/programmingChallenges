
package challenge.week6;


import java.util.Scanner;
import mainpackage.Problem;


public class Week6Level2 extends Problem
{

    public static void main(String[] args) {
        new Week6Level2().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int n = Integer.parseInt(line);
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
            String[] values = line.split("[ ]");
            int a = Integer.parseInt(values[0]);
            int b = Integer.parseInt(values[1]);
            long answer = knuthsUpArrow(a,b);
            System.out.println(answer);
        }
    }

    private long knuthsUpArrow(int a, int b) {
        if (b == 1) return (long)a;
        else return (long)Math.pow(a,knuthsUpArrow(a,b-1));
    }
    
}
