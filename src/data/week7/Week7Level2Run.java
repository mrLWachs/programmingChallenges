
package data.week7;

import io.System;
import mainpackage.AutoRun;


public class Week7Level2Run  extends AutoRun
{

    public void auto(int week, int level) {
        start(week, level);
        System.autoFlush();
    }
    
    public void run(int week, int level) {
        start(week, level);
        System.flush();
    }

    private void start(int week, int level) {   
        System.out.header("Week " + week + ", Level " + level + ": starting");           
        String[] lines = { 
           "TrT135a6",
           "abct1abco",
           "arTsandCrafts",
           "oTTer"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (isValid(line)) System.out.println("Password 'good'");
            else               System.out.println("Password 'bad'");
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
    private boolean isValid(String password) {
        int countOfTs = 0;
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (character == 'T') {
                countOfTs++;
                if (countOfTs >= 2) return true;
            }
        }
        boolean foundT = false;
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (character == 't') foundT = true;
            if (foundT && character == 'o') return true;
        }
        return false;
    }

}
