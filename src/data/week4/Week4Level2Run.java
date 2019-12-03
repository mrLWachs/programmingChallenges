
package data.week4;

import io.System;
import java.util.ArrayList;
import mainpackage.Problem;


public class Week4Level2Run extends Problem
{
    
    public void start() {   
        System.out.header("Week 4, Level 2: starting");          
        String[] lines = { 
           "2004",
           "2100"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            io.System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {      
            String line1 = lines[i];
            i++;
            String line2 = lines[i];
                    
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

            outputs.add("All positions Change in year " + currentYear);

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
                    outputs.add("All positions Change in year " + year);
                }

            }
            
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week 4, Level 2: complete");
        System.flush();
    }
    
}
