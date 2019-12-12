
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
        System.out.println("How many times has the first machine been "
                + "played since paying out?");
        String line2 = input.nextLine();
        System.out.println("How many times has the second machine been "
                + "played since paying out?");
        String line3 = input.nextLine(); 
        System.out.println("How many times has the third machine been "
                + "played since paying out?");
        String line4       = input.nextLine();
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
