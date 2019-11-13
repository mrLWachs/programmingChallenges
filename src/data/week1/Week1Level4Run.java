
package data.week1;

import io.System;
import mainpackage.Problem;

public class Week1Level4Run  extends Problem
{

    public void start() {   
        System.out.header("Week 1, Level 4: starting"); 
        String[] lines = { 
            "2",
            "1 2 3 5",
            "5 1 3 2 4" 
        };    
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");    
        String line = lines[0];
        int totalCases = Integer.parseInt(line);
        String[] outputs = new String[totalCases];
        for (int testCase = 1; testCase <= totalCases; testCase++) {
            line = lines[testCase];
            int[] numbers  = getNumbers(line);            
            int highestKid = findHighest(numbers);
            int missing    = findMissing(numbers,highestKid);
            if (missing == -1) outputs[testCase-1] = "No one is missing";
            else               outputs[testCase-1] = "Student " + missing + 
                                                     " is missing!";
        }
        for (int i = 0; i < outputs.length; i++) {
            System.out.println(outputs[i]);
        }        
        System.out.header("Week 1, Level 4: complete");
        System.flush();
    }
    
    private static int[] getNumbers(String line) {
        String[] values = line.split("[ ]");
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static int findHighest(int[] numbers) {
        int highest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > highest) {
                highest = numbers[i];
            }
        }
        return highest;
    }

    private static int findMissing(int[] numbers, int highestKid) {
        int currentKid = highestKid;        
        for (int i = 0; i < numbers.length; i++) {
            boolean found = false;
            for (int j = 0; j < numbers.length; j++) {
                if (currentKid == numbers[j]) {
                    found = true;
                }
            }
            if (!found) return currentKid;
            currentKid--;
        }
        return -1;
    }

    
}
