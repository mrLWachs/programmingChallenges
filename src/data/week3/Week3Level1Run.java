
package data.week3;

import io.System;
import java.util.ArrayList;
import mainpackage.Problem;

public class Week3Level1Run  extends Problem
{

    public void start() {   
        System.out.header("Week 3, Level 1: starting");          
        String[] lines = { 
           "1h2he2al3aal312o0",        
           "20o399v6helloe1r1_91234567891010100abc31415042.00",        
           "5VOybh5sQn0i4.P4g6qgGghh0IVj6p",        
           "6xbV6rs45JSc8L6M.S59h6,xDrvo5PH4Uo3ZFl0ZPO.q",        
           "8KYhXBXUc3bho6ab,Vcm7sFs_T4p83HurzmQu71wnlwut1e2Ir0aCSH2K5f",        
           "47fBs5GtUyc3TAi5_TXSe6o4Yr3n7uXJiMvc2me0o5SNQ",        
           "4f_rd2Ka5Z50uy0VSoC",        
           "2b27ipzS.704aQs1170A",        
           "1t68domYh20i1s1_31Vi6O.3ZTs2h_6Dguzfa5lJb7_1s4UTEe21c4qM9r3"
                + "93e22t66piWU_712DfT0m4pOTe53fWRs52WL7s1a2vg78_x8lAe02qS9Mz",        
           "4XA8I3oqt4e4S_3cMi5chLys6qgkQm_7Tq_3Von7bXNK13o8r4bejHrt4_0X_"
                + "7sZyxx_v1e64szA7r63pP_Ky1_435lw8oD6l5hfe2al5,o,ll7XNT"
                + "emX_3aIh2mi2ld3rAd5IcKne1n0SVs8aNmsNI",        
           "7ZNHvj1t7lGLocKh5AR_Si3,Us5Bn5Y_2mm2Me3Rws5oAbns7sM,zlta4j"
                + "rHg22e4T8G_4DaEc6mxGJgo6BeShGn7rADcOKt7fZegdFa3Kyi1"
                + "n36Js1_65UOXfn6USMr5u3Brm4q7kb1e8uqousI4r8f7fZXPis1_"
                + "6N,kI685yjJF64p8y75Q6wS_2s58TWCqDN335Jic0_66y0YD04Ylv"
                + "90BZyb5s7c",        
           "88G,s9sQO4nR.n1e5rx5S_7vVWTJbi5x2Jzf6jGqCv_2Ib8f9pGv4xy7o13"
                + "kUf_4rlKl4IKUa36on6la0NTd54k6v,5ByFf_7zTUD,6a2On3wC"
                + "d5_HnQ_82Oeb8Gqt3FIw3.Do8AovmTX2_3hNi7Dv6Qbuf5TT58_6"
                + "jqEdpb875Yq3WSy7A1cqum_6Cg0Xws8gSdJl1te6YPv.Ia1.06W",        
           "0"           
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");     
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {      
            String line = lines[i];
            int index = 0;
            if (!line.equals("0")) {
                String message = "";
                int j = 0;
                boolean done = false;
                while (j < line.length() && !done) {
                    char value = line.charAt(j);
                    if (Character.isDigit(value)) {
                        if (value == '0') {
                            outputs.add("Case #" + index + ": " + message);
                            index++;
                            done = true;
                        }
                        else {
                            j += Integer.parseInt("" + value);
                        }
                    }
                    if (!done) {
                        char character = line.charAt(j);
                        if (character == '_') character = ' ';
                        message += character;
                        j++;
                    }
                }
            }            
        }        
        for (int i = 0; i < outputs.size(); i++) {
            System.out.println(outputs.get(i));
        }        
        System.out.header("Week 3, Level 1: complete");
        System.flush();
    }

}
