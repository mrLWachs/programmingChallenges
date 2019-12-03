
package challenge.week5;


import java.util.Scanner;
import mainpackage.Problem;


public class Week5Level2 extends Problem
{

    public static void main(String[] args) {
        new Week5Level2().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int n = Integer.parseInt(line);
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            line = input.nextLine();
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
        System.out.println("Player 1 scored " + player1);
        System.out.println("Player 2 scored " + player2);
    }

}
