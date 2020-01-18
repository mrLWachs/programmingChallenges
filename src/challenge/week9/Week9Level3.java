
package challenge.week9;

import java.util.Scanner;
import mainpackage.Problem;


public class Week9Level3 extends Problem
{

    public static void main(String[] args) {
        new Week9Level3().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int antoniaTotal = 100;
        int davidTotal   = 100;
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            line = input.nextLine();
            String[] values = line.split("[ ]");
            int antoniaRoll = Integer.parseInt(values[0]);
            int davidRoll   = Integer.parseInt(values[1]);
            if      (antoniaRoll < davidRoll) antoniaTotal -= davidRoll;
            else if (davidRoll < antoniaRoll) davidTotal   -= antoniaRoll;
        }
        System.out.println(antoniaTotal);
        System.out.println(davidTotal);        
    }

}