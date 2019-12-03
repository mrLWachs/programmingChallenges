
package challenge.week4;

import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week4Level3 extends Problem
{

    public static void main(String[] args) {
        new Week4Level3().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
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
        System.out.println("CASE: " + value);
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

}
