
package challenge.week5;


import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week5Level3 extends Problem
{

    int a = 0;
    int b = 0;
    
    public static void main(String[] args) {
        new Week5Level3().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        ArrayList<String> outputs = new ArrayList<>();
        while (!line.equals("7")) {
            String[] instruction = line.split("[ ]");
            execute(instruction,outputs);
            line = input.nextLine();
        }
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }
    }

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
