
package challenge.week6;


import java.util.Scanner;
import mainpackage.Problem;


public class Week6Level3 extends Problem
{

    public static void main(String[] args) {
        new Week6Level3().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        System.out.println("How many quarters does Martha have in the jar?");
        String line1 = input.nextLine();
        System.out.println("How many times has the first machine been played since paying out?");
        String line2 = input.nextLine();
        System.out.println("How many times has the second machine been played since paying out?");
        String line3 = input.nextLine(); 
        System.out.println("How many times has the third machine been played since paying out?");
        String line4   = input.nextLine();
        int quarters   = Integer.parseInt(line1);
        int machines[] = new int[3];
        machines[0]    = Integer.parseInt(line2);
        machines[1]    = Integer.parseInt(line3);
        machines[2]    = Integer.parseInt(line4);
        int times = calculate(quarters,machines);
        System.out.println("Martha plays " + times + " times before ging broke.");        
    }

    private int calculate(int quarters, int[] machines) {
        Martha martha = new Martha(quarters,machines);
        int machine = 0;
        while (martha.hasQuarters()) {
            martha.play(machine);
            machine++;
        }
        return martha.timesPlayed;
    }
    
    private class Martha
    {
        public  int   quarters;
        public  int   timesPlayed;
        private int[] machines;
        private int[] rounds;
        
        
        public Martha(int quarters, int[] machines) {
            this.quarters = quarters;
            this.machines = machines;            
            timesPlayed = 0;
            rounds = new int[machines.length];
            for (int i = 0; i < rounds.length; i++) {
                rounds[i] = 0;
            }
        }
        
        public void play(int machine) {
            quarters--;
            int timesPlayedSinceLastPayOut = machines[machine];            
            int payOutPlayRound = 0;
            if      (machine == 1) payOutPlayRound = 35;
            else if (machine == 2) payOutPlayRound = 100;
            else if (machine == 3) payOutPlayRound = 10;
            
            
        }
        
        public boolean hasQuarters() {
            if (quarters <= 0) return false;
            return true;
        }
        
    }

}
