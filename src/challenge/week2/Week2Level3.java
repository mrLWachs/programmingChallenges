
package challenge.week2;

import java.util.Scanner;
import mainpackage.Problem;


public class Week2Level3 extends Problem
{
    
    public static void main(String[] args) {
        new Week2Level3().start();
    }
    
    public void start()  {
        Scanner input = new Scanner(System.in);  
        String line = input.nextLine();
        int totalTests = Integer.parseInt(line);
        String[] outputs = new String[totalTests];
        for (int test = 0; test < totalTests; test++) {
            line = input.nextLine();
            int size = Integer.parseInt(line);
            line = input.nextLine();
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
