
package challenge.week10;

import java.util.Scanner;
import mainpackage.Problem;


public class Week10Level2 extends Problem
{

    public static void main(String[] args) {
        new Week10Level2().start();
    }
    
    public void start() {        
        Scanner input = new Scanner(System.in);  
        String line = input.nextLine();
        int dataSets = Integer.parseInt(line);
        for (int dataSet = 0; dataSet < dataSets; dataSet++) {
            line = input.nextLine();
            int number = Integer.parseInt(line);
            checkForNasty(number);
        } 
    }

    private void checkForNasty(int number) {
        
    }

}