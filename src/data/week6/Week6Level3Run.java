
package data.week6;

import io.System;
import mainpackage.AutoRun;

public class Week6Level3Run  extends AutoRun
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
           "48",
           "3",
           "10",
           "4"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println("How many quarters does Martha have in the jar?");
            System.out.println(lines[i]);
            i++;
            System.out.println("How many times has the first machine been "
                + "played since paying out?");
            System.out.println(lines[i]);
            i++;
            System.out.println("How many times has the third machine been "
                + "played since paying out?");
            System.out.println(lines[i]);
            i++;
        }
        System.out.println("\nOutputs:\n"); 
        for (int i = 0; i < lines.length; i++) {
            String line1 = lines[i];
            i++;
            String line2 = lines[i];
            i++;
            String line3 = lines[i]; 
            i++;
            String line4 = lines[i];
            int quarters       = Integer.parseInt(line1);        
            Machine[] machines = new Machine[3];
            machines[0]        = new Machine(30,35,Integer.parseInt(line2));
            machines[1]        = new Machine(60,100,Integer.parseInt(line3));
            machines[2]        = new Machine(9,10,Integer.parseInt(line4));
            Gambler martha     = new Gambler(quarters,machines);
            martha.gamble();
            System.out.println("Martha plays " + martha.timesPlayed + 
                               " times before going broke.");
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
    private class Gambler
    {
        public  int       quarters;
        public  int       timesPlayed;
        private Machine[] machines;
        
        
        public Gambler(int quarters, Machine[] machines) {
            this.quarters = quarters;
            this.machines = machines; 
        }
        
        public void gamble() {
            int machine = 0;
            while (hasQuarters()) {
                play(machine);
                timesPlayed++;
                machine++;
                if (machine >= machines.length) machine = 0;
            }
        }
        
        public void play(int machine) {
            quarters--;
            int winAmount = machines[machine].play();
            quarters = quarters + winAmount;
        }
        
        public boolean hasQuarters() {
            if (quarters <= 0) return false;
            return true;
        }
                
    }
    
    private class Machine
    {
        
        private int payOutTime;
        private int currentPlay;
        private int payOutAmount;
                
        public Machine(int payOutAmount, int payOutTime, int currentPlay) {
            this.payOutAmount = payOutAmount;
            this.payOutTime   = payOutTime;            
            this.currentPlay  = currentPlay;
        }
        
        public int play() {
            currentPlay++;
            if (currentPlay == payOutTime) {
                currentPlay = 0;
                return payOutAmount;
            }
            return 0;
        }
        
    }

}
