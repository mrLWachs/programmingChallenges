
package challenge.week2;

import java.util.Scanner;


public class Week2Level1 
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);     
        final String WIN  = "W";
        int winCount  = 0;
        int result    = -1;
        for (int i = 0; i < 6; i++) {
            String line = input.nextLine();
            if (line.equalsIgnoreCase(WIN)) winCount++;
        }
        if      (winCount >= 5) result = 1;
        else if (winCount >= 3) result = 2;
        else if (winCount >= 1) result = 3;
        System.out.println(result);
    }

}
