
package challenge.week4;

import java.util.Scanner;
import mainpackage.Problem;


public class Week4Level2 extends Problem
{

    public static void main(String[] args) {
        new Week4Level2().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line1 = input.nextLine();
        String line2 = input.nextLine();
        int currentYear = Integer.parseInt(line1);
        int futureYear  = Integer.parseInt(line2);
        
        int mayorCount      = 0;
        int treasurerCount  = 0;
        int programmerCount = 0;
        int dogCatcherCount = 0;
        
        int mayorChangeYear      = currentYear;
        int treasurerChangeYear  = currentYear;
        int programmerChangeYear = currentYear;
        int dogCatcherChangeYear = currentYear;

        System.out.println("All positions Change in year " + currentYear);
        
        for (int year = currentYear+1; year <= futureYear; year++) {
            
            boolean mayorChange      = false;
            boolean treasurerChange  = false;
            boolean programmerChange = false;
            boolean dogCatcherChange = false;
                        
            mayorCount++;
            treasurerCount++;
            programmerCount++;
            dogCatcherCount++;
            
            if (mayorCount == 4) {
                mayorCount = 0;
                mayorChange = true;
            }
            if (treasurerCount == 2) {
                treasurerCount = 0;
                treasurerChange = true;
            }
            if (programmerCount == 3) {
                programmerCount = 0;
                programmerChange = true;
            }
            if (dogCatcherCount == 5) {
                dogCatcherCount = 0;
                dogCatcherChange = true;
            }
            
            if (mayorChange &&
                treasurerChange &&
                programmerChange &&
                dogCatcherChange) {
                System.out.println("All positions Change in year " + year);
            }
                        
        }
        
        
    }

}
