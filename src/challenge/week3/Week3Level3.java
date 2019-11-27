
package challenge.week3;

import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week3Level3 extends Problem
{

    public static void main(String[] args) {
        new Week3Level3().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int totalCases = Integer.parseInt(line);
        String[] outputs = new String[totalCases];
        for (int testCase = 0; testCase < totalCases; testCase++) {
            line = input.nextLine();
            ArrayList<Character> occurances = new ArrayList<>();
            ArrayList<Integer>   counts     = new ArrayList<>();            
            char[] symbols = line.toCharArray();
            for (int i = 0; i < symbols.length; i++) {
                Character character = new Character(symbols[i]);
                Integer   count     = 1;
                if (!occurances.contains(character)) {
                    occurances.add(character);
                    counts.add(count);
                }
                else {
                    int location = occurances.indexOf(character);
                    count = (Integer)counts.get(location);
                    count++;
                    counts.set(location, count);
                }
            }
            String output = "";
            for (int i = 0; i < occurances.size(); i++) {
                Character character = occurances.get(i);
                Integer   count     = counts.get(i);
                output += count.toString() + " " + character.toString() + " ";
            }
            outputs[testCase] = output;
        }
        for (int i = 0; i < totalCases; i++) {
            System.out.println(outputs[i]);
        }
    }

}
