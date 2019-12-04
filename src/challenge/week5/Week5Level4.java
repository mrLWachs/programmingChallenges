
package challenge.week5;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import mainpackage.Problem;


public class Week5Level4 extends Problem
{
    int n1;
    int n2;
    int[] n1X;
    int[] n1Y;
    int[] n2X;
    int[] n2Y;
    int[] distances1;
    int[] distances2;

    public static void main(String[] args) {
        new Week5Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int end = 1;
        while (!line.equals("-1 -1")) {
            getRocks(line);
            line = input.nextLine();
            getTeam1(line);
            line = input.nextLine();
            getTeam2(line);
            distances1 = getDistance(distances1, n1, n1X, n1Y);
            distances2 = getDistance(distances2, n2, n2X, n2Y);
            String text = "End " + end + calculate();
            System.out.println(text);
            end++;
            line = input.nextLine();
        }
    }

    private String calculate() {
        Arrays.sort(distances1);
        Arrays.sort(distances2);
        int low1 = distances1[0];
        int low2 = distances2[0];        
        if      (low1 < low2) return getScore(low2,distances1,1);
        else if (low2 < low1) return getScore(low1,distances2,2);
        return "ERROR";
    }

    private String getScore(int scoreToBeat, int[] distances, int team) {
        final int INCHES_IN_ROCK = 5;
        final int INCHES_IN_FOOT = 72 + INCHES_IN_ROCK;
        ArrayList<Integer> inCircleScores = new ArrayList<>();
        for (int i = 0; i < distances.length; i++) {
            int distance = distances[i];
            if (distance <= INCHES_IN_FOOT) inCircleScores.add(distance);
        }
        int score = 0;
        for (int i = 0; i < inCircleScores.size(); i++) {
            int distance = inCircleScores.get(i);
            if (distance < scoreToBeat) score++;    
        }
        return (": team " + team + " scores " + score);
    }

    private int[] getDistance(int[] distances, int n, 
            int[] xValues, int[] yValues) {
        final double x1 = 0;
        final double y1 = 0;
        distances = new int[n];
        for (int i = 0; i < distances.length; i++) {
            double x2 = (double)xValues[i];
            double y2 = (double)yValues[i];
            double d1 = Math.pow((x2 - x1), 2);
            double d2 = Math.pow((y2 - y1), 2);
            distances[i] = (int)Math.sqrt(d1 + d2);
        }
        return distances;
    }

    private void getTeam2(String line)  {
        String[] n2Coordinates = line.split("[ ]");
        n2X = new int[n2];
        n2Y = new int[n2];
        int index = 0;
        for (int i = 0; i < n2Coordinates.length; i++) {
            n2X[index] = Integer.parseInt(n2Coordinates[i]);
            i++;
            n2Y[index] = Integer.parseInt(n2Coordinates[i]);
            index++;
        }
    }

    private void getTeam1(String line) {
        String[] n1Coordinates = line.split("[ ]");
        n1X = new int[n1];
        n1Y = new int[n1];
        int index = 0;
        for (int i = 0; i < n1Coordinates.length; i++) {
            n1X[index] = Integer.parseInt(n1Coordinates[i]);
            i++;
            n1Y[index] = Integer.parseInt(n1Coordinates[i]);
            index++;
        }
    }

    private void getRocks(String line) {
        String[] values = line.split("[ ]");
        n1 = Integer.parseInt(values[0]);
        n2 = Integer.parseInt(values[1]);
    }

}
