package challenge.week8;

import java.util.Scanner;
import mainpackage.Problem;


public class Week8Level3 extends Problem
{

    public static void main(String[] args) {
        new Week8Level3().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int year = Integer.parseInt(line);
        distinctYears(year);        
    }

    private void distinctYears(int year) {
        do {            
            year++;
        } while (isNotDistinct("" + year));
        System.out.println(year);
    }

    private boolean isNotDistinct(String year) {
        char[] digits = year.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            char digit = digits[i];
            if (isInside(digit,digits,i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInside(char digit, char[] digits, int spotToSkip) {
        for (int i = 0; i < digits.length; i++) {
            if (i != spotToSkip) {
                if (digits[i] == digit) return true;
            }
        }
        return false;
    }

}