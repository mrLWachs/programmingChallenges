
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
            "4"
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
    
    private int eliminatedTeams;
    
    
    private void process(int number) {
        int round = 0;
        ArrayList<Team> teams = createTeams(number);
        while (eliminatedTeams < number) {
            playRound(teams,round);
            round++;
        }        
        System.out.println("There are " + round + " rounds.");
    }
    
    private ArrayList<Team> createTeams(int number) {
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            teams.add(new Team());
        }
        return teams;
    }
    
    private void playRound(ArrayList<Team> teams, int round) {        
        showRound(teams,round);

        ArrayList<Team> activeTeams = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (!team.isEliminated()) {
                team.dontChoose();
                activeTeams.add(team);
            }
            
//            show(teams, "Added active team");
            
        }
        boolean lastRound = createPairings(activeTeams);
        if (lastRound) {
            for (int i = 0; i < activeTeams.size(); i++) {
                Team team = activeTeams.get(i);
                if (!team.isEliminated()) {
                    team.eliminate();
                    eliminatedTeams++;
                }
            }
        }
    }

    private void showRound(ArrayList<Team> teams, int round) {
        int undefeatedTeams = 0;
        int oneLossTeams    = 0;
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (team.isUndefeated())   undefeatedTeams++;
            if (team.getLosses() == 1) oneLossTeams++;
        }        
        System.out.println("Round " + round + ": " + 
                undefeatedTeams + " undefeated, " + 
                oneLossTeams    + " one-loss, " + 
                eliminatedTeams + " eliminated");
    }
    
    private boolean createPairings(ArrayList<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (!team.isChosen()) {
                team.choose();
                Team opponent = findOpponent(teams,team);
                if (opponent == null) return true;
                opponent.choose();
                opponent.lose();
                return false;
            }
        }
        return true;
    }

    private Team findOpponent(ArrayList<Team> teams, Team team) {
        for (int i = 0; i < teams.size(); i++) {
            Team opponent = teams.get(i);
            if (canPlay(team,opponent)) return opponent;
        }
        return null;
    }

    private boolean canPlay(Team team, Team opponent) {
        if (opponent.isChosen())                                  return false;
        if (team.isUndefeated()     && opponent.getLosses() == 1) return false;
        if (opponent.isUndefeated() && team.getLosses()     == 1) return false;
        return true;
    }

    private void show(ArrayList<Team> teams, String text) {
        System.out.println(text + "...................................");
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            System.out.println(team.toString());
        }
        System.out.println(".........................................\n");
    }
    
    
    
    
    
    private static int teams = 0;

    

    
    
    private class Team 
    {
        
        private int     number;
        private int     losses;
        private boolean eliminated;
        private boolean undefeated;        
        private boolean chosen;
        
        
        public Team() {
            losses     = 0;
            eliminated = false;
            undefeated = true;
            chosen     = false; 
            teams++;
            number = teams;
            
            show("created!");
        }
        
        public int getLosses() {
            return losses;
        }
        
        public boolean isEliminated() {
            return eliminated;
        }
        
        public void eliminate() {
            eliminated = true;
            eliminatedTeams++;
            
            show("eliminate");
        }
        
        public boolean isUndefeated() {
            return undefeated;
        }
        
        public boolean isChosen() {
            return chosen;
        }
        
        public void choose() {
            chosen = true;
            
            
            show("choosing!");
        }
        
        public void dontChoose() {
            chosen = false;
            
            show("dontChoose");
        }
        
        
        public void lose() {   
            undefeated = false;
            losses++;
            
            show("lose");

            if (losses >= 2) eliminate();
        }
        
        public String toString() {
            return "Team " + number + ":"
                    + "\t undefeated = " + undefeated
                    + "\t losses =     " + losses
                    + "\t eliminated = " + eliminated
                    + "\t chosen =     " + chosen; 
        }
        
        private void show(String text) {
//            System.out.println("~~~" + text + toString());            
        }
        
    }
    
}
