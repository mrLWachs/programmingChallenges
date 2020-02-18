
package challenge.week10;

import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week10Level2 extends Problem
{

    public static void main(String[] args) {
        new Week10Level2().start();
    }
    
    public void start() {        
        Scanner input = new Scanner(System.in);  
        String line = input.nextLine();
        int dataSets = Integer.parseInt(line);
        for (int dataSet = 0; dataSet < dataSets; dataSet++) {
            line = input.nextLine();
            int number = Integer.parseInt(line);
            checkForNasty(number);
        } 
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