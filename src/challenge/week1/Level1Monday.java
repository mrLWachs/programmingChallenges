
package challenge.week1;

import java.util.Scanner;

public class Level1Monday 
{

    public Level1Monday() {
        Scanner input = new Scanner(System.in);     
        String line = input.nextLine();
        int totalCases = Integer.parseInt(line);
        String[] outputs = new String[totalCases];
        for (int testCase = 1; testCase <= totalCases; testCase++) {
            line = input.nextLine();
            String[] values = line.split("[ ]");
            double tP = (double)Integer.parseInt(values[0]);
            double tR = (double)Integer.parseInt(values[1]);
            double k  = Double.parseDouble(values[2]);
            double q  = (double)Integer.parseInt(values[3]);
            double m  = (double)Integer.parseInt(values[4]);
            double temperature = Math.abs(k * (tP - (tR + (m * q))));
            outputs[testCase-1] = "Case #" + testCase + " " + temperature;
        }
        for (int i = 0; i < outputs.length; i++) {
            System.out.println(outputs[i]);
        }
    }
        
}
