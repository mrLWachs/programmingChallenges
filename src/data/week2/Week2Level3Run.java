
package data.week2;

import io.System;
import mainpackage.AutoRun;

public class Week2Level3Run  extends AutoRun
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
        String[] data = {
            "2",
            "10",
            "3 2 2 1 4 7 1 2 0 1",
            "5",
            "1 1 1 1 1"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
        System.out.println("\nOutputs:\n");
        int index = 0;
        String line = data[0];
        int totalTests = Integer.parseInt(line);
        String[] outputs = new String[totalTests];
        for (int test = 0; test < totalTests; test++) {
            index++;
            line = data[index];
            int size = Integer.parseInt(line);
            index++;
            line = data[index];
            String[] values = line.split("[ ]");
            int[]    board  = new int[size];
            for (int i = 0; i < board.length; i++) {
                board[i] = Integer.parseInt(values[i]);
            }
            final String WIN  = "Active player wins.";
            final String LOSE = "Active player loses.";
            if (check(board)) outputs[test] = WIN;
            else              outputs[test] = LOSE;
        }
        for (int i = 0; i < outputs.length; i++) {
            System.out.println(outputs[i]);
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
    private static boolean check(int[] board) {
        int       player  = 0;
        int       end     = board.length - 1;
        boolean[] visited = new boolean[board.length];        
        while(player < end && visited[player] != true) {
            int moves = board[player];
            visited[player] = true;
            if (moves % 2 == 0) player -= moves;
            else                player += moves;
            if (player >= end) return true;
        }
        return false;
    }

}
