
package data.week2;

import io.System;
import mainpackage.Problem;

public class Week2Level1Run  extends Problem
{

    public void start() {
        System.out.header("Week 2, Level 1: starting");
        String[][] data = {
            {"W","L","W","W","L","W"},  
            {"L","L","L","L","L","L"}
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.println(data[i][j]);
            }
        }
        System.out.println("\nOutputs:\n");
        final String WIN  = "W";
        for (int testCase = 0; testCase < data.length; testCase++) {
            int winCount = 0;
            int result   = -1;
            for (int i = 0; i < 6; i++) {
                String line = data[testCase][i];
                if (line.equalsIgnoreCase(WIN)) winCount++;
            }
            if      (winCount >= 5) result = 1;
            else if (winCount >= 3) result = 2;
            else if (winCount >= 1) result = 3;
            System.out.println(result);
        }
        System.out.header("Week 2, Level 1: complete");
        System.flush();
    }

}
