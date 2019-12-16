
package data.week5;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;

public class Week5Level2Run  extends AutoRun
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
           "12",
           "15",
           "-20",
           "8",
           "-3",
           "12",
           "-14",
           "2",
           "-1",
           "7",
           "-12",
           "6",
           "-4"           
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int testCase = 0; testCase < lines.length; testCase++) {      
            String line = lines[testCase];            
            int n = Integer.parseInt(line);
            int[] weights = new int[n];
            for (int i = 0; i < n; i++) {
                testCase++;
                line = lines[testCase];
                weights[i] = Integer.parseInt(line);
            }
            int player1 = 0;
            int player2 = 0;
            int turn    = 1;
            int scale   = 0;
            for (int i = 0; i < weights.length; i++) {
                if (turn == 1) {
                    turn = 2;
                    scale = scale + weights[i];
                    if (scale == 0) player1++;
                }
                else if (turn == 2) {
                    turn = 1;
                    scale = scale + weights[i];
                    if (scale == 0) player2++;
                }
            }
            outputs.add("Player 1 scored " + player1);
            outputs.add("Player 2 scored " + player2);
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

}
