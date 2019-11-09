
package challenge.week1;

import java.util.Scanner;

public class Level4Thursday 
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);     
        String line = input.nextLine();
        int totalCases = Integer.parseInt(line);
        String[] outputs = new String[totalCases];
        for (int testCase = 1; testCase <= totalCases; testCase++) {
            line = input.nextLine();
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
