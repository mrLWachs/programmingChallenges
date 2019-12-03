
package data.week4;

import io.System;
import java.util.ArrayList;
import mainpackage.Problem;


public class Week4Level3Run extends Problem
{
    
    public void start() {   
        System.out.header("Week 4, Level 3: starting");          
        String[] lines = { 
           "4 2 3 1 4",
           "1 3 1 5 5 7 0 -1 1"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            io.System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int testCase = 0; testCase < lines.length; testCase++) {      
            String line = lines[testCase];
                
            String[] values = line.split("[ ]");
            int[] numbers = toInts(values);
            ArrayList<Integer> digits = new ArrayList<>();
            ArrayList<Integer> counts = new ArrayList<>();        
            for (int i = 0; i < numbers.length; i++) {            
                int index = digits.indexOf(numbers[i]);
                if (index != -1) {
                    int count = counts.get(index);
                    count++;
                    counts.set(index, count);
                }
                else {
                    digits.add(numbers[i]);
                    counts.add(1);
                }            
            }
            int largest = counts.get(0);
            int value   = digits.get(0);
            for (int i = 1; i < counts.size(); i++) {
                int count = counts.get(i);
                if (count > largest) {
                    largest = count;
                    value   = digits.get(i);
                }
            }
            outputs.add("CASE " + (testCase+1) + ": " + value);
            
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week 4, Level 3: complete");
        System.flush();
    }
    
    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
    
}
