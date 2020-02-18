
package data.week10;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;


public class Week10Level2Run  extends AutoRun
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
            "4",
            "6",
            "24",
            "30420",
            "10078"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");    
        int currentLine = 0;
        int dataSets = Integer.parseInt(lines[currentLine]);
        for (int dataSet = 0; dataSet < dataSets; dataSet++) {
            currentLine++;
            int number = Integer.parseInt(lines[currentLine]);
            checkForNasty(number);
        }   
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void checkForNasty(int number) {
        ArrayList<Integer> factors = getFactors(number);
        if (checkNastySum(factors,number)) System.out.println(number + " is nasty");
        else                               System.out.println(number + " is not nasty");
    }

    private ArrayList<Integer> getFactors(int number) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int value = 1; value <= number; value++) {
            if (isFactor(value,number)) factors.add(value);
        }
        return factors;
    }

    private boolean isFactor(int value, int number) {
        if (number % value == 0) return true;
        else                     return false;
    }
    
    private boolean checkNastySum(ArrayList<Integer> factors, int number) {
        boolean isNasty = false;
        ArrayList<FactorPairs> factorPairs = getFactorPairs(factors,number);
        for (int i = 0; i < factorPairs.size(); i++) {
            FactorPairs currentPair = factorPairs.get(i);
            isNasty = checkForNasty(currentPair,factorPairs,number);
            if (isNasty) return true;
        }
        return false;
    }

    private boolean checkForNasty(FactorPairs pair, 
            ArrayList<FactorPairs> factorPairs, int number) {
        for (int i = 0; i < factorPairs.size(); i++) {
            FactorPairs newPair = factorPairs.get(i);
            if (!newPair.equals(pair)) {
                if (pair.minusValue == newPair.addValue) return true;
            }
        }
        return false;
    }
    
    private ArrayList<FactorPairs> getFactorPairs(ArrayList<Integer> factors, 
            int number) {
        ArrayList<FactorPairs> factorPairs = new ArrayList<>();
        for (int i = 0; i < factors.size(); i++) {
            int factor = factors.get(i);
            int match  = findMatchingFactor(factor,factors,number);
            FactorPairs pair = new FactorPairs(factor, match);
            if (!factorPairs.contains(pair)) factorPairs.add(pair);
        }
        return factorPairs;
    }

    private int findMatchingFactor(int factor, ArrayList<Integer> factors, 
            int number) {
        for (int i = 0; i < factors.size(); i++) {
            int value = factors.get(i);
            if (value != factor) {
                if (value * factor == number) return value;
            }
        }
        return 0;
    }

    private class FactorPairs
    {
        public int factor1;
        public int factor2;
        
        public int minusValue;
        public int addValue;
        
        
        public FactorPairs(int factor1, int factor2) {
            this.factor1 = factor1;
            this.factor2 = factor2;
            int highest = factor1;
            int lowest  = factor2;
            if (factor2 > factor1) highest = factor2;
            if (factor1 < factor2) lowest  = factor1;
            minusValue = highest - lowest;
            addValue   = lowest  + highest;            
        }
        
        public boolean equals(Object object) {
            FactorPairs that = (FactorPairs)object;
            if (this.factor1 == that.factor1 &&
                this.factor2 == that.factor2) {
                return true;
            }
            return false;
        }
        
    }
    
    
}
