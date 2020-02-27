
package data.week10;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;


public class Week10Level3Run  extends AutoRun
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
            "1",
            "2"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");    
        int lineCount = 0;
        int testCases = Integer.parseInt(lines[lineCount]);
        for (lineCount = 1; lineCount <= testCases; lineCount++) {
            int teams = Integer.parseInt(lines[lineCount]);
            process(teams);
        }   
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }
    
    private ArrayList<Team> teams;
    
    private int totalEliminatedTeams;
    
    
    private final Team    NO_TEAM            = null;
    private final boolean IS_LAST_ROUND      = true;
    private final boolean NOT_LAST_ROUND     = false;
    private final boolean HAS_BEEN_CHOOSEN   = true;
    private final boolean NOT_YET_CHOOSEN    = false;
    private final boolean HAS_BEEN_ELIMINTED = true;
    private final boolean NOT_ELIMINATED     = false;
    private final boolean HAS_BEEN_DEFEATED  = true;
    private final boolean UNDEFEATED         = false;
    private final boolean CAN_PLAY           = true;
    private final boolean CANNOT_PLAY        = false;    
    private final int     ONE_LOSS           = 1;
    private final int     TWO_LOSSES         = 2;
    
    
    
    private void process(int number) {
        int round = 0;
        createTeams(number);
        while (totalEliminatedTeams < number) {
            playRound(round);
            round++;
        }        
        System.out.println("There are " + round + " rounds.");
    }
    
    private void createTeams(int number) {
        teams = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            teams.add(new Team());
        }
    }
    
    private void playRound(int round) {        
        showRound(round);       
        clearRound();
        if (createPairings() == IS_LAST_ROUND) playLastRound();
    }

    private void showRound(int round) {
        int undefeatedTeams = 0;
        int oneLossTeams    = 0;
        int eliminatedTeams = 0;        
        for (Team team : teams) {
            if (team.isEliminated() == HAS_BEEN_ELIMINTED) eliminatedTeams++;
            if (team.isDefeated()   == UNDEFEATED)         undefeatedTeams++;
            if (team.getLosses()    == ONE_LOSS)           oneLossTeams++;
        }
        System.out.println("Round " + round + ": " + 
                undefeatedTeams + " undefeated, " + 
                oneLossTeams    + " one-loss, " + 
                eliminatedTeams + " eliminated");
    }
    
    private void clearRound() {
        for (Team team : teams) {
            if (team.isEliminated() == NOT_ELIMINATED) {
                team.dontChoose();
            }
        }
    }
    
    private boolean createPairings() {
        for (Team team : teams) {
            if (team.isEliminated() == NOT_ELIMINATED &&
                team.isChosen()     == NOT_YET_CHOOSEN) {
                Team opponent = findOpponent(team);
                return play(team,opponent);
            }
        }
        return IS_LAST_ROUND;
    }
    
    private boolean play(Team team, Team opponent) {
        if (team     == NO_TEAM) return IS_LAST_ROUND;
        if (opponent == NO_TEAM) return IS_LAST_ROUND;
        opponent.choose();
        opponent.lose();
        return NOT_LAST_ROUND;
    }
    
    private void playLastRound() {
        for (Team team : teams) {
            if (team.isEliminated() == NOT_ELIMINATED) {
                team.eliminate();
                totalEliminatedTeams++;
            }
        }
    }

    private Team findOpponent(Team team) {
        team.choose();
        for (Team opponent : teams) {
            if (isValidOpponent(team,opponent) == CAN_PLAY) return opponent;
        }
        return null;
    }

    private boolean isValidOpponent(Team team, Team opponent) {
        if (team.equals(opponent))                          return CANNOT_PLAY;
        if (opponent.isChosen()   == HAS_BEEN_CHOOSEN)      return CANNOT_PLAY;
        if (team.isDefeated()     == HAS_BEEN_DEFEATED && 
            opponent.getLosses()  == ONE_LOSS)              return CANNOT_PLAY;
        if (opponent.isDefeated() == HAS_BEEN_DEFEATED && 
            team.getLosses()      == ONE_LOSS)              return CANNOT_PLAY;
        return CAN_PLAY;
    }
    
    
    /////////////////////////////////////////////////////////////////////////
    private static int counter;    
    private void show(String text) {
        counter++;
        System.out.println(counter + ": " + text + "...................................");
        for (Team team : teams) {
            System.out.println(team.toString());
        }
        System.out.println(".........................................\n");
    }
    /////////////////////////////////////////////////////////////////////////
    
    
    private static int teamCount = 0;

    
    private class Team 
    {
        
        private int     number;
        private int     losses;
        private boolean eliminated;
        private boolean defeated;        
        private boolean chosen;
                
        public Team() {
            teamCount++;
            losses     = 0;
            number     = teamCount;
            eliminated = NOT_ELIMINATED;
            defeated   = UNDEFEATED;
            chosen     = NOT_YET_CHOOSEN;                   
        }
        
        public int getLosses() {
            return losses;
        }
        
        public boolean isEliminated() {
            return eliminated;
        }
                
        public boolean isDefeated() {
            return defeated;
        }
        
        public boolean isChosen() {
            return chosen;
        }
                
        public void eliminate() {
            eliminated = HAS_BEEN_ELIMINTED;
            totalEliminatedTeams++;   
        }
        
        public void choose() {
            chosen = HAS_BEEN_CHOOSEN;
        }
        
        public void dontChoose() {
            chosen = NOT_YET_CHOOSEN;
        }
                
        public void lose() {   
            defeated = HAS_BEEN_DEFEATED;
            losses++;
            if (losses >= TWO_LOSSES) eliminate();
        }
        
        public String toString() {
            return "Team " + number + ":"
                    + "\t undefeated = " + defeated
                    + "\t losses =     " + losses
                    + "\t eliminated = " + eliminated
                    + "\t chosen =     " + chosen; 
        }
        
        public boolean equals(Object object) {
            Team that = (Team)object;
            if (this.number == that.number) return true;
            return false;
        }
        
    }
    
}
