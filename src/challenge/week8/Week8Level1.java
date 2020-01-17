
package challenge.week8;

import mainpackage.Problem;


public class Week8Level1 extends Problem
{

    public static void main(String[] args) {
        new Week8Level1().start();
    }
    
    public void start() {
        for (int i = 0; i < 14; i++) {
            System.out.println(binomialCoefficient(i));
        }
    }

    private int binomialCoefficient(int n) {
        if (n == 0) return 1;
        else return binomialCoefficient(n-1) * (4*n-2)/n;    
    }

}