
package data;

public class Week2Level1Run 
{

    public Week2Level1Run() {
        String[][] data = {
            {"W","L","W","W","L","W"},  
            {"L","L","L","L","L","L"}
        };
        final String WIN  = "W";
        for (int testCase = 0; testCase < data.length; testCase++) {
            int winCount = 0;
            int result   = -1;
            for (int i = 0; i < 6; i++) {
                String line = data[testCase][i];
                if (line.equalsIgnoreCase(WIN)) winCount++;
            }
            if      (winCount >= 5) result = 1;
            else if (winCount >= 3) result = 2;
            else if (winCount >= 1) result = 3;
            System.out.println(result);
        }
    }

}
