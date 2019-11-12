
package data;

/**
 *
 * @author Lawrence Wachs
 */
public class Week1MondayRun {
    
    public Week1MondayRun() {    
        String[][] cases = {
            {
                "425",   /* tP */
                "60",    /* tR */
                "-0.01", /* k */
                "3",     /* q */
                "1"      /* m */
            },
            {
                "425",   /* tP */
                "60",    /* tR */
                "-0.01", /* k */
                "3",     /* q */
                "2"      /* m */
            },
            {
                "425",   /* tP */
                "60",    /* tR */
                "-0.01", /* k */
                "3",     /* q */
                "3"      /* m */
            }
        };
        for (int c = 0; c < cases.length; c++) {
            int    tP = Integer.parseInt(   cases[c][0] );
            int    tR = Integer.parseInt(   cases[c][1] );
            double k  = Double.parseDouble( cases[c][2] );
            int    q  = Integer.parseInt(   cases[c][3] );
            int    m  = Integer.parseInt(   cases[c][4] );
            double temperature = (double)tP;
            for (int min = 1; min <= m; min++) {                
                temperature = temperature +  k * (((double)tP) - (((double)tR) + (((double)min) * ((double)q))));
            }
            System.out.println("Case #" + (c+1) + " " + temperature);
        }
    }
    
}
