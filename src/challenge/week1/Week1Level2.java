
package challenge.week1;

import java.util.Scanner;

public class Week1Level2 
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);     
        String line = input.nextLine();
        int[] counts = new int[3];
        boolean[] counted = new boolean[3];   
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if (letter == 'a') {                    
                counts[0]++;
                counted[0] = true;
            }
            if (letter == 'b') {
                counts[1]++;
                counted[1] = true;
            }
            if (letter == 'c') {
                counts[2]++;
                counted[2] = true;
            }                
        }
        String output = "no set";
        if (counted[0] && counted[1] && counted[2]) output = "set: abc";
        if (counts[0] >= 3) output = "set of three: a";
        if (counts[1] >= 3) output = "set of three: b";
        if (counts[2] >= 3) output = "set of three: c";
        System.out.println(output);  
    }
    
}
