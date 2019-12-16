
package data.week5;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;

public class Week5Level3Run  extends AutoRun
{

    public void auto(int week, int level) {
        start(week, level);
        System.autoFlush();
    }
    
    public void run(int week, int level) {
        start(week, level);
        System.flush();
    }

    private void start(int week, int level) {  
        System.out.header("Week " + week + ", Level " + level + ": starting");          
        String[] lines = { 
           "1 A 3",
           "1 B 4",
           "2 B",
           "2 A",
           "3 A B",
           "2 A",
           "5 A A",
           "2 A",
           "2 B",
           "7"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int testCase = 0; testCase < lines.length; testCase++) {      
            String line = lines[testCase];
            while (!line.equals("7")) {
                String[] instruction = line.split("[ ]");
                execute(instruction,outputs);
                testCase++;
                line = lines[testCase];
            }
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
    
    int a = 0;
    int b = 0;

    private void execute(String[] instruction, ArrayList<String> outputs) {        
        if (instruction.length == 2) {
            if      (instruction[1].equals("A")) outputs.add("" + a);
            else if (instruction[1].equals("B")) outputs.add("" + b);
        }
        else if (instruction.length == 3) {
            if (instruction[0].equals("1")) {
                int value = Integer.parseInt(instruction[2]);
                if      (instruction[1].equals("A")) a = value;
                else if (instruction[1].equals("B")) b = value;
            }
            else if (instruction[0].equals("3")) {
                if (instruction[1].equals("A")) {
                    if      (instruction[2].equals("A")) a = a + a;
                    else if (instruction[2].equals("B")) a = a + b;
                }
                else if (instruction[1].equals("B")) {
                    if      (instruction[2].equals("A")) b = b + a;
                    else if (instruction[2].equals("B")) b = b + b;
                }
            }
            else if (instruction[0].equals("4")) {
                if (instruction[1].equals("A")) {
                    if      (instruction[2].equals("A")) a = a + a;
                    else if (instruction[2].equals("B")) a = a + b;
                }
                else if (instruction[1].equals("B")) {
                    if      (instruction[2].equals("A")) b = b * a;
                    else if (instruction[2].equals("B")) b = b * b;
                }
            }
            else if (instruction[0].equals("5")) {
                if (instruction[1].equals("A")) {
                    if      (instruction[2].equals("A")) a = a - a;
                    else if (instruction[2].equals("B")) a = a - b;
                }
                else if (instruction[1].equals("B")) {
                    if      (instruction[2].equals("A")) b = b - a;
                    else if (instruction[2].equals("B")) b = b - b;
                }
            }
            else if (instruction[0].equals("6")) {
                if (instruction[1].equals("A")) {
                    if      (instruction[2].equals("A")) a = a / a;
                    else if (instruction[2].equals("B")) a = a / b;
                }
                else if (instruction[1].equals("B")) {
                    if      (instruction[2].equals("A")) b = b / a;
                    else if (instruction[2].equals("B")) b = b / b;
                }
            }
        }
    }
    
}
