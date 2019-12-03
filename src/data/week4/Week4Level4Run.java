
package data.week4;

import io.System;
import java.util.ArrayList;
import java.util.Stack;
import mainpackage.Problem;


public class Week4Level4Run extends Problem
{
    
    public void start() {   
        System.out.header("Week 4, Level 4: starting");          
        String[] lines = { 
           "1",
           "+ 1 2",
           "- 2 2",
           "+ 2 - 2 1",
           "- - 3 + 2 1 9",
           "0"           
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            io.System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int testCase = 0; testCase < lines.length; testCase++) {      
            String line = lines[testCase];
                
            while (!line.equals("0")) {
                String[] prefix = line.split("[ ]");
                Stack<String> stack = new Stack<>();
                ArrayList<String> postfix = new ArrayList<>();
                for (int i = prefix.length - 1; i >= 0; i--) {                
                    String symbol = prefix[i];
                    if (symbol.equals("+") ||
                        symbol.equals("-")) {
                        String op1 = stack.pop();
                        String op2 = stack.pop();
                        String expression = op1 + " " + op2 + " " + symbol + " ";
                        stack.push(expression);                   
                    }
                    else {
                        stack.push(symbol + " ");
                    }
                }
                String output = "";            
                for (int i = 0; i < stack.size(); i++) {
                    String symbol = stack.get(i);
                    output += symbol;
                }
                outputs.add(output);
                
                testCase++;
                line = lines[testCase];
            }
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week 4, Level 4: complete");
        System.flush();
    }
    
}
