
package challenge.week9;

import java.util.Scanner;
import mainpackage.Problem;


public class Week9Level2 extends Problem
{

    public static void main(String[] args) {
        new Week9Level2().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int i = 0;
        while (!line.equals("0 0 0")) {
            String[] values = line.split("[ ]");
            int x = Integer.parseInt(values[0]);
            int y = Integer.parseInt(values[1]);
            int z = Integer.parseInt(values[2]);
            i++;
            check(x,y,z,i);
            line = input.nextLine();
        }
    }

    private void check(int x, int y, int z, int count) {        
        int answer = x*y*z;
        String text = "CASE " + count + ": " + answer;
        int times = occurances("" + x,"" + answer);
        if (times == y) text += " yes";
        else            text += " no";
        io.System.out.println(text);
    }

    private int occurances(String number, String sequence) {
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            String digit = sequence.charAt(i) + "";
            if (number.equals(digit)) count++;
        }
        return count;
    }

}