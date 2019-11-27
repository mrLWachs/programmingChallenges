
package data.week3;

import io.System;
import java.util.ArrayList;
import mainpackage.Problem;

public class Week3Level3Run  extends Problem
{

    public void start() {   
        System.out.header("Week 3, Level 3: starting");          
        String[] lines = { 
           "4",         
           "+++===!!!!",
           "777777......TTTTTTTTTTTT",
           "(AABBC)",
           "3.1415555"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");        
        for (int currentLine = 0; currentLine < lines.length; currentLine++) {      
            
            String line = lines[currentLine];
            int totalCases = Integer.parseInt(line);
            String[] outputs = new String[totalCases];
            for (int testCase = 0; testCase < totalCases; testCase++) {
                currentLine++;
                line = lines[currentLine];
                
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
        System.out.header("Week 3, Level 3: complete");
        System.flush();
    }

}
