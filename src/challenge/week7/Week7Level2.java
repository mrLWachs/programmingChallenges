
package challenge.week7;

import java.util.Scanner;
import mainpackage.Problem;


public class Week7Level2 extends Problem
{

    public static void main(String[] args) {
        new Week7Level2().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in);        
        String line = input.nextLine();
        if (isValid(line)) System.out.println("Password 'good'");
        else               System.out.println("Password 'bad'");
    }
    
    private boolean isValid(String password) {
        int countOfTs = 0;
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (character == 'T') {
                countOfTs++;
                if (countOfTs >= 2) return true;
            }
        }
        boolean foundT = false;
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (character == 't') foundT = true;
            if (foundT && character == 'o') return true;
        }
        return false;
    }

}
