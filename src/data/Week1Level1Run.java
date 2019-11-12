
package data;


public class Week1Level1Run {
    
    public Week1Level1Run() {   
        String[][] cases = {
            {"425","60","-0.01","3","1"},
            {"425","60","-0.01","3","2"},
            {"425","60","-0.01","3","3"}
        }; /* tP, tR, k, q, m */
        for (int c = 0; c < cases.length; c++) {
            int    tP = Integer.parseInt(   cases[c][0] );
            int    tR = Integer.parseInt(   cases[c][1] );
            double k  = Double.parseDouble( cases[c][2] );
            int    q  = Integer.parseInt(   cases[c][3] );
            int    m  = Integer.parseInt(   cases[c][4] );
            double temperature = (double)tP;
            for (int min = 1; min <= m; min++) {                
                temperature = temperature +  k * (((double)tP) - 
                        (((double)tR) + (((double)min) * ((double)q))));
            }
            System.out.println("Case #" + (c+1) + " " + temperature);
        }
    }
    
}
