
package challenge.week3;

import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week3Level1 extends Problem
{

    public static void main(String[] args) {
        new Week3Level1().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        ArrayList<String> outputs = new ArrayList<>();
        int index = 0;
        while (!line.equals("0")) {
            String message = "";
            int i = 0;
            boolean done = false;
            while (i < line.length() && !done) {
                char value = line.charAt(i);
                if (Character.isDigit(value)) {
                    if (value == '0') {
                        outputs.add("Case #" + index + ": " + message);
                        index++;
                        done = true;
                    }
                    else {
                        i += Integer.parseInt("" + value);
                    }
                }
                if (!done) {
                    char character = line.charAt(i);
                    if (character == '_') character = ' ';
                    message += character;
                    i++;
                }
            }
            line = input.nextLine();
        }
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }
    }

}
