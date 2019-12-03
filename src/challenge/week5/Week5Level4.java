
package challenge.week5;


import static java.util.Arrays.sort;
import java.util.Scanner;
import mainpackage.Problem;


public class Week5Level4 extends Problem
{

    public static void main(String[] args) {
        new Week5Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int end = 1;
        while (!line.equals("-1 -1")) {
            String[] values = line.split("[ ]");
            int n1 = Integer.parseInt(values[0]);
            int n2 = Integer.parseInt(values[1]);
            line = input.nextLine();
            String[] n1Coordinates = line.split("[ ]");
            int[] n1X = new int[n1];
            int[] n1Y = new int[n1];
            int index = 0;
            for (int i = 0; i < n1Coordinates.length; i++) {
                n1X[index] = Integer.parseInt(n1Coordinates[i]);
                i++;
                n1Y[index] = Integer.parseInt(n1Coordinates[i]);
                index++;
            }
            line = input.nextLine();
            String[] n2Coordinates = line.split("[ ]");
            int[] n2X = new int[n2];
            int[] n2Y = new int[n2];
            index = 0;
            for (int i = 0; i < n2Coordinates.length; i++) {
                n2X[index] = Integer.parseInt(n2Coordinates[i]);
                i++;
                n2Y[index] = Integer.parseInt(n2Coordinates[i]);
                index++;
            }
            int[] team1Distances = new int[n1];
            final double x1 = 0;
            final double y1 = 0;
            for (int i = 0; i < team1Distances.length; i++) {
                double x2 = (double)n1X[i];
                double y2 = (double)n1Y[i];
                double d1 = Math.pow((x2 - x1), 2);
                double d2 = Math.pow((y2 - y1), 2);
                team1Distances[i] = (int)Math.sqrt(d1 + d2);
            }
            int[] team2Distances = new int[n2];
            for (int i = 0; i < team2Distances.length; i++) {
                double x2 = (double)n2X[i];
                double y2 = (double)n2Y[i];
                double d1 = Math.pow((x2 - x1), 2);
                double d2 = Math.pow((y2 - y1), 2);
                team2Distances[i] = (int)Math.sqrt(d1 + d2);
            }
            
//            sort(team1Distances);
//            sort(team2Distances);
//            output("team1Distances",team1Distances);
//            output("team2Distances",team2Distances); 
                        
            int lowest1 = team1Distances[0];
            int lowest2 = team2Distances[0];     
            int score = 0;            
            if (lowest1 < lowest2) {
                for (int i = 0; i < team1Distances.length; i++) {
                    if (team1Distances[i] < lowest2) {
                        score++;
                    }
                }
                System.out.println("End " + end + ": team 1 scores " + score);
            }
            else if (lowest2 < lowest1) {
                for (int i = 0; i < team2Distances.length; i++) {
                    if (team2Distances[i] < lowest1) {
                        score++;
                    }
                }
                System.out.println("End " + end + ": team 2 scores " + score);
            }
            end++;
            line = input.nextLine();
        }
        
    }


    private int findSpot(int[] distances, int lowest) {
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] > lowest) {
                return i;
            }                    
        }
        return -1;
    }

    private void output(String text, int[] a) {
        text += " = [";
        for (int i = 0; i < a.length - 1; i++) {
            text += a[i] + ",";
        }
        text += a[a.length-1] + "]";
        System.out.println(text);
    }

}
