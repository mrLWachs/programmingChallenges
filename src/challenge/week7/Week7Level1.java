
package challenge.week7;

import mainpackage.Problem;


public class Week7Level1 extends Problem
{

    public static void main(String[] args) {
        new Week7Level1().start();
    }
    
    public void start() {
        for (int i = 1; i <= 100; i++) {
            if (isFunctional(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isFunctional(int number) {
        double answer = (100 * Math.sin(number)) / (Math.pow(number, 3) - 
                (30 * Math.pow(number, 2)) + (200 * number));
        if (answer > 0) return true;
        return false;
    }

}
