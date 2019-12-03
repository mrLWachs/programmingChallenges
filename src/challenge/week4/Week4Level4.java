
package challenge.week4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import mainpackage.Problem;


public class Week4Level4 extends Problem
{

    public static void main(String[] args) {
        new Week4Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
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
            System.out.println(output);
            line = input.nextLine();
        }
    }

}
