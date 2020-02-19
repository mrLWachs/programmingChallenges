
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
    private int rounds;
    
    
    private void process(int numberOfTeams) {
        rounds = 0;
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            teams.add(new Team());
        }
        while (eliminatedTeams < numberOfTeams) {
            playRound(teams);
        }        
    }
    
    private void playRound(ArrayList<Team> teams) {        
        int undefeatedTeams = 0;
        int oneLossTeams    = 0;
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (team.undefeated)  undefeatedTeams++;
            if (team.losses == 1) oneLossTeams++;
        }
        System.out.println("Round " + rounds + ": " + 
                undefeatedTeams + " undefeated, " + 
                oneLossTeams    + " one-loss, " + 
                eliminatedTeams + " eliminated");
        ArrayList<Team> activeTeams = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (!team.eliminated) {
                activeTeams.add(team);
            }
        }
        for (int i = 0; i < activeTeams.size(); i++) {
            activeTeams.get(i).chosen = false;
        }
        boolean lastRound = createPairings(activeTeams);
        if (lastRound) {
            for (int i = 0; i < activeTeams.size(); i++) {
                Team team = activeTeams.get(i);
                if (!team.eliminated) {
                    team.eliminated = true;
                    eliminatedTeams++;
                }
            }
        }
        rounds++;
    }

    private boolean createPairings(ArrayList<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (!team.chosen) {
                team.chosen = true;
                Team opponent = findOpponent(teams,team);
                if (opponent == null) return true;
                opponent.chosen = true;
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
        if (opponent.chosen)                                 return false;
        if (team.undefeated && opponent.losses     == 1) return false;
        if (opponent.undefeated     && team.losses == 1) return false;
        return true;
    }

    
    private class Team 
    {
        
        public int     losses;
        public boolean eliminated;
        public boolean undefeated;        
        public boolean chosen;
        
        
        public Team() {
            losses     = 0;
            eliminated = false;
            undefeated = true;
            chosen     = false;            
        }
        
        public void lose() {
            if (!eliminated) {
                System.out.println("Loss!");
                losses++;
                undefeated = false;
                if (losses == 2) {
                    System.out.println("Eliminated!");
                    eliminated = true;
                    eliminatedTeams++;
                }
            }
        }
        
    }
    
}
